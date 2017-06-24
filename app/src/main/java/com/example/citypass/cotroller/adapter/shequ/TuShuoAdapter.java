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
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.shequ.TuShuoBean;

import java.util.List;


public class TuShuoAdapter extends RecyclerView.Adapter<TuShuoAdapter.ViewHolder> implements View.OnClickListener {
    private List<TuShuoBean.ServerInfoBean> data;
    private List<Integer> heightList;//装产出的随机数
    private Context context;
    TuShuoBean.ServerInfoBean bean;
    public TuShuoAdapter(BaseActivity activity, List<TuShuoBean.ServerInfoBean> data) {

        this.context = activity;
        this.data=data;
        //记录为每个控件产生的随机高度,避免滑回到顶部出现空白
        //       heightList = new ArrayList<>();
//        for (int i = 0; i < data.size(); i++) {
//            int height = new Random().nextInt(200) + 100;//[100,300)的随机数
//            heightList.add(height);
//        }
    }

    //recyclerVeiw 最外层不能设置点击事件
    private MingRenTangAdapter.OnItemClickListener mOnItemClickListener = null;

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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_tushuo, viewGroup, false);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bean = data.get(position);
        holder.name.setText(bean.getRole());
//        holder.zan.setText(bean.getImageCount());
        holder.time.setText(bean.getReplyTime());
        holder.content.setText(bean.getTbody());
//          for (int i=0;i<bean.getImageCount();i++){
        Glide.with(App.activity).load(bean.getUserface()).into(holder.imageView);
//          }
//
        holder.zan.setText(bean.getSUP()+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView  imageView;
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
