package com.example.citypass.cotroller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.InforAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        InforAdapter adapter=new InforAdapter(getContext());
        inforList.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_information;
    }

}
