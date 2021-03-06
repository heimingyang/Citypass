package com.example.citypass.cotroller.activity.naonao;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.naonao.Title_Detail_NaoNao_Adapter;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.model.bean.naonao.Title_Detail_NaoNao_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.view.MRecyclerView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class Title_Detail_NaoNao_Activity extends BaseActivity {

    @BindView(R.id.title_detail_naonao_activity_cancel)
    ImageView titleDetailNaonaoActivityCancel;
    @BindView(R.id.title_detail_naonao_activity_name)
    TextView titleDetailNaonaoActivityName;
    @BindView(R.id.title_detail_naonao_activity_xiangqing)
    ImageView titleDetailNaonaoActivityXiangqing;
    @BindView(R.id.title_detail_naonao_activity)
    MRecyclerView titleDetailNaonaoActivity;
    @BindView(R.id.title_detail_naonao_activity_fabu)
    ImageView titleDetailNaonaoActivityFabu;
    private List<Title_Detail_NaoNao_Bean.ServerInfoBean> mList = new ArrayList<>();
    private Title_Detail_NaoNao_Adapter adapter;
    private Intent in;
    private View v;
    private PopupWindow pop;

    @Override
    protected int getLayoutId() {
        return R.layout.title__detail__nao_nao_activity;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {


    }

    private void getData() {
        TextView mRenQi = (TextView) v.findViewById(R.id.title_detail_tou_naonao_text_look);
        TextView mCanYu = (TextView) v.findViewById(R.id.title_detail_tou_naonao_text_canyu);
        TextView mDescription = (TextView) v.findViewById(R.id.title_detail_tou_naonao_body);
        ImageView im = (ImageView) v.findViewById(R.id.title_detail_tou_naonao_img);
        Glide.with(this).load(in.getStringExtra("image")).into(im);
        mRenQi.setText(" 人气 " + in.getIntExtra("renqi", 0) + "");
        mCanYu.setText(" 参与 " + in.getIntExtra("canyu", 0) + "");

        mDescription.setText("#" + in.getStringExtra("name") + "#" + in.getStringExtra("body"));
    }

    /*
    in.putExtra("name",bean.getTitle());
                    in.putExtra("renqi",bean.getHit());
                    in.putExtra("canyu",bean.getCSum());
                    in.putExtra("body",bean.getDescription());
     */
    @Override
    protected void initView() {
        in = getIntent();
        titleDetailNaonaoActivityName.setText("#" + in.getStringExtra("name") + "#");
        v = LayoutInflater.from(this).inflate(R.layout.title_detail_tou_naonao_activity, null);
        LinearLayoutManager man = new LinearLayoutManager(this);
        getData();

        if (in.getSerializableExtra("user") == null) {
            Toast.makeText(this, "返回的数据为空", Toast.LENGTH_SHORT).show();
        } else {
            initParsing();
        }
        titleDetailNaonaoActivity.addHeaderView(v);
        titleDetailNaonaoActivity.setLayoutManager(man);
        TextView tv = new TextView(Title_Detail_NaoNao_Activity.this);
        tv.setText("没有更多内容了~");
        tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        titleDetailNaonaoActivity.setFootView(tv);
        titleDetailNaonaoActivity.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                titleDetailNaonaoActivity.refreshComplete();
            }

            {

            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":30108866,\"siteID\":2422,\"flag\":1,\"gambitid\":132,\"curPage\":1,\"pageSize\":10,\"oldTime\":\"2017-06-26  11:41:53\",\"type\":2,\"istop_count\":0},\"requestTime\":\"2017-06-26 11:41:57\",\"customerKey\":\"D5C9290ED19143A77F056DD7EF73846E\",\"Method\":\"PHSocket_GetTieBaList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":30108866,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Title_Detail_NaoNao_Act", result);
                Title_Detail_NaoNao_Bean title_detail_naoNao_bean = JSON.parseObject(result, Title_Detail_NaoNao_Bean.class);
                mList.addAll(title_detail_naoNao_bean.getServerInfo());
                if (adapter == null) {
                    adapter = new Title_Detail_NaoNao_Adapter(mList);
                    titleDetailNaonaoActivity.setAdapter(adapter);
                } else {
                    adapter.setNewData(mList);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @OnClick({R.id.title_detail_naonao_activity_cancel, R.id.title_detail_naonao_activity_xiangqing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_detail_naonao_activity_cancel:
                onBackPressed();
                break;
            case R.id.title_detail_naonao_activity_xiangqing:
                UMImage img = new UMImage(Title_Detail_NaoNao_Activity.this, R.drawable.aaa);
                UMWeb web = new UMWeb("http://appnew.ccoo.cn/appserverapi.ashx");
                web.setTitle("伪摄影师的杰作");//标题
                web.setThumb(img);  //缩略图
                web.setDescription("新版本上线，一起来露露脸吧，用小视频打个招呼~");//描述
                new ShareAction(Title_Detail_NaoNao_Activity.this).withText("hello")
                        .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();

                break;
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(Title_Detail_NaoNao_Activity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(Title_Detail_NaoNao_Activity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(Title_Detail_NaoNao_Activity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }



    @OnClick(R.id.title_detail_naonao_activity_fabu)
    public void onViewClicked() {
//       //是否登录
        if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
            initPop();
            pop.showAsDropDown(v, 0, 0, Gravity.BOTTOM);
        } else {
            Intent in = new Intent(Title_Detail_NaoNao_Activity.this, LoginActivity.class);
            startActivity(in);
        }
    }

    private void initPop() {
        View v = LayoutInflater.from(Title_Detail_NaoNao_Activity.this).inflate(R.layout.carmer_naonao_popupwindow_activity, null);
        RelativeLayout viewById = (RelativeLayout) v.findViewById(R.id.naonaonaonaonaonaonao);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        pop = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        //popupWindow的背景透明度
        v.getBackground().setAlpha(180);
        //颜色
        pop.setBackgroundDrawable(new BitmapDrawable());
        //popupWindow的外部点击
        pop.setOutsideTouchable(true);
//        pop.setFocusable(false);
        //返回
        LinearLayout mCancel = (LinearLayout) v.findViewById(R.id.carmer_naonao_popupwindow_activity_cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        LinearLayout mVideo  = (LinearLayout) v.findViewById(R.id.carmer_naonao_popupwindow_activity_video);
        //小视频的点击事件
        mVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAndroidSDKVersion() >= 23){

                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO)
                            != PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(Title_Detail_NaoNao_Activity.this,  new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.RECORD_AUDIO
                        },0);
                    }
                }else {
                    Intent in = new Intent(Title_Detail_NaoNao_Activity.this,NaoNao_Carmer_Activity.class);
                    startActivity(in);
                }


            }


        });
        LinearLayout mPhoto = (LinearLayout) v.findViewById(R.id.carmer_naonao_popupwindow_activity_photo);
        mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Title_Detail_NaoNao_Activity.this, Carmer_Photo_NaoNao_Activity.class);
                startActivity(in);
            }
        });
    }

    private boolean hasAllPermissionsGranted(int[] grantResults) {
        for (int grantResult : grantResults) {

            // PackageManager.PERMISSION_GRANTED  //有权限   PackageManager.PERMISSION_DENIED无权限
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
    private void showPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Title_Detail_NaoNao_Activity.this);
        builder.setTitle("帮助");
        builder.setMessage("当前应用缺少相机权限或者录音权限。请点击\"设置\"-打开所需权限。");
        // 拒绝, 退出应用
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        // 判断是否有权限
        if (requestCode == 0 && hasAllPermissionsGranted(grantResults)) {

            //有权限 去启动Video
            Intent in = new Intent(Title_Detail_NaoNao_Activity.this,NaoNao_Carmer_Activity.class);
            startActivity(in);
        } else {

            //去打开权限

            showPermissionDialog();
        }
    }

    private int getAndroidSDKVersion() {
        int version = 0;
        try {
            version = Integer.valueOf(android.os.Build.VERSION.SDK);
            Log.d("NaoNaoFragment", "version:" + version);
        } catch (NumberFormatException e) {
            Log.d("NaoNaoFragment", e.toString());
        }
        return version;
    }
    private static final String PACKAGE_URL_SCHEME = "package:"; // 方案
    // 启动应用的设置
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + getPackageName()));
        startActivity(intent);
    }
}
