package com.example.citypass.cotroller.fragment.toutiao;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.HttviewpagerAdapter;
import com.example.citypass.cotroller.fragment.toutiao.show.HshowbabyFragment;
import com.example.citypass.cotroller.fragment.toutiao.show.HshowbeautyFragment;
import com.example.citypass.cotroller.fragment.toutiao.show.HshowmanFragment;
import com.example.citypass.model.bean.toutiao.Showbean;
import com.example.citypass.model.bean.toutiao.Showinter;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/30 9:24
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


public class HshowFragment extends BaseFragment {
    @BindView(R.id.hshow_viewpager)
    ViewPager hshowViewpager;
    @BindView(R.id.hshow_radiobt1)
    RadioButton hshowRadiobt1;
    @BindView(R.id.hshow_radiobt2)
    RadioButton hshowRadiobt2;
    @BindView(R.id.hshow_radiobt3)
    RadioButton hshowRadiobt3;
    @BindView(R.id.hshow_lin1_title)
    RelativeLayout hshowLin1Title;
    @BindView(R.id.hshow_lin1_one)
    ImageView hshowLin1One;
    @BindView(R.id.hshow_lin1_two)
    ImageView hshowLin1Two;
    @BindView(R.id.hshow_lin1_three)
    ImageView hshowLin1Three;
    @BindView(R.id.hshow_lin1_four)
    ImageView hshowLin1Four;
    @BindView(R.id.hshow_lin1_five)
    ImageView hshowLin1Five;
    @BindView(R.id.hshow_lin1_six)
    ImageView hshowLin1Six;
    @BindView(R.id.hshow_lin1_tv1_up)
    TextView hshowLin1Tv1Up;
    @BindView(R.id.hshow_lin1_tv1_down)
    TextView hshowLin1Tv1Down;
    @BindView(R.id.hshow_lin1_tvone)
    RelativeLayout hshowLin1Tvone;
    @BindView(R.id.hshow_lin1_tv2)
    TextView hshowLin1Tv2;
    @BindView(R.id.hshow_lin1_tvtwo)
    RelativeLayout hshowLin1Tvtwo;
    @BindView(R.id.hshow_lin1_tv3)
    TextView hshowLin1Tv3;
    @BindView(R.id.hshow_lin1_tvthree)
    RelativeLayout hshowLin1Tvthree;
    @BindView(R.id.hshow_lin1_tv4)
    TextView hshowLin1Tv4;
    @BindView(R.id.hshow_lin1_tvfour)
    RelativeLayout hshowLin1Tvfour;
    @BindView(R.id.hshow_lin1_tv5)
    TextView hshowLin1Tv5;
    @BindView(R.id.hshow_lin1_tvfive)
    RelativeLayout hshowLin1Tvfive;
    @BindView(R.id.hshow_lin1_tv6)
    TextView hshowLin1Tv6;
    @BindView(R.id.hshow_lin1_tvsix)
    RelativeLayout hshowLin1Tvsix;
    @BindView(R.id.hshow_lin1)
    RelativeLayout hshowLin1;
    @BindView(R.id.hshow_lin2_title)
    RelativeLayout hshowLin2Title;
    @BindView(R.id.hshow_lin2_one)
    ImageView hshowLin2One;
    @BindView(R.id.hshow_lin2_two)
    ImageView hshowLin2Two;
    @BindView(R.id.hshow_lin2_three)
    ImageView hshowLin2Three;
    @BindView(R.id.hshow_lin2_four)
    ImageView hshowLin2Four;
    @BindView(R.id.hshow_lin2_five)
    ImageView hshowLin2Five;
    @BindView(R.id.hshow_lin2_six)
    ImageView hshowLin2Six;
    @BindView(R.id.hshow_lin2_tv1_up)
    TextView hshowLin2Tv1Up;
    @BindView(R.id.hshow_lin2_tv1_down)
    TextView hshowLin2Tv1Down;
    @BindView(R.id.hshow_lin2_tvone)
    RelativeLayout hshowLin2Tvone;
    @BindView(R.id.hshow_lin2_tv2)
    TextView hshowLin2Tv2;
    @BindView(R.id.hshow_lin2_tvtwo)
    RelativeLayout hshowLin2Tvtwo;
    @BindView(R.id.hshow_lin2_tv3)
    TextView hshowLin2Tv3;
    @BindView(R.id.hshow_lin2_tvthree)
    RelativeLayout hshowLin2Tvthree;
    @BindView(R.id.hshow_lin2_tv4)
    TextView hshowLin2Tv4;
    @BindView(R.id.hshow_lin2_tvfour)
    RelativeLayout hshowLin2Tvfour;
    @BindView(R.id.hshow_lin2_tv5)
    TextView hshowLin2Tv5;
    @BindView(R.id.hshow_lin2_tvfive)
    RelativeLayout hshowLin2Tvfive;
    @BindView(R.id.hshow_lin2_tv6)
    TextView hshowLin2Tv6;
    @BindView(R.id.hshow_lin2_tvsix)
    RelativeLayout hshowLin2Tvsix;
    @BindView(R.id.hshow_lin2)
    RelativeLayout hshowLin2;
    @BindView(R.id.hshow_lin3_title)
    RelativeLayout hshowLin3Title;
    @BindView(R.id.hshow_lin3_one)
    ImageView hshowLin3One;
    @BindView(R.id.hshow_lin3_two)
    ImageView hshowLin3Two;
    @BindView(R.id.hshow_lin3_three)
    ImageView hshowLin3Three;
    @BindView(R.id.hshow_lin3_four)
    ImageView hshowLin3Four;
    @BindView(R.id.hshow_lin3_five)
    ImageView hshowLin3Five;
    @BindView(R.id.hshow_lin3_six)
    ImageView hshowLin3Six;
    @BindView(R.id.hshow_lin3_tv1_up)
    TextView hshowLin3Tv1Up;
    @BindView(R.id.hshow_lin3_tv1_down)
    TextView hshowLin3Tv1Down;
    @BindView(R.id.hshow_lin3_tvone)
    RelativeLayout hshowLin3Tvone;
    @BindView(R.id.hshow_lin3_tv2)
    TextView hshowLin3Tv2;
    @BindView(R.id.hshow_lin3_tvtwo)
    RelativeLayout hshowLin3Tvtwo;
    @BindView(R.id.hshow_lin3_tv3)
    TextView hshowLin3Tv3;
    @BindView(R.id.hshow_lin3_tvthree)
    RelativeLayout hshowLin3Tvthree;
    @BindView(R.id.hshow_lin3_tv4)
    TextView hshowLin3Tv4;
    @BindView(R.id.hshow_lin3_tvfour)
    RelativeLayout hshowLin3Tvfour;
    @BindView(R.id.hshow_lin3_tv5)
    TextView hshowLin3Tv5;
    @BindView(R.id.hshow_lin3_tvfive)
    RelativeLayout hshowLin3Tvfive;
    @BindView(R.id.hshow_lin3_tv6)
    TextView hshowLin3Tv6;
    @BindView(R.id.hshow_lin3_tvsix)
    RelativeLayout hshowLin3Tvsix;
    @BindView(R.id.hshow_lin3)
    RelativeLayout hshowLin3;
    Unbinder unbinder;
    private ViewPager viewPager;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private ArrayList<Fragment> fragments;
    private int pager = 5;
    private int item;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 999:
                    item = pager % 4;
                    viewPager.setCurrentItem(item);
                    pager++;
                    break;
            }
        }
    };
    private boolean login;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.hshow_viewpager);
        radioButton1 = (RadioButton) view.findViewById(R.id.hshow_radiobt1);
        radioButton2 = (RadioButton) view.findViewById(R.id.hshow_radiobt2);
        radioButton3 = (RadioButton) view.findViewById(R.id.hshow_radiobt3);
        //轮播图
        lunbo();
        getpoupwindowdata();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.hshow;
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

    @OnClick({R.id.hshow_lin1, R.id.hshow_lin2, R.id.hshow_lin3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hshow_lin1:

                break;
            case R.id.hshow_lin2:
                break;
            case R.id.hshow_lin3:
                break;
        }
    }
    //秀场图片加载数据
    public void getpoupwindowdata() {
        login = SpUtils.getSp().getBoolean(LoginUtils.LOGIN, true);

        Showinter.ParamBean param = new Showinter.ParamBean();
        param.setSiteID(2422);

        Showinter.StatisBean statis = new Showinter.StatisBean();
        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
       /* if (login) {
            statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, null)));
        } else {*/
            statis.setUserId(0);
//        }

        Showinter toutiao = new Showinter();
        toutiao.setMethod("PHSocket_GetTCoverInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("DEA832A7713A04741F6C68FE74F3E30E");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Map<String, String> map = new HashMap<>();
        map.put("param", s);
        //Log.e("TTTTTTTTT",s);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, null, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                //Log.e("Showbean", result.toString());
                Showbean showbean = JSON.parseObject(result, Showbean.class);
                if (showbean == null) {
                    return;
                }
                Showbean.ServerInfoBean bean = showbean.getServerInfo();

                Showbean.ServerInfoBean.TCoverInfoByGirlListBeanX girl = bean.getTCoverInfoByGirlList();
                Showbean.ServerInfoBean.TCoverInfoByBoyListBeanX boy = bean.getTCoverInfoByBoyList();
                Showbean.ServerInfoBean.TCoverInfoByBaByListBeanX baby = bean.getTCoverInfoByBaByList();

                Glide.with(getActivity()).load(girl.getTCoverInfoByGirlList().get(0).getPhoto()).into(hshowLin1One);
                hshowLin1Tv1Up.setText(girl.getTCoverInfoByGirlList().get(0).getMapName());
                hshowLin1Tv1Down.setText(girl.getTCoverInfoByGirlList().get(0).getNick());

                Glide.with(getActivity()).load(girl.getTCoverInfoByGirlList().get(1).getPhoto()).into(hshowLin1Two);
                hshowLin1Tv2.setText(girl.getTCoverInfoByGirlList().get(1).getTName());

                Glide.with(getActivity()).load(girl.getTCoverInfoByGirlList().get(2).getPhoto()).into(hshowLin1Three);
                hshowLin1Tv3.setText(girl.getTCoverInfoByGirlList().get(2).getTName());

                Glide.with(getActivity()).load(girl.getTCoverInfoByGirlList().get(3).getPhoto()).into(hshowLin1Six);
                hshowLin1Tv4.setText(girl.getTCoverInfoByGirlList().get(3).getTName());

                Glide.with(getActivity()).load(girl.getTCoverInfoByGirlList().get(4).getPhoto()).into(hshowLin1Five);
                hshowLin1Tv5.setText(girl.getTCoverInfoByGirlList().get(4).getTName());

                Glide.with(getActivity()).load(girl.getTCoverInfoByGirlList().get(5).getPhoto()).into(hshowLin1Four);
                hshowLin1Tv6.setText(girl.getTCoverInfoByGirlList().get(5).getTName());


                Glide.with(getActivity()).load(boy.getTCoverInfoByBoyList().get(0).getPhoto()).into(hshowLin2One);
                hshowLin2Tv1Up.setText(boy.getTCoverInfoByBoyList().get(0).getMapName());
                hshowLin2Tv1Down.setText(boy.getTCoverInfoByBoyList().get(0).getNick());

                Glide.with(getActivity()).load(boy.getTCoverInfoByBoyList().get(1).getPhoto()).into(hshowLin2Two);
                hshowLin2Tv2.setText(boy.getTCoverInfoByBoyList().get(1).getTName());


                Glide.with(getActivity()).load(baby.getTCoverInfoByBaByList().get(0).getPhoto()).into(hshowLin3One);
                hshowLin3Tv1Up.setText(baby.getTCoverInfoByBaByList().get(0).getMapName());
                hshowLin3Tv1Down.setText(baby.getTCoverInfoByBaByList().get(0).getNick());

                Glide.with(getActivity()).load(baby.getTCoverInfoByBaByList().get(1).getPhoto()).into(hshowLin3Two);
                hshowLin3Tv2.setText(baby.getTCoverInfoByBaByList().get(1).getTName());

                // Log.e("list", list.size() + "");
            }

            @Override
            public void onError(String errormsg) {
                Log.e("onError", errormsg);
            }
        });
    }
    private void lunbo() {
        fragments = new ArrayList<>();
        fragments.add(new HshowbeautyFragment());
        fragments.add(new HshowbabyFragment());
        fragments.add(new HshowmanFragment());

        HttviewpagerAdapter adapter1 = new HttviewpagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter1);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                item = position;
                String id = String.valueOf(position);
                if (id.equals("0")) {
                    radioButton1.setChecked(true);
                } else if (id.equals("1")) {
                    radioButton2.setChecked(true);
                } else if (id.equals("2")) {
                    radioButton3.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //轮播图send message
        sendlunbomessage();
    }

    private void sendlunbomessage() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(999);
            }
        }, 2000, 2000);
    }
}
