package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.model.bean.information.InforTwo;
import com.example.citypass.model.bean.information.InformationTwo;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 19:28
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InformationTwoFragment extends BaseFragment {
    @BindView(R.id.inforTwo_Text)
    TextView inforTwoText;
    @BindView(R.id.inforTwo_TextOne)
    TextView inforTwoTextOne;
    @BindView(R.id.inforTwo_RelativeOne)
    RelativeLayout inforTwoRelativeOne;
    @BindView(R.id.inforTwo_TextTwo)
    TextView inforTwoTextTwo;
    @BindView(R.id.inforTwo_RelativeTwo)
    RelativeLayout inforTwoRelativeTwo;
    @BindView(R.id.inforTwo_TextThree)
    TextView inforTwoTextThree;
    @BindView(R.id.inforTwo_RelativeThree)
    RelativeLayout inforTwoRelativeThree;
    @BindView(R.id.inforTwo_TextFour)
    TextView inforTwoTextFour;
    @BindView(R.id.inforTwo_RelativeFour)
    RelativeLayout inforTwoRelativeFour;
    @BindView(R.id.inforTwo_TextFive)
    TextView inforTwoTextFive;
    @BindView(R.id.inforTwo_RelativeFive)
    RelativeLayout inforTwoRelativeFive;
    @BindView(R.id.inforTwo_TextSix)
    TextView inforTwoTextSix;
    @BindView(R.id.inforTwo_RelativeSix)
    RelativeLayout inforTwoRelativeSix;
    @BindView(R.id.inforTwo_TextSeven)
    TextView inforTwoTextSeven;
    @BindView(R.id.inforTwo_RelativeSeven)
    RelativeLayout inforTwoRelativeSeven;
    @BindView(R.id.inforTwo_TextEight)
    TextView inforTwoTextEight;
    @BindView(R.id.inforTwo_RelativeEight)
    RelativeLayout inforTwoRelativeEight;
    Unbinder unbinder;
    private MedaModel model;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        model = new IMedalModel();
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id", 0);
        model.getMedal(getparam(id), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                InforTwo inforTwo = JSON.parseObject(result, InforTwo.class);
                int code = inforTwo.getMessageList().getCode();
                if (code == 1000) {
                    InforTwo.ServerInfoBean serverInfo = inforTwo.getServerInfo();
                    inforTwoTextOne.setText(serverInfo.getBirthday());
                    inforTwoTextTwo.setText(serverInfo.getXingZuo());
                    inforTwoTextThree.setText(serverInfo.getJob());
                    inforTwoTextFour.setText(serverInfo.getAddress());
                    inforTwoTextFive.setText(serverInfo.getMarry());
                    inforTwoTextSix.setText(serverInfo.getWeiXin());
                    inforTwoTextSeven.setText(serverInfo.getQQ());
                    inforTwoTextEight.setText(serverInfo.getSignInfo());
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_informations;
    }

    private String getparam(int id) {
        InformationTwo cityUp = new InformationTwo();
        cityUp.setCustomerID(8001);
        cityUp.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss"));
        cityUp.setMethod("PHSocket_GetUserInfoDetails");
        cityUp.setCustomerKey("B757752C64514CB5B3F8B17330024493");
        cityUp.setAppName("CcooCity");
        cityUp.setVersion("4.5");
        InformationTwo.ParamBean paramBean = new InformationTwo.ParamBean();
        paramBean.setUSiteId(LoginUtils.information.getServerInfo().getSiteID());
        paramBean.setUserId(SpUtils.getSp().getString(LoginUtils.USERID, ""));
        if(SpUtils.getSp().getString(LoginUtils.USERID, "").equals(id+"")){
            paramBean.setFuserId(0);

        }else {
            paramBean.setFuserId(id);
        }
        cityUp.setParam(paramBean);
        InformationTwo.StatisBean statisBean = new InformationTwo.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86" + LoginUtils.information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        String model = Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion = Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion + "");
        cityUp.setStatis(statisBean);
        String s = JSON.toJSONString(cityUp);
        return s;
    }
    private void start(){
        Intent intent=new Intent(getActivity(),InforActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.inforTwo_RelativeOne, R.id.inforTwo_RelativeTwo, R.id.inforTwo_RelativeThree, R.id.inforTwo_RelativeFour, R.id.inforTwo_RelativeFive, R.id.inforTwo_RelativeSix, R.id.inforTwo_RelativeSeven, R.id.inforTwo_RelativeEight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.inforTwo_RelativeOne:
                start();
                break;
            case R.id.inforTwo_RelativeTwo:
                start();
                break;
            case R.id.inforTwo_RelativeThree:
                start();
                break;
            case R.id.inforTwo_RelativeFour:
                start();
                break;
            case R.id.inforTwo_RelativeFive:
                start();
                break;
            case R.id.inforTwo_RelativeSix:
                start();
                break;
            case R.id.inforTwo_RelativeSeven:
                start();
                break;
            case R.id.inforTwo_RelativeEight:
                start();
                break;
        }
    }
}
