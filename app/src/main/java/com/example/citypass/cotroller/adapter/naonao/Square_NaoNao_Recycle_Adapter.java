package com.example.citypass.cotroller.adapter.naonao;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Square_NaoNao_Bean;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/22 0022 1:10
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


public class Square_NaoNao_Recycle_Adapter extends RecyclerView.Adapter<Square_NaoNao_Recycle_Adapter.MyViewHolder> {
     private List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList;

    public Square_NaoNao_Recycle_Adapter(List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.square_naonao_recycle_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean bean = mList.get(position);
        holder.mTextPinLun.setText(bean.getLastNick());
        holder.mPinLun.setText(bean.getDing()+"");
        holder.mZan.setText(bean.getTchild()+"");
        holder.mAddress.setText(bean.getMapName()+"");
        holder.mBody.setText(bean.getTitle()+"");
        holder.mLevel.setText("lv."+bean.getLevel()+"");
        holder.mName.setText(bean.getNick()+"");
        holder.mTime.setText(bean.getLastTime()+"");
        Glide.with(App.activity).load(bean.getUserFace()).into(holder.mTouXiang);

    }



    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mTouXiang;
        private TextView mName,mLevel,mTime,mBody,mAddress,mZan,mPinLun,mTextPinLun;
        public MyViewHolder(View v) {
            super(v);
            mTouXiang = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_touxiang);
            mName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_name);
            mLevel = (TextView) v.findViewById(R.id.square_naonao_recycle_item_level);
            mTime = (TextView) v.findViewById(R.id.square_naonao_recycle_item_time);
            mBody = (TextView) v.findViewById(R.id.square_naonao_recycle_item_body);
            mAddress = (TextView) v.findViewById(R.id.square_naonao_recycle_item_address);
            mZan = (TextView) v.findViewById(R.id.square_naonao_recycle_item_zan);
            mPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_pinlun);
            mTextPinLun  = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
        }
    }
}
