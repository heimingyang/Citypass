package com.example.citypass.cotroller.fragment.information;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.model.bean.information.GuanZhu;
import com.example.citypass.model.bean.information.UpGuanZhu;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/24 16:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MailFragment extends BaseFragment {
    @BindView(R.id.mail_text_order)
    TextView mailTextOrder;
    Unbinder unbinder;
    @BindView(R.id.mail_text_List)
    MRecyclerView mailTextList;
    Unbinder unbinder1;
    private int type = 1;
    private int curpage=1;
    private MedaModel model;
    private List<UpGuanZhu.ServerInfoBean> mList=new ArrayList<>();

    public void setType(int type) {
        this.type = type;
    }

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
        mailTextList.setLayoutManager(layoutManager);
        mailTextList.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    private void getParam(boolean boo) {
        if(type==1){

        }else if(type==2){
            GuanZhu guanZhu=new GuanZhu();
            guanZhu.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
            guanZhu.setCurPage(curpage);
            guanZhu.setPageSize(10);
            guanZhu.setUserName(LoginUtils.information.getServerInfo().getUserName());
            String param = LoginUtils.getParam(guanZhu, "PHSocket_GetBBSFriendList");
            model.getMedal(param, new MyCallBack() {
                @Override
                public void onSuccess(String result) {
                    UpGuanZhu upGuanZhu = JSON.parseObject(result, UpGuanZhu.class);
                    if(upGuanZhu.getMessageList().getCode()==1000){
                        mList.addAll(upGuanZhu.getServerInfo());
                        if(mList.size()>0){
                            mailTextOrder.setVisibility(View.GONE);
                            mailTextList.setVisibility(View.VISIBLE);
                        }
                    }
                }

                @Override
                public void onError(String errormsg) {

                }
            });
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fensi;
    }

}
