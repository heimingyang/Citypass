package com.example.citypass.cotroller.toutiao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.toutiao.Toutiao;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.google.gson.Gson;

public class TtrecyclerXQActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ttrecycler_xq;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        Toutiao.ParamBean param = new Toutiao.ParamBean();
        param.setPageSize(3);
        param.setSiteID(2422);
        param.setNewsID(id);
        param.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,null)));

        Toutiao.StatisBean statis = new Toutiao.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(this));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(this));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(0);


        Toutiao toutiao = new Toutiao();
        toutiao.setMethod("PHSocket_GetCityNewsBody");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("BC3BE051462325B907AD613D4A4AD8CE");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Log.e("onSuccess",s);

        InforModel inforModel=new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("onSuccess",result);

            }

            @Override
            public void onError(String errormsg) {

            }
        });

    }
}
