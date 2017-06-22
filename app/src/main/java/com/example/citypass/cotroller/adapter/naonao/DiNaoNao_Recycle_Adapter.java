package com.example.citypass.cotroller.adapter.naonao;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Di_NaoNao_Bean;

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


public class DiNaoNao_Recycle_Adapter extends RecyclerView.Adapter<DiNaoNao_Recycle_Adapter.MyViewHolder> {
private List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList;

    public DiNaoNao_Recycle_Adapter(List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.di_naonao_recycle_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Di_NaoNao_Bean.ServerInfoBean.InfoBean in = mList.get(position+3);
        holder.mCount.setText("回帖数："+in.getSum()+"");
        holder.mLevel.setText("LV."+in.getLevel()+"");
        Log.d("DiNaoNao_Recycle_Adapte", in.getLevel() + "");

        holder.mAddress.setText(in.getLifeAddr()+"");
        holder.mName.setText(in.getNick()+"");
        holder.mPaiMing.setText(position+4+"");
        Glide.with(App.activity).load(in.getUserFace()).into(holder.mImage);
        if(mList.size() == position){
            in = mList.get(position+3);
        }
    }



    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size()-3;
    }
    class  MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mPaiMing,mName,mAddress,mLevel,mCount;
        private ImageView mImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            mPaiMing = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_paiming);
            mName = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_name);
            mAddress = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_address);
            mLevel = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_level);
            mCount = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_count);
            mImage = (ImageView) itemView.findViewById(R.id.di_naonao_recycle_item_image);
        }
    }
}
