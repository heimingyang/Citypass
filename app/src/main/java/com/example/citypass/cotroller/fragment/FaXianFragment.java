package com.example.citypass.cotroller.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.discover.MyDiscoverAdapter;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.model.http.bean.faxian.MyFaXian;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 8:27
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

public class FaXianFragment extends BaseFragment {
    @BindView(R.id.faxian_listview)
    ListView faxianListview;
    Unbinder unbinder;

    private MyDiscoverAdapter myDiscoverAdapter;

    @Override
    protected void initData() {
        Map map = new HashMap();
        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"siteID\":2422},\"requestTime\":\"2017-06-19 20:34:34\",\"customerKey\":\"D3C4D036715724FC4E3714003BC10955\",\"Method\":\"PHSocket_GetFindNavigationInfo\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":0,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("发现数据", result);

                MyFaXian myFaXian = JSON.parseObject(result, MyFaXian.class);
                List<MyFaXian.ServerInfoBean> mlist = myFaXian.getServerInfo();
                myDiscoverAdapter = new MyDiscoverAdapter(mlist, getActivity());
                faxianListview.setAdapter(myDiscoverAdapter);

            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }

    @Override
    protected void initListener() {
        App.activity.getImgTwo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "扫描二维码", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, 1);


            }
        });
    }

    @Override
    protected void initView(View view) {
        View views = LayoutInflater.from(getActivity()).inflate(R.layout.image_item, null);
        ImageView imageView = (ImageView) views.findViewById(R.id.img_item);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.find_test);
        imageView.setImageDrawable(drawable);
        faxianListview.addHeaderView(views);


    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_faxian;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        App.activity.getText().setText("发现");
        App.activity.getText().setCompoundDrawables(null, null, null, null);
        App.activity.getImgOne().setVisibility(View.GONE);
        Drawable drawable = App.activity.getResources().getDrawable(R.drawable.saoyisao);
        App.activity.getImgTwo().setImageDrawable(drawable);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            //处理扫描结果（在界面上显示）if (null != data) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                String result = bundle.getString(CodeUtils.RESULT_STRING);
                Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
            } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
            }
        }

    }
}
