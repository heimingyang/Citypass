package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.Notify;
import com.example.citypass.model.bean.information.NotifyDetail;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.view.MRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/30 14:50
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class NotifyDeatailActivity extends BaseActivity {
    @BindView(R.id.notifyDetail_back)
    ImageView notifyDetailBack;
    @BindView(R.id.notifyDetail_Title)
    TextView notifyDetailTitle;
    @BindView(R.id.notifyDetail_ImgTwo)
    ImageView notifyDetailImgTwo;
    @BindView(R.id.notifyDetail_Relative)
    RelativeLayout notifyDetailRelative;
    @BindView(R.id.notifyDetail_Recycler)
    MRecyclerView notifyDetailRecycler;
    @BindView(R.id.notifyDetail_Image)
    ImageView notifyDetailImage;
    @BindView(R.id.notifyDetail_RelativeTwo)
    RelativeLayout notifyDetailRelativeTwo;
    private MedaModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notifydetail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
//        String str = intent.getStringExtra("str");
        String title=intent.getStringExtra("title");
        notifyDetailTitle.setText(title);
//        model=new IMedalModel();
//        NotifyDetail notify=new NotifyDetail();
//        notify.setUserid(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
//        notify.setSiteid(LoginUtils.information.getServerInfo().getSiteID());
//        notify.setPageindex(1);
//        notify.setPagesize(10);
//        String param = LoginUtils.getParam(notify, str);
//        model.getMedal(param, new MyCallBack() {
//            @Override
//            public void onSuccess(String result) {
//
//            }
//
//            @Override
//            public void onError(String errormsg) {
//
//            }
//        });
    }


    @OnClick({R.id.notifyDetail_back, R.id.notifyDetail_ImgTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.notifyDetail_back:
                onBackPressed();
                break;
            case R.id.notifyDetail_ImgTwo:
                break;
        }
    }
}
