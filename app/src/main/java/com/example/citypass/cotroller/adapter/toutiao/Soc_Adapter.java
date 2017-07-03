package com.example.citypass.cotroller.adapter.toutiao;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.toutiao.TtrecyclerXQActivity;
import com.example.citypass.model.bean.toutiao.NewestBean;
import com.example.citypass.model.bean.toutiao.Socbean;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

/**
 * /**
 * 项目名称: City Pass
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/7/1 16:18
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


public class Soc_Adapter extends RecyclerView.Adapter<Soc_Adapter.MyViewHolder> {
    private List<Socbean.ServerInfoBean.ReplyInfoBean> mList;
    private Context context;

    public Soc_Adapter(List<Socbean.ServerInfoBean.ReplyInfoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }
    public void setNewData(List<Socbean.ServerInfoBean.ReplyInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.soc_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Socbean.ServerInfoBean.ReplyInfoBean bean = mList.get(position);
        if(bean==null){
            return;
        }
        holder.toutiaolvtv1.setText(bean.getTitle());

        Drawable draw2=context.getResources().getDrawable(R.drawable.news_fire);
        draw2.setBounds(0, 0, draw2.getMinimumWidth(), draw2.getMinimumHeight());
        holder.toutiaolvtv1.setCompoundDrawables(draw2,null,null,null);

        holder.toutiaolvtv2.setText(bean.getBrowse()+"");
        Drawable draw=context.getResources().getDrawable(R.drawable.ccoo_icon_message);
        draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
        holder.toutiaolvtv2.setCompoundDrawables(draw,null,null,null);

        holder.toutiaolvtv3.setText(bean.getReply()+"");
        Drawable draw1=context.getResources().getDrawable(R.drawable.ccoo_icon_look2);
        draw1.setBounds(0, 0, draw1.getMinimumWidth(), draw1.getMinimumHeight());
        holder.toutiaolvtv3.setCompoundDrawables(draw1,null,null,null);

        holder.toutiaolvtv4.setVisibility(View.VISIBLE);
        holder.toutiaolvtv4.setText(bean.getFlag());
        holder.toutiaolvtv4.setCompoundDrawables(null,null,null,null);
        Glide.with(context)
                .load(bean.getNewsImage())
                .into(holder.toutiaolvimg);


       holder.onclick.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context, TtrecyclerXQActivity.class);
               intent.putExtra("id",bean.getId());
               intent.putExtra("hotflag",bean.getHotFlag());
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class  MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout onclick;
        RelativeLayout toutiaoitem;
        TextView toutiaolvtv1,toutiaolvtv2,toutiaolvtv3,toutiaolvtv4;
        ImageView toutiaolvimg;
        public MyViewHolder(View itemView) {
            super(itemView);
            onclick= (LinearLayout) itemView.findViewById(R.id.toutiaolv_onclick);
            toutiaoitem= (RelativeLayout) itemView.findViewById(R.id.toutiao_item);
            toutiaolvtv1= (TextView) itemView.findViewById(R.id.toutiaolv_tv1);
            toutiaolvtv2= (TextView) itemView.findViewById(R.id.toutiaolv_tv2);
            toutiaolvtv3= (TextView) itemView.findViewById(R.id.toutiaolv_tv3);
            toutiaolvtv4= (TextView) itemView.findViewById(R.id.toutiaolv_tv4);
            toutiaolvimg= (ImageView) itemView.findViewById(R.id.toutiaolv_img);
        }
    }
}
