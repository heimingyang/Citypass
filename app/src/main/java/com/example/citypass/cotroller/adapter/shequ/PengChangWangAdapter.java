package com.example.citypass.cotroller.adapter.shequ;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.shequ.PengChangWangBean;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/21 0021 0:55
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


public class PengChangWangAdapter extends RecyclerView.Adapter<PengChangWangAdapter.MyViewHolder> {
    private List<PengChangWangBean.ServerInfoBean.InfoBean> mList;

    public PengChangWangAdapter(List<PengChangWangBean.ServerInfoBean.InfoBean> mList) {
        this.mList = mList;
        Log.e("aaaaa",mList.size()+"");
    }




    public void setNewData(List<PengChangWangBean.ServerInfoBean.InfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.shequ_pangchangwang_listview,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final PengChangWangBean.ServerInfoBean.InfoBean in = mList.get(position+3);
        holder.paiming.setText(position+3+"");
        holder.name.setText(in.getNick());
        holder.huitieshu.setText(in.getSum());
        holder.level.setText("lv."+in.getLevel());

        if(in.getLifeAddr().equals("无法显示当前位置")){

            holder.where.setText("来自火星");
        }else {

            holder.where.setText(in.getLifeAddr()+"");
        }

        Glide.with(App.activity).load(in.getUserFace()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.touxiang);

        holder.PengChangWangLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转详情之前先判断是否登录
                if(SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)){
                    Intent ins = new Intent(App.activity, PersonalActivity.class);
                    ins.putExtra("id", in.getUserID());
                    App.activity.startActivity(ins);
                }else {
                    Intent ina = new Intent(App.activity, LoginActivity.class);
                    App.activity.startActivity(ina);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size()-3;
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{
        private TextView paiming,name,where,level,huitieshu;
        private CircleImageView touxiang;
        private LinearLayout PengChangWangLinear;
        public MyViewHolder(View itemView) {
            super(itemView);
            PengChangWangLinear= (LinearLayout) itemView.findViewById(R.id.PengChangWang_layout);
            paiming= (TextView) itemView.findViewById(R.id.PengChangWang_PaiMing);
            name= (TextView) itemView.findViewById(R.id.PengChangWang_userName);
            where= (TextView) itemView.findViewById(R.id.PengChangWang_where_text);
            level= (TextView) itemView.findViewById(R.id.PengChangWang_user_level);
            huitieshu= (TextView) itemView.findViewById(R.id.PengChangWang_HuiTieShuCount);
            touxiang= (CircleImageView) itemView.findViewById(R.id.PengChangWang_userImage);

        }
    }
}