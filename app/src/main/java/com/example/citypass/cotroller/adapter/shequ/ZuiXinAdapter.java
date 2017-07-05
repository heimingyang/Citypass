package com.example.citypass.cotroller.adapter.shequ;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
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
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.model.bean.shequ.ZuiXinBean;

import java.util.ArrayList;
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
public class ZuiXinAdapter extends RecyclerView.Adapter<ZuiXinAdapter.ViewHolder> {

    private List<ZuiXinBean.ServerInfoBean> data;
    private OnItemClickListener onItemClickListener;
    private List<String> strList = new ArrayList<>();
    private LinearLayout myLayout;

    public void setmOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }




    //define interface
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public ZuiXinAdapter(List<ZuiXinBean.ServerInfoBean> data){
        this.data = data;
        Log.e("aaa",data.size()+"");
    }
    public void setNewData(List<ZuiXinBean.ServerInfoBean> data){
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shequ_zuixin, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ZuiXinBean.ServerInfoBean bean = data.get(position);
        holder.titleTv.setText(bean.getTitle()+"");
        holder.nameTv.setText(bean.getRole()+"");
        holder.contentTv.setText(bean.getTbody()+"");
        holder.laiziTv.setText(bean.getBName()+"");
        holder.zanTv.setText(bean.getSUP()+"");
        holder.timeTv.setText(bean.getReplyTime()+"");
        holder.replyTv.setText(bean.getReply()+"");
        final ImageView img = holder.headIv;
        Glide.with(App.activity).load(bean.getUserface()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });
        if (bean.getImagesNum() == 0) {
            holder.imageRL.setVisibility(View.GONE);
        } else {
            holder.imageRL.setVisibility(View.VISIBLE);
            holder.imageLL.setVisibility(View.VISIBLE);
            String[] images = data.get(position).getImages().split("\\|");

            for (int i = 0; i < 3; i++) {
                ImageView imageView = (ImageView) holder.imageLL.getChildAt(i);
                if (i <= images.length-1) {
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(App.activity)
                            .load(images[i])
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.drawable.ic_launcher)
                            .into(imageView);
                }else{
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
            if (bean.getImagesNum() <= 3) {
                holder.imageNumTv.setVisibility(View.GONE);
            } else {
                holder.imageNumTv.setVisibility(View.VISIBLE);
                holder.imageNumTv.setText("共" + data.get(position).getImagesNum() + "张");
            }
        }
        //得到所有的网址，
        String imagess = bean.getUserface();
        if(imagess != null){
            String[] split = imagess.split("\\|");
        }

    }
    @Override
    public int getItemViewType(int position) {


        return super.getItemViewType(position);
    }

    //要在数据中截取到imageview url路径的方法
    private String getJson_Url(String jsons) {

        /**
         * 判断json串里有没有“|”
         * 有的话就让它把从开始到“|”前面的截取走
         * 如果没有了就让它直接从0截取到json串结束
         * */

        if (jsons.contains("|")) {
            //第一个"|"出现的索引
            int i = jsons.indexOf("|");
            String sub = jsons.substring(0, i) + "|";
            Log.i("截取出来的img--------->", sub);
            getJson_Url(sub);
            return jsons.substring(i, jsons.length());

        } else {
            return jsons;
        }
    }



    @Override
    public int getItemCount() {

        return data.isEmpty()?0:data.size();
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getLayoutPosition());
                }
            });
        }
    }
}
