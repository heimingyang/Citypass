//package com.example.citypass.cotroller.tongyong;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.Bundle;
//import android.text.format.DateUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.example.citypass.R;
//import com.example.citypass.base.BaseFragment;
//import com.example.citypass.utils.DeviceUtils;
//import com.example.citypass.utils.SpUtils;
//import com.google.gson.Gson;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;
//
//import static android.content.Context.MODE_PRIVATE;
//
///**
// * Created by Administrator on 2017/6/24 0024.
// */
//
//public class CommunityDetailsZSXItemFragment extends BaseFragment {
//    int tipicID;
//    List<ZSXItemCallBackEntity.ServerInfoBean> serverInfoList;
//    ZSXItemAdapter itemAdapter;
//    boolean isBoolean;
//    @BindView(R.id.com_zsx_lv)
//    ListView comZsxLv;
//    Unbinder unbinder;
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        isBoolean = true;
//    }
//
//    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent.getStringExtra("shuangxin").equals("ol")) {
//                serverInfoList.clear();
//                getData();
//            }
//
//        }
//    };
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.com_zsx_item_fragment;
//    }
//
//    @Override
//    public void initView(View view) {
//
//    }
//
//    @Override
//    public void initData() {
//
//        IntentFilter intentFilter = new IntentFilter("chuang.xin");
//        getActivity().registerReceiver(broadcastReceiver, intentFilter);
//
//        tipicID = (int) SpUtils.(getActivity(), "topicID2", 0, "topicID2", MODE_PRIVATE);
//        serverInfoList = new ArrayList<>();
//        itemAdapter = new ZSXItemAdapter(getActivity(), serverInfoList);
//        comZsxLv.setAdapter(itemAdapter);
//
//    }
//
//    @Override
//    public void initListener() {
//
//    }
//
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        getActivity().unregisterReceiver(broadcastReceiver);
//    }
//
//    private void getData() {
//
//        ZSXItemEntity newsEntity = new ZSXItemEntity();
//        ZSXItemEntity.ParamBean paramBean = new ZSXItemEntity.ParamBean();
//
//
//        paramBean.setTopicID(tipicID);
//        paramBean.setIsDaka(0);
//        paramBean.setSiteID(CommunityFanil.SITEID);
//        paramBean.setOrder(0);
//        paramBean.setCurPage(1);
//        paramBean.setRuserName("");
//        paramBean.setPageSize(CommunityFanil.SHIPAGESIZE);
//
//        ZSXItemEntity.StatisBean statisBean = new ZSXItemEntity.StatisBean();
//
//        statisBean.setPhoneId(DeviceUtils.getDeviceId(getContext()));
//        statisBean.setSystem_VersionNo(DeviceUtils.getBuildVersion());
//        statisBean.setUserId(UserInfoUtils.getInstance(getContext()).getUserId());
//        statisBean.setPhoneNum("");
//        statisBean.setSystemNo(2);
//        statisBean.setPhoneNo(DeviceUtils.getPhoneModel());
//        statisBean.setSiteId(CommunityFanil.SITEID);
//
//        newsEntity.setAppName(CommunityFanil.APPNAME);
//        newsEntity.setParam(paramBean);
//        newsEntity.setRequestTime(DateUtils.getInstance().getDate(new Date(System.currentTimeMillis())));
//        newsEntity.setCustomerKey("C3EBA4A6C2CECB8A67A3D06C2");
//        newsEntity.setMethod("PHSocket_GetBBSReplyList");
//        newsEntity.setStatis(statisBean);
//        newsEntity.setVersion(CommunityFanil.VERSION);
//        newsEntity.setCustomerID(CommunityFanil.CUSTOMERID);
//
//        Gson gson = new Gson();
//        String toJson = gson.toJson(newsEntity);
//        Map<String, String> map = new HashMap<>();
//        map.put("param", toJson);
//
//        ICommunityMode.getInstance().perpleThings(getActivity(), CommunityFanil.URL, map, new NetworkCallback() {
//            @Override
//            public void success(String result) {
//                if (isBoolean) {
//                    ZSXItemCallBackEntity jsonBean = FastJsonUtils.createJsonBean(result, ZSXItemCallBackEntity.class);
//                    if (jsonBean.getMessageList().getCode() == 1000) {
//                        List<ZSXItemCallBackEntity.ServerInfoBean> serverInfo = jsonBean.getServerInfo();
//                        if (serverInfo != null)
//                            serverInfoList.addAll(serverInfo);
//
//                        itemAdapter.notifyDataSetChanged();
//                    }
//                }
//
//            }
//
//            @Override
//            public void error(String error) {
//                Toast.makeText(getActivity(), "" + error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//
//
//
//
//
//
//}
//
