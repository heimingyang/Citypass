package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.shequ.ZuiXinBean;

import java.util.List;


/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/22 14:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class ZuiXinAdapter extends RecyclerView.Adapter<ZuiXinAdapter.ViewHolder> implements View.OnClickListener {

    private List<ZuiXinBean.ServerInfoBean> data;
    private Context context;


    private OnItemClickListener mOnItemClickListener = null;

    public ZuiXinAdapter(BaseActivity activity, List<ZuiXinBean.ServerInfoBean> data) {
        this.context = activity;
        this.data = data;
    }


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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_zuixin, viewGroup, false);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTv.setText(data.get(position).getTitle());
        holder.contentTv.setText(data.get(position).getTbody());
        if (data.get(position).getImagesNum() == 0) {
            holder.imageRL.setVisibility(View.GONE);
        } else {
            holder.imageRL.setVisibility(View.VISIBLE);
            holder.imageLL.setVisibility(View.VISIBLE);
            String[] images = data.get(position).getImages().split("\\|");

            for (int i = 0; i < 3; i++) {
                ImageView imageView = (ImageView) holder.imageLL.getChildAt(i);
                if (i <= images.length-1) {
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(context)
                            .load(images[i])
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.drawable.ic_launcher)
                            .into(imageView);
                }else{
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
            if (data.get(position).getImagesNum() <= 3) {
                holder.imageNumTv.setVisibility(View.GONE);
            } else {
                holder.imageNumTv.setVisibility(View.VISIBLE);
                holder.imageNumTv.setText("共" + data.get(position).getImagesNum() + "张");
            }
        }
        holder.laiziTv.setText(data.get(position).getBName(

        ));


        holder.nameTv.setText(data.get(position).getRole());
        holder.zanTv.setText(String.valueOf(data.get(position).getSUP()));
        holder.zanTv.setText(String.valueOf(data.get(position).getReply()));
        Glide.with(context)
                .load(data.get(position).getUserface())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher)
                .into(holder.headIv);
    }

    @Override
    public int getItemCount() {
        if(data==null){

            return 0;
        }

        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv, titleTv, contentTv, imageNumTv, laiziTv, timeTv, zanTv, replyTv;

        private ImageView headIv;

        private RelativeLayout imageRL;

        private LinearLayout imageLL,ZuiXinLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            ZuiXinLayout= (LinearLayout) itemView.findViewById(R.id.ZuiXinLayout);
            nameTv = (TextView) itemView.findViewById(R.id.name_tv);
            titleTv = (TextView) itemView.findViewById(R.id.newest_title_tv);
            contentTv = (TextView) itemView.findViewById(R.id.newest_content_tv);
            imageNumTv = (TextView) itemView.findViewById(R.id.newest_image_num_tv);
            laiziTv = (TextView) itemView.findViewById(R.id.laizi_tv);
            timeTv = (TextView) itemView.findViewById(R.id.time_tv);
            zanTv = (TextView) itemView.findViewById(R.id.zan_tv);
            replyTv = (TextView) itemView.findViewById(R.id.reply_tv);
            imageRL = (RelativeLayout) itemView.findViewById(R.id.newest_image_relative);
            imageLL = (LinearLayout) itemView.findViewById(R.id.newest_image_layout);
            headIv = (ImageView) itemView.findViewById(R.id.head_iv);
            ZuiXinLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent=new Intent(context, TieZiDetialActivity.class);
//                    intent.putExtra("id",data.get(getAdapterPosition()-1).getTopicID()+"");
//                    intent.putExtra("name1",data.get(getAdapterPosition()-1).getUserName());
//                    context.startActivity(intent);
                    Log.i("bbb",data.get(getAdapterPosition()-1).getTopicID()+"");
                    Log.i("bbb",data.get(getAdapterPosition()-1).getUserface());
                }
            });
        }
    }
}
