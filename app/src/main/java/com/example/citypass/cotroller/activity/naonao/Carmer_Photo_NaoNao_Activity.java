package com.example.citypass.cotroller.activity.naonao;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.FolderBean;
import com.example.citypass.utils.LogUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/29 0029 8:54
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


public class Carmer_Photo_NaoNao_Activity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.carmer_photo_naonao_cancel)
    ImageView carmerPhotoNaonaoCancel;
    @BindView(R.id.carmer_photo_naonao_xuanze)
    TextView carmerPhotoNaonaoXuanze;
    @BindView(R.id.carmer_photo_naonao_head)
    RelativeLayout carmerPhotoNaonaoHead;
    @BindView(R.id.carmer_photo_naonao_ok)
    Button carmerPhotoNaonaoOk;
    @BindView(R.id.carmer_photo_naonao_add)
    LinearLayout carmerPhotoNaonaoAdd;
    @BindView(R.id.carmer_photo_naonao_scroll)
    HorizontalScrollView carmerPhotoNaonaoScroll;
    @BindView(R.id.carmer_photo_naonao_dibu)
    RelativeLayout carmerPhotoNaonaoDibu;
    @BindView(R.id.carmer_photo_naonao_grid)
    GridView carmerPhotoNaonaoGrid;
    private ProgressDialog progressDialog;
    private List<String> list = new ArrayList<>();
    private List<String> viewList;
    private List<FolderBean> listfolder;
    private PopupWindow popupWindow;
    private Myadapter myadapter;
    private File AllFile;
    private int xuanzeCount;//当前选择图片数
    Set<String> mDirPath = new HashSet<String>();
    private int imageCount;
    private List<String> list1;
    private int parcie;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.dismiss();
            //判断文件是否为空
            if (AllFile == null) {
                Toast.makeText(Carmer_Photo_NaoNao_Activity.this, "没有图片", Toast.LENGTH_SHORT).show();
            } else {
                //将文件放到列表视图展示到数组中
                list1 = Arrays.asList(AllFile.list());
                //将文件以及地址放到适配器了
                myadapter = new Myadapter(Carmer_Photo_NaoNao_Activity.this, list1, R.layout.item_grid, AllFile.getAbsolutePath());
                //将所有的文件  放在 GridView上（图片）
                carmerPhotoNaonaoGrid.setAdapter(myadapter);
            }
        }
    };

    private ArrayList<String> bList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.carmer_photo_naonao_activity;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        //将默认的图片添加到最下方的LinearLayout上
        carmerPhotoNaonaoAdd.addView(LayoutInflater.from(this).inflate(R.layout.roundimage, null));
        //外部存储是否与安装地址相同   是否有 内存卡
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "当前存储卡不可用", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog = ProgressDialog.show(this, null, "正在加载");
            new Thread() {


                @Override
                public void run() {
                    super.run();
                    // 外部内容
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    //
                    ContentResolver contentResolver = Carmer_Photo_NaoNao_Activity.this.getContentResolver();
                    Cursor query = contentResolver.query(uri,
                            null, MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                            new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);

                    //遍历每张图片
                    while (query.moveToNext()) {
                        FolderBean folderBean = null;
                        //第一张图片的路径npribaevte Sckd
                        String path = query.getString(query
                                .getColumnIndex(MediaStore.Images.Media.DATA));
                        //得到父文件的File流
                        File parentFile = new File(path).getParentFile();
                        //如果这个file没有 就跳过这个文件夹
                        if (parentFile == null) {
                            continue;
                        }
                        //得到路径
                        String dirPath = parentFile.getAbsolutePath();
                        //看set集合里面是否包含这个父文件
                        if (!mDirPath.contains(dirPath)) {
                            //没有的话就添加到set集合里
                            mDirPath.add(dirPath);
                            folderBean = new FolderBean();
                            //添加文件夹路径
                            folderBean.setDir(dirPath);
                            //添加第一张图片的路径
                            folderBean.setFirstDir(path);
                        } else {
                            continue;
                        }
                        if (parentFile.list() == null) {
                            continue;
                        } else {
                            int priceSize = parentFile.list(new FilenameFilter() {
                                @Override
                                public boolean accept(File dir, String name) {
                                    if (name.endsWith(".jpg")
                                            || name.endsWith(".png")
                                            || name.endsWith(".jpeg"))
                                        return true;
                                    return false;
                                }
                            }).length;
                            imageCount += priceSize;
                            folderBean.setCount(imageCount);
                            listfolder.add(folderBean);


                            if (priceSize > parcie) {
                                parcie = priceSize;
                                AllFile = parentFile;
                            }
                        }

                        imageCount = 0;
                    }
                    query.close();

                    mHandler.sendEmptyMessage(1);
                }
            }.start();
        }
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        viewList = new ArrayList<>();
        listfolder = new ArrayList<>();
    }
     //PopupWindow 弹出的是 所获取到的文件夹的名字
    private void initPopWindow() {
        View view = LayoutInflater.from(Carmer_Photo_NaoNao_Activity.this).inflate(R.layout.pop_listview, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final ListView listView = (ListView) view.findViewById(R.id.pop_listView);
        listView.setAdapter(new MyPopAdapter(Carmer_Photo_NaoNao_Activity.this, listfolder, R.layout.item_pop));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File file = new File(listfolder.get(position).getDir());
                String[] strings = file.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        if (name.endsWith(".jpg")
                                || name.endsWith(".png")
                                || name.endsWith(".jpeg"))
                            return true;
                        return false;
                    }
                });

                List<String> list = Arrays.asList(strings);
                carmerPhotoNaonaoGrid.setAdapter(new Myadapter(Carmer_Photo_NaoNao_Activity.this, list, R.layout.item_grid, file.getAbsolutePath()));
                popupWindow.dismiss();
                Toast.makeText(Carmer_Photo_NaoNao_Activity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        popupWindow.setAnimationStyle(R.style.pictire_pop_andimal);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));


    }

    @Override
    public void onClick(View v) {

    }


    @OnClick({R.id.carmer_photo_naonao_cancel, R.id.carmer_photo_naonao_xuanze, R.id.carmer_photo_naonao_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.carmer_photo_naonao_cancel:
                onBackPressed();
                break;
            case R.id.carmer_photo_naonao_xuanze:
                initPopWindow();
                popupWindow.showAsDropDown(carmerPhotoNaonaoHead);
                break;
            case R.id.carmer_photo_naonao_ok:
                if(xuanzeCount <=0){
                    Toast.makeText(this, "您还没有选择图片", Toast.LENGTH_SHORT).show();
                }else {
                    Intent in = new Intent(Carmer_Photo_NaoNao_Activity.this, Carmer_FaBu_NaoNao_Activity.class);
                    in.putStringArrayListExtra("path", bList);
                    Log.d("Carmer_Photo_NaoNao_Act", "bList:" + bList);
                    startActivity(in);
                    finish();
                }
                break;
        }
    }
    //文件夹下的所有图片 GridView的适配器
    public class Myadapter extends BaseListAdapter<String> {

        private List<String> listim = new ArrayList<>();
        private String diapath;//路径
        private Bitmap bitmap;//图片
        private boolean aBoolea;

        public Myadapter(Context context, List<String> list, int layoutID) {
            super(context, list, layoutID);
        }

        public Myadapter(Context context, List<String> list, int layoutID, String diapath) {
            super(context, list, layoutID);
            this.diapath = diapath;
        }

        @Override
        protected void convert(ViewHolder holder, final String strings) {
            final String imgpath = diapath + "/" + strings;
            final ImageButton imageButton = (ImageButton) holder.getView(R.id.grid_imageButton);
            final ImageView imageView = (ImageView) holder.getView(R.id.grid_image);
            bitmap = holder.setImageLoader(R.id.grid_image, diapath + "/" + strings);
            //判断图片的选中与未选中的效果
            if (!listim.contains(diapath + "/" + strings)) {
                //未选中  隐藏
                imageButton.setImageResource(R.drawable.picture_unselected);
                imageButton.setVisibility(View.GONE);
                imageView.setColorFilter(Color.parseColor("#00000000"));
            } else {
                //选中 显示
                imageView.setColorFilter(Color.parseColor("#77000000"));
                imageButton.setImageResource(R.drawable.pictures_selected);
                imageButton.setVisibility(View.VISIBLE);
            }
            //判断点击效果
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listim.contains(diapath + "/" + strings)) {
                        imageButton.setImageResource(R.drawable.picture_unselected);
                        imageButton.setVisibility(View.GONE);
                        imageView.setColorFilter(Color.parseColor("#00000000"));
                        listim.remove(diapath + "/" + strings);
                          //选中效果的在下面的ScrollView上展示
                        for (int i = 0; i < viewList.size(); i++) {
                            if (viewList.get(i).equals(imgpath)) {
                                viewList.remove(i);
                                xuanzeCount--;
                                carmerPhotoNaonaoAdd.removeViewAt(i);
                                carmerPhotoNaonaoOk.setText("完成(" + xuanzeCount + "/9)");
                            }
                        }
                    } else {
                        if (xuanzeCount >= 9) {
                            //判断 是否超过所选中的Count是否超过所指定的
                            Toast.makeText(Carmer_Photo_NaoNao_Activity.this, "不能再选图片了", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        imageView.setColorFilter(Color.parseColor("#77000000"));
                        imageButton.setImageResource(R.drawable.pictures_selected);
                        imageButton.setVisibility(View.VISIBLE);
                        //将所选中的添加到视图上
                        View imgView = LayoutInflater.from(Carmer_Photo_NaoNao_Activity.this).inflate(R.layout.roundimage, null);
                        carmerPhotoNaonaoAdd.removeViewAt(carmerPhotoNaonaoAdd.getChildCount() - 1);
                        ImageView imageView1 = (ImageView) imgView.findViewById(R.id.rounde_imageview);
                        imageView1.setImageBitmap(bitmap);
                        String sbmap = bitmap.toString();
                        int i = sbmap.indexOf("@");
                        String bitmapname = sbmap.substring(i + 1, sbmap.length());
                        //用这个当做图片名（bitmap值有唯一性，这样也让图片名字有唯一性）
                          LogUtils.e("截取后的数据", bitmapname);


//                        每次将选中的图片的path路径存入集合
                        saveMyBitmap(bitmap, bitmapname);
//                        bList.add("/sdcard/" + bitmapname + ".png");
//                        Log.d("Myadapter", "bitmapname"+bitmapname);
                        bList.add(imgpath );
                        Log.d("Myadapter", "imgpath"+imgpath);
                       // 通过路径用Glide加载图片
                      Glide.with(Carmer_Photo_NaoNao_Activity.this).load(imgpath).into(imageView1);
                        viewList.add(imgpath);
                        xuanzeCount++;
                        carmerPhotoNaonaoAdd.addView(imgView);
                        carmerPhotoNaonaoAdd.addView(LayoutInflater.from(Carmer_Photo_NaoNao_Activity.this).inflate(R.layout.roundimage, null));
                        carmerPhotoNaonaoOk.setText("完成(" + xuanzeCount + "/9)");
                        listim.add(diapath + "/" + strings);
                        carmerPhotoNaonaoScroll.scrollTo(carmerPhotoNaonaoScroll.getChildAt(0).getRight(), 0);
                    }
                }
            });


        }

        //拍照后会返回bitmap对象，将bitmap保存在SD卡
        public void saveMyBitmap(Bitmap mBitmap, String bitName) {
            File f = new File("/sdcard/" + bitName + ".png");
            try {
                f.createNewFile();
            } catch (IOException e) {

            }
            FileOutputStream fOut = null;
            try {
                fOut = new FileOutputStream(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            try {
                fOut.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    // 获取 】每个相册的文件名字和图片的适配器
    private class MyPopAdapter extends BaseListAdapter<FolderBean> {


        public MyPopAdapter(Context context, List<FolderBean> list, int layoutID) {
            super(context, list, layoutID);
        }

        @Override
        protected void convert(ViewHolder holder, FolderBean folderBean) {
            holder.setImageLoader(R.id.pop_item_image, folderBean.getFirstDir());
        }
    }

    private View getAddView(int id) {
        return LayoutInflater.from(Carmer_Photo_NaoNao_Activity.this).inflate(id, null);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            if (bitmap != null) {
                carmerPhotoNaonaoAdd.removeViewAt(carmerPhotoNaonaoAdd.getChildCount() - 1);
                View imgView = LayoutInflater.from(Carmer_Photo_NaoNao_Activity.this).inflate(R.layout.roundimage, null);
                ImageView imageView1 = (ImageView) imgView.findViewById(R.id.rounde_imageview);
                imageView1.setImageBitmap(bitmap);
                carmerPhotoNaonaoAdd.addView(imgView);
                carmerPhotoNaonaoAdd.addView(LayoutInflater.from(Carmer_Photo_NaoNao_Activity.this).inflate(R.layout.roundimage, null));
                carmerPhotoNaonaoScroll.scrollTo(carmerPhotoNaonaoScroll.getChildAt(0).getRight(), 0);
            }
        }
    }
}
