package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.information.Task;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 15:50
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TaskAdapter extends BaseAdapter {
    private List<Task.ServerInfoBean> mList;
    private Context mContext;
    private int a;

    public TaskAdapter(List<Task.ServerInfoBean> mList, Context mContext, int a) {
        this.mList = mList;
        this.mContext = mContext;
        this.a = a;
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
        convertView= LayoutInflater.from(mContext).inflate(R.layout.list_taskone_item,null);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.task_item_img);
        TextView textOne= (TextView) convertView.findViewById(R.id.task_item_textone);
        TextView textTwo= (TextView) convertView.findViewById(R.id.task_text_three);
        TextView textThree= (TextView) convertView.findViewById(R.id.task_text_four);
        TextView textFour= (TextView) convertView.findViewById(R.id.task_text_five);
        Task.ServerInfoBean serverInfoBean = mList.get(position);
        Glide.with(mContext).load(serverInfoBean.getTImage()).into(imageView);
        textOne.setText(serverInfoBean.getTitle());
        textTwo.setText(serverInfoBean.getCoin());
        textThree.setText(serverInfoBean.getIntegral());
        if(a==0){
            textFour.setVisibility(View.GONE);
        }else{
            int tState = serverInfoBean.getTState();
            if(tState==1006) {
                textFour.setText("已完成");
            }else{
                textFour.setText("未完成");
            }
        }
        return convertView;
    }
}
