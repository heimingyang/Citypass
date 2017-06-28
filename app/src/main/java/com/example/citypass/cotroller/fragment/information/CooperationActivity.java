package com.example.citypass.cotroller.fragment.information;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 商务合作页面
 * 创建人: 马杰
 * 创建时间: 2017/6/20 19:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CooperationActivity extends BaseActivity {
    @BindView(R.id.cooperation_back)
    ImageView cooperationBack;
    @BindView(R.id.cooperation_Relative)
    RelativeLayout cooperationRelative;

    @Override
    protected int getLayoutId() {
        return R.layout.acitivity_cooperation;
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


    @OnClick(R.id.cooperation_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
