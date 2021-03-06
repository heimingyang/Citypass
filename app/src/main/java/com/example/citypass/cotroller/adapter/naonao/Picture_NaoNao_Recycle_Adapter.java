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
import com.example.citypass.cotroller.fragment.naonao.detail.SquareDetailBean;
import com.example.citypass.cotroller.fragment.naonao.detail.SquareNaonaoDetailActivity;
import com.example.citypass.model.bean.naonao.Picture_NaoNao_Bean;
import com.example.citypass.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/23 0023 19:39
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


public class Picture_NaoNao_Recycle_Adapter extends RecyclerView.Adapter<Picture_NaoNao_Recycle_Adapter.MyViewHolder> {
    private List<Picture_NaoNao_Bean.ServerInfoBean> mList;

    public Picture_NaoNao_Recycle_Adapter(List<Picture_NaoNao_Bean.ServerInfoBean> mList) {
        this.mList = mList;
    }
   public void setNewData(List<Picture_NaoNao_Bean.ServerInfoBean> mList){
       this.mList = mList;
       notifyDataSetChanged();
   }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.picture_naonao_recycle_item, null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Picture_NaoNao_Bean.ServerInfoBean bean = mList.get(position);
        holder.mZanText.setText(bean.getDing() + "");
        holder.mBody.setText(bean.getTitle() + "");
        holder.mTime.setText(bean.getLastTime() + "");
        holder.mName.setText(bean.getNick() + "");
        LogUtils.e("log----->", bean.getCreateTime());
        if (bean.getImageCount() > 1) {
            int i = bean.getImage().indexOf("|");
            String substring = bean.getImage().substring(0, i);
            Log.d("Picturefgdgdfecycle_", substring);
            Glide.with(App.activity).load(substring).into(holder.mImg);
        } else {
            Glide.with(App.activity).load(bean.getImage()).into(holder.mImg);
            Log.d("Picture_NaoNao_Recycle_", bean.getImage());
        }
        if (bean.getIsdaka() == 0) {
            holder.mZan.setImageResource(R.drawable.ccoo_icon_zan);
        } else {
            holder.mZan.setImageResource(R.drawable.ccoo_icon_zan_2);
        }
       holder.mLin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(App.activity, SquareNaonaoDetailActivity.class);
               String title = bean.getTitle();
               String name = bean.getNick();
               String time = bean.getLastTime();
               String image = bean.getUserFace();
               String address = bean.getMapName();
               String Images = bean.getImage();
               int id = bean.getId();
               String username = bean.getUserName();
               SquareDetailBean detailBean = new SquareDetailBean(title, name, time, image, address, Images, id,username);
               EventBus.getDefault().postSticky(detailBean);
               intent.putExtra("position", position);
               App.activity.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg, mZan;
        private TextView mZanText, mBody, mName, mTime;
        private LinearLayout mLin;
        public MyViewHolder(View v) {
            super(v);
            mImg = (ImageView) v.findViewById(R.id.picture_naonao_recycle_image);
            mZan = (ImageView) v.findViewById(R.id.pricture_naonao_recycle_item_zan);
            mZanText = (TextView) v.findViewById(R.id.pricture_naonao_recycle_item_zan_text);
            mBody = (TextView) v.findViewById(R.id.pricture_naonao_recycle_item_body);
            mName = (TextView) v.findViewById(R.id.pricture_naonao_recycle_item_name);
            mTime = (TextView) v.findViewById(R.id.pricture_naonao_recycle_item_time);
            mLin = (LinearLayout) v.findViewById(R.id.picture_naonao_recycle_z);

        }
    }

}
