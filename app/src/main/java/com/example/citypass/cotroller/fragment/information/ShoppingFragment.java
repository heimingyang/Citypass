package com.example.citypass.cotroller.fragment.information;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.life.ShopAdapter;
import com.example.citypass.model.bean.information.Shop;
import com.example.citypass.model.bean.information.ShopParam;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;
import com.example.citypass.view.GifRfreshHeader;
import com.example.citypass.view.MRecyclerView;
import com.example.citypass.view.Mylistview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/29 14:03
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShoppingFragment extends BaseFragment {
    @BindView(R.id.shopping_list)
    MRecyclerView shoppingList;
    Unbinder unbinder;
    private int pageIndex=1;
    private int orderby=0;
    private MedaModel model;

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

    private List<Shop.ServerInfoBean.CommodityListBean.ContentBean> mList=new ArrayList<>();

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        model=new IMedalModel();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        shoppingList.setLayoutManager(layoutManager);
        getShop(true);
        ShopAdapter adapter=new ShopAdapter(getActivity(),mList);
        shoppingList.setAdapter(adapter);
        shoppingList.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {
                mList.clear();
                pageIndex=1;
                getShop(false);
            }

            @Override
            public void onLoadMore() {
                pageIndex++;
                getShop(true);
            }
        });
    }

    private void getShop(final boolean boo){
        model.getMedal(getParam(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Shop shop = JSON.parseObject(result, Shop.class);
                int code = shop.getMessageList().getCode();
                if(code==1000){
                    List<Shop.ServerInfoBean.CommodityListBean.ContentBean> content = shop.getServerInfo().getCommodityList().getContent();
                    mList.addAll(content);
                    if(boo){
                        shoppingList.loadMoreComplete();
                    }else{
                        shoppingList.refreshComplete();
                    }
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private String getParam(){
        ShopParam param=new ShopParam();
        param.setCustomerID(8001);
        param.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss"));
        param.setMethod("PHSocket_APP_TCommodityList");
        param.setCustomerKey("B757752C64514CB5B3F8B17330024493");
        param.setAppName("CcooCity");
        param.setVersion("4.5");
        ShopParam.ParamBean paramBean=new ShopParam.ParamBean();
        paramBean.setPageSize(10);
        paramBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        paramBean.setCType(1);
        paramBean.setOrderType(1);
        paramBean.setPageIndex(pageIndex);
        paramBean.setOrderBy(orderby);
        param.setParam(paramBean);
        ShopParam.StatisBean statisBean=new ShopParam.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86"+LoginUtils.information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        String  model= android.os.Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion=android.os.Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion+"");
        param.setStatis(statisBean);
        String s = JSON.toJSONString(param);
        return s;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopping;
    }
}
