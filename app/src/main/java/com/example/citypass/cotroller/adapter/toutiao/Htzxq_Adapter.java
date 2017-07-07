package com.example.citypass.cotroller.adapter.toutiao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.toutiao.Newbean;
import com.example.citypass.model.bean.toutiao.Tzxqbean;
import com.example.citypass.utils.GlideCircleTransform;
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


public class Htzxq_Adapter extends RecyclerView.Adapter<Htzxq_Adapter.MyViewHolder> {
    private List<Tzxqbean.ServerInfoBean> mList;
    private Context context;

    public Htzxq_Adapter(List<Tzxqbean.ServerInfoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }
    public void setNewData(List<Tzxqbean.ServerInfoBean> mList){
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
        final Tzxqbean.ServerInfoBean bean=mList.get(position);

        if(bean==null){
            return;
        }
        holder.attitemtv1.setVisibility(View.GONE);
        holder.attitemtv2.setText(bean.getRoleName());
        holder.attitemtv3.setText(bean.getAddTime());
        holder.attitemtv4.setText("Lv."+bean.getLevel());
        Drawable draw1=context.getResources().getDrawable(R.drawable.ccoo_icon_huifu_press);
        draw1.setBounds(0, 0, draw1.getMinimumWidth(), draw1.getMinimumHeight());
        holder.attitemtv5.setCompoundDrawables(null,null,draw1,null);
        holder.attitemtv5.setText(bean.getRtitle());

        holder.attitemtv6.setVisibility(View.GONE);

        Glide.with(context)
                .load(bean.getRoleImg())
                .transform(new GlideCircleTransform(context))
                .into(holder.attitemimg2);

        String t=bean.getRtitle();
        if(t.equals("沙发")){
            holder.attitemimg1.setImageResource(R.drawable.news_discuss_image1);
        }else if(t.equals("板凳")){
            holder.attitemimg1.setImageResource(R.drawable.news_discuss_image2);
        }else if(t.equals("马扎")){
            holder.attitemimg1.setImageResource(R.drawable.news_discuss_image3);
        }else {
            holder.attitemimg1.setVisibility(View.GONE);
        }
        holder.attitemtv7.setVisibility(View.VISIBLE);
        holder.attitemtv7.setText(bean.getReplyMemo());


       if(bean.getMedalInfo().size()!=0){
           Glide.with(context)
                   .load("http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png")
                   .into(holder.attitemimg3);

           Glide.with(context)
                   .load("http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png")
                   .into(holder.attitemimg4);

           Glide.with(context)
                   .load("http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png")
                   .into(holder.attitemimg5);
       }



        holder.attitewm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class  MyViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout attitewm;
        TextView attitemtv1,attitemtv2,attitemtv3,attitemtv4,attitemtv5,attitemtv6,attitemtv7;
        ImageView attitemimg1,attitemimg2,attitemimg3,attitemimg4,attitemimg5;
        public MyViewHolder(View itemView) {
            super(itemView);
            attitemtv1= (TextView) itemView.findViewById(R.id.att_item_tv1);
            attitemtv2= (TextView) itemView.findViewById(R.id.att_item_tv2);
            attitemtv3= (TextView) itemView.findViewById(R.id.att_item_tv3);
            attitemtv4= (TextView) itemView.findViewById(R.id.att_item_tv4);
            attitemtv5= (TextView) itemView.findViewById(R.id.att_item_tv5);
            attitemtv6= (TextView) itemView.findViewById(R.id.att_item_tv6);
            attitemtv7= (TextView) itemView.findViewById(R.id.att_item_tv7);

            attitemimg1= (ImageView) itemView.findViewById(R.id.att_item_img1);
            attitemimg2= (ImageView) itemView.findViewById(R.id.att_item_img2);
            attitemimg3= (ImageView) itemView.findViewById(R.id.att_item_img3);
            attitemimg4= (ImageView) itemView.findViewById(R.id.att_item_img4);
            attitemimg5= (ImageView) itemView.findViewById(R.id.att_item_img5);
            attitewm= (RelativeLayout) itemView.findViewById(R.id.att_item);
        }
    }


}
