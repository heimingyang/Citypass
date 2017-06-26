package com.example.citypass.cotroller.adapter.toutiao;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.toutiao.TtrecyclerXQActivity;
import com.example.citypass.model.bean.toutiao.Touqiaolistview;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/23 15:06
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


public class HttpurecyclerviewAdapter extends BaseAdapter<Touqiaolistview.ServerInfoBean.HeadTInfoListBean> {
    public HttpurecyclerviewAdapter(Context context,  List<Touqiaolistview.ServerInfoBean.HeadTInfoListBean> datas) {
        super(context, R.layout.toutiao_listview_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final Touqiaolistview.ServerInfoBean.HeadTInfoListBean headTInfoListBean) {
        if(headTInfoListBean!=null){
            holder.setText(R.id.toutiaolv_tv1,headTInfoListBean.getData().get(0).getTitle());
            holder.setText(R.id.toutiaolv_tv2,headTInfoListBean.getData().get(0).getVariable8());
            holder.setText(R.id.toutiaolv_tv3, String.valueOf(headTInfoListBean.getData().get(0).getVariable1()));

            TextView textView=holder.getView(R.id.toutiaolv_tv1);
            ImageView imageView=holder.getView(R.id.toutiaolv_img);

            String url=headTInfoListBean.getData().get(0).getImage();
            if(url!=null){
                imageView.setVisibility(View.VISIBLE);
                Glide.with(App.activity)
                        .load(url)
                        .into(imageView);
                imageView.setVisibility(View.VISIBLE);
            }else {
                imageView.setVisibility(View.GONE);
            }

            holder.setOnclickListener(R.id.toutiaolv_onclick, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, TtrecyclerXQActivity.class);
                    intent.putExtra("id",headTInfoListBean.getTheirID());
                    intent.putExtra("type",headTInfoListBean.getFirstType());
                    context.startActivity(intent);
                }
            });
        }
    }
}
