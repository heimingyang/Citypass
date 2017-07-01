package com.example.citypass.cotroller.adapter.shequ;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.shequ.MingRenTangBean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 15:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MingRenTangFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.shequ_recyclerview)
    MRecyclerView shequRecyclerview;
    Unbinder unbinder;
    CircleImageView touxiang2;
    TextView name2;
    CircleImageView touxiang1;
    TextView name1;
    CircleImageView touxiang3;
    TextView name3;
    TextView count1;
    TextView count2;
    TextView count3;
    private int a = 0;
    private View view1;
    private List<MingRenTangBean.ServerInfoBean.InfoBean> mList = new ArrayList<>();
    private MingRenTangAdapter adapter;
    private MingRenTangBean bean;
    @Override
    protected void initData() {
        if (a == 0) {


            initParsing();
            //上拉加载下拉刷新的监听
            shequRecyclerview.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }

                //刷新
                @Override
                public void onRefresh() {
                    mList.clear();
                    initParsing();
                    shequRecyclerview.refreshComplete();
                }

                //加载
                @Override
                public void onLoadMore() {
                    shequRecyclerview.loadMoreComplete();
                }
            });
            a = 1;
        }
    }

    private void initParsing() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"customerID\":8001,\"requestTime\":\"2017-06-22 08:11:16\",\"Method\":\"PHSocket_GetBBSToReplyRank\",\"customerKey\":\"D7F61790160BDD549AF1E8FD0DBA66C4\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"userID\":30939591},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}";
        map.put("param", str);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("aaa", result);
                bean  = JSON.parseObject(result, MingRenTangBean.class);
                count1.setText(bean.getServerInfo().getInfo().get(0).getSum());
                count2.setText(bean.getServerInfo().getInfo().get(1).getSum());
                count3.setText(bean.getServerInfo().getInfo().get(2).getSum());
                name1.setText(bean.getServerInfo().getInfo().get(0).getNick());
                name2.setText(bean.getServerInfo().getInfo().get(1).getNick());
                name3.setText(bean.getServerInfo().getInfo().get(2).getNick());
                Glide.with(getContext()).load(bean.getServerInfo().getInfo().get(0).getUserFace()).into(touxiang1);
                Glide.with(getContext()).load(bean.getServerInfo().getInfo().get(1).getUserFace()).into(touxiang2);
                Glide.with(getContext()).load(bean.getServerInfo().getInfo().get(2).getUserFace()).into(touxiang3);
                mList.addAll(bean.getServerInfo().getInfo());
                //判断是否已经加载过
                if (adapter == null) {
                    adapter = new MingRenTangAdapter(mList);
                    shequRecyclerview.setAdapter(adapter);
                } else {
                    adapter.setNewData(mList);
                }
            }

            @Override
            public void onError(String errormsg) {

            }


        });
    }

    @Override
    protected void initListener() {
        touxiang1.setOnClickListener(this);
        touxiang2.setOnClickListener(this);
        touxiang3.setOnClickListener(this);
    }

    @Override
    protected void initView(View view) {
        view1 = LayoutInflater.from(App.activity).inflate(R.layout.shequ_mingrentang_tou, null);
        initViews();
        LinearLayoutManager man = new LinearLayoutManager(App.activity);
        shequRecyclerview.addHeaderView(view1);
        shequRecyclerview.setLayoutManager(man);


    }

    private void initViews() {
        touxiang1 = (CircleImageView) view1.findViewById(R.id.mingrentang_TouXiang1);
        touxiang2 = (CircleImageView) view1.findViewById(R.id.mingrentang_TouXiang2);
        touxiang3 = (CircleImageView) view1.findViewById(R.id.mingrentang_TouXiang3);
        name1 = (TextView) view1.findViewById(R.id.mingrentang_name_text1);
        name2 = (TextView) view1.findViewById(R.id.mingrentang_name_text2);
        name3 = (TextView) view1.findViewById(R.id.mingrentang_name_text3);
        count1 = (TextView) view1.findViewById(R.id.mingrentang_Text1);
        count2 = (TextView) view1.findViewById(R.id.mingrentang_Text2);
        count3 = (TextView) view1.findViewById(R.id.mingrentang_Text3);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shequ_recycler;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mingrentang_TouXiang1:
                getIntents(bean.getServerInfo().getInfo().get(0).getUserID());
                break;
            case R.id.mingrentang_TouXiang2:
                getIntents(bean.getServerInfo().getInfo().get(1).getUserID());
                break;
            case R.id.mingrentang_TouXiang3:
                getIntents(bean.getServerInfo().getInfo().get(2).getUserID());
                break;
        }
    }

    private void getIntents(int id) {
        //跳转详情之前先判断是否登录
        if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
            //如果登录就带着UserId跳转详情页面
            Intent ins = new Intent(App.activity, PersonalActivity.class);
            ins.putExtra("id", id);
            App.activity.startActivity(ins);
        } else {
            //未登录就跳转到登录页面
            Intent ina = new Intent(App.activity, LoginActivity.class);
            App.activity.startActivity(ina);
        }
    }
}
