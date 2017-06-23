package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.citypass.R;
import com.example.citypass.model.bean.shequ.MingRenTangBean;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/21 23:56
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MingRenTangAdapter extends RecyclerView.Adapter<MingRenTangAdapter.ViewHolder> implements View.OnClickListener{

    private List<MingRenTangBean.ServerInfoBean.InfoBean> list;
    private Context context;

    public MingRenTangAdapter(Context context,List<MingRenTangBean.ServerInfoBean.InfoBean> list){
        this.context = context;
        this.list = list;
    }

    //recyclerVeiw 最外层不能设置点击事件
    private OnItemClickListener mOnItemClickListener = null;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }


    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public MingRenTangAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_mingrentang_listview, viewGroup, false);
        view.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MingRenTangAdapter.ViewHolder viewHolder, int position) {
        MingRenTangBean.ServerInfoBean.InfoBean infoBean = list.get(position+3);
        viewHolder.paiming.setText(position+3+"");
        viewHolder.name.setText(infoBean.getNick());
        viewHolder.huitieshu.setText(infoBean.getSum());
        viewHolder.level.setText("lv."+infoBean.getLevel());

        if(infoBean.getLifeAddr().equals("无法显示当前位置")){

            viewHolder.where.setText("来自火星");
        }else {

            viewHolder.where.setText(infoBean.getLifeAddr()+"");
        }

        Glide.with(context).load(infoBean.getUserFace()).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.touxiang);
    }

    @Override
    public int getItemCount() {
        if(list==null){

            return 0;
        }

        return list.size()-3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView paiming,name,where,level,huitieshu;
        private ImageView touxiang;
        private LinearLayout mingRenTangLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            mingRenTangLayout= (LinearLayout) itemView.findViewById(R.id.MingRenTang_layout);
            paiming= (TextView) itemView.findViewById(R.id.MingRenTang_PaiMing);
            name= (TextView) itemView.findViewById(R.id.MingRenTang_userName);
            where= (TextView) itemView.findViewById(R.id.MingRenTang_where_text);
            level= (TextView) itemView.findViewById(R.id.MingRenTang_user_level);
            huitieshu= (TextView) itemView.findViewById(R.id.MingRenTang_HuiTieShuCount);
            touxiang= (ImageView) itemView.findViewById(R.id.MingRenTang_userImage);
//            mingRenTangLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(App.activity, PengChangWangDetailActivity.class);
//                    intent.putExtra("userId",list.get(getAdapterPosition()-2).getUserID());
//                    intent.putExtra("userName",list.get(getAdapterPosition()-2).getNick());
//                    intent.putExtra("face",list.get(getAdapterPosition()-2).getUserFace());
//                    App.activity.startActivity(intent);
//                }
//            });

        }
    }
}

