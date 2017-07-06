package com.example.citypass.cotroller.fragment.faxian_belle;


import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.cotroller.adapter.discover.Belle_Details1_Adapter;
import com.example.citypass.model.bean.beele.Belle_xq1_Bean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/5 0005 9:10
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

public class Details_Fragment extends BaseFragment {
    @BindView(R.id.belle_xq_recycle)
    PullToRefreshRecyclerView belleXqRecycle;
    Unbinder unbinder;
    //头布局1
    private View head1;
    //头布局2
    private View head2;

    //头布局1中的组件
    private ImageView details1_img, details1_zan, details1_gift, details1_In, details1_Info, details1_danmu;
    private TextView details1_tv_ZanCount, details1_tv_location, details1_tv_time, details1_tv_name, details1_tv_job, details1_tv_age,
            details1_tv_yinxiang, details1_tv_hello, details1_tv_zhuye;
    private ImageView details1_tx;


    //头布局2中的组件
    private ImageView details1_img_giveGift;

    //recycleview适配器
    private Belle_Details1_Adapter belle_details1_adapter;


    private Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean coverPhotoDetailsInfoBean;

    public Details_Fragment(Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean coverPhotoDetailsInfoBean) {
        this.coverPhotoDetailsInfoBean = coverPhotoDetailsInfoBean;
    }


    @Override
    protected void initData() {
        Log.e("Details_Fragment", "coverPhotoDetailsInfoBean:" + coverPhotoDetailsInfoBean);
        //加载大图
        Picasso.with(getContext()).load(coverPhotoDetailsInfoBean.getPhoto()).into(details1_img);
        Log.e("Details_Fragment", coverPhotoDetailsInfoBean.getPhoto());
        //加载头像
        Glide.with(getContext()).load(coverPhotoDetailsInfoBean.getUserface()).asBitmap().centerCrop().into(new BitmapImageViewTarget(details1_tx) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                ciDrawable.setCircular(true);
                details1_tx.setImageDrawable(ciDrawable);
            }
        });


        //加载各项数据
        details1_tv_ZanCount.setText(coverPhotoDetailsInfoBean.getLikeTotal() + "");
        details1_tv_location.setText(coverPhotoDetailsInfoBean.getMapName() + "");
        details1_tv_time.setText(coverPhotoDetailsInfoBean.getCreateTime() + "");
        details1_tv_name.setText(coverPhotoDetailsInfoBean.getNick() + "");
        details1_tv_job.setText(coverPhotoDetailsInfoBean.getPositionName() + "");
        details1_tv_age.setText(coverPhotoDetailsInfoBean.getAge() + "");
        details1_tv_yinxiang.setText(coverPhotoDetailsInfoBean.getImName() + "");

        belle_details1_adapter = new Belle_Details1_Adapter(getContext(), coverPhotoDetailsInfoBean.getCoverReplyList());

        belleXqRecycle.setAdapter(belle_details1_adapter);


    }

    @Override
    protected void initListener() {
        details1_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details1_zan.setImageResource(R.drawable.cover_info_love2);
            }
        });

    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.activity);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        belleXqRecycle.setLayoutManager(linearLayoutManager);

        head1 = LayoutInflater.from(getContext()).inflate(R.layout.belle_details1_head1, null);
        findHead1Viewbyid();

        belleXqRecycle.addHeaderView(head1);
//        belleXqRecycle.addHeaderView(head2);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_belle_details;
    }

    //找头布局1中的组件
    private void findHead1Viewbyid() {
        details1_img = (ImageView) head1.findViewById(R.id.belle_details_img);

        details1_zan = (ImageView) head1.findViewById(R.id.xq1_zan);

        details1_gift = (ImageView) head1.findViewById(R.id.xq1_gift);

        details1_In = (ImageView) head1.findViewById(R.id.xq1_yin);

        details1_Info = (ImageView) head1.findViewById(R.id.xq1_info);

        details1_danmu = (ImageView) head1.findViewById(R.id.xq1_dan);

        details1_tx = (ImageView) head1.findViewById(R.id.xq1_img_tx);
//--------------------------------------------------------------------------------------------------
        details1_tv_ZanCount = (TextView) head1.findViewById(R.id.xq1_zan_count);


        details1_tv_location = (TextView) head1.findViewById(R.id.xq1_location);

        details1_tv_time = (TextView) head1.findViewById(R.id.xq1_time);


        details1_tv_name = (TextView) head1.findViewById(R.id.xq1_name);

        details1_tv_job = (TextView) head1.findViewById(R.id.xq1_job);

        details1_tv_age = (TextView) head1.findViewById(R.id.xq1_age);

        details1_tv_yinxiang = (TextView) head1.findViewById(R.id.xq1_yinxiang);

        details1_tv_hello = (TextView) head1.findViewById(R.id.xq1_hello);

        details1_tv_zhuye = (TextView) head1.findViewById(R.id.xq1_home);
        details1_img_giveGift = (ImageView) head1.findViewById(R.id.xq1_give_gift);


    }

}
