package com.example.citypass.cotroller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.life.LifeFragmentBean;

import java.util.List;

import static com.example.citypass.model.bean.life.LifeFragmentBean.*;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/22 0:50
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class MyGridAdapter extends BaseAdapter {
    private List<LifeFragmentBean.ServerInfoBean.GetPostListBeanX.GetPostListBean> mList;
    private Context context;
    private TextView mtext;
    private ImageView image;

    public MyGridAdapter(Context context, List<LifeFragmentBean.ServerInfoBean.GetPostListBeanX.GetPostListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.new_life_gv_item, null);
        for (int i = 0; i < mList.size(); i++) {
            ServerInfoBean.GetPostListBeanX.GetPostListBean bean = mList.get(position);

            Log.d("MyGridAdapter", "mList.get(position):" + mList.size());

            if((i+1)%4!=0){
                mtext = (TextView) v.findViewById(R.id.text);

                image = (ImageView) v.findViewById(R.id.image);
                String channelName =bean.getChannelName();
                String channelImg = bean.getChannelImg();
                mtext.setText(channelName);
                Glide.with(context).load(channelImg).into(image);
            }else{
                String channelName =bean.getChannelName();
                String channelImg = bean.getChannelImg();
                mtext.setText(channelName);
                Glide.with(context).load(channelImg).into(image);
                if( i == mList.size()-1){
                   break;
                }

            }if(i == mList.size() -1){


            }



        }






        return v;
    }
}
