package com.example.citypass.cotroller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.City;
import com.example.citypass.model.bean.CityUp;
import com.example.citypass.model.biz.infor.CityModel;
import com.example.citypass.model.biz.infor.ICityModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.citypass.utils.LoginUtils.USERID;
import static com.example.citypass.utils.LoginUtils.information;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 14:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CityActivity extends BaseActivity {
    @BindView(R.id.city_back)
    ImageView cityBack;
    @BindView(R.id.city_Relative)
    RelativeLayout cityRelative;
    @BindView(R.id.city_myMoney)
    TextView cityMyMoney;
    @BindView(R.id.city_RelativeOne)
    RelativeLayout cityRelativeOne;
    @BindView(R.id.city_Relative_Two)
    RelativeLayout cityRelativeTwo;
    @BindView(R.id.city_Relative_Three)
    RelativeLayout cityRelativeThree;
    @BindView(R.id.city_Relative_Four)
    RelativeLayout cityRelativeFour;
    @BindView(R.id.city_Linear)
    LinearLayout cityLinear;
    @BindView(R.id.city_TextOne)
    TextView cityTextOne;
    @BindView(R.id.city_TextTwo)
    TextView cityTextTwo;
    @BindView(R.id.city_RelativeFive)
    RelativeLayout cityRelativeFive;
    private CityModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_city;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new ICityModel();
        model.getParam(getparam(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                City city = JSON.parseObject(result, City.class);
                int code = city.getMessageList().getCode();
                if(code==1000){
                    int coin = city.getServerInfo().getUserExtend().get(0).getCoin();
                    cityMyMoney.setText(coin+"");
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private String getparam(){
        CityUp cityUp=new CityUp();
        cityUp.setCustomerID(8001);
        cityUp.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        cityUp.setMethod("PHSocket_GetUserCoinLog");
        cityUp.setCustomerKey("B757752C64514CB5B3F8B17330024493");
        cityUp.setAppName("CcooCity");
        cityUp.setVersion("4.5");
        CityUp.ParamBean paramBean=new CityUp.ParamBean();
        paramBean.setCurPage(1);
        paramBean.setPageSize(10);
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setIncrease(0);
        paramBean.setUserID(SpUtils.getSp().getString(USERID,""));
        cityUp.setParam(paramBean);
        CityUp.StatisBean statisBean=new CityUp.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+LoginUtils.information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        cityUp.setStatis(statisBean);
        String s = JSON.toJSONString(cityUp);
        return s;
    }


    @OnClick({R.id.city_back, R.id.city_Relative_Two, R.id.city_Relative_Three, R.id.city_Relative_Four, R.id.city_TextTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.city_back:
                onBackPressed();
                break;
            case R.id.city_Relative_Two:
                Intent intent=new Intent(CityActivity.this,TaskActivity.class);
                startActivity(intent);
                break;
            case R.id.city_Relative_Three:
                break;
            case R.id.city_Relative_Four:
                break;
            case R.id.city_TextTwo:
                break;
        }
    }
}
