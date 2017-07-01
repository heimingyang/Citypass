package com.example.citypass.cotroller.adapter.life;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.citypass.R;
import com.example.citypass.model.bean.information.Msg;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/1 10:16
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MessageAdapter extends BaseAdapter<Msg.ServerInfoBean> {
    public MessageAdapter(Context context, List<Msg.ServerInfoBean> datas) {
        super(context, R.layout.msg_list_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Msg.ServerInfoBean serverInfoBean) {
        holder.setText(R.id.msg_list_time,serverInfoBean.getCreateTime());
        holder.setText(R.id.msg_list_text,serverInfoBean.getMassage());
    }
}
