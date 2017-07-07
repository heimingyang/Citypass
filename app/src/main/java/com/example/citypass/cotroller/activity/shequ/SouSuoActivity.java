package com.example.citypass.cotroller.activity.shequ;


import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.shequ.BbsSearchFragment;
import com.example.citypass.cotroller.fragment.shequ.SearchListFragment;
import com.example.citypass.model.ddb.MyManger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 21:15
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class SouSuoActivity extends BaseActivity {
    @BindView(R.id.sousuo_editext)
    EditText sousuoEditext;
    @BindView(R.id.qingcu)
    ImageView qingcu;
    @BindView(R.id.quxiao)
    TextView quxiao;
    @BindView(R.id.Search_FrameLayout)
    FrameLayout SearchFrameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private MyManger manager;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_shequ_sousuo;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        sousuoEditext.addTextChangedListener(new TextWatcher() {
            //改变前
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                qingcu.setVisibility(View.GONE);
                quxiao.setText("取消");
            }

            //改变中
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    qingcu.setVisibility(View.GONE);
                    quxiao.setText("取消");
                } else if (count > 0) {
                    qingcu.setVisibility(View.VISIBLE);
                    quxiao.setText("搜索");
                }
            }

            //改变后
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initView() {
        fragmentManager = App.activity.getSupportFragmentManager();
        mShared = getSharedPreferences("bbsdata", MODE_PRIVATE);
        mEditor = mShared.edit();
        fragmentManager = App.activity.getSupportFragmentManager();
        initFrag();
    }

    private void initFrag() {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.Search_FrameLayout, new SearchListFragment());
        transaction.commit();
        manager = new MyManger(this);
    }


    @OnClick({R.id.qingcu, R.id.quxiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qingcu:
                sousuoEditext.setText(null);
                break;
            case R.id.quxiao:
                if (quxiao.getText().toString().trim().equals("取消")) {
                    this.finish();
                } else {
                    boolean insert = manager.insert(sousuoEditext.getText().toString());
                    mEditor.putString("bbsname", sousuoEditext.getText().toString());
                    mEditor.commit();
                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.Search_FrameLayout, new BbsSearchFragment());
                    transaction.commit();
                }
                break;
        }
    }

}
