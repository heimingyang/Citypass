package com.example.citypass.model.bean.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.information.ModifyActivity;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 项目名称: 血压卫士
 * 类描述: 修改密码页面
 * 创建人: 马杰
 * 创建时间: 2017/7/6 19:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ModifyPassActivity extends BaseActivity {
    @BindView(R.id.modify_back)
    ImageView modifyBack;
    @BindView(R.id.modify_Relative)
    RelativeLayout modifyRelative;
    @BindView(R.id.modify_text)
    TextView modifyText;
    @BindView(R.id.modify_textOne)
    TextView modifyTextOne;
    @BindView(R.id.modify_get)
    Button modifyGet;
    @BindView(R.id.modify_phone)
    EditText modifyPhone;
    @BindView(R.id.modify_one)
    RelativeLayout modifyOne;
    @BindView(R.id.modify_textTwo)
    TextView modifyTextTwo;
    @BindView(R.id.modify_yanzheng)
    EditText modifyYanzheng;
    @BindView(R.id.modify_two)
    RelativeLayout modifyTwo;
    @BindView(R.id.modify_back_login)
    Button modifyBackLogin;
    private MedaModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new IMedalModel();
        modifyGet.setVisibility(View.GONE);
        modifyPhone.setHint("输入密码");
        modifyYanzheng.setHint("验证密码");
    }



    @OnClick({R.id.modify_back, R.id.modify_back_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_back:
                onBackPressed();
                break;
            case R.id.modify_back_login:
                if(modifyYanzheng.getText().toString().equals(modifyPhone.getText().toString())){
                    xiuGai();
                }else{
                    Toast.makeText(ModifyPassActivity.this,"密码两次输入不一致",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    private void xiuGai(){
        XiuGai xiuGai=new XiuGai();
        xiuGai.setPhone(LoginUtils.information.getServerInfo().getTel());
        xiuGai.setNewPassWord(modifyPhone.getText().toString().trim());
        String param = LoginUtils.getParam(xiuGai, "PHSocket_SetUserFindNewPassWord");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                City city = JSON.parseObject(result, City.class);
                int code = city.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(ModifyPassActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }else{
                    Toast.makeText(ModifyPassActivity.this,city.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
}
