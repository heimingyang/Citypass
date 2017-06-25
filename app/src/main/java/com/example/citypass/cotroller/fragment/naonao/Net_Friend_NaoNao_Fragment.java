package com.example.citypass.cotroller.fragment.naonao;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.Net_Friend_NaoNao_Recycle_Adapter;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.List;

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
    private Net_Friend_NaoNao_Recycle_Adapter adapter;
    private List<String> mlist = new ArrayList<>();
    @Override
    protected void initData() {
        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        TextView tv = new TextView(getActivity());
        tv.setText("已没有更多数据");
        tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tv.setPadding(180,5,180,5);
        netFriendNaonaoRecycle.addHeaderView(tv);
        netFriendNaonaoRecycle.setLayoutManager(man);
        mlist.add("");
        if(adapter==null){
            adapter = new Net_Friend_NaoNao_Recycle_Adapter(mlist);
            netFriendNaonaoRecycle.setAdapter(adapter);
        }else {
            netFriendNaonaoRecycle.setAdapter(adapter);
        }
        netFriendNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
            netFriendNaonaoRecycle.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });
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
