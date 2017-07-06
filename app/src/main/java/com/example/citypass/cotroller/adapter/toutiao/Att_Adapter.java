package com.example.citypass.cotroller.adapter.toutiao;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.toutiao.Attbean;
import com.example.citypass.model.bean.toutiao.Socbean;
import com.example.citypass.utils.GlideCircleTransform;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

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


public class Att_Adapter extends RecyclerView.Adapter<Att_Adapter.MyViewHolder> {
    private List<Attbean.ServerInfoBean> mList;
    private Context context;

    public Att_Adapter(List<Attbean.ServerInfoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }
    public void setNewData(List<Attbean.ServerInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.att_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Attbean.ServerInfoBean bean=mList.get(position);

        if(bean==null){
            return;
        }
        if(position<3){
            holder.attitemimg1.setVisibility(View.VISIBLE);
            if(position==0){
                holder.attitemtv1.setBackgroundResource(R.drawable.news_ranking1);
                holder.attitemimg1.setBackgroundResource(R.drawable.news_rankings1);
                holder.attitemtv1.setTextColor(R.color.hcfmorecity);
                holder.attitemtv1.setText(position+1+"");
            }
            if(position==1){
                holder.attitemtv1.setBackgroundResource(R.drawable.news_ranking2);
                holder.attitemimg1.setBackgroundResource(R.drawable.news_rankings2);
                holder.attitemtv1.setTextColor(R.color.blue);
                holder.attitemtv1.setText(position+1+"");
            }
            if(position==2){
                holder.attitemtv1.setBackgroundResource(R.drawable.news_ranking3);
                holder.attitemimg1.setBackgroundResource(R.drawable.news_rankings3);
                holder.attitemtv1.setTextColor(R.color.green);
                holder.attitemtv1.setText(position+1+"");
            }
        }else {
            holder.attitemimg1.setVisibility(View.GONE);
            holder.attitemtv1.setBackgroundResource(R.drawable.news_ranking4);
            holder.attitemtv1.setTextColor(R.color.black);
            holder.attitemtv1.setText(position+1+"");
        }
        holder.attitemtv2.setText(bean.getNickName());
        holder.attitemtv3.setText(bean.getAddress());
        holder.attitemtv4.setText("Lv."+bean.getLevel());
        holder.attitemtv5.setText(bean.getDingNum()+"");
        holder.attitemtv6.setText(bean.getReplyNum()+"");

        Glide.with(context)
                .load(bean.getUserFace())
                .transform(new GlideCircleTransform(context))
                .into(holder.attitemimg2);

        Glide.with(context)
                .load("http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png")
                .into(holder.attitemimg3);

        Glide.with(context)
                .load("http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png")
                .into(holder.attitemimg4);

        Glide.with(context)
                .load("http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png")
                .into(holder.attitemimg5);


        holder.attitewm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PersonalActivity.class);
                intent.putExtra("id",Integer.parseInt(bean.getUserId()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class  MyViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout attitewm;
        TextView attitemtv1,attitemtv2,attitemtv3,attitemtv4,attitemtv5,attitemtv6;
        ImageView attitemimg1,attitemimg2,attitemimg3,attitemimg4,attitemimg5;
        public MyViewHolder(View itemView) {
            super(itemView);
            attitemtv1= (TextView) itemView.findViewById(R.id.att_item_tv1);
            attitemtv2= (TextView) itemView.findViewById(R.id.att_item_tv2);
            attitemtv3= (TextView) itemView.findViewById(R.id.att_item_tv3);
            attitemtv4= (TextView) itemView.findViewById(R.id.att_item_tv4);
            attitemtv5= (TextView) itemView.findViewById(R.id.att_item_tv5);
            attitemtv6= (TextView) itemView.findViewById(R.id.att_item_tv6);
            attitemimg1= (ImageView) itemView.findViewById(R.id.att_item_img1);
            attitemimg2= (ImageView) itemView.findViewById(R.id.att_item_img2);
            attitemimg3= (ImageView) itemView.findViewById(R.id.att_item_img3);
            attitemimg4= (ImageView) itemView.findViewById(R.id.att_item_img4);
            attitemimg5= (ImageView) itemView.findViewById(R.id.att_item_img5);
            attitewm= (RelativeLayout) itemView.findViewById(R.id.att_item);
        }
    }


}
