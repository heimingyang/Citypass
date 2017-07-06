package com.example.citypass.cotroller.activity.find;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.discover.Belle_Select_Adapter;
import com.example.citypass.cotroller.adapter.discover.Publish_Boy_Adapter;
import com.example.citypass.model.bean.beele.BBoy_Bean;
import com.example.citypass.model.bean.information.Information;
import com.example.citypass.model.bean.information.Login;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;
import com.yuyh.library.imgsel.bean.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PublishActivity extends BaseActivity {


    @BindView(R.id.Publish_back)
    ImageView PublishBack;
    @BindView(R.id.Publish_relativelayout)
    RelativeLayout PublishRelativelayout;
    @BindView(R.id.Publish_img)
    ImageView PublishImg;
    @BindView(R.id.publish_checket)
    ImageView publishChecket;
    @BindView(R.id.Publish_relativelayout1)
    RelativeLayout PublishRelativelayout1;
    @BindView(R.id.publishi_content)
    EditText publishiContent;
    @BindView(R.id.publish_content_checket)
    TextView publishContentChecket;
    @BindView(R.id.publish_ok)
    Button publishOk;
    @BindView(R.id.publish_fengexian)
    TextView publishFengexian;
    @BindView(R.id.publish_recycle)
    RecyclerView publishRecycle;
    @BindView(R.id.publish_kongbai)
    TextView publishKongbai;
    //上个页面传过来的值
    private String name;
    private String birthday;
    private String job;
    private String qinggan;
    private String from;
    private String wx;
    private String qq;
    private String info;
    private String stringExtra;
    //dialog的组件
    private TextView tv_paizhao;
    private TextView tv_xiangce;
    private TextView tv_quxiao;
    private Dialog dialog;
    private Dialog dialog1;
    //图片选择框架需要的
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };
    private int REQUEST_CODE = 200;//相册请求码
    private int REQUEST_CODE1 = 201;//拍照的请求码
    private Uri photoUri;
    //装bitmap的集合
    private List<String> bList = new ArrayList<>();
    private Bitmap bm;
    //适配器
    private Belle_Select_Adapter belle_select_adapter;
    private Bitmap bm1;
    private int count;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    //男生dialog的内容
    private String[] boystr = {"单身墙", "颜值墙", "脱单墙", "炫技墙", "酱油墙"};


    private PopupWindow popupWindow;
    private View view1;

    //选择展示区域里的popupwindow中的组件
    private GridView boy_Gridview;
    private Button boy_Ok;
    //选择展示区域
    private int select;
    //popupgridview 适配器
    private Publish_Boy_Adapter publish_boy_adapter;
    private String sex;
    private String gril1;
    private String gril2;
    private String gril3;
    private String gril4;
    private String gril5;
    private String str;
    private String gril6;
    private String gril7;
    private String gril8;
    private String gril9;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish;


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        birthday = intent.getStringExtra("birthday");
        job = intent.getStringExtra("job");
        qinggan = intent.getStringExtra("qinggan");
        from = intent.getStringExtra("from");
        wx = intent.getStringExtra("wx");
        qq = intent.getStringExtra("qq");
        info = intent.getStringExtra("info");
        stringExtra = intent.getStringExtra("");
        sex = intent.getStringExtra("sex");
        LogUtils.e("sex", sex);


        if (bList.isEmpty()) {
            if (sex.contains("女")) {
                publishKongbai.setVisibility(View.GONE);
                publishContentChecket.setVisibility(View.GONE);
                PublishImg.setImageResource(R.drawable.cover_guide_upload1);

            } else {
                publishKongbai.setVisibility(View.VISIBLE);
                publishContentChecket.setVisibility(View.VISIBLE);
                PublishImg.setImageResource(R.drawable.cover_guide_upload2);


            }
        } else {
            Glide.with(this).load(bList.get(0)).into(PublishImg);

        }


    }

    @Override
    protected void initView() {
        publishRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }


    @OnClick({R.id.Publish_back, R.id.publish_checket, R.id.publish_content_checket, R.id.publish_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Publish_back:
                finish();

                break;
            //选择图片
            case R.id.publish_checket:
                showPublishDialog();

                break;
            //选择展示区域
            case R.id.publish_content_checket:
                showBoysChecket();


                break;
            //提交
            case R.id.publish_ok:
                if (sex.contains("女")) {
                    publishGril();

                } else {
                    publishBoy();
                }

                break;
        }
    }

    private void showPublishDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.publish_dialog, null);
        dialog = new AlertDialog.Builder(this).setView(view).create();
        if (bList.size() < 9) {
            dialog.show();

        } else {
            Toast.makeText(this, "最多只能选择9张图片", Toast.LENGTH_SHORT).show();
        }


        tv_paizhao = (TextView) view.findViewById(R.id.publish_dlog_paizhao);
        tv_xiangce = (TextView) view.findViewById(R.id.publish_dlog_xiangce);
        tv_quxiao = (TextView) view.findViewById(R.id.publish_dlog_quxiao);
        //拍照
        tv_paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                single();


            }
        });


        //相册
        tv_xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                multiselect();


            }
        });


        tv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });


    }

    //图片多选
    public void multiselect() {

        ImgSelConfig config = new ImgSelConfig.Builder(loader)
                .multiSelect(true)
                // 使用沉浸式状态栏
                .maxNum(9 - bList.size())
                .statusBarColor(Color.parseColor("#3F51B5")).build();

        ImgSelActivity.startActivity(this, config, REQUEST_CODE);
    }

    //拍照选图
    public void single() {
//执行拍照前，应该先判断SD卡是否存在
        String SDState = Environment.getExternalStorageState();
        if (SDState.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE1);
        } else {
            Toast.makeText(this, "内存卡不存在", Toast.LENGTH_LONG).show();
        }
    }


    //选择图片后的接口回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //选择图片返回数据
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);

            for (String path : pathList) {
                LogUtils.e("返回图片数据,-", path + "\n");
                bList.add(path);

            }
        }


        //拍照返回数据
        if (requestCode == REQUEST_CODE1 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            // 获取相机返回的数据，并转换为Bitmap图片格式，这是缩略图
            Bitmap bitmap = (Bitmap) bundle.get("data");

            String sbmap = bitmap.toString();
            LogUtils.e("拍照返回数据", sbmap);
            int i = sbmap.indexOf("@");
            String bitmapname = sbmap.substring(i + 1, sbmap.length());
            //用这个当做图片名（bitmap值有唯一性，这样也让图片名字有唯一性）
            LogUtils.e("截取后的数据", bitmapname);

            //将bitmap对象转成图片，保存在SD卡
            saveMyBitmap(bitmap, bitmapname);
            bList.add("/sdcard/" + bitmapname + ".png");

        }
        belle_select_adapter = new Belle_Select_Adapter(PublishActivity.this, bList);
        publishRecycle.setAdapter(belle_select_adapter);
        belle_select_adapter.setOnItemClickListener(new Belle_Select_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Glide.with(PublishActivity.this).load(bList.get(position)).into(PublishImg);
                count = position;
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

    //选择展示区域的popup
    private void showBoysChecket() {
        view1 = LayoutInflater.from(PublishActivity.this).inflate(R.layout.boy_muban, null);
        boy_Gridview = (GridView) view1.findViewById(R.id.boy_checket_gridview);
        boy_Ok = (Button) view1.findViewById(R.id.boy_checket_btn);
        publish_boy_adapter = new Publish_Boy_Adapter(PublishActivity.this, boystr);
        boy_Gridview.setAdapter(publish_boy_adapter);
        boy_Gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                publish_boy_adapter.setSeclection(position);
                publish_boy_adapter.notifyDataSetChanged();
                str = boystr[position];
                Log.i("stttttt", str);

            }
        });

        boy_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publishKongbai.setText(str);
                popupWindow.dismiss();


            }
        });


        popupWindow = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(publishRecycle);


    }

    //男生发表
    private void publishBoy() {
        //username
        str1 = "{\n" +
                "    \"appName\": \"CcooCity\",\n" +
                "    \"Param\": {\n" +
                "        \"username\": \"";
        //type

        str2 = "\",\n" +
                "        \"TypeId\": \"";
        //content
        str3 = "\",\n" +
                "        \"mapname\": \"不显示地理位置\",\n" +
                "        \"description\": \"";
        //userid
        str4 = "\",\n" +
                "        \"userid\": ";
        //photo
        str5 = ",\n" +
                "        \"siteid\": 2422,\n" +
                "        \"photo\": \"";
        str6 = "\",\n" +
                "        \"mappoint\": \"4.9E-324,4.9E-324\"\n" +
                "    },\n" +
                "    \"requestTime\": \"2017-07-01 11:04:51\",\n" +
                "    \"customerKey\": \"FB3643F4C0F47FC444FE89AD04669AFB\",\n" +
                "    \"Method\": \"PHSocket_SetBoyCoverUserAndInfo\",\n" +
                "    \"Statis\": {\n" +
                "        \"PhoneId\": \"133524541070404\",\n" +
                "        \"System_VersionNo\": \"Android 4.2.2\",\n" +
                "        \"UserId\": 31363437,\n" +
                "        \"PhoneNum\": \"+8617646525761\",\n" +
                "        \"SystemNo\": 2,\n" +
                "        \"PhoneNo\": \"GT-P5210\",\n" +
                "        \"SiteId\": 2422\n" +
                "    },\n" +
                "    \"customerID\": 8001,\n" +
                "    \"version\": \"4.5\"\n" +
                "}";

        Map<String, String> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bList.size(); i++) {
            String s = bList.get(i);
            if (i < bList.size()) {
                sb.append(s + ",");
            } else if (i == bList.size()) {
                sb.append(s);
            }
        }

        map.put("param", str1 + LoginUtils.information.getServerInfo().getUserName() + str2 + "1" + str3 + publishiContent.getText().toString() + str4 + LoginUtils.information.getServerInfo().getId() + str5 + sb.toString() + str6);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                BBoy_Bean bBoy_bean = JSON.parseObject(result, BBoy_Bean.class);
                int code = bBoy_bean.getMessageList().getCode();
                if (code == 1000) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LogUtils.e("发表状态", "成功");
                            Toast.makeText(PublishActivity.this, "发表成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });

                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(PublishActivity.this, "发表失败", Toast.LENGTH_SHORT).show();

                        }
                    });
                    LogUtils.e("发表状态", "失败");

                }

            }

            @Override
            public void onError(String errormsg) {
                LogUtils.e("发表状态", "失败");


            }
        });

    }

    //女生发表
    private void publishGril() {
//        userid
        gril1 = "{\n" +
                "    \"appName\": \"CcooCity\",\n" +
                "    \"Param\": {\n" +
                "        \"userid\": ";
//        siteid
        gril2 = ",\n" +
                "        \"siteid\": ";
//        username
        gril3 = ",\n" +
                "        \"username\": \"";
        //photo
        gril4 = "\",\n" +
                "        \"mapname\": \"不显示地理位置\",\n" +
                "        \"photo\": \"";
        //description
        gril5 = "\",\n" +
                "        \"description\": \"";

//requestTime
        gril6 = "\",\n" +
                "        \"mappoint\": \"4.9E-324,4.9E-324\"\n" +
                "    },\n" +
                "    \"requestTime\": \"";

//        userid
        gril7 = "\",\n" +
                "    \"customerKey\": \"C4F3EAA8E9540ECDAEFA80EB5BD4A8D9\",\n" +
                "    \"Method\": \"PHSocket_SetCover_UserAndInfo\",\n" +
                "    \"Statis\": {\n" +
                "        \"PhoneId\": \"861677342183129\",\n" +
                "        \"System_VersionNo\": \"Android 4.4.4\",\n" +
                "        \"UserId\": ";

//SiteId
        gril8 = ",\n" +
                "        \"PhoneNum\": \"+8617641727221\",\n" +
                "        \"SystemNo\": 2,\n" +
                "        \"PhoneNo\": \"GT-P5210\",\n" +
                "        \"SiteId\": ";

        gril9 = " },\n" +
                "    \"customerID\": 8001,\n" +
                "    \"version\": \"4.5\"\n" +
                "}";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String time = formatter.format(curDate);
        LogUtils.e("time", time);

        Map<String, String> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bList.size(); i++) {
            String s = bList.get(i);
            if (i < bList.size()) {
                sb.append(s + ",");
            } else if (i == bList.size()) {
                sb.append(s);
            }
        }
        Information.ServerInfoBean serverInfo = LoginUtils.information.getServerInfo();
        map.put("param", gril1 + serverInfo.getId() + gril2 + serverInfo.getSiteID() + gril3 + serverInfo.getUserName() + gril4 + sb.toString() + gril5 + publishiContent.getText().toString()
                + gril6 + time + gril7 + serverInfo.getId() + gril8 + serverInfo.getSiteID() + gril9
        );


        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("---------------->", result);
                BBoy_Bean bBoy_bean = JSON.parseObject(result, BBoy_Bean.class);
                int code = bBoy_bean.getMessageList().getCode();
                if (code == 1000) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LogUtils.e("发表状态", "成功");
                            Toast.makeText(PublishActivity.this, "发表成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });

                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(PublishActivity.this, "发表失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                    LogUtils.e("发表状态", "失败");

                }
            }

            @Override
            public void onError(String errormsg) {

                LogUtils.e("发表状态", "失败");

            }
        });

    }
}
