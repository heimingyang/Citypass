package com.example.citypass.cotroller.fragment.information;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.life.MedalAdapter;
import com.example.citypass.cotroller.adapter.life.ModelOneAdapter;
import com.example.citypass.model.bean.information.Medal;
import com.example.citypass.model.bean.information.MedalUp;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.MyGridViewOne;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 15:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ModelFragment extends BaseFragment {

    @BindView(R.id.fragment_medal_textOne)
    TextView fragmentMedalTextOne;
    @BindView(R.id.fragment_medal_textTwo)
    TextView fragmentMedalTextTwo;
    @BindView(R.id.fragment_medal_textThree)
    TextView fragmentMedalTextThree;
    @BindView(R.id.fragment_medal_Grid)
    MyGridViewOne fragmentMedalGrid;
    @BindView(R.id.fragment_medal_RelativeOne)
    RelativeLayout fragmentMedalRelativeOne;
    @BindView(R.id.fragment_medal_textFour)
    TextView fragmentMedalTextFour;
    @BindView(R.id.fragment_medal_textFive)
    TextView fragmentMedalTextFive;
    @BindView(R.id.fragment_medal_GridOne)
    MyGridViewOne fragmentMedalGridOne;
    @BindView(R.id.fragment_medal_RelativeTwo)
    RelativeLayout fragmentMedalRelativeTwo;
    @BindView(R.id.fragment_medal_textSix)
    TextView fragmentMedalTextSix;
    @BindView(R.id.fragment_medal_textSeven)
    TextView fragmentMedalTextSeven;
    @BindView(R.id.fragment_medal_GridTwo)
    MyGridViewOne fragmentMedalGridTwo;
    @BindView(R.id.fragment_medal_RelativeThree)
    RelativeLayout fragmentMedalRelativeThree;
    Unbinder unbinder;
    private MedaModel model;
    private List<Medal.ServerInfoBean.TMedalListBean.TMedalListBeans> tMedalList1;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        fragmentMedalGridTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog(tMedalList1.get(position));
            }
        });
    }

    @Override
    protected void initView(View view) {
        model=new IMedalModel();
        model.getMedal(getParams(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtils.e("aaaa",result);
                Medal medal = JSON.parseObject(result, Medal.class);
                int code = medal.getMessageList().getCode();
                if(code==1000){
                    Medal.ServerInfoBean.TMedalListBean tMedalList = medal.getServerInfo().getTMedalList();
                    Medal.ServerInfoBean.TUserMedalListBean tUserMedalList = medal.getServerInfo().getTUserMedalList();
                    tMedalList1 = tMedalList.getTMedalList();
                    fragmentMedalTextOne.setText("已点亮勋章"+tUserMedalList.getTUserMedalList().size()+"枚，未点亮"+tMedalList1.size()+"枚");
                    if(tMedalList1.size()>0){
                        fragmentMedalTextSeven.setVisibility(View.GONE);
                        fragmentMedalGridTwo.setVisibility(View.VISIBLE);
                    ModelOneAdapter adapter=new ModelOneAdapter(tMedalList1,getActivity());
                    fragmentMedalGridTwo.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_medal;
    }

    private String getParams() {
        MedalUp medal = new MedalUp();
        medal.setCustomerID(8001);
        medal.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss"));
        medal.setMethod("PHSocket_APP_MyUserMedalList");
        medal.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        medal.setAppName("CcooCity");
        medal.setVersion("4.5");
        MedalUp.ParamBean paramBean = new MedalUp.ParamBean();
        paramBean.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        paramBean.setUserID(SpUtils.getSp().getString(LoginUtils.USERID, ""));
        paramBean.setPageSize(100);
        paramBean.setCurPage(1);
        medal.setParam(paramBean);
        MedalUp.StatisBean statisBean = new MedalUp.StatisBean();
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        paramBean.setUserID(SpUtils.getSp().getString(LoginUtils.USERID, ""));
        String model = Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion = Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion + "");
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86" + LoginUtils.information.getServerInfo().getTel());
        medal.setStatis(statisBean);
        String s = JSON.toJSONString(medal);
        return s;
    }

    private void Dialog(Medal.ServerInfoBean.TMedalListBean.TMedalListBeans bean) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.medal_dialog_itemone, null);
        ImageView imgOne = (ImageView) view.findViewById(R.id.medal_dialog_back);
        ImageView imgTwo = (ImageView) view.findViewById(R.id.medal_dialog_Img);
        TextView textOne = (TextView) view.findViewById(R.id.medal_dialog_textOne);
        TextView textTwo = (TextView) view.findViewById(R.id.medal_dialog_texttwo);
        TextView textThree = (TextView) view.findViewById(R.id.medal_dialog_textthree);
        TextView textFour = (TextView) view.findViewById(R.id.medal_dialog_textfour);
        TextView textFive = (TextView) view.findViewById(R.id.medal_dialog_textfive);
        ProgressBar pro = (ProgressBar) view.findViewById(R.id.medal_dialog_progress);
        pro.setProgress(Integer.parseInt(bean.getIProgress()));
        HttpFacory.create().loadImage(bean.getImage(), imgTwo, false);
        textOne.setText(bean.getSName());
        textTwo.setText(bean.getDescription());
        textThree.setText("当前完成数：" + bean.getMState());
        textFour.setText("点亮可获得" + bean.getDCoin() + "城市币，" + bean.getDIntegral() + "成长值");
        textFive.setText(bean.getCanBeLitCondition() + bean.getEffectivetime());
        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
        imgOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
