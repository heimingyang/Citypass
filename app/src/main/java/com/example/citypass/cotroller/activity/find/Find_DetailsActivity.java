package com.example.citypass.cotroller.activity.find;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.discover.Belle_Xq_Adapter;
import com.example.citypass.cotroller.fragment.faxian_belle.Details_Fragment;
import com.example.citypass.model.bean.beele.Belle_xq1_Bean;
import com.example.citypass.model.http.HttpFacory;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/5 0005 8:48
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

public class Find_DetailsActivity extends BaseActivity {


    @BindView(R.id.belle_xq_back)
    ImageView belleXqBack;
    @BindView(R.id.belle_xq_title)
    TextView belleXqTitle;
    @BindView(R.id.belle_xq_more)
    ImageView belleXqMore;
    @BindView(R.id.meinv_xq_title)
    RelativeLayout meinvXqTitle;
    @BindView(R.id.belle_details_viewpagers)
    ViewPager belleDetailsViewpager;

    private List<Fragment> fList;
    private Details_Fragment details_fragment;

    //viewpager适配器
    private Belle_Xq_Adapter belle_xq_adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_find_details;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {
        fList = new ArrayList<>();
        requestData();

    }


    @OnClick({R.id.belle_xq_back, R.id.belle_xq_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.belle_xq_back:
                finish();
                break;
            case R.id.belle_xq_more:

                break;
        }
    }

    private void requestData() {
        Intent intent = App.activity.getIntent();
        //id
        String id = intent.getStringExtra("id");
        Log.e("Find_DetailsActivity_id", id);
        //siteID
        int siteID = LoginUtils.information.getServerInfo().getSiteID();
        Log.d("Find_DetailsActivity", "siteID:" + siteID);
        //userid
        String userid = LoginUtils.information.getServerInfo().getId();
        //拼接参数
        //ID
        String str1 = "{\n" +
                "    \"appName\": \"CcooCity\",\n" +
                "    \"Param\": {\n" +
                "        \"pageSize\": 100,\n" +
                "        \"ID\": ";
        //UserId
        String str2 = ",\n" +
                "        \"userID\": \"";
        //SiteID
        String str3 = "\",\n" +
                "        \"siteID\": ";
        //Time
        String str4 = ",\n" +
                "        \"curPage\": 1\n" +
                "    },\n" +
                "    \"requestTime\": \"";
        //userId
        String str5 = "\",\n" +
                "    \"customerKey\": \"9A5DF98CA3AF94EAFCC159A5A421FB59\",\n" +
                "    \"Method\": \"PHSocket_GetCoverPhotoDetails\",\n" +
                "    \"Statis\": {\n" +
                "        \"PhoneId\": \"133524541070404\",\n" +
                "        \"System_VersionNo\": \"Android 4.2.2\",\n" +
                "        \"UserId\": ";
        //siteID
        String str6 = ",\n" +
                "        \"PhoneNum\": \"+8617646525761\",\n" +
                "        \"SystemNo\": 2,\n" +
                "        \"PhoneNo\": \"GT-P5210\",\n" +
                "        \"SiteId\": ";
        String str7 = "\n" +
                "    },\n" +
                "    \"customerID\": 8001,\n" +
                "    \"version\": \"4.5\"\n" +
                "}";

        //发表时间
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String time = formatter.format(curDate);

        Map<String, String> map = new HashMap<>();
        map.put("param", str1 + id + str2 + userid + str3 + siteID + str4 + time + str5 + userid + str6 + siteID + str7);

        HttpFacory.create().POST("http://appnew.ccoo.cn/appserverapi.ashx/", map, "", new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Log.d("Find_DetailsActivity", result);
                Belle_xq1_Bean belle_xq1_bean = JSON.parseObject(result, Belle_xq1_Bean.class);

                List<Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> coverPhotoDetailsInfo
                        = belle_xq1_bean.getServerInfo().getCoverPhotoDetailsInfo().getCoverPhotoDetailsInfo();
//                Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean coverPhotoDetailsInfoBean
//                        = coverPhotoDetailsInfo.get(0);

                for (int i = 0; i < coverPhotoDetailsInfo.size(); i++) {
                    details_fragment = new Details_Fragment(coverPhotoDetailsInfo.get(i));
                    belleXqTitle.setText(coverPhotoDetailsInfo.get(i).getNick()+"");
                    fList.add(details_fragment);
                }
                Log.d("Find_DetailsActivity", "coverPhotoDetailsInfo:" + fList.size() + "");
                belle_xq_adapter = new Belle_Xq_Adapter(getSupportFragmentManager(), Find_DetailsActivity.this, fList);
                belleDetailsViewpager.setAdapter(belle_xq_adapter);

//                Log.e("initdata", "请求成功");

            }

            @Override
            public void onError(String errormsg) {
//                Log.e("initdata", "请求失败");

            }
        });
    }
}
