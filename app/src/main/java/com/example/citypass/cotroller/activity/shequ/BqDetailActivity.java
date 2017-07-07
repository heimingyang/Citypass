package com.example.citypass.cotroller.activity.shequ;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.fragment.shequ.ZuiXinFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/7/7 16:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class BqDetailActivity extends BaseActivity {
    @BindView(R.id.bq_detail_topback)
    ImageView bqDetailTopback;
    @BindView(R.id.bq_detail_toptitle)
    TextView bqDetailToptitle;
    @BindView(R.id.bq_detail_topft)
    ImageView bqDetailTopft;
    @BindView(R.id.bq_detail_title)
    TextView bqDetailTitle;
    @BindView(R.id.bq_detail_gz)
    TextView bqDetailGz;
    @BindView(R.id.bq_detail_gzcount)
    TextView bqDetailGzcount;
    @BindView(R.id.bq_detail_tz)
    TextView bqDetailTz;
    @BindView(R.id.bq_detail_tzcount)
    TextView bqDetailTzcount;
    @BindView(R.id.bq_detail_tablayout)
    TabLayout bqDetailTablayout;
    @BindView(R.id.bq_detail_viewpager)
    ViewPager bqDetailViewpager;
    private List<BaseFragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bq_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        App.activity = this;
        list = new ArrayList<>();
        list.add(new ZuiXinFragment());

        String title = getIntent().getStringExtra("title");
        if (title != null) {
            bqDetailTitle.setText(title);
            bqDetailToptitle.setText(title);
        }
    }


    @OnClick(R.id.bq_detail_topback)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bq_detail_topback:
                onBackPressed();
                break;
        }
    }
}
