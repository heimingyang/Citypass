package com.example.citypass.cotroller.fragment.faxian_belle;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.view.MRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/23 0023 9:48
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

public class TuHao_Fragment extends BaseFragment {
    @BindView(R.id.Tuhao_recycle)
    MRecyclerView TuhaoRecycle;
    Unbinder unbinder;
    private Handler handler = new Handler();

    @Override
    protected void initData() {
        TuhaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        TuhaoRecycle.refreshComplete();

                    }
                }, 2000);

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
        View mview = LayoutInflater.from(getContext()).inflate(R.layout.no_content, null);
        TuhaoRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        TuhaoRecycle.addHeaderView(mview);
        TuhaoRecycle.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.tuhao_fragment;
    }


}
