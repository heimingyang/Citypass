package com.example.citypass.cotroller.fragment.information;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.City;
import com.example.citypass.model.bean.information.Image;
import com.example.citypass.model.bean.information.Login;
import com.example.citypass.model.bean.toutiao.IsLoad;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;

import java.io.File;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.citypass.utils.LoginUtils.information;


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
    @BindView(R.id.information_PhoneOne)
    TextView informationPhoneOne;
    @BindView(R.id.information_WeixinOne)
    TextView informationWeixinOne;
    @BindView(R.id.information_QQOne)
    TextView informationQQOne;
    @BindView(R.id.information_dengji)
    TextView informationDengji;
    private InforModel model;
    private String ffff, mm, dd;
    private String s;
    private Uri uri;
    private File tempFile;
    private String file;

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
        model = new IInforModel();
        initInfor();
    }

    private void initInfor() {
        String userFace = information.getServerInfo().getUserFace();
        HttpFacory.create().loadImage(userFace, informationHeadPortrait, true);
        inforNumberTwo.setText(information.getServerInfo().getUserName());
        informationNickTwo.setText(information.getServerInfo().getNick());
        informationNameTwo.setText(information.getServerInfo().getName());
        informationSexTwo.setText(information.getServerInfo().getSex());
        informationAgeTwo.setText(information.getServerInfo().getXingZuo());
        informationOccupationTwo.setText(information.getServerInfo().getJob());
        informationEmotionTwo.setText(information.getServerInfo().getMarry());
        informationResidenceTwo.setText(information.getServerInfo().getLifeAddr());
        informationAutographTwo.setText(information.getServerInfo().getInfo());
        String tel = information.getServerInfo().getTel();
        char[] chars = tel.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (i > 2 && i < 7) {
                chars[i] = '*';
            }
            sb.append(chars[i]);
        }
        String phone = sb.toString();
        informationPhoneTwo.setText("已绑定手机" + phone);
        informationWeixinTwo.setText(information.getServerInfo().getWeiXin());
        informationQQTwo.setText(information.getServerInfo().getQQ());
        informationGradeTwo.setText(information.getServerInfo().getHonorName());
        int level = information.getServerInfo().getLevel();
        if(level<=10){
            informationDengji.setText("LV."+level);
        }else if(level<=20&&level>10){
            informationDengji.setBackgroundResource(R.drawable.ccoo_bg_dengji2);
            informationDengji.setText("LV."+level);
        }else if(level<=30&&level>20){
            informationDengji.setBackgroundResource(R.drawable.ccoo_bg_dengji3);
            informationDengji.setText("LV."+level);
        }
        int medalCount = information.getServerInfo().getMedalCount();
        if (medalCount == 0) {
            informationMedalTwo.setText("无");
        }
        informationCityTwo.setText(information.getServerInfo().getCoin() + "枚");
    }



    @OnClick({R.id.information_back, R.id.informations_Relative, R.id.information_Number, R.id.information_Nick, R.id.information_Name, R.id.information_Sex, R.id.information_Age, R.id.information_Occupation, R.id.information_Emotion, R.id.information_Residence, R.id.information_Autograph, R.id.information_Phone, R.id.information_Weixin, R.id.information_QQ, R.id.information_Grade, R.id.information_Medal, R.id.information_City,
            R.id.information_PhoneOne,R.id.information_WeixinOne,R.id.information_QQOne})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.information_back:
                onBackPressed();
                break;
            case R.id.informations_Relative:
                getDialog();
                break;
            case R.id.information_Number:
                Toast.makeText(InforActivity.this,"账号不可修改",Toast.LENGTH_SHORT).show();
                break;
            case R.id.information_Nick:
                getDialog("个性昵称", informationNickTwo.getText().toString(), "你的个性网名（10字内）", 1, informationNickTwo);
                break;
            case R.id.information_Name:
                getDialog("真实姓名", informationNameTwo.getText().toString(), "你的真实姓名", 0, informationNameTwo);
                break;
            case R.id.information_Sex:
                Toast.makeText(InforActivity.this, "性别已设置，无法修改~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.information_Age:
                getDate(information.getServerInfo().getBirthday(), 4, informationAgeTwo);
                break;
            case R.id.information_Occupation:
                getDialog("你的职业", informationOccupationTwo.getText().toString(), "你目前从事职业", 14, informationOccupationTwo);
                break;
            case R.id.information_Emotion:
                getEmotion("情感状态", 13, informationEmotionTwo);
                break;
            case R.id.information_Residence:
                getDialog("居住地", informationResidenceTwo.getText().toString(), "你所住小区，街道或村镇（12字内）", 12, informationResidenceTwo);
                break;
            case R.id.information_Autograph:
                getDialog("个性签名", informationAutographTwo.getText().toString(), "设置签名，彰显个性~", 9, informationAutographTwo);
                break;
            case R.id.information_Phone:
                Intent intent=new Intent(InforActivity.this,PhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.information_Weixin:
                getDialog("微信号",informationWeixinTwo.getText().toString(),"你的微信号，方便好友联系~",11,informationWeixinTwo);
                break;
            case R.id.information_QQ:
                getDialog("联系QQ",informationQQTwo.getText().toString(),"常用QQ号，方便好友联系~",7,informationQQTwo);
                break;
            case R.id.information_Grade:
                Intent intentTwo=new Intent(InforActivity.this,LevelActivity.class);
                startActivity(intentTwo);
                break;
            case R.id.information_Medal:
                Intent intentThree=new Intent(InforActivity.this,MedalActivity.class);
                startActivity(intentThree);
                break;
            case R.id.information_City:
                Intent intentFour=new Intent(InforActivity.this,CityActivity.class);
                startActivity(intentFour);
                break;
            case R.id.information_PhoneOne:
                break;
            case R.id.information_WeixinOne:
                break;
            case R.id.information_QQOne:
                break;
        }
    }

    private void getDialog(String title, String content, String hint, final int keyId, final TextView v) {
        final View view = LayoutInflater.from(InforActivity.this).inflate(R.layout.infor_dialog_moban, null);
        final EditText editText = (EditText) view.findViewById(R.id.infor_dialog_edit);
        editText.setHint(hint);
        editText.setText(content);
        AlertDialog dialog = new AlertDialog.Builder(InforActivity.this)
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
                        upload(keyId, s, v);
                    }
                }).create();
        dialog.show();
    }

    private void getDate(String title, final int keyId, final TextView v) {
        final View view = LayoutInflater.from(InforActivity.this).inflate(R.layout.date_dialog_moban, null);
        DatePicker Datepicker = (DatePicker) view.findViewById(R.id.infor_dialog_date);
        Long longTime = TimeUtils.getLongTime(information.getServerInfo().getBirthday(), "yyyy-MM-dd");
        ffff = TimeUtils.getStringTime(longTime, "yyyy");
        mm = TimeUtils.getStringTime(longTime, "MM");
        dd = TimeUtils.getStringTime(longTime, "dd");
        Datepicker.init(Integer.parseInt(ffff), Integer.parseInt(mm), Integer.parseInt(dd), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                ffff = year + "";
                mm = monthOfYear + 1 + "";
                dd = dayOfMonth + "";
            }
        });
        AlertDialog dialog = new AlertDialog.Builder(InforActivity.this)
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
                        String s = ffff + "-" + mm + "-" + dd;
                        upload(keyId, s, v);
                    }
                }).create();
        dialog.show();
    }

    private void getEmotion(String title, final int keyId, final TextView v) {
        final View view = LayoutInflater.from(InforActivity.this).inflate(R.layout.radio_dialog_moban, null);
        RadioGroup editText = (RadioGroup) view.findViewById(R.id.radio_dialog);
        editText.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radio_one:
                        s = "单身";
                        break;
                    case R.id.radio_two:
                        s = "热恋";
                        break;
                    case R.id.radio_three:
                        s = "已婚";
                        break;
                    case R.id.radio_four:
                        s = "保密";
                        break;
                }
            }
        });
        AlertDialog dialog = new AlertDialog.Builder(InforActivity.this)
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
                        upload(keyId, s, v);
                    }
                }).create();
        dialog.show();
    }

    private void upload(int keyId, final String value, final TextView view) {
        String upload = LoginUtils.upload(keyId, value);
        model.UpLoad(upload, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                IsLoad isLoad = JSON.parseObject(result, IsLoad.class);
                int code = isLoad.getMessageList().getCode();
                if (code == 1000) {
                    view.setText(value);
                    handler.sendEmptyMessage(0);
                } else {
                    handler.sendEmptyMessage(1);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Toast.makeText(InforActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(InforActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    public void getDialog() {
        final AlertDialog dialog=new AlertDialog.Builder(App.activity).create();
        dialog.show();
        dialog.getWindow().setContentView(R.layout.my_dialog);
        //打开相机
        dialog.getWindow().findViewById(R.id.my_textOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture
                File tempFile=new File("/sdcard/ll1x/"+ Calendar.getInstance().getTimeInMillis()+".jpg");
                // 以时间秒为文件名
                File temp = new File("/sdcard/ll1x/");//自已项目 文件夹
                if (!temp.exists()) {
                    temp.mkdir();
                }
                uri=Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                App.activity.startActivityForResult(intent, 3);
                dialog.dismiss();
            }
        });
        //打开相册
        dialog.getWindow().findViewById(R.id.my_textTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                App.activity.startActivityForResult(intent, 1);
                dialog.dismiss();
            }
        });
        dialog.getWindow().findViewById(R.id.my_textThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
    }
    
    private void upLoadImage(){
        Image image=new Image();
        image.setKeyID(2);
        image.setUsiteID(information.getServerInfo().getSiteID());
        image.setSiteID(information.getServerInfo().getSiteID());
        image.setUserID(SpUtils.getSp().getString(LoginUtils.USERID,""));
        image.setUserName(information.getServerInfo().getUserName());
        String param = LoginUtils.getParam(image, "PHSocket_SetUserBaseInfo");
        model.UpLoad(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                City city = JSON.parseObject(result, City.class);
                int code = city.getMessageList().getCode();
                if(code==1000){
                    Toast.makeText(InforActivity.this,"头像上传成功",Toast.LENGTH_SHORT).show();
                    information.getServerInfo().setUserFace(file);
                    HttpFacory.create().loadImage(file,informationHeadPortrait,true);
                }else{
                    Toast.makeText(InforActivity.this,city.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {
                Toast.makeText(InforActivity.this,errormsg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量
            return;
        }
        switch (requestCode){
            case 1:
                //相册剪裁
                startPhotoZoom(data.getData());
                break;
            case 2:
                //上传头像的请求
                upLoadImage();
                break;
            case 3:
                //相机剪裁
                startPhotoZoom(uri);
                break;
        }
    }

    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");

        intent.setDataAndType(uri, "image/*");

        intent.putExtra("crop", "true");

        intent.putExtra("aspectX", 2);

        intent.putExtra("aspectY", 2);

        intent.putExtra("outputX", 200);

        intent.putExtra("outputY", 200);

        intent.putExtra("scale", true);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        intent.putExtra("return-data", false);

        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

        intent.putExtra("noFaceDetection", true); // no face detection

        file="/sdcard/ll1x/"+ Calendar.getInstance().getTimeInMillis()+".jpg";
        tempFile=new File(file); // 以时间秒为文件名
        File temp = new File("/sdcard/ll1x/");//自已项目 文件夹
        if (!temp.exists()) {
            temp.mkdir();
        }
        intent.putExtra("output", Uri.fromFile(tempFile));  // 专入目标文件
        intent.putExtra("outputFormat", "JPEG"); //输入文件格式
        Intent wrapperIntent = Intent.createChooser(intent, "头像"); //开始 并设置标题
        startActivityForResult(wrapperIntent, 2);
    }
}
