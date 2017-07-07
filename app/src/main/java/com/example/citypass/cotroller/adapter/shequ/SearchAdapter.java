package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.citypass.R;
import com.example.citypass.cotroller.activity.shequ.CardDetailActivity;
import com.example.citypass.model.bean.shequ.SerachBeans;
import com.example.citypass.utils.UrlUtils;

import java.util.List;


/**
 * Created by 李艳东 on 2017/6/30  11:17
 */

public class SearchAdapter extends BaseAdapter<SerachBeans.ServerInfoBean> {
    private SharedPreferences mShared;
    private TextView title;

    public SearchAdapter(Context context, List<SerachBeans.ServerInfoBean> datas) {
        super(context, R.layout.bbs_seracher_item, datas);

    }


    @Override
    public void convert(ViewHolder holder, final SerachBeans.ServerInfoBean serverInfoBean) {
        holder.setText(R.id.ser_title, serverInfoBean.getTitle());

        mShared = context.getSharedPreferences("bbsdata", Context.MODE_PRIVATE);
        String bbsname = "北京";
        String str = serverInfoBean.getTitle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.bbs_seracher_item, null);
        title = (TextView) inflate.findViewById(R.id.ser_title);

            //文字
            String result = serverInfoBean.getTitle();
            //文字中的关键字
            String editTextStr = bbsname;


        holder.setText(R.id.Role, serverInfoBean.getRole());
        holder.setText(R.id.Reply, serverInfoBean.getReply() + "");
        holder.setText(R.id.AddTime, serverInfoBean.getAddTime());
        holder.setOnclickListener(R.id.ser_ly, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CardDetailActivity.class);
                int topicID = serverInfoBean.getTopicID();
                intent.putExtra("ser_url", UrlUtils.SER_DETAIL + String.valueOf(topicID));
                context.startActivity(intent);
            }
        });
    }
}
