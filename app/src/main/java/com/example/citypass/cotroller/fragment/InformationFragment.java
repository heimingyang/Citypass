package com.example.citypass.cotroller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.Utils.SpUtils;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.CooperationActivity;
import com.example.citypass.cotroller.LoginActivity;
import com.example.citypass.cotroller.adapter.InforAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    Unbinder unbinder;
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
    Unbinder unbinder1;
    private boolean login;

    @Override
    protected void initData() {
        login = SpUtils.getSp().getBoolean("login", false);
    }

    @Override
    protected void initListener() {
        inforList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        login(null);
                        break;
                    case 1:
                        login(null);
                        break;
                    case 2:
                        login(null);
                        break;
                    case 3:
                        login(null);
                        break;
                    case 4:
                        login(null);
                        break;
                    case 5:
                        login(null);
                        break;
                    case 6:
                        login(null);
                        break;
                    case 7:
                        login(null);
                        break;
                    case 8:
                        login(null);
                        break;
                    case 9:
                        login(null);
                        break;
                    case 10:
                        login(null);
                        break;
                    case 11:
                        login(null);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView(View view) {
        InforAdapter adapter = new InforAdapter(getContext());
        inforList.setAdapter(adapter);
    }

    private void login(Class c) {
        if (login) {
            Intent intent = new Intent(getActivity(), c);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_information;
    }



    @OnClick({R.id.infor_img, R.id.infor_name, R.id.infor_order, R.id.infor_guanzhu, R.id.infor_fensi, R.id.infor_login, R.id.infor_setting, R.id.infor_hezuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.infor_img:
                login(null);
                break;
            case R.id.infor_name:
                login(null);
                break;
            case R.id.infor_order:
                login(null);
                break;
            case R.id.infor_guanzhu:
                login(null);
                break;
            case R.id.infor_fensi:
                login(null);
                break;
            case R.id.infor_login:
                login(null);
                break;
            case R.id.infor_setting:
                login(null);
                break;
            case R.id.infor_hezuo:
                login(CooperationActivity.class);
                break;
        }
    }
}
