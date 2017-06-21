package com.example.citypass.cotroller.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.Utils.LoginUtils;
import com.example.citypass.Utils.SpUtils;
import com.example.citypass.Utils.TimeUtils;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.CooperationActivity;
import com.example.citypass.cotroller.LoginActivity;
import com.example.citypass.cotroller.SettingActivity;
import com.example.citypass.cotroller.adapter.InforAdapter;
import com.example.citypass.model.bean.Information;
import com.example.citypass.model.bean.Informations;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述: 侧滑菜单个人中心
 * 创建人: 马杰
 * 创建时间: 2017/6/19 21:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InformationFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.infor_img)
    ImageView inforImg;
    @BindView(R.id.infor_name)
    TextView inforName;
    @BindView(R.id.infor_order)
    TextView inforOrder;
    @BindView(R.id.infor_guanzhu)
    TextView inforGuanzhu;
    @BindView(R.id.infor_fensi)
    TextView inforFensi;
    @BindView(R.id.infor_login)
    RelativeLayout inforLogin;
    @BindView(R.id.infor_setting)
    TextView inforSetting;
    @BindView(R.id.infor_hezuo)
    TextView inforHezuo;
    @BindView(R.id.infor_dibu)
    RelativeLayout inforDibu;
    @BindView(R.id.infor_list)
    ListView inforList;
    Unbinder unbinder1;
    private boolean login=false;
    private Information information;
    private ImageView image;

    @Override
    protected void initData() {
        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false);
    }

    @Override
    protected void initListener() {
        inforList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        login(null);
                        break;
                    case 1:
                        login(null);
                        break;
                    case 2:
                        login(null);
                        break;
                    case 3:
                        login(null);
                        break;
                    case 4:
                        login(null);
                        break;
                    case 5:
                        login(null);
                        break;
                    case 6:
                        login(null);
                        break;
                    case 7:
                        login(null);
                        break;
                    case 8:
                        login(null);
                        break;
                    case 9:
                        login(null);
                        break;
                    case 10:
                        login(null);
                        break;
                    case 11:
                        login(null);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView(View view) {
        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false);
        InforAdapter adapter = new InforAdapter(getContext());
        inforList.setAdapter(adapter);
        if(login){
            getInformation();
        }else{

        }
    }

    private void login(Class c) {
        if (login) {
            Intent intent = new Intent(getActivity(), c);
            startActivityForResult(intent,200);
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent,100);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_information;
    }



    @OnClick({R.id.infor_img, R.id.infor_name, R.id.infor_order, R.id.infor_guanzhu, R.id.infor_fensi, R.id.infor_login, R.id.infor_setting, R.id.infor_hezuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.infor_img:
                login(null);
                break;
            case R.id.infor_name:
                login(null);
                break;
            case R.id.infor_order:
                login(null);
                break;
            case R.id.infor_guanzhu:
                login(null);
                break;
            case R.id.infor_fensi:
                login(null);
                break;
            case R.id.infor_login:
                login(null);
                break;
            case R.id.infor_setting:
                login(SettingActivity.class);
                break;
            case R.id.infor_hezuo:
                login(CooperationActivity.class);
                break;
        }
    }

    private void getInformation(){
        final Informations informations=new Informations();
        informations.setCustomerID(8001);
        informations.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        informations.setMethod("PHSocket_GetBBSUsersInfoNew");
        informations.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        informations.setAppName("CcooCity");
        informations.setVersion("4.5");
        Informations.ParamBean paramBean=new Informations.ParamBean();
        paramBean.setSiteID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,"")));
        paramBean.setUserName(SpUtils.getSp().getString(LoginUtils.USERNAME,""));
        informations.setParam(paramBean);
        Informations.StatisBean statisBean=new Informations.StatisBean();
        statisBean.setSiteId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USITEID,"")));
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        statisBean.setPhoneId("863181036606964");
        statisBean.setPhoneNum(SpUtils.getSp().getString(LoginUtils.PHONE,""));
        informations.setStatis(statisBean);
        String s = JSON.toJSONString(informations);
        HashMap<String,String> map=new HashMap<>();
        map.put("param",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                information = JSON.parseObject(result, Information.class);
                LoginUtils.information=information;
                int code = information.getMessageList().getCode();
                if(code==1000){
                    inforName.setText(information.getServerInfo().getNick());
                    Drawable drawable=null;
                    if(information.getServerInfo().getSex().equals("男")) {
                        drawable = getResources().getDrawable(R.drawable.regist_man_check);
                    }else{
                        drawable = getResources().getDrawable(R.drawable.regist_woman_check);
                    }
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    inforName.setCompoundDrawables(null,null,drawable,null);
                    inforOrder.setText(information.getServerInfo().getInfo());
                    inforFensi.setText(information.getServerInfo().getFansNum()+"粉丝");
                    inforGuanzhu.setText(information.getServerInfo().getFrendNum()+"关注");
                    HttpFacory.create().loadImage(information.getServerInfo().getUserFace(),inforImg,true);
                    image=App.activity.getImg();
                    HttpFacory.create().loadImage(information.getServerInfo().getUserFace(), image,true);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                switch (resultCode){
                    case 101:
                        getInformation();
                        break;
                }
                break;
            case 200:
                switch (resultCode){
                    case 201:
                        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false);
                        inforImg.setImageResource(R.drawable.login_icon_accounta);
                        inforName.setCompoundDrawables(null,null,null,null);
                        inforName.setText("城市游客");
                        inforOrder.setText("请先登录或注册");
                        image.setImageResource(R.drawable.login_icon_accounta);
                        break;
                }
                break;
        }
    }
}