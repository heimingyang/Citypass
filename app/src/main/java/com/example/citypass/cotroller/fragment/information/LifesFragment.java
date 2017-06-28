package com.example.citypass.cotroller.fragment.information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 16:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LifesFragment extends BaseFragment {
    @BindView(R.id.lifes_Img)
    ImageView lifesImg;
    @BindView(R.id.lifes_Text)
    TextView lifesText;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lifes;
    }


    @OnClick(R.id.lifes_Text)
    public void onViewClicked() {
    }
}
