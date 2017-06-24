package com.example.citypass.cotroller.fragment.naonao;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.view.MRecyclerView;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/20 0020 17:02
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


public class Net_Friend_NaoNao_Fragment extends BaseFragment {
    @BindView(R.id.net_friend_naonao_recycle)
    MRecyclerView netFriendNaonaoRecycle;
    Unbinder unbinder;

    @Override
    protected void initData() {
        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        TextView tv = new TextView(getActivity());
        tv.setText("已经没有更多数据了");
        tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        netFriendNaonaoRecycle.addHeaderView(tv);
        netFriendNaonaoRecycle.setLayoutManager(man);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.net_friend_naonao_fragment;
    }


}
