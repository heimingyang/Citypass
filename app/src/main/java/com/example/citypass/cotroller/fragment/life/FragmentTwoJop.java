package com.example.citypass.cotroller.fragment.life;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.model.bean.life.LifeFragmentBean;
import com.example.citypass.model.http.LifeModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.UrlUtils;
import com.example.citypass.utils.WebViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/22 14:08
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class FragmentTwoJop extends BaseFragment {
    @BindView(R.id.Frag_Gridview)
    GridView FragGridview;
    private LifeModel model;
    private List<LifeFragmentBean.ServerInfoBean.GetTelListBeanX.GetTelListBean> mList = new ArrayList<>();
    private MyJopGVAdapter adapter;
    private int i = 0;

    @Override
    protected void initData() {
        if (i == 0) {
            model.Post(new MyCallBack() {
                @Override
                public void onSuccess(String result) {
                    LifeFragmentBean bean = JSON.parseObject(result, LifeFragmentBean.class);

                    List<LifeFragmentBean.ServerInfoBean.GetTelListBeanX.GetTelListBean> getTelList = bean.getServerInfo().getGetTelList().getGetTelList().subList(12, 21);

                    mList.addAll(getTelList);
                    adapter = new MyJopGVAdapter();
                    FragGridview.setAdapter(adapter);
                    i = 1;
                    Log.d("FragmentOneJop", "mList.size():" + mList.size());
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
        model = new LifeModel();

        FragGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LifeFragmentBean.ServerInfoBean.GetTelListBeanX.GetTelListBean getTelListBean = mList.get(position);

                WebViewUtils.UtilIntent(getContext(), UrlUtils.OnePager_Jop + getTelListBean.getChannelUrl());

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gridview;
    }


    public class MyJopGVAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyHodler h = null;
            if (convertView == null) {
                h = new MyHodler();

                convertView = LayoutInflater.from(getContext()).inflate(R.layout.new_life_gv_item2, null);

                h.mText = (TextView) convertView.findViewById(R.id.Gv_textName);

                convertView.setTag(h);
            } else
                h = (MyHodler) convertView.getTag();

            LifeFragmentBean.ServerInfoBean.GetTelListBeanX.GetTelListBean telListBean = mList.get(position);

            h.mText.setText(telListBean.getCname() + "");

            return convertView;
        }

        class MyHodler {
            private TextView mText;
        }
    }


}
