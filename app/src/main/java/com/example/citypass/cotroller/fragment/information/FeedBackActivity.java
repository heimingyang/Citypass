package com.example.citypass.cotroller.fragment.information;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.Feed;
import com.example.citypass.model.bean.IsLogin;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 意见反馈页面
 * 创建人: 马杰
 * 创建时间: 2017/6/21 19:31
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class FeedBackActivity extends BaseActivity {
    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.feedback_Relative)
    RelativeLayout feedbackRelative;
    @BindView(R.id.feedback_phone)
    EditText feedbackPhone;
    @BindView(R.id.feedback_order)
    EditText feedbackOrder;
    @BindView(R.id.feedback_feed)
    Button feedbackFeed;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.feedback_back, R.id.feedback_feed})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                onBackPressed();
                break;
            case R.id.feedback_feed:
                String trim1 = feedbackPhone.getText().toString().trim();
                String trim = feedbackOrder.getText().toString().trim();
                if(trim.length()>=10){
                    feedBack(trim1,trim);
                }else{
                    Toast.makeText(FeedBackActivity.this,"意见反馈最少不低于10个字",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void feedBack(String phone,String order){
        Feed feed=new Feed();
        feed.setCustomerID(8001);
        feed.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        feed.setMethod("PHSocket_SetContactusInfo");
        feed.setCustomerKey("CDCFAE3FE325EBAF0BC481C6DE5AF18A");
        feed.setAppName("CcooCity");
        feed.setVersion("4.5");
        Feed.ParamBean paramBean=new Feed.ParamBean();
        paramBean.setSiteID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,"")));
        paramBean.setName(LoginUtils.information.getServerInfo().getName());
        paramBean.setTel(phone);
        paramBean.setInfo(order);
        paramBean.setEmail("");
        paramBean.setFromType(2);
        feed.setParam(paramBean);
        Feed.StatisBean statisBean=new Feed.StatisBean();
        statisBean.setSiteId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,"")));
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum(SpUtils.getSp().getString(LoginUtils.PHONE,""));
        feed.setStatis(statisBean);
        String s = JSON.toJSONString(feed);
        HashMap<String,String> map=new HashMap<>();
        map.put("param",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                IsLogin isLogin = JSON.parseObject(result, IsLogin.class);
                int code = isLogin.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(FeedBackActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
