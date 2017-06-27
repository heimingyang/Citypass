package com.example.citypass.cotroller;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.LevelAdapter;
import com.example.citypass.model.bean.Level;
import com.example.citypass.model.bean.Levels;
import com.example.citypass.model.biz.infor.ILevelModel;
import com.example.citypass.model.biz.infor.LevelModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.level;
import static com.example.citypass.utils.LoginUtils.USERID;
import static com.example.citypass.utils.LoginUtils.information;

/**
 * 项目名称: 血压卫士
 * 类描述: 等级页面
 * 创建人: 马杰
 * 创建时间: 2017/6/24 9:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LevelActivity extends BaseActivity {
    @BindView(R.id.level_back)
    ImageView levelBack;
    @BindView(R.id.level_privilege)
    TextView levelPrivilege;
    @BindView(R.id.level_Relative)
    RelativeLayout levelRelative;
    @BindView(R.id.level_imgOne)
    ImageView levelImgOne;
    @BindView(R.id.level_textOne)
    TextView levelTextOne;
    @BindView(R.id.level_linearOne)
    RelativeLayout levelLinearOne;
    @BindView(R.id.level_imgTwo)
    ImageView levelImgTwo;
    @BindView(R.id.level_textTwo)
    TextView levelTextTwo;
    @BindView(R.id.level_linearTwo)
    RelativeLayout levelLinearTwo;
    @BindView(R.id.level_imgThree)
    ImageView levelImgThree;
    @BindView(R.id.level_textThree)
    TextView levelTextThree;
    @BindView(R.id.level_linearThree)
    RelativeLayout levelLinearThree;
    @BindView(R.id.level_imgFour)
    ImageView levelImgFour;
    @BindView(R.id.level_textFour)
    TextView levelTextFour;
    @BindView(R.id.level_linearFour)
    RelativeLayout levelLinearFour;
    @BindView(R.id.level_imgFive)
    ImageView levelImgFive;
    @BindView(R.id.level_textFive)
    TextView levelTextFive;
    @BindView(R.id.level_linearFive)
    RelativeLayout levelLinearFive;
    @BindView(R.id.level_RelativeTwo)
    RelativeLayout levelRelativeTwo;
    @BindView(R.id.level_RelativeThree)
    RelativeLayout levelRelativeThree;
    @BindView(R.id.level_RelativeFour)
    RelativeLayout levelRelativeFour;
    @BindView(R.id.level_List)
    ListView levelList;
    @BindView(R.id.level_dengji)
    TextView levelDengji;
    private LevelModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_level;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        model.getList(gerParam(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Levels levels = JSON.parseObject(result, Levels.class);
                int code = levels.getMessageList().getCode();
                if(code==1000){
                    levelDengji.setText(levels.getServerInfo().getMyTLevel().getMyTLevel().get(0).getCIntegral());
                    int currLevel = levels.getServerInfo().getMyTLevel().getMyTLevel().get(0).getCurrLevel();
                    List<Levels.ServerInfoBean.TLevelListBeans.TLevelListBean> tLevelList = levels.getServerInfo().getTLevelList().getTLevelList();
                    LevelAdapter adapter=new LevelAdapter(tLevelList,LevelActivity.this,currLevel-1);
                    levelList.setAdapter(adapter);
                    int currLevel1 = levels.getServerInfo().getMyTLevel().getMyTLevel().get(0).getCurrLevel();
                    if(currLevel1==1){
                        HttpFacory.create().loadImage(LoginUtils.information.getServerInfo().getUserFace(), levelImgOne, true);
                    }else if(currLevel1==2){
                        HttpFacory.create().loadImage(LoginUtils.information.getServerInfo().getUserFace(), levelImgTwo, true);
                        levelImgOne.setBackgroundResource(R.drawable.task_mylevel_head5);
                    }else if(currLevel1==3){
                        HttpFacory.create().loadImage(LoginUtils.information.getServerInfo().getUserFace(), levelImgThree, true);
                        levelImgOne.setBackgroundResource(R.drawable.task_mylevel_head5);
                        levelImgTwo.setBackgroundResource(R.drawable.task_mylevel_head5);
                    }else if(currLevel1==4){
                        HttpFacory.create().loadImage(LoginUtils.information.getServerInfo().getUserFace(), levelImgFour, true);
                        levelImgOne.setBackgroundResource(R.drawable.task_mylevel_head5);
                        levelImgTwo.setBackgroundResource(R.drawable.task_mylevel_head5);
                        levelImgThree.setBackgroundResource(R.drawable.task_mylevel_head5);
                    }else if(currLevel1==5){
                        HttpFacory.create().loadImage(LoginUtils.information.getServerInfo().getUserFace(), levelImgFive, true);
                        levelImgOne.setBackgroundResource(R.drawable.task_mylevel_head5);
                        levelImgTwo.setBackgroundResource(R.drawable.task_mylevel_head5);
                        levelImgThree.setBackgroundResource(R.drawable.task_mylevel_head5);
                        levelImgFour.setBackgroundResource(R.drawable.task_mylevel_head5);
                    }
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initView() {
        model = new ILevelModel();

    }

    private String gerParam() {
        Level level = new Level();
        level.setCustomerID(8001);
        level.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss"));
        level.setMethod("PHSocket_APP_GetMyTLevel");
        level.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        level.setAppName("CcooCity");
        level.setVersion("4.5");
        Level.ParamBean paramBean = new Level.ParamBean();
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setUserID(SpUtils.getSp().getString(USERID, ""));
        paramBean.setCurPage(1);
        paramBean.setPageSize(30);
        level.setParam(paramBean);
        Level.StatisBean statisBean = new Level.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86" + information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(USERID, "")));
        statisBean.setSiteId(information.getServerInfo().getSiteID());
        String model = Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion = Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion + "");
        level.setStatis(statisBean);
        String s = JSON.toJSONString(level);
        return s;
    }


    @OnClick({R.id.level_back, R.id.level_privilege})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.level_back:
                onBackPressed();
                break;
            case R.id.level_privilege:
                break;
        }
    }

}
