package com.example.citypass.cotroller.fragment.naonao.detail;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.detail.DetailHuiFuAdapter;
import com.example.citypass.cotroller.adapter.naonao.detail.DetailNewAdapter;
import com.example.citypass.model.bean.naonao.detail.DetailHuiFuBean;
import com.example.citypass.model.bean.naonao.detail.DetailNewBean;
import com.example.citypass.model.bean.naonao.detail.HuiFuEnentBean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.UrlUtils;
import com.example.citypass.view.MyRecycler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

import static android.R.attr.id;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/28 21:39
 * 修改人:  张超
 * 修改内容:
 * 修改时间: 大咖说
 */

public class DetailNewFragment extends BaseFragment {

    @BindView(R.id.Naonao_Recycler)
    MyRecycler NaonaoRecycler;
    Unbinder unbinder1;
    @BindView(R.id.NaoNao_Recycler_Text)
    TextView NaoNaoRecyclerText;
    Unbinder unbinder;
    private List<DetailNewBean.ServerInfoBean> mList;
    private DetailNewAdapter adapter;
    private int mid;
    private int i = 0;
    private List<DetailNewBean.ServerInfoBean.ClildReplyListBean> childList;
    private DetailNewBean.ServerInfoBean.ClildReplyListBean ReplyListBean;
    private DetailHuiFuAdapter huiFuAdapter;

    @Override
    protected void initData() {
        Shuju();
    }

    private void Shuju() {
        final Map<String, String> params = new HashMap<>();
        String str = "{\"appName\":\"CcooCity\",\"Param\":{\"isDaka\":0,\"pageSize\":50,\"ruserName\":\"\",\"siteID\":2422,\"order\":0,\"tID\":";
        int id = mid;
        String values = ",\"curPage\":1},\"requestTime\":\"2017-07-04 19:25:43\",\"customerKey\":\"D07A7A94B49FA9981CD1FE9FA5C16CD9\",\"Method\":\"PHSocket_GetTieBaReplyList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 4.4.4\",\"UserId\":30108866,\"PhoneNum\":\"+8617641727221\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        params.put("param", str + id + values);
        if (i == 0) {
            HttpFacory.create().POST(UrlUtils.BaseUrl, params, "", new MyCallBack() {
                @Override
                public void onSuccess(String result) {
                    Log.d("DetailNewFragment", result);
                    DetailNewBean parse = JSON.parseObject(result, DetailNewBean.class);
                    if (parse.getMessageList().getCode() != 1000) {
                        return;
                    }

                    List<DetailNewBean.ServerInfoBean> serverInfo = parse.getServerInfo();


                    if (serverInfo == null) {
                        NaoNaoRecyclerText.setVisibility(View.VISIBLE);
                        return;
                    } else {
                    NaoNaoRecyclerText.setVisibility(View.GONE);
                        mList.addAll(serverInfo);
                        if (adapter == null) {
                            adapter = new DetailNewAdapter(mList, getContext());
                            NaonaoRecycler.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        } else {
                            adapter.setNewData(mList);
                        }
                    }

                    i = 1;
                }

                @Override
                public void onError(String errormsg) {

                }
            });

        }

    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initView(View view) {
        childList = new ArrayList<>();
        mList = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        NaonaoRecycler.setLayoutManager(manager);
        NaonaoRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.naonao_recyvler;
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMianThread(SquareDetailBean bean) {

        mid = bean.getId();
        Log.d("DetailNewFragment", "id:" + id);

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMianThreadList(HuiFuEnentBean bean) {
        List<DetailHuiFuBean.ServerInfoBean.ReplyListBean> replyList = bean.getReplyList();

        String mapName = replyList.get(0).getMapName();

        String createTime = replyList.get(0).getCreateTime();

        String body = replyList.get(0).getBody();

        String userface = replyList.get(0).getUserface();

        String Name = replyList.get(0).getNick();

        String lou = replyList.get(0).getLou();

        int level = replyList.get(0).getLevel();

        ReplyListBean = new DetailNewBean.ServerInfoBean.ClildReplyListBean();
//时间
        ReplyListBean.setCreateTime(createTime);
        //地址
        ReplyListBean.setAtUser(mapName);
        //内容
        ReplyListBean.setBody(body);
        //姓名
        ReplyListBean.setNick(Name);
        //楼层
        ReplyListBean.setAtUser(lou + "");
        //    等级
        ReplyListBean.setDing(String.valueOf(level) + "");

        ReplyListBean.setUserface(userface);

        mList.get(0).getClildReplyList().add(ReplyListBean);

        huiFuAdapter = new DetailHuiFuAdapter(mList.get(0).getClildReplyList(), getContext());
        NaonaoRecycler.setAdapter(huiFuAdapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
