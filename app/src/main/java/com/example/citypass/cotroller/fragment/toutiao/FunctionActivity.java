package com.example.citypass.cotroller.fragment.toutiao;


import android.util.Log;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.utils.SpUtils;

public class FunctionActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_function;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        String htag= SpUtils.getSp().getString("htag",null);
        Log.e("htag",htag);
    }
}
