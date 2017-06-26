package com.example.citypass.cotroller.fragment.shequ;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.shequ.BanQuAdapter;
import com.example.citypass.cotroller.adapter.shequ.BanQuGroupAdapter;
import com.example.citypass.model.bean.shequ.BanQuBean;
import com.example.citypass.model.biz.infor.BbSimp;
import com.example.citypass.model.http.MyCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

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

    @BindView(R.id.banqu_listview1)
    ListView banquListview1;
    @BindView(R.id.banqu_listview2)
    ListView banquListview2;
    Unbinder unbinder;
    private BbSimp bbSimp;
    private List<String> groupList;
    private List<String> childList;
    String[] par ={"{\"customerID\":8001,\"requestTime\":\"2017-06-26 15:19:59\",\"Method\":\"PHSocket_GetUserMayFavoriteBoardList\",\"customerKey\":\"07CCA6AF56C0D1522D0B484214DEB259\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteID\":2422,\"userName\":\"sid110249370682305\",\"pageIndex\":1,\"pageSize\":10},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}","{\"customerID\":8001,\"requestTime\":\"2017-06-26 15:21:21\",\"Method\":\"PHSocket_GetBoardListBySiteId\",\"customerKey\":\"DDEB24613E1738F5AF07A9C10C5C061C\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteId\":2422,\"type\":1,\"pageIndex\":1,\"pageSize\":50},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}","{\"customerID\":8001,\"requestTime\":\"2017-06-26 15:22:07\",\"Method\":\"PHSocket_GetBoardListBySiteId\",\"customerKey\":\"1CA896985440A0546C3CC7A876552573\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteId\":2422,\"type\":3,\"pageIndex\":1,\"pageSize\":50},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}","{\"customerID\":8001,\"requestTime\":\"2017-06-26 15:22:24\",\"Method\":\"PHSocket_GetBoardListBySiteId\",\"customerKey\":\"6A23688C877ACC6993EBDA7FE667B452\",\"appName\":\"CcooCity\",\"version\":\"4.5\",\"Param\":{\"siteId\":2422,\"type\":4,\"pageIndex\":1,\"pageSize\":50},\"Statis\":{\"SiteId\":2422,\"UserId\":30939591,\"PhoneNo\":\"vivo X7\",\"SystemNo\":2,\"System_VersionNo\":\"Android 5.1.1\",\"PhoneId\":\"862460032827563\",\"PhoneNum\":\"+8615735971710\"}}"," "," "};
    private List<BanQuBean.ServerInfoBean> serverInfo;
    private BanQuGroupAdapter groupAdapter;
    private BanQuAdapter childAdapter;

    @Override
    protected void initView(View view) {
        banquListview1 = (ListView) view.findViewById(R.id.banqu_listview1);
        banquListview2 = (ListView) view.findViewById(R.id.banqu_listview2);


    }

    @Override
    protected void initData() {
        groupList = new ArrayList<>();
        groupList.add("我的关注");
        groupList.add("百姓事");
        groupList.add("兴趣圈");
        groupList.add("生活馆");
        groupList.add("问世帮");
        groupList.add("找客服");

        groupAdapter = new BanQuGroupAdapter(groupList,getActivity());
        banquListview1.setAdapter(groupAdapter);
        bbSimp = new BbSimp();
        serverInfo = new ArrayList<>();
        childAdapter = new BanQuAdapter(getActivity(),serverInfo);
        banquListview2.setAdapter(childAdapter);

        groupAdapter.setItem(new BanQuGroupAdapter.onItem() {
            @Override
            public void onItem(int position) {
                if (position == 0) {

                    serverInfo.clear();
                    loadChildData(par[position], position);
                    loadChildData(par[position], position);

                }
                serverInfo.clear();
                loadChildData(par[position], position);
            }
        });
    }

    public void loadData(){
        loadChildData(par[0], 0);
        loadChildData(par[1], 1);
    }

    private void loadChildData(String method, final int position) {
        bbSimp = new BbSimp();
        bbSimp.loadBq( new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                int po = serverInfo.size();
                BanQuBean banQuBean = JSON.parseObject(result,BanQuBean.class);
                try {
                    if ( position == 1) {
                        BanQuBean.ServerInfoBean serverInfoBean = serverInfo.get(po);
                        serverInfo.remove(po + 1);
                        serverInfoBean.setShowTwo(true);
                        serverInfoBean.setParentName("推荐板块");
                    serverInfo.add(po + 1, serverInfoBean);
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
                    banquListview2.setAdapter(childAdapter);
                }catch (Exception e){

                }
            }

            @Override
            public void onError(String errormsg) {

            }
        },method);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.shequ_banqu;
    }


}
