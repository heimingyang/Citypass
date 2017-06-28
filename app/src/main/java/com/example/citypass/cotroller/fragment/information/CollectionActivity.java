package com.example.citypass.cotroller.fragment.information;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 19:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CollectionActivity extends BaseActivity {
    @BindView(R.id.collection_back)
    ImageView collectionBack;
    @BindView(R.id.collection_Relative)
    RelativeLayout collectionRelative;
    @BindView(R.id.collection_Text_one)
    TextView collectionTextOne;
    @BindView(R.id.collection_Text_two)
    TextView collectionTextTwo;
    @BindView(R.id.collection_Text_three)
    TextView collectionTextThree;
    @BindView(R.id.collection_Text_four)
    TextView collectionTextFour;
    @BindView(R.id.collection_Text_five)
    TextView collectionTextFive;
    @BindView(R.id.collection_Text_six)
    TextView collectionTextSix;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
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


    @OnClick({R.id.collection_back, R.id.collection_Text_one, R.id.collection_Text_two, R.id.collection_Text_three, R.id.collection_Text_four, R.id.collection_Text_five, R.id.collection_Text_six})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collection_back:
                onBackPressed();
                break;
            case R.id.collection_Text_one:
                break;
            case R.id.collection_Text_two:
                break;
            case R.id.collection_Text_three:
                break;
            case R.id.collection_Text_four:
                break;
            case R.id.collection_Text_five:
                break;
            case R.id.collection_Text_six:
                break;
        }
    }
}
