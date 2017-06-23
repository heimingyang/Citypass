package com.example.citypass.cotroller.fragment.life;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.FragmentAdapter;
import com.example.citypass.cotroller.adapter.Fragment_LifeGVAdapter;
import com.example.citypass.cotroller.adapter.MyGridAdapter;
import com.example.citypass.cotroller.fragment.webview.WebViewActivity;
import com.example.citypass.model.bean.life.LifeFragmentBean;
import com.example.citypass.model.http.LifeModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:生活页面
 * 创建人:张超
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
    @BindView(R.id.houses_images1)
    ImageView housesImages1;
    @BindView(R.id.houses_titles1)
    TextView housesTitles1;
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
    @BindView(R.id.fangdajing)
    ImageView fangdajing;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.RadioBut1)
    RadioButton RadioBut1;
    @BindView(R.id.RadioBut2)
    RadioButton RadioBut2;
    @BindView(R.id.Yuan_RadioGroup)
    RadioGroup YuanRadioGroup;
    @BindView(R.id.yuan1)
    RadioButton yuan1;
    @BindView(R.id.yuan2)
    RadioButton yuan2;
    @BindView(R.id.yuan1_lay)
    LinearLayout yuan1Lay;
    @BindView(R.id.viewpagerBottom)
    ViewPager viewpagerBottom;
    @BindView(R.id.Linear_ViewPager)
    ViewPager LinearViewPager;
    Unbinder unbinder;
    private LifeModel model = new LifeModel();
    private Fragment_LifeGVAdapter adapter;
    private List<LifeFragmentBean.ServerInfoBean.GetPostListBeanX.GetPostListBean> mList = new ArrayList<>();
    private LifeFragmentBean bean;
    private List<GridView> vieList = new ArrayList<>();
    private List<GridView> vieList1 = new ArrayList<>();
    private MyGridAdapter mGvAdapter;
    private FragmentAdapter pagerAdapter;
    private List<Fragment> FragmList;
    private List<Fragment> JopFraList;
    private int anInt = 0;
    private List<LifeFragmentBean.ServerInfoBean.GetPostWorkListBeanX.GetJobListBean> getJobList;
    private List<LifeFragmentBean.ServerInfoBean.GetPostHouseListBeanX.GetHomeChuZuInfoListBean> getHomeChuZuInfoList;

    @Override
    protected void initData() {
        if (anInt == 0) {
            model.Post(new MyCallBack() {
                @Override
                public void onSuccess(String result) {
                    Log.d("LifeFragment", result);
                    bean = JSON.parseObject(result, LifeFragmentBean.class);
//             这是找工作的解析
                    List<LifeFragmentBean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> getPostWorkList = bean.getServerInfo().getGetPostWorkList().getGetPostWorkList();

                    Glide.with(getContext()).load(getPostWorkList.get(0).getChannelImg()).into(jobImage);

                    String memo = getPostWorkList.get(0).getMemo();

                    zhanweiText1.setText(memo);


                    //这是找房子的解析

                    LifeFragmentBean.ServerInfoBean.GetPostHouseListBeanX.GetPostHouseListBean getPostHouseListBean = bean.getServerInfo().getGetPostHouseList().getGetPostHouseList().get(0);
                    Glide.with(getContext()).load(getPostHouseListBean.getChannelImg()).into(houseImage);

                    String memo1 = getPostHouseListBean.getMemo();

                    zhanText1.setText(memo1);


                    //最大图片那的解析
                    List<LifeFragmentBean.ServerInfoBean.GetPostHouseListBeanX.GetPostChushouBySiteIdListBean> been = bean.getServerInfo().getGetPostHouseList().getGetPostChushouBySiteIdList();

                    String address = been.get(0).getAddress();
                    String areazone = been.get(0).getAreazone();
                    housesName1.setText(address);
                    housesTitle1.setText(areazone);

                    String pic = been.get(0).getPic();

                    Glide.with(getContext()).load(pic).into(housesImage1);

                    //第二张

                    String address1 = been.get(1).getAddress();
                    String areazone1 = been.get(1).getAreazone();
                    String pic1 = been.get(1).getPic();
                    housesTitles1.setText(areazone1);
                    housesNames1.setText(address1);
                    Glide.with(getContext()).load(pic1).into(housesImages1);

                    //解析第一个listview列表
                    getOneList();
//                  //第二个列表
                    getTwoList();
                    anInt = 1;
                }


                @Override
                public void onError(String errormsg) {

                }
            });
        }
    }

    //找工作 加上图片

    private void getTwoList() {
        //解析第二个listview解析

        getHomeChuZuInfoList = bean.getServerInfo().getGetPostHouseList().getGetHomeChuZuInfoList();

        for (int i = 0; i < getHomeChuZuInfoList.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_life_jop_item2, null);
            TextView text1 = (TextView) view.findViewById(R.id.Htext1);
            TextView text2 = (TextView) view.findViewById(R.id.Htext2);
            TextView text3 = (TextView) view.findViewById(R.id.Htext3);

            String title = getHomeChuZuInfoList.get(i).getTitle();
            String pType = getHomeChuZuInfoList.get(i).getPType();
            text1.setText(pType);
            text2.setText(title);
            String time = getHomeChuZuInfoList.get(i).getTime();
            text3.setText(time);
            houseLinearlayout.removeView(view);
            houseLinearlayout.addView(view);
            continue;

        }
    }

    private void getOneList() {
        getJobList = bean.getServerInfo().getGetPostWorkList().getGetJobList();
        for (int i = 0; i < getJobList.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_life_jopitem1, null);
            TextView text1 = (TextView) view.findViewById(R.id.text1);
            TextView text2 = (TextView) view.findViewById(R.id.text2);
            TextView text3 = (TextView) view.findViewById(R.id.text3);
            text1.setText(getJobList.get(i).getPosition());
            text2.setText(getJobList.get(i).getTitle());
            String editTime = getJobList.get(i).getEditTime();
            text3.setText(TimeUtils.getTime(editTime));
            zhaopinListLay.removeView(view);
            zhaopinListLay.addView(view);
            continue;
        }
    }

    @Override
    protected void initListener() {


    }

    //动态添加viewpager
    private void NewViewPager() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        ViewPager pager = new ViewPager(getContext());
        List<LifeFragmentBean.ServerInfoBean.GetPostListBeanX.GetPostListBean> getPostList = bean.getServerInfo().getGetPostList().getGetPostList();
        mList.addAll(getPostList);
//        ServerInfoBean.GetPostListBeanX getPostList = bean.getServerInfo().getGetPostList();
//
//        mList.add(getPostList);


        Log.d("LifeFragment", "mList.size():" + mList.size());
        GridView gv = new GridView(getContext());
        gv.setNumColumns(8);

        gv.setLayoutParams(params);

        gv.setGravity(Gravity.CENTER_HORIZONTAL);

        //这是另一个gridview
//        GridView gv1 = new GridView(getContext());
//
//        gv1.setNumColumns(4);
//
//        gv1.setGravity(Gravity.CENTER_HORIZONTAL);


//        mGvAdapter = new MyGridAdapter(getContext());

        gv.setAdapter(mGvAdapter);
//        gv1.setAdapter(mGvAdapter);


        LinearViewPager.addView(gv);
//        LinearViewPager.addView(gv1);

        vieList.add(gv);
//        vieList1.add(gv1);
        adapter = new Fragment_LifeGVAdapter(vieList);
        pager.setAdapter(adapter);
//        adapter = new Fragment_LifeGVAdapter(vieList1);
//        pager.setAdapter(adapter);


    }


    @Override
    protected void initView(View view) {
        //这是上方的viewpager
        LoadViewpager();
        //下面的viewpager的监听事件

        HuaDong();

    }

    //加载viewpager
    private void LoadViewpager() {
        FragmList = new ArrayList<>();
        JopFraList = new ArrayList<>();
        FragmList.add(new FragmentOneVP());
        FragmList.add(new FragmentTwoVP());
        pagerAdapter = new FragmentAdapter(getFragmentManager(), getContext(), FragmList);
        LinearViewPager.setAdapter(pagerAdapter);

        //这是下方的viewpager

        JopFraList.add(new FragmentOneJop());
        JopFraList.add(new FragmentTwoJop());
        pagerAdapter = new FragmentAdapter(getFragmentManager(), getContext(), JopFraList);
        viewpagerBottom.setAdapter(pagerAdapter);
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

    private void HuaDong() {
        LinearViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position % FragmList.size() == 0) {
                    RadioBut1.setChecked(true);
                } else if (position % FragmList.size() == 1) {
                    RadioBut2.setChecked(true);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewpagerBottom.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                if (position % JopFraList.size() == 0) {
                    yuan1.setChecked(true);
                } else if (position % JopFraList.size() == 1) {
                    yuan2.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @OnClick({R.id.job_relay, R.id.zhaopin_text1, R.id.zhaopin_text2, R.id.zhaopin_text3, R.id.zhaopin_lay, R.id.house_text1, R.id.zhan_text1, R.id.house_relay, R.id.houses_text1, R.id.houses_text2, R.id.houses_text3, R.id.house_lay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.job_relay:
                String url = "http://m.yanqing.ccoo.cn/post/zhaopin/";
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);

                break;
            case R.id.zhaopin_text1:
                String Zhaourl = " http://m.yanqing.ccoo.cn/post/job/";
                Intent Zhaointent = new Intent(getContext(), WebViewActivity.class);
                Zhaointent.putExtra("url", Zhaourl);
                startActivity(Zhaointent);


                break;
            case R.id.zhaopin_text2:
                String Zhaourl1 = " http://m.yanqing.ccoo.cn/post/jianzhi/";
                Intent Zhaointent1 = new Intent(getContext(), WebViewActivity.class);
                Zhaointent1.putExtra("url", Zhaourl1);
                startActivity(Zhaointent1);


                break;
            case R.id.zhaopin_text3:
                String Zhaourl2 = " http://m.yanqing.ccoo.cn/post/qiuzhi/";
                Intent Zhaointent2 = new Intent(getContext(), WebViewActivity.class);
                Zhaointent2.putExtra("url", Zhaourl2);
                startActivity(Zhaointent2);
                break;
            case R.id.zhaopin_lay:
                break;
            case R.id.house_text1:
                break;
            case R.id.zhan_text1:
                break;
            case R.id.house_relay:
                break;
            case R.id.houses_text1:
                break;
            case R.id.houses_text2:
                break;
            case R.id.houses_text3:
                break;
            case R.id.house_lay:
                break;
        }
    }
}


