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
 * 类描述: 免责声明
 * 创建人: 马杰
 * 创建时间: 2017/6/22 15:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class AboutActivity2 extends BaseActivity {
    @BindView(R.id.about2_back)
    ImageView about2Back;
    @BindView(R.id.about2_Relative)
    RelativeLayout about2Relative;

    @Override
    protected int getLayoutId() {
        return R.layout.aboutwe_layout2;
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


    @OnClick(R.id.about2_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
