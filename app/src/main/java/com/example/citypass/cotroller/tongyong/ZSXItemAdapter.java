package com.example.citypass.cotroller.tongyong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.utils.GlideCircleTransform;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24 0024.
 */

public class ZSXItemAdapter extends BaseAdapter {
    Context context;
    List<ZSXItemCallBackEntity.ServerInfoBean> serverInfoList;
    public ZSXItemAdapter(Context context, List<ZSXItemCallBackEntity.ServerInfoBean> serverInfoList){
        this.context =context;
        this.serverInfoList =serverInfoList;

    }

    @Override
    public int getCount() {
        return serverInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return serverInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        HolderView holderView;
        if(convertView == null){
            holderView = new HolderView();
            convertView = LayoutInflater.from(context).inflate(R.layout.zsx_iteem, null);
            holderView.content = (TextView) convertView.findViewById(R.id.zsx_content);
            holderView.img = (ImageView) convertView.findViewById(R.id.zsx_img);
            holderView.name = (TextView) convertView.findViewById(R.id.zsx_name);
            holderView.time = (TextView) convertView.findViewById(R.id.zsx_time);
            holderView.topImg = (ImageView) convertView.findViewById(R.id.zsx_top_img);
            holderView.pagTxt= (TextView) convertView.findViewById(R.id.pang_txt);
            holderView.lv = (TextView) convertView.findViewById(R.id.zsx_header);
            convertView.setTag(holderView);
        }else
            holderView = (HolderView) convertView.getTag();
        Glide.with(context).load(serverInfoList.get(position).getRoleImg()).transform(new GlideCircleTransform(context)).into(holderView.img);
        if(position == 0){
            holderView.topImg.setImageResource(R.mipmap.news_discuss_image1);
            holderView.pagTxt.setText("沙发");
        }else if(position == 1){
            holderView.topImg.setImageResource(R.mipmap.news_discuss_image2);
            holderView.pagTxt.setText("板凳");
        }else{
            holderView.topImg.setImageResource(R.mipmap.news_discuss_image3);
            holderView.pagTxt.setText("马扎");
        }
        holderView.lv.setText("Lv"+serverInfoList.get(position).getLevel());
        holderView.content .setText(serverInfoList.get(position).getReplyMemo());
        holderView.name .setText(serverInfoList.get(position).getRoleName());
        try {
            holderView.time .setText(TimeUtils.getTime(serverInfoList.get(position).getAddTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        holderView.topImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, ReplyDetailActivity.class);
//                intent.putExtra("uid",serverInfoList.get(position).getUserID());
//                context.startActivity(intent);
            }
        });

        return convertView;
    }
    class HolderView{
        ImageView img,topImg;
        TextView content,time,name,pagTxt,lv;
    }
}
