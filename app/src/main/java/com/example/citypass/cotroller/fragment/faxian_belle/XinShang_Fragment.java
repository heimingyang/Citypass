package com.example.citypass.cotroller.fragment.faxian_belle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.cotroller.adapter.discover.Belle_XinShang_Adapter;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.beele.Belle_Enjoy_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.view.MRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/23 0023 9:57
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

public class XinShang_Fragment extends BaseFragment {
    @BindView(R.id.xinsahng_Recycle)
    MRecyclerView xinsahngRecycle;
    Unbinder unbinder;

    private ImageView xinshangImg1, xinshangImg2, xinshangImg3;
    private TextView xinshangTv1, xinshangTv2, xinshangTv3, xinshangZan1, xinshangZan2, xinshangZan3;
    //recycleview  适配器
    private Belle_XinShang_Adapter belle_xinShang_adapter;
    private Handler handler = new Handler();
    private List<Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> coverXinShangInfoList;


    @Override
    protected void initData() {


        Map<String, String> map = new HashMap<>();
        map.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":50,\"curPage\":1,\"siteID\":2422},\"requestTime\":\"2017-06-23 19:11:15\",\"customerKey\":\"8CB1DF6909EAAB3AA33200313F8B1003\",\"Method\":\"PHSocket_GetCoverXinShangInfo\",\"Statis\":{\"PhoneId\":\"133524541070404\",\"System_VersionNo\":\"Android 4.2.2\",\"UserId\":0,\"PhoneNum\":\" 8617646525761\",\"SystemNo\":2,\"PhoneNo\":\"GT-P5210\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}");
        try {
            HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
                @Override
                public void onSuccess(String result) {

                    Belle_Enjoy_Bean belle_enjoy_bean = JSON.parseObject(result, Belle_Enjoy_Bean.class);
                    Belle_Enjoy_Bean.ServerInfoBean serverInfo = belle_enjoy_bean.getServerInfo();
                    //前三的信息
                    final List<Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListTop3BeanX.CoverXinShangInfoListTop3Bean> coverXinShangInfoListTop3 = serverInfo.getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3();
                    //第一个
                    final Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListTop3BeanX.CoverXinShangInfoListTop3Bean coverXinShangInfoListTop3Bean =
                            coverXinShangInfoListTop3.get(0);

                    //姓名
                    String nick = coverXinShangInfoListTop3Bean.getNick();
                    //点赞次数
                    String likeTotal = coverXinShangInfoListTop3Bean.getLikeTotal();
                    //头像url
                    String userface = coverXinShangInfoListTop3Bean.getUserface();

                    xinshangTv1.setText(nick);
                    xinshangZan1.setText(likeTotal);

//                    Glide.with(getContext()).load(userface).into(xinshangImg1);
                    Glide.with(getContext()).load(userface).asBitmap().centerCrop().into(new BitmapImageViewTarget(xinshangImg1) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                            ciDrawable.setCircular(true);
                            xinshangImg1.setImageDrawable(ciDrawable);
                        }
                    });
                    xinshangImg1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), PersonalActivity.class);
                            coverXinShangInfoListTop3Bean.getUserID();
                            intent.putExtra("id", Integer.parseInt(coverXinShangInfoListTop3Bean.getUserID()));
                            getContext().startActivity(intent);

                        }
                    });


                    //第二个
                    final Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListTop3BeanX.CoverXinShangInfoListTop3Bean coverXinShangInfoListTop3Bean1 =
                            coverXinShangInfoListTop3.get(1);

                    //姓名
                    String nick2 = coverXinShangInfoListTop3Bean1.getNick();
                    //点赞次数
                    String likeTotal2 = coverXinShangInfoListTop3Bean1.getLikeTotal();
                    //头像url
                    String userface2 = coverXinShangInfoListTop3Bean1.getUserface();

                    xinshangTv2.setText(nick2);
                    xinshangZan2.setText(likeTotal2);

//                    Glide.with(getContext()).load(userface2).into(xinshangImg2);
                    Glide.with(getContext()).load(userface2).asBitmap().centerCrop().into(new BitmapImageViewTarget(xinshangImg2) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                            ciDrawable.setCircular(true);
                            xinshangImg2.setImageDrawable(ciDrawable);
                        }
                    });
                    xinshangImg2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), PersonalActivity.class);
                            intent.putExtra("id", Integer.parseInt(coverXinShangInfoListTop3Bean1.getUserID()));
                            getContext().startActivity(intent);

                        }
                    });


                    //第三个
                    final Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListTop3BeanX.CoverXinShangInfoListTop3Bean coverXinShangInfoListTop3Bean2 =
                            coverXinShangInfoListTop3.get(2);

                    //姓名
                    String nick3 = coverXinShangInfoListTop3Bean2.getNick();
                    //点赞次数
                    String likeTotal3 = coverXinShangInfoListTop3Bean2.getLikeTotal();
                    //头像url
                    String userface3 = coverXinShangInfoListTop3Bean2.getUserface();

                    xinshangTv3.setText(nick3);
                    xinshangZan3.setText(likeTotal3);

//                    Glide.with(getContext()).load(userface3).into(xinshangImg3);
                    Glide.with(getContext()).load(userface3).asBitmap().centerCrop().into(new BitmapImageViewTarget(xinshangImg3) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                            ciDrawable.setCircular(true);
                            xinshangImg3.setImageDrawable(ciDrawable);
                        }
                    });

                    xinshangImg3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), PersonalActivity.class);
                            intent.putExtra("id", Integer.parseInt(coverXinShangInfoListTop3Bean2.getUserID()));
                            getContext().startActivity(intent);

                        }
                    });


                    //除前三外剩下人的信息

                    coverXinShangInfoList = serverInfo.getCoverXinShangInfoList().getCoverXinShangInfoList();
                    String age = coverXinShangInfoList.get(1).getAge();
                    LogUtils.e("age----->", age);


                    belle_xinShang_adapter = new Belle_XinShang_Adapter(coverXinShangInfoList, getActivity());
                    xinsahngRecycle.setAdapter(belle_xinShang_adapter);


                }

                @Override
                public void onError(String errormsg) {


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initListener() {
        xinsahngRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
            @Override
            public void onRvScrolled(int dx, int dy) {

            }

            @Override
            public void onRefresh() {

                xinsahngRecycle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xinsahngRecycle.refreshComplete();

                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {
                xinsahngRecycle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xinsahngRecycle.loadMoreComplete();

                    }
                }, 2000);

            }
        });


    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager man = new LinearLayoutManager(getActivity());
        View mview = LayoutInflater.from(getActivity()).inflate(R.layout.meinv_tou, null);

        xinshangImg1 = (ImageView) mview.findViewById(R.id.xinshang_img1);
        xinshangImg2 = (ImageView) mview.findViewById(R.id.xinshang_img2);
        xinshangImg3 = (ImageView) mview.findViewById(R.id.xinshang_img3);

        xinshangTv1 = (TextView) mview.findViewById(R.id.xinshang_tv1);
        xinshangTv2 = (TextView) mview.findViewById(R.id.xinshang_tv2);
        xinshangTv3 = (TextView) mview.findViewById(R.id.xinshang_tv3);

        xinshangZan1 = (TextView) mview.findViewById(R.id.xinshang_zan1);
        xinshangZan2 = (TextView) mview.findViewById(R.id.xinshang_zan2);
        xinshangZan3 = (TextView) mview.findViewById(R.id.xinshang_zan3);

        xinsahngRecycle.setLayoutManager(man);
        xinsahngRecycle.addHeaderView(mview);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xinshang_fragment;
    }

}
