package com.example.citypass.cotroller.adapter.naonao;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Title_Detail_NaoNao_Bean;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/26 0026 12:02
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


public class Title_Detail_NaoNao_Adapter extends RecyclerView.Adapter<Title_Detail_NaoNao_Adapter.Title_Detail_ViewHolder> {
    private List<Title_Detail_NaoNao_Bean.ServerInfoBean> mList;

    public Title_Detail_NaoNao_Adapter(List<Title_Detail_NaoNao_Bean.ServerInfoBean> mList) {
        this.mList = mList;
    }
    public void setNewData(List<Title_Detail_NaoNao_Bean.ServerInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }
    @Override
    public Title_Detail_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.title_detail_naonao_item,null);
        Title_Detail_ViewHolder holder = new Title_Detail_ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Title_Detail_ViewHolder holder, int position) {
        Title_Detail_NaoNao_Bean.ServerInfoBean bean = mList.get(position);
        holder.mPinLun.setText(bean.getTchild()+"");
        holder.mZanText.setText(bean.getDing()+"");
        holder.mAddress.setText(bean.getMapName()+"");
        holder.mName.setText(bean.getGambitName()+"");
        holder.mBody.setText(bean.getDescription()+"");
        holder.mTime.setText(bean.getLastTime()+"");
        Glide.with(App.activity).load(bean.getImage()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mTouXiang) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                holder.mTouXiang.setImageDrawable(ciDrawable);
            }
        });
        Glide.with(App.activity).load(bean.getImage()).into(holder.mImg);
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class Title_Detail_ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mTouXiang,mImg;
        private TextView mName,mBody,mAddress,mZanText,mPinLun,mTime;
        public Title_Detail_ViewHolder(View v) {
            super(v);
            mTouXiang = (ImageView) v.findViewById(R.id.title_detail_naonao_item_touxiang);
            mName = (TextView) v.findViewById(R.id.title_detail_naonao_item_name);
            mBody = (TextView) v.findViewById(R.id.title_detail_naonao_item_body);
            mAddress = (TextView) v.findViewById(R.id.title_detail_naonao_item_address);
            mZanText = (TextView) v.findViewById(R.id.title_detail_naonao_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.title_detail_naonao_item_pinlun);
            mTime = (TextView) v.findViewById(R.id.title_detail_naonao_item_time);
            mImg = (ImageView) v.findViewById(R.id.title_detail_naonao_item_img);
        }
    }
}
