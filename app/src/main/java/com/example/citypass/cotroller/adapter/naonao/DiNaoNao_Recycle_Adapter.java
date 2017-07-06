package com.example.citypass.cotroller.adapter.naonao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.naonao.Di_NaoNao_Bean;
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


public class DiNaoNao_Recycle_Adapter extends RecyclerView.Adapter<DiNaoNao_Recycle_Adapter.MyViewHolder> {
    private List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList;

    public DiNaoNao_Recycle_Adapter(List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList) {
        this.mList = mList;
        Log.e("aaaaa",mList.size()+"");
    }

    public void setNewData(List<Di_NaoNao_Bean.ServerInfoBean.InfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.di_naonao_recycle_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Di_NaoNao_Bean.ServerInfoBean.InfoBean in = mList.get(position+3);
        holder.mCount.setText("回帖数："+in.getSum()+"");
        holder.mLevel.setText("LV."+in.getLevel()+"");
        Log.d("DiNaoNao_Recycle_Adapte", in.getLevel() + "");
        holder.mAddress.setText(in.getLifeAddr()+"");
        holder.mName.setText(in.getNick()+"");
        holder.mPaiMing.setText(position+4+"");

//        Glide.with(App.activity).load(in.getUserFace()).into(holder.mImage);

        Glide.with(App.activity).load(in.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                holder.mImage.setImageDrawable(ciDrawable);
            }
        });



        holder.mRela.setOnClickListener(new View.OnClickListener() {
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
        private TextView mPaiMing,mName,mAddress,mLevel,mCount;
        private ImageView mImage;
        private RelativeLayout mRela;
        public MyViewHolder(View itemView) {
            super(itemView);
            mPaiMing = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_paiming);
            mName = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_name);
            mAddress = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_address);
            mLevel = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_level);
            mCount = (TextView) itemView.findViewById(R.id.di_naonao_recycle_item_count);
            mImage = (ImageView) itemView.findViewById(R.id.di_naonao_recycle_item_image);
           mRela = (RelativeLayout) itemView.findViewById(R.id.di_naonao_recycle_item_hehe);

        }
    }
}