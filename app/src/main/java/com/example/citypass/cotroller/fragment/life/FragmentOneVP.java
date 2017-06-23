package com.example.citypass.cotroller.fragment.life;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.model.bean.life.LifeFragmentBean;
import com.example.citypass.model.http.LifeModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.UrlUtils;
import com.example.citypass.utils.WebViewUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/22 10:02
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class FragmentOneVP extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.lay)
    LinearLayout lay;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.lay1)
    LinearLayout lay1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.lay2)
    LinearLayout lay2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.lay3)
    LinearLayout lay3;
    Unbinder unbinder;
    private LifeModel model;
    private List<LifeFragmentBean.ServerInfoBean.GetPostListBeanX.GetPostListBean> getPostList;

    @Override
    protected void initData() {


        OneJiexi();


    }

    private void OneJiexi() {
        model.Post(new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                LifeFragmentBean bean = JSON.parseObject(result, LifeFragmentBean.class);
                Log.d("FragmentOneVP", result);

                getPostList = bean.getServerInfo().getGetPostList().getGetPostList();
                Log.d("FragmentOneVP", "getPostList.size():" + getPostList.size());
                String Mimg = getPostList.get(0).getChannelImg();
                Glide.with(getContext()).load(Mimg).into(image);
                String name = getPostList.get(0).getChannelName();
                text.setText(name);

                String Mimg1 = getPostList.get(1).getChannelImg();
                Glide.with(getContext()).load(Mimg1).into(image1);

                String name1 = getPostList.get(1).getChannelName();
                text1.setText(name1);

                String Mimg2 = getPostList.get(2).getChannelImg();
                Glide.with(getContext()).load(Mimg2).into(image2);

                String name2 = getPostList.get(2).getChannelName();
                text2.setText(name2);


                String Mimg3 = getPostList.get(3).getChannelImg();
                Glide.with(getContext()).load(Mimg3).into(image3);
                String name3 = getPostList.get(3).getChannelName();
                text3.setText(name3);

            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    @Override
    protected void initListener() {
        image.setOnClickListener(this);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
    }

    @Override
    protected void initView(View view) {
        model = new LifeModel();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.new_life_gv_item;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image:
                WebViewUtils.UtilIntent(getContext(), UrlUtils.OnePager_Jop + getPostList.get(0).getChannelUrl(),"招聘信息");
                break;

            case R.id.image1:
                WebViewUtils.UtilIntent(getContext(), UrlUtils.OnePager_Jop + getPostList.get(1).getChannelUrl(),"房屋出售");

                break;
            case R.id.image2:
                WebViewUtils.UtilIntent(getContext(), UrlUtils.OnePager_Jop + getPostList.get(2).getChannelUrl(),"新楼盘");

                break;
            case R.id.image3:
                WebViewUtils.UtilIntent(getContext(), UrlUtils.OnePager_Jop + getPostList.get(3).getChannelUrl(),"二手信息");

                break;


        }
    }
}
