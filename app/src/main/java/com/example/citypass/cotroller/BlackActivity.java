package com.example.citypass.cotroller;

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
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/24 11:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class BlackActivity extends BaseActivity {
    @BindView(R.id.black_back)
    ImageView blackBack;
    @BindView(R.id.black_Relative)
    RelativeLayout blackRelative;

    @Override
    protected int getLayoutId() {
        return R.layout.acitivity_blacklist;
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


    @OnClick(R.id.black_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
