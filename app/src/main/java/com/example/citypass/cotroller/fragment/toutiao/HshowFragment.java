package com.example.citypass.cotroller.fragment.toutiao;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.HttviewpagerAdapter;
import com.example.citypass.cotroller.fragment.toutiao.show.HshowbabyFragment;
import com.example.citypass.cotroller.fragment.toutiao.show.HshowbeautyFragment;
import com.example.citypass.cotroller.fragment.toutiao.show.HshowmanFragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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



    @Override
    protected int getLayoutId() {
        return R.layout.hshow;
    }
}
