package com.example.citypass.cotroller.adapter.naonao.detail;

import android.content.Context;
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
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.detail.DetailNewBean;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/4 19:44
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailHuiFuAdapter extends RecyclerView.Adapter<DetailHuiFuAdapter.MyHodler> {
    private List<DetailNewBean.ServerInfoBean.ClildReplyListBean> mList;
    private Context context;

    public DetailHuiFuAdapter(List<DetailNewBean.ServerInfoBean.ClildReplyListBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public MyHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_naonao_detail_newitem, null);

        MyHodler hodler = new MyHodler(v);


        return hodler;
    }

    @Override
    public void onBindViewHolder(final MyHodler holder, int position) {
        DetailNewBean.ServerInfoBean.ClildReplyListBean bean = mList.get(position);

        //评论的内容
        String body = bean.getBody();
        holder.mContentText.setText(body);
        //得到地址
        String address = bean.getAudio();
        holder.mTextAddress.setText(address);
        //等级
        String ding = bean.getDing();
        holder.mDengjiText.setText("lv :" + ding);

        //得到沙发
        String atUser = bean.getAtUser();
        holder.mTextsofa.setText(atUser + "");

        String createTime = bean.getCreateTime();
        String time = TimeUtils.getTime(createTime);
        holder.mTime.setText(time);
        Log.d("DetailNewAdapter", time);

        //得到姓名

        holder.mTitleName.setText(bean.getNick());

        //加载圆形头像


        Glide.with(context).load(bean.getUserface()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mTitleImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);

                drawable.setCircular(true);

                holder.mTitleImage.setImageDrawable(drawable);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHodler extends RecyclerView.ViewHolder {
        private ImageView mTitleImage, mMsgImage;
        private TextView mTitleName, mDengjiText, mContentText, mTime, mTextAddress, mPLcontent, mPLTime, mPLName, mTextsofa;
        private RelativeLayout mRelative;

        public MyHodler(View v) {
            super(v);
            mTitleImage = (ImageView) v.findViewById(R.id.naonao_newItem_Image);
            mMsgImage = (ImageView) v.findViewById(R.id.naonao_item_imageMsg);
            mTitleName = (TextView) v.findViewById(R.id.naonao_item_titlename);
            mDengjiText = (TextView) v.findViewById(R.id.naonao_item_dengji);
            mContentText = (TextView) v.findViewById(R.id.naonao_item_content);
            mTime = (TextView) v.findViewById(R.id.naonao_itemTime);
            mTextAddress = (TextView) v.findViewById(R.id.naonao_itemAddress);
            mPLName = (TextView) v.findViewById(R.id.naonao_item_pinName);
            mPLcontent = (TextView) v.findViewById(R.id.naonao_item_pinContent);
            mPLTime = (TextView) v.findViewById(R.id.naonao_item_pinTime);
            mTextsofa = (TextView) v.findViewById(R.id.naonao_item_sofa);
            mRelative = (RelativeLayout) v.findViewById(R.id.nanao_item_TwoRelative);

        }
    }
}
