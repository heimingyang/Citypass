package com.example.citypass.cotroller.fragment.naonao;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.naonao.Square_NaoNao_Recycle_Adapter;
import com.example.citypass.cotroller.adapter.naonao.Square_NaoNao_TypeAdapter;
import com.example.citypass.model.bean.naonao.Square_NaoNao_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.view.MRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/20 0020 17:02
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


public class Square_NaoNao_Fragment extends BaseFragment implements Square_NaoNao_TypeAdapter.mOnItemClickListener {

    @BindView(R.id.square_naonao_recycle)
    MRecyclerView squareNaonaoRecycle;
    Unbinder unbinder;
    //    @BindView(R.id.NaoNao_Recycler_Type)
//    RecyclerView RecyclerType;
    private int j = 1;
    private int a = 0;
    private Square_NaoNao_Recycle_Adapter adapter;
    private List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList = new ArrayList<>();
    private Square_NaoNao_TypeAdapter Typeadapter;

    @Override
    protected void initData() {
        if (a == 0) {
            LinearLayoutManager man = new LinearLayoutManager(getContext());
            squareNaonaoRecycle.setLayoutManager(man);
            initParsing();
            TextView tv = new TextView(getContext());
            tv.setText("最新动态");
            tv.setTextColor(Color.parseColor("#cdcdcd"));
            tv.setPadding(5, 5, 5, 5);
            squareNaonaoRecycle.addHeaderView(tv);
            squareNaonaoRecycle.setLoadingListener(new MRecyclerView.LoadingListener() {
                @Override
                public void onRvScrolled(int dx, int dy) {

                }


                @Override
                public void onRefresh() {
                    squareNaonaoRecycle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initParsing();
                            squareNaonaoRecycle.refreshComplete();
                        }
                    },2000);
                }

                @Override
                public void onLoadMore() {
                    squareNaonaoRecycle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            j++;
                            initParsing();
                            squareNaonaoRecycle.loadMoreComplete();
                        }
                    },2000);
                }
            });
            a = 1;
        }
    }

    private void initParsing() {
        final Map<String, String> map = new HashMap<>();
        String a = "{\"appName\":\"CcooCity\",\"Param\":{\"userID\":0,\"siteID\":2422,\"order\":0,\"gambitid\":0,\"curPage\":";
        String str = j + "";
        String b = ",\"pageSize\":20,\"oldTime\":\"\",\"type\":1},\"requestTime\":\"2017-07-07 15:53:33\",\"customerKey\":\"935A33F592C9C6509BAF3C887F29C205\",\"Method\":\"PHSocket_GetNewTieBaList\",\"Statis\":{\"PhoneId\":\"861677342183129\",\"System_VersionNo\":\"Android 5.1\",\"UserId\":0,\"PhoneNum\":\"+8618833628372\",\"SystemNo\":2,\"PhoneNo\":\"OPPO R9m\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.5\"}";
        String i = a + str + b;
        map.put("param", i);
        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Square_NaoNao_Fragment", result);
                Square_NaoNao_Bean square_naoNao_bean = JSON.parseObject(result, Square_NaoNao_Bean.class);
                if (mList.size() < 0) {
                    return;
                }
                if (square_naoNao_bean.getMessageList().getCode() != 1000) {
                    return;
                }
                squareNaonaoRecycle.setVisibility(View.VISIBLE);
                mList.clear();
                mList.addAll(square_naoNao_bean.getServerInfo().getGetPostWorkList().getGetPostWorkList());
                if (Typeadapter == null) {
                    Typeadapter = new Square_NaoNao_TypeAdapter(mList, getActivity());
                    squareNaonaoRecycle.setAdapter(Typeadapter);

                }else {
                    Typeadapter.setNewData(mList);
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
        LinearLayout mLinear = (LinearLayout) view.findViewById(R.id.NaoNao_FragmentInclude);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.square_naonao_fragment;
    }


    //自定义点击事件
    @Override
    public void ItemClick(int position) {
        Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean bean = mList.get(position);

        Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
    }


//    @Override
//    public void ItemClick(int positon) {
//        Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean bean = mList.get(positon - 2);
//        Intent intent = new Intent(getContext(), SquareNaonaoDetailActivity.class);
//        String title = bean.getTitle();
//        String name = bean.getNick();
//        String time = bean.getLastTime();
//        String image = bean.getUserFace();
//        String address = bean.getMapName();
//        String Images = bean.getImage();
//
//        SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images);
//        EventBus.getDefault().postSticky(detailBean);
//        startActivity(intent);
//
//    }


}
