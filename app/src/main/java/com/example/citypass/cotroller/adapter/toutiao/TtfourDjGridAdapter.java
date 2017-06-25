package com.example.citypass.cotroller.adapter.toutiao;

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
import com.example.citypass.model.bean.toutiao.TtfourDJ;
import com.example.citypass.utils.GlideCircleTransform;

import java.util.List;

import static com.example.citypass.model.bean.life.LifeFragmentBean.ServerInfoBean;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/22 0:50
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class TtfourDjGridAdapter extends BaseAdapter {
    private List<TtfourDJ.ServerInfoBean> mList;
    private Context context;


    public TtfourDjGridAdapter(Context context, List<TtfourDJ.ServerInfoBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder holder;
        if(convertView == null){
            holder=new viewholder();
            convertView = LayoutInflater.from(context).inflate(R.layout.ttfourdj_gridview_item, null);
            holder.textView= (TextView) convertView.findViewById(R.id.ttgridview_item_tv);
            holder.imageView= (ImageView) convertView.findViewById(R.id.ttgridview_item_img);

            convertView.setTag(holder);
        }else {
            holder = (viewholder) convertView.getTag();
        }
        holder.textView.setText(mList.get(position).getTitle());
        Log.e("TAG", mList.get(position).getTitle());
        String url=mList.get(position).getIcon();
        if(url!=null){
            Glide.with(parent.getContext())
                    .load(url)
                    .into(holder.imageView);
        }
        return convertView;
    }
    class  viewholder{
        TextView textView;
        ImageView imageView;
    }
}
