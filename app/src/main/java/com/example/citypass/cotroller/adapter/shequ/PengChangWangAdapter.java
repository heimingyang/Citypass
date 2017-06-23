package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.citypass.R;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.model.bean.shequ.PengChangWangBean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


public class PengChangWangAdapter extends RecyclerView.Adapter<PengChangWangAdapter.ViewHolder> implements View.OnClickListener{
    private List<PengChangWangBean.ServerInfoBean.InfoBean> list;
    private Context context;
    private InputStream inputStream;

    public PengChangWangAdapter(Context context, List<PengChangWangBean.ServerInfoBean.InfoBean> list) {
        this.list = list;
        this.context = context;

    }
    //recyclerVeiw 最外层不能设置点击事件
    private OnItemClickListener mOnItemClickListener = null;



    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    @Override
    public PengChangWangAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_pangchangwang_listview, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;

    }

    @Override
    public void onBindViewHolder(PengChangWangAdapter.ViewHolder viewHolder, int position) {
        PengChangWangBean.ServerInfoBean.InfoBean infoBean = list.get(position+3);
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
        try {
            inputStream = new FileInputStream(infoBean.getUserFace());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }

    @Override
    public int getItemCount() {

        if(list==null){

            return 0;
        }

        return list.size()-3;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView paiming,name,where,level,huitieshu;
        private CircleImageView touxiang;
        private LinearLayout PengChangWangLinear;
        public ViewHolder(View itemView) {
            super(itemView);
            PengChangWangLinear= (LinearLayout) itemView.findViewById(R.id.PengChangWang_layout);
            paiming= (TextView) itemView.findViewById(R.id.PengChangWang_PaiMing);
            name= (TextView) itemView.findViewById(R.id.PengChangWang_userName);
            where= (TextView) itemView.findViewById(R.id.PengChangWang_where_text);
            level= (TextView) itemView.findViewById(R.id.PengChangWang_user_level);
            huitieshu= (TextView) itemView.findViewById(R.id.PengChangWang_HuiTieShuCount);
            touxiang= (CircleImageView) itemView.findViewById(R.id.PengChangWang_userImage);
//            PengChangWangLinear.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
}
