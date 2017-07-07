package com.example.citypass.cotroller.activity.naonao;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.naonao.Carmer_FaBu_NaoNao_Grid_Adapter;
import com.example.citypass.model.bean.naonao.Carmer_FaBu_NaoNao_publish_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.citypass.R.layout.item;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/29 0029 15:10
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


public class Carmer_FaBu_NaoNao_Activity extends BaseActivity {

    @BindView(R.id.carmer_fabu_naonao_cancel)
    ImageView carmerFabuNaonaoCancel;
    @BindView(R.id.carmer_fabu_naonao_fabu)
    TextView carmerFabuNaonaoFabu;
    @BindView(R.id.mail_Relative)
    RelativeLayout mailRelative;


    @BindView(R.id.carmer_fabu_naonao_edit)
    EditText carmerFabuNaonaoEdit;
    @BindView(R.id.carmer_fabu_naonao_worry)
    ImageView carmerFabuNaonaoWorry;
    @BindView(R.id.carmer_fabu_naonao_address)
    RelativeLayout carmerFabuNaonaoAddress;
    @BindView(R.id.carmer_fabu_naonao_emoji)
    ImageView carmerFabuNaonaoEmoji;
    @BindView(R.id.carmer_fabu_naonao_aite)
    ImageView NaonaoAite;
    @BindView(R.id.carmer_fabu_naonao_yuyin)
    ImageView carmerFabuNaonaoYuyin;
    @BindView(R.id.carmer_fabu_naonao_collect)
    ImageView carmerFabuNaonaoCollect;
    @BindView(R.id.hehe)
    RelativeLayout hehe;
    @BindView(R.id.view_pager_content)
    LinearLayout linear01;
    @BindView(R.id.viewGroup)
    LinearLayout linear02;
    @BindView(R.id.shangdian)
    TextView shangdian;
    @BindView(R.id.carmer_fabu_naonao_shangdian)
    ImageView carmerFabuNaonaoShangdian;
    @BindView(R.id.carmer_fabu_naonao_emoji_v)
    LinearLayout carmerFabuNaonaoEmojiV;
    @BindView(R.id.carmer_fabu_naonao_add)
    LinearLayout carmerFabuNaonaoAdd;
    @BindView(R.id.carmer_fabu_naonao_scroll)
    HorizontalScrollView carmerFabuNaonaoScroll;
    @BindView(R.id.carmer_fabu_naonao_title)
    RelativeLayout carmerFabuNaonaoTitle;
    @BindView(R.id.carmer_fabu_naonao_grid)
    GridView carmerFabuNaonaoGrid;
    private List<Integer> listView;
    private int next = 0;
    private ViewPager adViewPager;
    private AdPageAdapter adapter;
    private ImageView[] imageViews;
    private ImageView imageView;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private boolean isContinue = true;
    private List<View> gridViewlist = new ArrayList<View>();
    private ArrayList<String> path;
    private View imgView;
    private String img;
    private List<String> list;

    private List<String> mlist = new ArrayList<>();
    private Carmer_FaBu_NaoNao_Grid_Adapter camer_grid_adapter;
    private String str_count;

    @Override
    protected int getLayoutId() {
        return R.layout.carmer_fabu_naonao_activity;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"audioTime\":0,\"vcID\":\"\",\"atname\":\"\",\"audio\":\"\",\"uID\":\"31363437\",\"image\":\"http:\\/\\/p9.pccoo.cn\\/app_bbs\\/20170703\\/2017070311380591652347_3_3.png,http:\\/\\/p9.pccoo.cn\\/app_bbs\\/20170703\\/2017070311380608203833_60_60.png,http:\\/\\/p9.pccoo.cn\\/app_bbs\\/20170703\\/2017070311380620830984_62_61.png\",\"mapPoint\":\"4.9E-324,4.9E-324\",\"type\":2,\"usiteID\":2422,\"gambitID\":4605,\"mapName\":\"不显示地理位置\",\"content\":\"[sys\\/2.gif][sys\\/3.gif]vv发v[sys\\/4.gif][sys\\/5.gif]v多个\",\"siteID\":2422,\"source\":2,\"userName\":\"sid094756353406476\"},\"requestTime\":\"2017-07-03 11:39:08\",\"customerKey\":\"02DCE2ED53D3CB63EC4FD8194B2F932C\",\"Method\":\"PHSocket_SetTieBaAdd\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":31363437,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        String a = "{\"appName\":\"CcooCity\",\"Param\":{\"audioTime\":0,\"vcID\":\"\",\"atname\":\"\",\"audio\":\"\",\"uID\":";
        String uID = LoginUtils.information.getServerInfo().getId() + "";
        Log.d("Carmer_FaBu_NaoNao_Acti", "uID" + uID);
        String b = ",\"image\":\"";
        for (int i = 0; i < path.size(); i++) {
            img = path.get(i) + ",";
        }
        Log.d("Carmer_FaBu_NaoNao_Acti", "image" + img);
        String sa = "\",\"mapPoint\":\"4.9E-324,4.9E-324\",\"type\":2,\"usiteID\":";
        int id = 2422;
        String sd = ",\"gambitID\":4605,\"mapName\":\"不显示地理位置\",\"content\":\"";
        int unicodeJoy = 0x1F602;
        String emojiString = getEmojiStringByUnicode(unicodeJoy);
        carmerFabuNaonaoEdit.append(emojiString);
        String context = carmerFabuNaonaoEdit.getText().toString().trim() + "";

        Log.d("Carmer_FaBu_NaoNao_Acti", "context" + context);
        String e = "\",\"siteID\":2422,\"source\":2,\"userName\":\"";
        String userName = LoginUtils.information.getServerInfo().getUserName() + "";
        Log.d("Carmer_FaBu_NaoNao_Acti", "userName" + userName);
        String f = "\"},\"requestTime\":\"2017-07-03 11:39:08\",\"customerKey\":\"02DCE2ED53D3CB63EC4FD8194B2F932C\",\"Method\":\"PHSocket_SetTieBaAdd\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":31363437,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", a + uID + b + img + sa + id + sd + context + e + userName + f);
        Log.d("Carmer_FaBu_NaoNao_Acti", a + uID + b + img + sa + id + sd + context + e + userName + f);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Carmer_FaBu_NaoNao_Acti", result);
                Carmer_FaBu_NaoNao_publish_Bean carmer_faBu_naoNao_publish_bean = JSON.parseObject(result, Carmer_FaBu_NaoNao_publish_Bean.class);
                if (carmer_faBu_naoNao_publish_bean.getMessageList().getCode() == 1000) {
                    Toast.makeText(Carmer_FaBu_NaoNao_Activity.this, "发表成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(Carmer_FaBu_NaoNao_Activity.this, "发表失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {
                Log.d("Carmer_FaBu_NaoNao_Acti", errormsg);
            }
        });
    }



    //回调


    @Override
    protected void initView() {
        carmerFabuNaonaoEmojiV.setVisibility(View.GONE);
        Intent intent = getIntent();


//        carmerFabuNaonaoAdd.addView(LayoutInflater.from(this).inflate(R.layout.carmer_fabu_naonao_img, null));

        path = intent.getStringArrayListExtra("path");
        for (int i = 0; i < path.size(); i++) {
            imgView = LayoutInflater.from(Carmer_FaBu_NaoNao_Activity.this).inflate(R.layout.carmer_fabu_naonao_img, null);
            ImageView imageView1 = (ImageView) imgView.findViewById(R.id.rounde_imageview);
            Log.d("我的path", path.get(i));
            Glide.with(Carmer_FaBu_NaoNao_Activity.this).load(path.get(i)).into(imageView1);
            carmerFabuNaonaoAdd.addView(imgView);

            Log.d("Carmer_FaBu_NaoNao_Acti", "imageView1:" + imageView1);
        }

        carmerFabuNaonaoScroll.scrollTo(carmerFabuNaonaoScroll.getChildAt(0).getRight(), 0);
        View via = LayoutInflater.from(this).inflate(R.layout.carmer_fabu_naonao_img, null);
        ImageView im = (ImageView) via.findViewById(R.id.rounde_imageview);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Carmer_FaBu_NaoNao_Activity.this, Carmer_Photo_NaoNao_Activity.class);
                startActivity(in);
                finish();
            }
        });
        carmerFabuNaonaoAdd.addView(via);


        listView = new ArrayList<>();
        // 创建ViewPager
        adViewPager = new ViewPager(this);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        // 设置属性
        adViewPager.setLayoutParams(new ViewGroup.LayoutParams(dm.widthPixels, dm.heightPixels));
        linear01.addView(adViewPager);

        getView();
        initCirclePoint();
        // 将GridView添加到ViewPager显示
        adViewPager.setAdapter(adapter);
        adViewPager.setOnPageChangeListener(new AdPageChangeListener());

        for (int i = 0; i < gridViewlist.size(); i++) {
            GridView view = (GridView) gridViewlist.get(i);
            final int finalI = i;
            view.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
//                    Toast.makeText(getApplicationContext(), item.get("image").toString(), Toast.LENGTH_LONG).show();
                    // 得到随机表情图片的Bitmap
                    Integer in = listView.get(position);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                            in);
                    // 得到SpannableString对象,主要用于拆分字符串
                    SpannableString spannableString = new SpannableString("[sys\\/" + String.valueOf(finalI) + ".gif]");
                    // 得到ImageSpan对象
                    ImageSpan imageSpan = new ImageSpan(Carmer_FaBu_NaoNao_Activity.this, bitmap);
                    // 调用spannableString的setSpan()方法
                    spannableString.setSpan(imageSpan, 0, 12,
                            Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

                    // 给EditText追加spannableString
                    carmerFabuNaonaoEdit.append(spannableString);
                    String newContent = carmerFabuNaonaoEdit.getText().toString().trim();
//                    CharSequence replace = smileyParser.strToSmiley(newContent);
//                    myEditText.setText(replace);
//                    myEditText.setSelection(replace.length());
                }
            });
        }
    }


    private final class AdPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            atomicInteger.getAndSet(arg0);
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0].setBackgroundResource(R.drawable.main_tuan_dian1);
                if (arg0 != i) {
                    imageViews[i].setBackgroundResource(R.drawable.main_tuan_dian2);
                }
            }
        }
    }

    private void initCirclePoint() {
        System.out.println("initCirclePoint()");
        imageViews = new ImageView[gridViewlist.size()];
        for (int i = 0; i < gridViewlist.size(); i++) {
            imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(40, 50, 40, 50);
            imageView.setLayoutParams(layoutParams);
            imageViews[i] = imageView;
            // 对内容进行Base64
            if (i == 0) {
                imageViews[i].setBackgroundResource(R.drawable.main_tuan_dian1);
            } else {
                imageViews[i].setBackgroundResource(R.drawable.main_tuan_dian1);
            }
            linear02.addView(imageViews[i]);
        }
    }

    private void getView() {

        int[] intView = {R.drawable.sys1, R.drawable.sys2, R.drawable.sys4,
                R.drawable.sys6, R.drawable.sys7, R.drawable.sys8, R.drawable.sys9, R.drawable.sys10,
                R.drawable.sys11, R.drawable.sys12, R.drawable.sys13, R.drawable.sys14, R.drawable.sys15,
                R.drawable.sys16, R.drawable.sys17, R.drawable.sys18, R.drawable.sys19, R.drawable.sys20,
                R.drawable.sys21, R.drawable.sys22, R.drawable.sys23, R.drawable.sys24, R.drawable.sys25, R.drawable.sys26,
                R.drawable.sys27, R.drawable.sys28, R.drawable.sys29, R.drawable.sys30, R.drawable.sys31, R.drawable.sys32,
                R.drawable.sys33, R.drawable.sys34, R.drawable.sys35, R.drawable.sys36, R.drawable.sys37, R.drawable.sys38,
                R.drawable.sys39, R.drawable.sys40, R.drawable.sys41, R.drawable.sys42, R.drawable.sys43, R.drawable.sys44,
                R.drawable.sys45, R.drawable.sys46, R.drawable.sys47, R.drawable.sys48, R.drawable.sys49, R.drawable.sys50,
                R.drawable.sys51
        };
        for (int i = 0; i < intView.length; i++) {
//            Integer in = listView.get()
//            Map<String, Object> mapView = new HashMap<String, Object>();
//            mapView.put("image", intView[i]);
            listView.add(intView[i]);
        }
        getGridView();
    }

    private void getGridView() {
        System.out.println("getGridView" + listView.size());
        boolean bool = true;
        while (bool) {
            int result = next + 18;
            System.out.println("result" + result);
            if (listView.size() != 0 && result < listView.size()) {
                System.out.println("result+kkkkkkkkkk" + result);
                GridView gridView = new GridView(this);
                int height = 28;//此处的高度需要动态计算
                int width = 30;//此处的宽度需要动态计算
                LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(width, height);
                gridView.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
                gridView.setNumColumns(6);
                List<Integer> gridlist = new ArrayList<Integer>();
                for (int i = next; i < result; i++) {
                    gridlist.add(listView.get(i));
                }
                MyAdapter myAdapter = new MyAdapter(gridlist);
                gridView.setAdapter(myAdapter);
                next = result;
                gridViewlist.add(gridView);

            } else if (result - listView.size() <= 18) {
                List<Integer> gridlist = new ArrayList<Integer>();
                for (int i = next; i < listView.size(); i++) {
                    gridlist.add(listView.get(i));
                }
                GridView gridView = new GridView(this);
                int height = 28;//此处的高度需要动态计算
                int width = 30;//此处的宽度需要动态计算
                LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(width, height);
                gridView.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
                gridView.setNumColumns(6);
                MyAdapter myAdapter = new MyAdapter(gridlist);
                gridView.setAdapter(myAdapter);
                next = listView.size() - 1;
                gridViewlist.add(gridView);
                bool = false;
            } else {
                bool = false;
            }
        }
        adapter = new AdPageAdapter(gridViewlist);

    }

    boolean flagDoubleCick = false;

    @OnClick({R.id.carmer_fabu_naonao_cancel, R.id.carmer_fabu_naonao_fabu, R.id.carmer_fabu_naonao_worry, R.id.carmer_fabu_naonao_emoji, R.id.carmer_fabu_naonao_aite, R.id.carmer_fabu_naonao_yuyin, R.id.carmer_fabu_naonao_collect, R.id.carmer_fabu_naonao_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.carmer_fabu_naonao_cancel:

                openConfirmDialog(this, "操作提示", "你还未完成发布，确定退出吗？", "确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
//TODO
                                finish();
                            }
                        }, "取消", new DialogInterface.OnClickListener() {


                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                //TODO
                                dialog.dismiss();
                            }
                        });


                break;
            case R.id.carmer_fabu_naonao_fabu:
                initParsing();
                break;
            case R.id.carmer_fabu_naonao_worry:
                carmerFabuNaonaoAddress.setVisibility(View.GONE);
                break;
            case R.id.carmer_fabu_naonao_emoji:

                if (!flagDoubleCick) {
                    carmerFabuNaonaoEmojiV.setVisibility(View.VISIBLE);
                    flagDoubleCick = true;
                } else {
                    carmerFabuNaonaoEmojiV.setVisibility(View.GONE);
                    flagDoubleCick = false;
                }

                break;
            case R.id.carmer_fabu_naonao_aite:
                Intent in = new Intent(Carmer_FaBu_NaoNao_Activity.this, Carmer_FaBu_AiTe_NaoNao_Activity.class);
                startActivity(in);
                break;
            case R.id.carmer_fabu_naonao_yuyin:
                break;
            case R.id.carmer_fabu_naonao_collect:
                break;
            case R.id.carmer_fabu_naonao_title:
                Intent ian = new Intent(Carmer_FaBu_NaoNao_Activity.this, Carmer_FaBu_NaoNao_Title_Activity.class);
                startActivityForResult(ian, 200);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            //当请求码为200
            case 200:
                switch (resultCode) {
                    case 201:
                        Bundle title = data.getBundleExtra("title");
                        String title1 = title.getString("title");
                        Log.e("回传数据", title1);
//
                        mlist.add(title1);
                        camer_grid_adapter = new Carmer_FaBu_NaoNao_Grid_Adapter(mlist);
                        carmerFabuNaonaoGrid.setAdapter(camer_grid_adapter);
                        carmerFabuNaonaoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String str = mlist.get(position);
                                carmerFabuNaonaoEdit.append("#" + str + "#");
                            }
                        });
                }
                break;

        }

//
//        if (requestCode == 0 && resultCode == 100) {
//            Bundle bun = data.getExtras();
//            String text = null;
//            if (bun != null)
//                text = bun.getString("title");
//            Log.d("text", text);
//

    }
    private String getEmojiStringByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    private final class AdPageAdapter extends PagerAdapter {
        private List<View> views = null;

        public AdPageAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(views.get(position));
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(View container, final int position) {
            ((ViewPager) container).addView(views.get(position), 0);
            Log.d("AdPageAdapter", "hehe");
            return views.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    private class MyAdapter extends BaseAdapter {
        List<Integer> listgrid;

        private MyAdapter(List<Integer> listgrid) {
            this.listgrid = listgrid;
        }

        @Override
        public int getCount() {
            return listgrid.size();
        }

        @Override
        public Object getItem(int position) {
            return listgrid.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(item, null);
            ImageView getViewLinear = (ImageView) convertView.findViewById(R.id.hehe);
            getViewLinear.setBackgroundResource(Integer.parseInt(listgrid.get(position).toString()));
            return convertView;
        }
    }

    public static AlertDialog openConfirmDialog(Context context, String title,
                                                String msg, String okbutton, DialogInterface.OnClickListener ok, String nobutton,
                                                DialogInterface.OnClickListener no) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage("\n" + msg + "\n");
        builder.setNegativeButton(okbutton, ok);
        builder.setNeutralButton(nobutton, no);
        AlertDialog loadWaitDialog = builder.create();
        loadWaitDialog.setCanceledOnTouchOutside(false);
        loadWaitDialog.show();
        return loadWaitDialog;

    }

    /**
     * 监听返回按钮
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            openConfirmDialog(this, "操作提示", "你还未完成发布，确定退出吗？", "确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
//TODO
                            finish();
                        }
                    }, "取消", new DialogInterface.OnClickListener() {


                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {

                            //TODO
                            dialog.dismiss();
                        }
                    });
        }


        return false;

    }

}