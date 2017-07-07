package com.example.citypass.cotroller.fragment.shequ;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.activity.shequ.TieZiDetialActivity;
import com.example.citypass.cotroller.adapter.shequ.BanQuAdapter;
import com.example.citypass.cotroller.adapter.shequ.BanQuGroupAdapter;
import com.example.citypass.model.bean.shequ.BanQuBean;
import com.example.citypass.model.biz.infor.BbSimp;
import com.example.citypass.model.http.MyCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 16:18
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

//  百姓事:{"customerID":8001,"requestTime":"2017-06-26 09:48:27","Method":"PHSocket_GetBoardListBySiteId","customerKey":"B50F83EBBE34E9E471D4E7F16EC48BFB","appName":"CcooCity","version":"4.5","Param":{"siteId":2422,"type":1,"pageIndex":1,"pageSize":50},"Statis":{"SiteId":2422,"UserId":30939591,"PhoneNo":"vivo X7","SystemNo":2,"System_VersionNo":"Android 5.1.1","PhoneId":"862460032827563","PhoneNum":"+8615735971710"}}
//{"customerID":8001,"requestTime":"2017-06-26 09:48:49","Method":"PHSocket_GetBoardListBySiteId","customerKey":"59DAABA47410299E141C567AF6C5297E","appName":"CcooCity","version":"4.5","Param":{"siteId":2422,"type":3,"pageIndex":1,"pageSize":50},"Statis":{"SiteId":2422,"UserId":30939591,"PhoneNo":"vivo X7","SystemNo":2,"System_VersionNo":"Android 5.1.1","PhoneId":"862460032827563","PhoneNum":"+8615735971710"}}
//{"customerID":8001,"requestTime":"2017-06-26 09:50:06","Method":"PHSocket_GetBoardListBySiteId","customerKey":"418965E04A011CE96AD66B237178AA46","appName":"CcooCity","version":"4.5","Param":{"siteId":2422,"type":4,"pageIndex":1,"pageSize":50},"Statis":{"SiteId":2422,"UserId":30939591,"PhoneNo":"vivo X7","SystemNo":2,"System_VersionNo":"Android 5.1.1","PhoneId":"862460032827563","PhoneNum":"+8615735971710"}}

public class BanQuFragment extends BaseFragment {

    private BbSimp bbSimp;
    private ListView grounpList, childList;
    private List<String> groupDatas;
    private List<String> childDatas;
    String[] par = {"{\"appName\":\"CcooCity\",\"Param\":{\"siteId\":2422,\"userName\":\"sid114143697608620\"},\"requestTime\":\"2017-06-24 09:27:07\",\"customerKey\":\"DDD47635F69CFDEB2270652753613A1C\",\"Method\":\"PHSocket_GetBoardInfoListByUser\",\"Statis\":{\"PhoneId\":\"867271010162211\",\"System_VersionNo\":\"Android 4.4.2\",\"UserId\":31139731,\"PhoneNum\":\"\",\"SystemNo\":2,\"PhoneNo\":\"ONE A2001\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":10,\"userName\":\"sid114143697608620\",\"siteID\":2422,\"pageIndex\":1},\"requestTime\":\"2017-06-24 09:27:08\",\"customerKey\":\"A761B0E8B765E6A2BF66E5A95F018F05\",\"Method\":\"PHSocket_GetUserMayFavoriteBoardList\",\"Statis\":{\"PhoneId\":\"867271010162211\",\"System_VersionNo\":\"Android 4.4.2\",\"UserId\":31139731,\"PhoneNum\":\"\",\"SystemNo\":2,\"PhoneNo\":\"ONE A2001\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":50,\"type\":1,\"siteId\":2422,\"pageIndex\":1},\"requestTime\":\"2017-06-24 09:28:38\",\"customerKey\":\"0B1ABB66BEB1F86DBB950025692CA164\",\"Method\":\"PHSocket_GetBoardListBySiteId\",\"Statis\":{\"PhoneId\":\"867271010162211\",\"System_VersionNo\":\"Android 4.4.2\",\"UserId\":31139731,\"PhoneNum\":\"\",\"SystemNo\":2,\"PhoneNo\":\"ONE A2001\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}\n", "", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":50,\"type\":3,\"siteId\":2422,\"pageIndex\":1},\"requestTime\":\"2017-06-24 10:40:01\",\"customerKey\":\"14D1126E1270B1CE98FD9B30106F7003\",\"Method\":\"PHSocket_GetBoardListBySiteId\",\"Statis\":{\"PhoneId\":\"867271010162211\",\"System_VersionNo\":\"Android 4.4.2\",\"UserId\":31139731,\"PhoneNum\":\"\",\"SystemNo\":2,\"PhoneNo\":\"ONE A2001\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}", "", ""};
    private List<BanQuBean.ServerInfoBean> serverInfo;
    private List<BanQuBean.ServerInfoBean> userBean = new ArrayList<>();
    private BanQuGroupAdapter groupAdapter;
    private BanQuAdapter childAdapter;



    @Override
    protected void initView(View view) {
        grounpList = (ListView) view.findViewById(R.id.banqu_listview1);
        childList = (ListView) view.findViewById(R.id.banqu_listview2);


    }

    @Override
    protected void initData() {
        groupDatas = new ArrayList<>();
        groupDatas.add("我的关注");
        groupDatas.add("百姓事");
        groupDatas.add("兴趣圈");
        groupDatas.add("生活馆");
        groupDatas.add("问世帮");
        groupDatas.add("找客服");

        groupAdapter = new BanQuGroupAdapter(groupDatas,getActivity());
        grounpList.setAdapter(groupAdapter);
        bbSimp = new BbSimp();
        loadChildData(par[0], 0);
        loadChildData(par[1], 1);
        serverInfo = new ArrayList<>();
        childAdapter = new BanQuAdapter(getActivity(),serverInfo);
        childAdapter.setOnItemClickListener(new BanQuAdapter.OnItemClickListener() {
            @Override
            public void on(int position) {

            }
        });
        childList.setAdapter(childAdapter);


    }


    private void loadChildData(String method, final int position) {
        bbSimp = new BbSimp();
        bbSimp.loadBq(new MyCallBack() {
            @Override
            public void onSuccess(String result) {

                Log.d("BqFragment", result);
                final int po = serverInfo.size();
                BanQuBean bqListDataBean = JSON.parseObject(result, BanQuBean.class);
                try {
                    serverInfo.addAll(bqListDataBean.getServerInfo());
                    childAdapter = new BanQuAdapter(getActivity(), serverInfo);
                    if (position == 0) {
                        userBean.clear();
                        userBean.addAll(serverInfo);
                    }
                    if (position == 1) {
                        BanQuBean.ServerInfoBean serverInfoBean = serverInfo.get(po);
                        serverInfo.remove(po + 1);
                        serverInfoBean.setShowTwo(true);
                        serverInfoBean.setParentName("推荐板块");

//                    serverInfo.add(po + 1, serverInfoBean);
                    } else if (position == 4) {
                        String parentName = "";
                        for (BanQuBean.ServerInfoBean serverInfoBean : serverInfo) {

                            if (!parentName.equals(serverInfoBean.getParentName())) {
                                serverInfoBean.setShowTwo(true);
                            }
                            parentName = serverInfoBean.getParentName();
                        }

                    }
                    Log.d("BqFragment", "position:" + position);
                    childAdapter.setOnItemClickListener(new BanQuAdapter.OnItemClickListener() {
                        @Override
                        public void on(int position) {
                            Intent intent = new Intent(getContext(), TieZiDetialActivity.class);
                            intent.putExtra("id", serverInfo.get(position).getBoardId());
                            startActivity(intent);
                        }
                    });
                    for (int i = 0; i < serverInfo.size(); i++) {
                        String boardName = serverInfo.get(i).getBoardName();
                        for (int i1 = 0; i1 < userBean.size(); i1++) {
                            if (userBean.get(i1).getBoardName().equals(boardName))
                                serverInfo.get(i).setChax(true);
                        }
                    }
                    childList.setAdapter(childAdapter);
                } catch (NullPointerException e) {

                }

            }

            @Override
            public void onError(String errormsg) {

            }
        }, method);

        groupAdapter.setItem(new BanQuGroupAdapter.onItem() {
            @Override
            public void onItem(int position) {
                if (position == 0) {

                    serverInfo.clear();
                    loadChildData(par[position], position);

                    loadChildData(par[position + 1], position + 1);

                }
                serverInfo.clear();
                loadChildData(par[position +1], position +1);
            }
        });

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.shequ_banqu;
    }


}
