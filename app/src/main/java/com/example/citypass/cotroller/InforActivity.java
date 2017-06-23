package com.example.citypass.cotroller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.toutiao.IsLoad;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 项目名称: 血压卫士
 * 类描述: 个人信息页面
 * 创建人: 马杰
 * 创建时间: 2017/6/23 10:54
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InforActivity extends BaseActivity {
    @BindView(R.id.information_back)
    ImageView informationBack;
    @BindView(R.id.information_Relative)
    RelativeLayout informationRelative;
    @BindView(R.id.information_Head_portrait)
    ImageView informationHeadPortrait;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.informations_Relative)
    RelativeLayout informationsRelative;
    @BindView(R.id.information_image)
    ImageView informationImage;
    @BindView(R.id.infor_NumberTwo)
    TextView inforNumberTwo;
    @BindView(R.id.information_Number)
    RelativeLayout informationNumber;
    @BindView(R.id.information_imageone)
    ImageView informationImageone;
    @BindView(R.id.information_NickTwo)
    TextView informationNickTwo;
    @BindView(R.id.information_Nick)
    RelativeLayout informationNick;
    @BindView(R.id.information_imagetwo)
    ImageView informationImagetwo;
    @BindView(R.id.information_NameTwo)
    TextView informationNameTwo;
    @BindView(R.id.information_Name)
    RelativeLayout informationName;
    @BindView(R.id.information_imagethree)
    ImageView informationImagethree;
    @BindView(R.id.information_SexTwo)
    TextView informationSexTwo;
    @BindView(R.id.information_Sex)
    RelativeLayout informationSex;
    @BindView(R.id.information_imagefour)
    ImageView informationImagefour;
    @BindView(R.id.information_AgeTwo)
    TextView informationAgeTwo;
    @BindView(R.id.information_Age)
    RelativeLayout informationAge;
    @BindView(R.id.information_imagefive)
    ImageView informationImagefive;
    @BindView(R.id.information_OccupationTwo)
    TextView informationOccupationTwo;
    @BindView(R.id.information_Occupation)
    RelativeLayout informationOccupation;
    @BindView(R.id.information_imagesix)
    ImageView informationImagesix;
    @BindView(R.id.information_EmotionTwo)
    TextView informationEmotionTwo;
    @BindView(R.id.information_Emotion)
    RelativeLayout informationEmotion;
    @BindView(R.id.information_imageseven)
    ImageView informationImageseven;
    @BindView(R.id.information_ResidenceTwo)
    TextView informationResidenceTwo;
    @BindView(R.id.information_Residence)
    RelativeLayout informationResidence;
    @BindView(R.id.information_imageeight)
    ImageView informationImageeight;
    @BindView(R.id.information_AutographTwo)
    TextView informationAutographTwo;
    @BindView(R.id.information_Autograph)
    RelativeLayout informationAutograph;
    @BindView(R.id.information_imagenine)
    ImageView informationImagenine;
    @BindView(R.id.information_PhoneTwo)
    TextView informationPhoneTwo;
    @BindView(R.id.information_Phone)
    RelativeLayout informationPhone;
    @BindView(R.id.information_imageten)
    ImageView informationImageten;
    @BindView(R.id.information_WeixinTwo)
    TextView informationWeixinTwo;
    @BindView(R.id.information_Weixin)
    RelativeLayout informationWeixin;
    @BindView(R.id.information_imageeleven)
    ImageView informationImageeleven;
    @BindView(R.id.information_QQTwo)
    TextView informationQQTwo;
    @BindView(R.id.information_QQ)
    RelativeLayout informationQQ;
    @BindView(R.id.information_imagetwelve)
    ImageView informationImagetwelve;
    @BindView(R.id.information_GradeTwo)
    TextView informationGradeTwo;
    @BindView(R.id.information_Grade)
    RelativeLayout informationGrade;
    @BindView(R.id.information_imagethirteen)
    ImageView informationImagethirteen;
    @BindView(R.id.information_MedalTwo)
    TextView informationMedalTwo;
    @BindView(R.id.information_Medal)
    RelativeLayout informationMedal;
    @BindView(R.id.information_imagefourten)
    ImageView informationImagefourten;
    @BindView(R.id.information_CityTwo)
    TextView informationCityTwo;
    @BindView(R.id.information_City)
    RelativeLayout informationCity;
    private InforModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_infor;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new IInforModel();
        initInfor();
    }

    private void initInfor(){
        String userFace = LoginUtils.information.getServerInfo().getUserFace();
        HttpFacory.create().loadImage(userFace,informationHeadPortrait,true);
        inforNumberTwo.setText(LoginUtils.information.getServerInfo().getUserName());
        informationNickTwo.setText(LoginUtils.information.getServerInfo().getNick());
        informationNameTwo.setText(LoginUtils.information.getServerInfo().getName());
        informationSexTwo.setText(LoginUtils.information.getServerInfo().getSex());
        informationAgeTwo.setText(LoginUtils.information.getServerInfo().getXingZuo());
        informationOccupationTwo.setText(LoginUtils.information.getServerInfo().getJob());
        informationEmotionTwo.setText(LoginUtils.information.getServerInfo().getMarry());
        informationResidenceTwo.setText(LoginUtils.information.getServerInfo().getLifeAddr());
        informationAutographTwo.setText(LoginUtils.information.getServerInfo().getInfo());
        String tel = LoginUtils.information.getServerInfo().getTel();
        char[] chars = tel.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(i>2||i<7){
                chars[i]='*';
            }
        }
        String phone=new String(chars);
        informationPhoneTwo.setText("已绑定手机"+phone);
        informationWeixinTwo.setText(LoginUtils.information.getServerInfo().getWeiXin());
        informationQQTwo.setText(LoginUtils.information.getServerInfo().getQQ());
        informationGradeTwo.setText(LoginUtils.information.getServerInfo().getHonorName());
        int medalCount = LoginUtils.information.getServerInfo().getMedalCount();
        if(medalCount==0) {
            informationMedalTwo.setText("无");
        }
        informationCityTwo.setText(LoginUtils.information.getServerInfo().getCoin()+"枚");
    }


    @OnClick({R.id.information_back, R.id.informations_Relative, R.id.information_Number, R.id.information_Nick, R.id.information_Name, R.id.information_Sex, R.id.information_Age, R.id.information_Occupation, R.id.information_Emotion, R.id.information_Residence, R.id.information_Autograph, R.id.information_Phone, R.id.information_Weixin, R.id.information_QQ, R.id.information_Grade, R.id.information_Medal, R.id.information_City})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.information_back:
                onBackPressed();
                break;
            case R.id.informations_Relative:
                break;
            case R.id.information_Number:
                break;
            case R.id.information_Nick:
                getDialog("个性昵称",informationNickTwo.getText().toString(),"你的个性网名（10字内）",1,informationNickTwo);
                break;
            case R.id.information_Name:
                getDialog("真实姓名",informationNameTwo.getText().toString(),"你的真实姓名",0,informationNameTwo);
                break;
            case R.id.information_Sex:
                Toast.makeText(InforActivity.this,"性别已设置，无法修改~",Toast.LENGTH_SHORT).show();
                break;
            case R.id.information_Age:
                break;
            case R.id.information_Occupation:
                getDialog("你的职业",informationOccupationTwo.getText().toString(),"你目前从事职业",14,informationOccupationTwo);
                break;
            case R.id.information_Emotion:
                break;
            case R.id.information_Residence:
                getDialog("居住地",informationResidenceTwo.getText().toString(),"你所住小区，街道或村镇（12字内）",12,informationResidenceTwo);
                break;
            case R.id.information_Autograph:
                getDialog("个性签名",informationAutographTwo.getText().toString(),"设置签名，彰显个性~",9,informationAutographTwo);
                break;
            case R.id.information_Phone:
                break;
            case R.id.information_Weixin:
                break;
            case R.id.information_QQ:
                break;
            case R.id.information_Grade:
                break;
            case R.id.information_Medal:
                break;
            case R.id.information_City:
                break;
        }
    }

    private void getDialog(String title, String content, String hint, final int keyId, final TextView v){
        final View view= LayoutInflater.from(InforActivity.this).inflate(R.layout.infor_dialog_moban,null);
        final EditText editText= (EditText) view.findViewById(R.id.infor_dialog_edit);
        editText.setHint(hint);
        editText.setText(content);
        AlertDialog dialog=new AlertDialog.Builder(InforActivity.this)
                .setTitle(title)
                .setView(view)
                .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = editText.getText().toString();
                        upload(keyId,s,v);
                    }
                }).create();
        dialog.show();
    }

    private void upload(int keyId, final String value, final TextView view){
        String upload = LoginUtils.upload(keyId, value);
        model.UpLoad(upload, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                IsLoad isLoad = JSON.parseObject(result, IsLoad.class);
                int code = isLoad.getMessageList().getCode();
                if(code==1000){
                    view.setText(value);
                    handler.sendEmptyMessage(0);
                }else{
                    handler.sendEmptyMessage(1);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Toast.makeText(InforActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(InforActivity.this,"修改失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}