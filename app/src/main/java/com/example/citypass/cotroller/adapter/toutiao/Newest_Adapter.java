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
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.toutiao.TtrecyclerXQActivity;
import com.example.citypass.model.bean.naonao.Di_NaoNao_Bean;
import com.example.citypass.model.bean.toutiao.NewestBean;
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


public class Newest_Adapter extends RecyclerView.Adapter<Newest_Adapter.MyViewHolder> {
    private List<NewestBean.ServerInfoBean.ReplyInfoBean> mList;
    private Context context;

    public Newest_Adapter(List<NewestBean.ServerInfoBean.ReplyInfoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }
    public void setNewData(List<NewestBean.ServerInfoBean.ReplyInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hnewest_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NewestBean.ServerInfoBean.ReplyInfoBean bean = mList.get(position);
        if(bean==null){
            return;
        }
        //得到yyyy-MM-dd HH:mm:ss
        String Flag=mList.get(position).getFlag();

        String top=TimeUtils.getDate(TimeUtils.getLongTime(Flag,"yyyy-MM-dd"),"dd");

        holder.hnewesttitletop.setText(top);
        holder.hnewesttitlecalendar.setText(bean.getNTime());
        holder.hnewesttitleweek.setText(bean.getWeekTime());
        holder.hnewesttitledata.setText(bean.getNewDate());
        holder.toutiaolvtv1.setText(bean.getTitle());
        holder.toutiaolvtv2.setText(bean.getBrowse()+"");
        Drawable draw=context.getResources().getDrawable(R.drawable.ccoo_icon_look2);
        draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
        holder.toutiaolvtv2.setCompoundDrawables(draw,null,null,null);

        holder.toutiaolvtv3.setText(bean.getReply()+"");
        Drawable draw1=context.getResources().getDrawable(R.drawable.ccoo_icon_message);
        draw1.setBounds(0, 0, draw1.getMinimumWidth(), draw1.getMinimumHeight());
        holder.toutiaolvtv2.setCompoundDrawables(draw1,null,null,null);


        Glide.with(context)
                .load(bean.getNewsImage())
                .into(holder.toutiaolvimg);

        //将同一天的合并在一起

        if (position == 0) {
            //第一个是一定显示的
            holder.hnewesttitle.setVisibility(View.VISIBLE);
        } else {
            //后一个与前一个对比,判断首字母是否相同，相同则隐藏
            String headerFlag = mList.get(position-1).getFlag();
            if (Flag.equals(headerFlag)) {
                holder.hnewesttitle.setVisibility(View.GONE);
            } else {
                holder.hnewesttitle.setVisibility(View.VISIBLE);
            }
        }

        holder.newestitem.setOnClickListener(new View.OnClickListener() {
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
        LinearLayout newestitem;
        RelativeLayout hnewesttitle,toutiaoitem;
        TextView hnewesttitletop,hnewesttitlecalendar,hnewesttitleweek,hnewesttitledata
                ,toutiaolvtv1,toutiaolvtv2,toutiaolvtv3;
        ImageView toutiaolvimg;
        public MyViewHolder(View itemView) {
            super(itemView);
            newestitem= (LinearLayout) itemView.findViewById(R.id.hnewest_item);
            hnewesttitle= (RelativeLayout) itemView.findViewById(R.id.hnewest_title);
            hnewesttitletop= (TextView) itemView.findViewById(R.id.hnewest_title_top);
            hnewesttitlecalendar= (TextView) itemView.findViewById(R.id.hnewest_title_calendar);
            hnewesttitleweek= (TextView) itemView.findViewById(R.id.hnewest_title_week);
            hnewesttitledata= (TextView) itemView.findViewById(R.id.hnewest_title_data);

            toutiaoitem= (RelativeLayout) itemView.findViewById(R.id.toutiao_item);
            toutiaolvtv1= (TextView) itemView.findViewById(R.id.toutiaolv_tv1);
            toutiaolvtv2= (TextView) itemView.findViewById(R.id.toutiaolv_tv2);
            toutiaolvtv3= (TextView) itemView.findViewById(R.id.toutiaolv_tv3);
            toutiaolvimg= (ImageView) itemView.findViewById(R.id.toutiaolv_img);
        }
    }
}
