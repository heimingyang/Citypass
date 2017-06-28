package com.example.citypass.cotroller.adapter.naonao;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.activity.naonao.Title_Detail_NaoNao_Activity;
import com.example.citypass.model.bean.information.Title_NaoNao_Bean;

import java.io.Serializable;
import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/23 0023 9:55
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


public class Title_NaoNao_Recycle_Adapter extends RecyclerView.Adapter<Title_NaoNao_Recycle_Adapter.MyViewHolder> {
    private List<Title_NaoNao_Bean.ServerInfoBean> mList;

    public Title_NaoNao_Recycle_Adapter(List<Title_NaoNao_Bean.ServerInfoBean> mList) {
        this.mList = mList;
        Log.e("aa",mList.size()+"");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.title_naonao_recycle_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }
    public void setNewData(List<Title_NaoNao_Bean.ServerInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
          final Title_NaoNao_Bean.ServerInfoBean bean = mList.get(position);
        holder.mBody.setText("#"+bean.getTitle()+"#");
        holder.mRenQi.setText("人气 "+bean.getHit()+"");
        holder.mCanYuText.setText("参与 "+bean.getCSum()+"");
        Glide.with(App.activity).load(bean.getImage()+"").into(holder.mImage);
        holder.mLinea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(App.activity, Title_Detail_NaoNao_Activity.class);
                in.putExtra("name",bean.getTitle());
                in.putExtra("renqi",bean.getHit());
                in.putExtra("canyu",bean.getCSum());
                in.putExtra("body",bean.getDescription());
                in.putExtra("image",bean.getImage());
                in.putExtra("user", (Serializable) bean.getUserList());
                App.activity.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mBody,mRenQi,mCanYuText;
        private LinearLayout mLinea;
        public MyViewHolder(View v) {
            super(v);
           mImage = (ImageView) v.findViewById(R.id.title_naonao_recycle_img);
            mBody = (TextView) v.findViewById(R.id.title_naonao_recycle_body);
            mRenQi = (TextView) v.findViewById(R.id.title_naonao_recycle_renqi_text);
            mCanYuText = (TextView) v.findViewById(R.id.title_naonao_recycle_canyu_text);
            mLinea = (LinearLayout) v.findViewById(R.id.title_naonao_recycle_item);
        }
    }
}
