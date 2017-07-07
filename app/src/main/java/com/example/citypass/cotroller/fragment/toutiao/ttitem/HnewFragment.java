package com.example.citypass.cotroller.fragment.toutiao.ttitem;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.toutiao.Hnew_Adapter;
import com.example.citypass.cotroller.adapter.toutiao.Hsoc_Adapter;
import com.example.citypass.cotroller.adapter.toutiao.Htzxq_Adapter;
import com.example.citypass.model.bean.toutiao.Idbean;
import com.example.citypass.model.bean.toutiao.Newbean;
import com.example.citypass.model.bean.toutiao.Newinter;
import com.example.citypass.model.bean.toutiao.Tzxqbean;
import com.example.citypass.model.bean.toutiao.Tzxqinter;
import com.example.citypass.model.biz.infor.IInforModel;
import com.example.citypass.model.biz.infor.InforModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.DeviceUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.KeyboardUtils;
import com.example.citypass.view.MRecyclerView;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/23 14:43
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


public class HnewFragment extends BaseFragment {


    @BindView(R.id.hnewfragment_tv)
    TextView hnewfragmentTv;
    @BindView(R.id.newrecycler)
    MRecyclerView newrecycler;
    Unbinder unbinder;
    private int page = 1;
    private ArrayList<Newbean.ServerInfoBean> mlist;
    private ArrayList<Tzxqbean.ServerInfoBean> tzmlist;
    private Hnew_Adapter adapter;
    private TextView textView;
    private View footview;
    private int mid;
    private Htzxq_Adapter tzadapter;


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void getid(Idbean messageEvent) {
        mid = messageEvent.getId();
        String type=messageEvent.getType();


        footview = LayoutInflater.from(getActivity()).inflate(R.layout.cityfootview,null);
        textView = (TextView) footview.findViewById(R.id.footview_tv);
        mlist = new ArrayList<Newbean.ServerInfoBean>();
        tzmlist=new ArrayList<>();
//
//        if(type.equals("html")){
            getjust(mid);
            adapter = new Hnew_Adapter(mlist,getActivity());
            newrecycler.setAdapter(adapter);
            newrecycler.setFootView(footview);
//        }
//        if(type.equals("帖子")){
//            gettz(mid);
//            tzadapter = new Htzxq_Adapter(tzmlist,getActivity());
//            newrecycler.setAdapter(tzadapter);
//            newrecycler.setFootView(footview);
//        }




        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        newrecycler.setLayoutManager(man);

        newrecycler.setLoadingMoreEnabled(true);
        newrecycler.setPullRefreshEnabled(false);
    }

    private void gettz(int mid) {
        Tzxqinter.ParamBean  param = new Tzxqinter.ParamBean();
        param.setCurPage(page);
        param.setIsDaka(0);
        param.setOrder(0);
        param.setPageSize(10);
        param.setRuserName("");
        param.setSiteID(2422);
        param.setTopicID(mid);

        Tzxqinter.StatisBean statis = new Tzxqinter.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));

        Tzxqinter toutiao = new Tzxqinter();
        toutiao.setMethod("PHSocket_GetBBSReplyList");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("7B0A92FF71842D45EC209990285DAE6D");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("onSuccess", result);

                Tzxqbean newbean= JSON.parseObject(result,Tzxqbean.class);
                if(newbean.getServerInfo().size()!=0){
                    tzmlist.addAll(newbean.getServerInfo());
                }


                if(tzmlist.size()==0){
                    textView.setText("目前还没有评论，评论强沙发吧--");
                }else  if(tzmlist.size()==1){
                    textView.setText("参与评论，抢占板凳吧--");
                }else if(tzmlist.size()==2){
                    textView.setText("参与评论，抢占马扎吧--");
                }else {
                    textView.setText("没有更多内容了--");
                }
                tzadapter.notifyDataSetChanged();

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


    public void getjust(int mid) {
        Newinter.ParamBean  param = new Newinter.ParamBean();
        param.setCurPage(page);
        param.setNewsID(mid);
        param.setPageSize(10);
        param.setSiteID(2422);
        param.setType(0);
        param.setUserID(SpUtils.getSp().getString(LoginUtils.USERID, ""));
        Newinter.StatisBean statis = new Newinter.StatisBean();

        statis.setPhoneId(DeviceUtils.getInstance().getDeviceId(getActivity()));
        statis.setPhoneNo(DeviceUtils.getInstance().getPhoneModel());
        statis.setPhoneNum(DeviceUtils.getInstance().getDevicenumber(getActivity()));
        statis.setSiteId(2422);
        statis.setSystemNo(2);
        DeviceUtils.getInstance();
        statis.setSystem_VersionNo(DeviceUtils.getBuildVersion());
        statis.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));

        Newinter toutiao = new Newinter();
        toutiao.setMethod("PHSocket_GetCityReplyInfo");
        toutiao.setParam(param);
        toutiao.setStatis(statis);
        toutiao.setAppName("CcooCity");
        toutiao.setCustomerID(8001);
        toutiao.setCustomerKey("43122C2198D09D332DD480DC982DFA2F");
        toutiao.setRequestTime(TimeUtils.getdangqianshijian());
        toutiao.setVersion("4.5");
        Gson gson = new Gson();
        String s = gson.toJson(toutiao);
//        Log.e("onSuccess", s);

        InforModel inforModel = new IInforModel();
        inforModel.UpLoad(s, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
//                Log.e("onSuccess", result);

                Newbean newbean= JSON.parseObject(result,Newbean.class);
                mlist.addAll(newbean.getServerInfo());

                //传值

                SpUtils.upSp().putString("newnumber",mlist.size()+"").commit();
//                Idbean  idbean=new Idbean();
//                idbean.setNewnumber(mlist.size());
//                EventBus.getDefault().postSticky(idbean);

                if(mlist.size()==0){
                    textView.setText("目前还没有评论，评论强沙发吧--");
                }else  if(mlist.size()==1){
                    textView.setText("参与评论，抢占板凳吧--");
                }else if(mlist.size()==2){
                    textView.setText("参与评论，抢占马扎吧--");
                }else {
                    textView.setText("没有更多内容了--");
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.ttitem_new;
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
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }
}
