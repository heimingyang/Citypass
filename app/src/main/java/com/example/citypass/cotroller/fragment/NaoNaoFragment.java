package com.example.citypass.cotroller.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.activity.naonao.Carmer_Photo_NaoNao_Activity;
import com.example.citypass.cotroller.activity.naonao.NaoNao_Carmer_Activity;
import com.example.citypass.cotroller.adapter.naonao.NaoNao_Tab_Adapter;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.naonao.Di_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Net_Friend_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Picture_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Recommond_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Square_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Star_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Title_NaoNao_Fragment;
import com.example.citypass.cotroller.fragment.naonao.Wang_NaoNao_Fragment;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

import static com.umeng.facebook.FacebookSdk.getApplicationContext;
import static com.umeng.socialize.utils.ContextUtil.getPackageName;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 8:19
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

public class NaoNaoFragment extends BaseFragment {

    @BindView(R.id.naonao_tab)
    TabLayout naonaoTab;
    @BindView(R.id.NaoNao_viewpager)
    ViewPager naonaoViewpager;
    Unbinder unbinder;
    private List<Fragment> mFraList = new ArrayList<>();
    private List<String> mStrList = new ArrayList<>();
    private int a = 0;
    private PopupWindow pop;
    private View view;
    // TODO: 2017/6/26 0026 加载数据
    @Override
    protected void initData() {
        if (a == 0) {
            mFraList.add(new Di_NaoNao_Fragment());
            mFraList.add(new Wang_NaoNao_Fragment());
            mFraList.add(new Star_NaoNao_Fragment());
            mFraList.add(new Square_NaoNao_Fragment());
            mFraList.add(new Title_NaoNao_Fragment());
            mFraList.add(new Recommond_NaoNao_Fragment());
            mFraList.add(new Picture_NaoNao_Fragment());
            mFraList.add(new Net_Friend_NaoNao_Fragment());
//        Map<String,String> map = new HashMap<>();
//        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"type\":1,\"siteID\":2422},\"requestTime\":\"2017-06-19 11:52:02\",\"customerKey\":\"B8ABEBF85C69DC0B7D33F4317B5AC0CB\",\"Method\":\"PHSocket_GetUseNavigationInfo\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
//        map.put("param",str);
//        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
//            @Override
//            public void onSuccess(String result) {
//                Log.d("NaoNaoFragment", result);
//                Gson gson = new Gson();
//                NaoNao_Bean bean =  gson.fromJson(result, NaoNao_Bean.class);
//                List<NaoNao_Bean.ServerInfoBean> mList = bean.getServerInfo();
//                for(int i = 0;i<mList.size();i++){
//                    mStrList.add(mList.get(i).getName());
//                }
//            }
//
//            @Override
//            public void onError(String errormsg) {
//                Log.d("NaoNaoFragment", errormsg);
//            }
//        });
            mStrList.add("闹闹帝");
            mStrList.add("闹闹王");
            mStrList.add("闹闹星");
            mStrList.add("广场");
            mStrList.add("话题");
            mStrList.add("推荐");
            mStrList.add("晒图");
            mStrList.add("网友自荐");
            naonaoTab.setTabMode(TabLayout.MODE_SCROLLABLE);
            NaoNao_Tab_Adapter mAdapter = new NaoNao_Tab_Adapter(getActivity().getSupportFragmentManager(), mFraList, mStrList);
            naonaoViewpager.setAdapter(mAdapter);
            naonaoViewpager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(naonaoTab) {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                }
            });
            naonaoTab.setupWithViewPager(naonaoViewpager);
            a = 1;

        }
    }


    @Override
    protected void initListener() {

    }

    // TODO: 2017/6/26 0026 初始化数据
    @Override
    protected void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_naonao;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //判断当前的页面的头部TextView
        App.activity.getText().setText("闹闹");

        App.activity.getText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        App.activity.getText().setCompoundDrawables(null, null, null, null);
        App.activity.getImgOne().setVisibility(View.INVISIBLE);
        App.activity.getImgTwo().setImageResource(R.drawable.mall_camera2);
        App.activity.getImgTwo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //是否登录
                if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
                    initPop();
                    pop.showAsDropDown(view, 0, 0, Gravity.BOTTOM);
                } else {
                    Intent in = new Intent(getActivity(), LoginActivity.class);
                    startActivity(in);
                }
            }
        });
    }

    // TODO: 2017/6/26 0026 弹出popupWindow
    private void initPop() {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.carmer_naonao_popupwindow_activity, null);
        RelativeLayout viewById = (RelativeLayout) view.findViewById(R.id.naonaonaonaonaonaonao);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            pop.dismiss();
            }
        });
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        //popupWindow的背景透明度
        view.getBackground().setAlpha(180);
        //颜色
        pop.setBackgroundDrawable(new BitmapDrawable());
        //popupWindow的外部点击
        pop.setOutsideTouchable(true);
//        pop.setFocusable(false);
        //返回
        LinearLayout mCancel = (LinearLayout) view.findViewById(R.id.carmer_naonao_popupwindow_activity_cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        LinearLayout mVideo  = (LinearLayout) view.findViewById(R.id.carmer_naonao_popupwindow_activity_video);
        //小视频的点击事件
        mVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAndroidSDKVersion() >= 23){

                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO)
                            != PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(getActivity(),  new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.RECORD_AUDIO
                        },0);
                    }
                }else {
                    Intent in = new Intent(getActivity(),NaoNao_Carmer_Activity.class);
                    startActivity(in);
                }


            }


        });
        LinearLayout mPhoto = (LinearLayout) view.findViewById(R.id.carmer_naonao_popupwindow_activity_photo);
        mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent in = new Intent(getActivity(), Carmer_Photo_NaoNao_Activity.class);
                startActivity(in);
            }
        });

    }

//    private void initVideo() {
//
//
//    }
    private boolean hasAllPermissionsGranted(int[] grantResults) {
        for (int grantResult : grantResults) {

           // PackageManager.PERMISSION_GRANTED  //有权限   PackageManager.PERMISSION_DENIED无权限
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
//    private static final int REQUEST_EXTERNAL_STORAGE = 1;
//    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };
//    public void myPermission() {
//        int permission = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                    getActivity(),
//                    PERMISSIONS_STORAGE,
//                    REQUEST_EXTERNAL_STORAGE
//            );
//        }
//    }

    private void showPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
Intent in = new Intent(getActivity(),NaoNao_Carmer_Activity.class);
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
