package com.example.citypass.cotroller.activity.naonao;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/29 0029 10:58
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


class ImageLoader {
    private static ImageLoader imageLoader;
    //图片缓存的核心对象
    private LruCache<String, Bitmap> mLruCache;
    //线程池
    private ExecutorService mThreadPool;
    //默认线程数为1个
    private static final int DEFAULT_THREAD_COUNT = 1;
    /**
     * 队列的调度方式
     */
    private Type mType = Type.LIFO;
    //任务列表
    private LinkedList<Runnable> mTaskQuere;

    //轮询线程
    private Thread mPoolThread;
    private Handler mPoolThreadHandler;


    //UI线程中的Handler
    private Handler mUiHandler;
    private Bitmap uIbitmap;


    public enum Type {
        FIFO, LIFO;
    }
    /**
     * 信号量 用来解决
     * mPoolThreadHandler还没有实例化 就执行addTask方法 导致空指针异常
     */
    private Semaphore mSemaphorePoolThreadHandler = new Semaphore(0);

    /**
     * 信号量 用来解决
     * 当有多张图片同时加载的时候  他们都要加到内存缓存
     * mThreadPool 线程池一直在ThreadQue区消息执行
     * 在这里 线程是并行的 为了不让线程阻塞 让他执行完一个再执行一个
     */
    private Semaphore mSemaphoreThreadPool;
    /**
     * @param threadCount 用户指定线程数
     * @param type        用户指定加载模式
     */
    private ImageLoader(int threadCount, Type type) {
        init(threadCount, type);
    }


    private void init(int threadCount, Type type) {
        //后台轮询线程
        mPoolThread = new Thread() {
            @Override
            public void run() {
                super.run();
                //Looper准备
                Looper.prepare();
                mPoolThreadHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        //线程池去取出一个任务去执行
                        mThreadPool.execute(getTask());
                        try {
                            mSemaphoreThreadPool.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //释放信号量 使线程不会阻塞
                mSemaphorePoolThreadHandler.release();
                //Looper开启轮询
                Looper.loop();
            }
        };
        mPoolThread.start();
        //获取到本应用的最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        //缓存空间为应用最大内存的八分之一
        int cacheMemory = maxMemory / 8;
        mLruCache = new LruCache<String, Bitmap>(cacheMemory) {
            //去测量每个BitMap的字节数
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //每一行的占据的字节数 乘以他的高度 就算出了总共占的字节数
                return value.getRowBytes() * value.getHeight();
            }
        };
        //初始化线程池
        mThreadPool = Executors.newFixedThreadPool(threadCount);
        mTaskQuere = new LinkedList<>();
        mType = type;
        mSemaphoreThreadPool = new Semaphore(threadCount);
    }

    public static ImageLoader getInstance(int count,Type type) {
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                if (imageLoader == null) {
                    imageLoader = new ImageLoader(count, type);
                }
            }
        }
        return imageLoader;
    }
    /**
     * 从任务队列 取出一个方法
     *
     * @return
     */
    private Runnable getTask() {
        if (mType == Type.FIFO) {
            return mTaskQuere.removeFirst();
        } else if (mType == Type.LIFO) {
            return mTaskQuere.removeLast();
        }
        return null;
    }
    /**
     * 根据Tag为Imageview设置图片
     *
     * @param path      图片地址
     * @param imageView 图片View
     */
    public Bitmap loadImage(final String path, final ImageView imageView) {
        //给每个ImageView设置Tag 防止复用布局 图片显示错乱
        imageView.setTag(path);
        //初始化UIHandler
        if (mUiHandler == null) {
            mUiHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    //获取到图片 为Imageview回调设置图片
                    ImgBeanHolder imgBeanHolders = (ImgBeanHolder) msg.obj;
                    String path = imgBeanHolders.path;
                    ImageView imageView = imgBeanHolders.imageView;
                    uIbitmap = imgBeanHolders.bitmap;
                    if (imageView.getTag().toString().equals(path)) {
                        imageView.setImageBitmap(uIbitmap);
                    }
                    mSemaphoreThreadPool.release();
                }
            };
        }
        //根据url到内存中找图片
        Bitmap bm = getBitmapFormLruCache(path);
        if (bm != null) {
            //从内存中找到图片了
            refreashBitmap(path, imageView, bm);
        } else {
            //在内存中没有图片
            addTask(new Runnable() {
                @Override
                public void run() {
                    //加载图片
                    //图片压缩
                    //1. 获取图片需要显示的大小
                    ImageSize imageSize = getImageViewSize(imageView);
                    //压缩图片
                    Bitmap bm = decodeSampledBitmapFromPath(path, imageSize.width, imageSize.height);
                    //加到内存
                    addBitmapToLurcache(path, bm);
                    //显示图片
                    refreashBitmap(path, imageView, bm);
                }
            });
        }
        return uIbitmap;
    }

    private void refreashBitmap(String path, ImageView imageView, Bitmap bm) {
        Message message = Message.obtain();
        ImgBeanHolder imgBeanHolder = new ImgBeanHolder();
        imgBeanHolder.bitmap = bm;
        imgBeanHolder.path = path;
        imgBeanHolder.imageView = imageView;
        message.obj = imgBeanHolder;
        mUiHandler.sendMessage(message);
    }

    /**
     * 将图片加入缓存
     *
     * @param path
     * @param bm
     */
    private void addBitmapToLurcache(String path, Bitmap bm) {
        if (getBitmapFormLruCache(path) == null) {
            if(bm!=null){
                mLruCache.put(path,bm);
            }
        }
    }

    /**
     * @param path   图片的压缩
     * @param width  图片要显示的宽
     * @param height 图片要显示的高
     * @return
     */
    private Bitmap decodeSampledBitmapFromPath(String path, int width, int height) {
        //获取图片的宽和高 但不把图片加到内存当中
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = caculateInSampleSize(options, width, height);
        options.inJustDecodeBounds = false;
        Bitmap bit = BitmapFactory.decodeFile(path, options);
        return bit;

    }

    /**
     * 根据需求的宽和高 我实际的宽和高
     *
     * @param options
     * @param width
     * @param height
     * @return
     */
    private int caculateInSampleSize(BitmapFactory.Options options, int reqwidth, int reqheight) {
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;
        //如果照片实际的宽度 都大于我们需要的宽度 就压缩
        if (width > reqwidth || height > reqheight) {
            int withRadio = Math.round(width * 1.0f / reqwidth);
            int heightRadio = Math.round(height * 1.0f / reqheight);
            inSampleSize = Math.max(withRadio, heightRadio);
        }
        return inSampleSize;
    }
    /**
     * 根据ImageView获取适当的压缩的宽和高
     *
     * @param imageView
     * @return
     */
    private ImageSize getImageViewSize(ImageView imageView) {
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();

        ImageSize imageSize = new ImageSize();
        ViewGroup.LayoutParams lp = imageView.getLayoutParams();
        int width = imageView.getWidth();//获取到ImageView的实际宽度
        if (width <= 0) { //说明图片还没有加载出来
            width = lp.width;//获取到layout的声明的宽度
        }
        if (width <= 0) {//有可能layout声明的是wrap
            width = imageView.getMaxWidth();//获取到最大的宽度
        }
        if (width <= 0) {//还获取不到
            width = displayMetrics.widthPixels;//屏幕的宽度
        }
        int height = imageView.getWidth();//获取到ImageView的实际高度
        if (height <= 0) { //说明图片还没有加载出来
            height = lp.height;//获取到layout的声明的高度
        }
        if (height <= 0) {//有可能layout声明的是wrap
            height = imageView.getMaxHeight();//获取到最大的高度
        }
        if (height <= 0) {//还获取不到
            height = displayMetrics.heightPixels;//屏幕的高度
        }
        imageSize.height = height;
        imageSize.width = width;
        return imageSize;
    }

    private synchronized void addTask(Runnable runnable) {
        //添加到任务列表
        mTaskQuere.add(runnable);
        try {
            if(mPoolThreadHandler==null){
                //当mPoolThreadHandler 没有实例化的时候 就会阻塞
                mSemaphorePoolThreadHandler.acquire();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mPoolThreadHandler.sendEmptyMessage(321321);
    }

    private Bitmap getBitmapFormLruCache(String path) {
        return mLruCache.get(path);
    }

    /**
     * 反射获取到一个view的属性指
     * @param object
     * @param fieldName
     * @return
     */
    private static  int getImageViewFieldValue(Object object,String fieldName){
        int value = 0;
//
        return value;

    }
    private class ImgBeanHolder {
        Bitmap bitmap;
        ImageView imageView;
        String path;

    }

    public class ImageSize {
        int height;
        int width;
    }
}
