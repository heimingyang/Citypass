package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.cotroller.activity.FaXianActionActivity;
import com.example.citypass.cotroller.activity.FaXianCityActivity;
import com.example.citypass.cotroller.activity.FaXianLottoActivity;
import com.example.citypass.cotroller.activity.FaXianMeiNvActivity;
import com.example.citypass.cotroller.activity.MyWebActivity;
import com.example.citypass.model.http.bean.faxian.MyFaXian;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/21 0021 14:09
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


class MyGrilAdapter extends BaseAdapter {

    Context context;
    MyFaXian.ServerInfoBean Bean;

    public MyGrilAdapter(Context context, MyFaXian.ServerInfoBean bean) {
        this.context = context;
        Bean = bean;
    }

    @Override
    public int getCount() {
        return Bean.getData().isEmpty() ? 0 : Bean.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return Bean.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.faxian_griditem, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.faxian_grid_img);
            holder.mtext = (TextView) convertView.findViewById(R.id.faxian_grid_text);

            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }
//
        LogUtils.e("      ", Bean.getData().size() + "");

        final MyFaXian.ServerInfoBean.DataBean dataBean = Bean.getData().get(position);

        String title = dataBean.getTitle();
        final String icon = dataBean.getIcon();
        holder.mtext.setText(title);
        Glide.with(context).load(icon).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = dataBean.getUrl();
                //美女秀场
                if (url.equals("/cover/mm/")) {
                    Intent intent1 = new Intent(context, FaXianMeiNvActivity.class);
                    context.startActivity(intent1);

                    //热门活动
                } else if (url.equals("/bbs/zthdlist.aspx")) {
                    Intent intent2 = new Intent(context, FaXianActionActivity.class);
                    context.startActivity(intent2);

                    //抽奖

                } else if (url.equals("/user/my_coin.aspx")) {
                    Intent intent3 = new Intent(context, FaXianLottoActivity.class);
                    context.startActivity(intent3);


                    //同城交友
                } else if (url.equals("/tieba/?flag=4&type=2")) {

                    Intent intent4 = new Intent(context, FaXianCityActivity.class);
                    context.startActivity(intent4);

                } else {
                    Intent intent = new Intent(context, MyWebActivity.class);

                    intent.putExtra("url", dataBean.getUrl());
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }


    class Holder {
        private ImageView imageView;
        private TextView mtext;

    }
}

