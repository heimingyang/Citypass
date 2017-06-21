package com.example.citypass.cotroller.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 8:23
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

public class LifeFragment extends BaseFragment {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.job_image)
    ImageView jobImage;
    @BindView(R.id.job_text1)
    TextView jobText1;
    @BindView(R.id.zhanwei_text1)
    TextView zhanweiText1;
    @BindView(R.id.job_more_text)
    TextView jobMoreText;
    @BindView(R.id.arrow_image)
    ImageView arrowImage;
    @BindView(R.id.job_relay)
    RelativeLayout jobRelay;
    @BindView(R.id.zhaopin_text1)
    TextView zhaopinText1;
    @BindView(R.id.zhaopin_text2)
    TextView zhaopinText2;
    @BindView(R.id.zhaopin_text3)
    TextView zhaopinText3;
    @BindView(R.id.zhaopin_lay)
    LinearLayout zhaopinLay;
    @BindView(R.id.zhaopin_list_lay)
    LinearLayout zhaopinListLay;
    @BindView(R.id.house_image)
    ImageView houseImage;
    @BindView(R.id.house_text1)
    TextView houseText1;
    @BindView(R.id.zhan_text1)
    TextView zhanText1;
    @BindView(R.id.house_more_text)
    TextView houseMoreText;
    @BindView(R.id.house_arrow_image)
    ImageView houseArrowImage;
    @BindView(R.id.house_relay)
    RelativeLayout houseRelay;
    @BindView(R.id.house_main_lay)
    LinearLayout houseMainLay;
    @BindView(R.id.houses_text1)
    TextView housesText1;
    @BindView(R.id.houses_text2)
    TextView housesText2;
    @BindView(R.id.houses_text3)
    TextView housesText3;
    @BindView(R.id.house_lay)
    LinearLayout houseLay;
    @BindView(R.id.houses_image1)
    ImageView housesImage1;
    @BindView(R.id.houses_title1)
    TextView housesTitle1;
    @BindView(R.id.houses_relay1)
    RelativeLayout housesRelay1;
    @BindView(R.id.houses_name1)
    TextView housesName1;
    @BindView(R.id.houses_price1)
    TextView housesPrice1;
    @BindView(R.id.houses_layout1)
    RelativeLayout housesLayout1;
    @BindView(R.id.houses_titles1)
    TextView housesTitles1;
    @BindView(R.id.houses_images1)
    ImageView housesImages1;
    @BindView(R.id.houses_relays1)
    RelativeLayout housesRelays1;
    @BindView(R.id.houses_names1)
    TextView housesNames1;
    @BindView(R.id.houses_prices1)
    TextView housesPrices1;
    @BindView(R.id.houses_layouts1)
    RelativeLayout housesLayouts1;
    @BindView(R.id.houses_lay)
    LinearLayout housesLay;
    @BindView(R.id.house_Linearlayout)
    LinearLayout houseLinearlayout;
    @BindView(R.id.viewpager1)
    ViewPager viewpager1;
    @BindView(R.id.yuan1)
    ImageView yuan1;
    @BindView(R.id.yuan2)
    ImageView yuan2;
    @BindView(R.id.yuan1_lay)
    LinearLayout yuan1Lay;
    @BindView(R.id.fangdajing)
    ImageView fangdajing;
    @BindView(R.id.edit)
    EditText edit;
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
    public int getLayoutId() {
        return R.layout.fragment_life;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        App.activity.getText().setText("生活");
        App.activity.getText().setCompoundDrawables(null, null, null, null);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
