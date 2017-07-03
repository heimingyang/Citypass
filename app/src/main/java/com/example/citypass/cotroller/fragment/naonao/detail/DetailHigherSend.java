package com.example.citypass.cotroller.fragment.naonao.detail;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.detail.DetailSendListAdapter;
import com.example.citypass.model.bean.naonao.detail.DetailSendBean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.UrlUtils;
import com.example.citypass.view.Mylistview;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/28 21:41
 * 修改人:  张超
 * 修改内容:
 * 修改时间: 大咖说
 */

public class DetailHigherSend extends BaseFragment {


    @BindView(R.id.NaoNao_itemMylistview)
    Mylistview Mylistview;
    Unbinder unbinder;
    @BindView(R.id.NaoNao_listview_Text)
    TextView ListviewText;
    Unbinder unbinder1;
    private int mID;
    private List<DetailSendBean.ServerInfoBean> mList;
    private DetailSendListAdapter adapter;

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"isDaka\":1,\"pageSize\":10,\"ruserName\":\"\",\"siteID\":2422,\"order\":0,\"tID\":";
        final int id = mID;
        String values = ",\"curPage\":1},\"requestTime\":\"2017-06-28 21:06:43\",\"customerKey\":\"D07A7A94B49FA9981CD1FE9FA5C16CD9\",\"Method\":\"PHSocket_GetTieBaReplyList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":30108866,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        map.put("param", str + id + values);
        HttpFacory.create().POST(UrlUtils.BaseUrl, map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("DetailHigherSend ", "大咖说" + result);
                DetailSendBean bean = JSON.parseObject(result, DetailSendBean.class);

                if (bean.getMessageList().getCode() != 1000) {
                    return;
                }
                if (bean.getServerInfo() == null) {
                    ListviewText.setVisibility(View.VISIBLE);
                    return;
                } else {
                    ListviewText.setVisibility(View.GONE);
                    mList.addAll(bean.getServerInfo());

                    Log.d("DetailHigherSend", "mList     :" + mList);

                    adapter = new DetailSendListAdapter(mList, getContext());
                    Mylistview.setAdapter(adapter);
                }


            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();
        EventBus.getDefault().register(this);


    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMianThread(SquareDetailBean bean) {
        mID = bean.getId();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.naonao_listview;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
