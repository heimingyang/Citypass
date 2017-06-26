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
import com.example.citypass.R;
import com.example.citypass.model.bean.shequ.TuShuoBean;

import java.util.List;


public class TuShuoAdapter extends RecyclerView.Adapter<TuShuoAdapter.ViewHolder>{
    private List<TuShuoBean.ServerInfoBean> data;
    private Context context;
    public TuShuoAdapter(Context context,List<TuShuoBean.ServerInfoBean> data) {
        this.context = context;
        this.data=data;
    }




    public void setNewData(List<TuShuoBean.ServerInfoBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_tushuo, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TuShuoBean.ServerInfoBean bean = data.get(position);
        holder.name.setText(bean.getRole()+"");
        holder.time.setText(bean.getReplyTime()+"");
        holder.content.setText(bean.getTbody()+"");
        holder.zan.setText(bean.getSUP()+"");
        if (bean.getImagesNum() > 1) {
            int i = bean.getImages().indexOf("|");
            String substring = bean.getImages().substring(0, i);
            Glide.with(context).load(substring).into(holder.imageView);
        } else {
            Glide.with(context).load(bean.getImages()).into(holder.imageView);
        }
        if (bean.getIsFollow() == 0) {
            holder.zanImage.setImageResource(R.drawable.ccoo_icon_zan);
        } else {
            holder.zanImage.setImageResource(R.drawable.ccoo_icon_zan_2);
        }
    }

    @Override
    public int getItemCount() {
        return data.isEmpty()?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView  imageView,zanImage;
        private TextView zan,content,time,name;
        private LinearLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            layout= (LinearLayout) itemView.findViewById(R.id.TuShuoLayout);
            zan= (TextView) itemView.findViewById(R.id.shaitu_zan);
            content= (TextView) itemView.findViewById(R.id.shaitu_content);
            time= (TextView) itemView.findViewById(R.id.shaitu_time);
            name= (TextView) itemView.findViewById(R.id.shaitu_name);
            imageView= (ImageView) itemView.findViewById(R.id.shaitu_image);
            zanImage = (ImageView) itemView.findViewById(R.id.shaitu_zanImg);
//            layout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // ToastUtils.showShortToast(getAdapterPosition()+"");
//                    Intent intent = new Intent(context,
//                            TuShuoDetialActivity.class);
//                    intent.putExtra("id", bean.getTopicID());
//                    intent.putExtra("pos", getPosition());
//                    context.startActivity(intent);
//                }
//            });
        }
    }
}
