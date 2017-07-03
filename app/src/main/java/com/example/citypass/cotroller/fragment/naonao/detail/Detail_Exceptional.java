package com.example.citypass.cotroller.fragment.naonao.detail;

import android.view.View;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.view.MyRecycler;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/28 21:42
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class Detail_Exceptional extends BaseFragment {


    @BindView(R.id.Naonao_Recycler)
    MyRecycler NaonaoRecycler;
    @BindView(R.id.NaoNao_Recycler_Text)
    TextView NaoNaoRecyclerText;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        NaoNaoRecyclerText.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.naonao_recyvler;
    }



}
