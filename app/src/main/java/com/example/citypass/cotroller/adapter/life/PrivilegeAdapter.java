package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.model.bean.information.Privilege;
import com.example.citypass.model.http.HttpFacory;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/28 11:06
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PrivilegeAdapter extends BaseAdapter {
    private List<Privilege.ServerInfoBean.UserPrivilegeListBean.UserPrivilegeListBeans> mList;
    private Context mContext;

    public PrivilegeAdapter(List<Privilege.ServerInfoBean.UserPrivilegeListBean.UserPrivilegeListBeans> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
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
        convertView= LayoutInflater.from(mContext).inflate(R.layout.privilege_list_item,null);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.privilege_item_img);
        TextView textView= (TextView) convertView.findViewById(R.id.privilege_item_textone);
        TextView textView1= (TextView) convertView.findViewById(R.id.privilege_text_three);
        TextView textView2= (TextView) convertView.findViewById(R.id.privilege_text_five);
        Privilege.ServerInfoBean.UserPrivilegeListBean.UserPrivilegeListBeans userPrivilegeListBeans = mList.get(position);
        HttpFacory.create().loadImage(userPrivilegeListBeans.getPImage(),imageView,false);
        textView.setText(userPrivilegeListBeans.getName());
        textView1.setText(userPrivilegeListBeans.getDescription());
        textView2.setText(userPrivilegeListBeans.getHName());
        return convertView;
    }
}
