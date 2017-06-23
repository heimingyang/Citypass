package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.shequ.HuoDongBean;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 19:05
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class HuoDongAdapter extends RecyclerView.Adapter<HuoDongAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<HuoDongBean.ServerInfoBean> list;
    public HuoDongAdapter(Context context,List<HuoDongBean.ServerInfoBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        if(list==null){

            return 0;
        }

        return list.size();
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

    public HuoDongAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_huodong, viewGroup, false);
        view.setOnClickListener(this);

        ViewHolder vh = new ViewHolder(view);

        return vh;

    }


    public void onBindViewHolder(HuoDongAdapter.ViewHolder viewHolder, int position) {

        HuoDongBean.ServerInfoBean infoBean = list.get(position);

        viewHolder.title.setText(infoBean.getTitle());
        Glide.with(context).load(infoBean.getImage()).into(viewHolder.imageView);
        if(infoBean.getClassType()==0){

            viewHolder.huodong.setImageResource(R.drawable.bbs_zhuanti_left);
            viewHolder.type.setImageResource(R.drawable.ccoo_icon_look2);
            viewHolder.time.setText("已有" + infoBean.getHit() + "人感兴趣");

        }else {
            viewHolder.huodong.setImageResource(R.drawable.bbs_huodong_left);
            viewHolder.type.setImageResource(R.drawable.ccoo_icon_time);
            viewHolder.time.setText("活动时间：" + infoBean.getStartTime() + "至"
                    + infoBean.getEndTime());
        }
        viewHolder.state.setImageResource(R.drawable.bbs_huodong_jieshu);

//        if (!TextUtils.isEmpty(infoBean.getStartTime()) && !TextUtils.isEmpty(infoBean.getEndTime())) {
//            int s = Integer.parseInt(infoBean.getStartTime().replace("-", ""));
//            int e = Integer.parseInt(infoBean.getEndTime().replace("-", ""));
//            int cur = Integer.parseInt(TimeUtils.getTime("yyyy-MM-dd"));
//            if (cur >= s && cur <= e) {
//                viewHolder.state.setImageResource(R.drawable.bbs_huodong_jinxing);
//            }
//        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title,time;
        ImageView huodong,imageView,state,type;
        View HuoDongLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
            time= (TextView) itemView.findViewById(R.id.time);
            huodong= (ImageView) itemView.findViewById(R.id.huodong);
            imageView= (ImageView) itemView.findViewById(R.id.imageview);
            state= (ImageView) itemView.findViewById(R.id.state);
            type= (ImageView) itemView.findViewById(R.id.type);
            HuoDongLayout=itemView.findViewById(R.id.huodong_Layout);

            HuoDongLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //ToastUtils.showShortToast(getAdapterPosition()+"");

                }
            });
        }

    }
}
