package com.example.citypass.cotroller.adapter.naonao.detail;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.naonao.detail.DetailNewBean;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/28 23:41
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailNewAdapter extends RecyclerView.Adapter<DetailNewAdapter.mViewHolder> {
    private List<DetailNewBean.ServerInfoBean> mList;
    private Context context;
    private DetailNewBean.ServerInfoBean.ClildReplyListBean listBean;

    public DetailNewAdapter(List<DetailNewBean.ServerInfoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    public void setNewData(List<DetailNewBean.ServerInfoBean> mList) {
        this.mList = mList;
        if (mList.size()>0){
            notifyDataSetChanged();
        }
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_naonao_detail_newitem, null);

        mViewHolder holder = new mViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {
        final DetailNewBean.ServerInfoBean bean = mList.get(position);
        //评论的内容
        String body = bean.getBody();
        holder.mContentText.setText(body);
//得到地址
        String address = bean.getMapName();
        holder.mTextAddress.setText(address);

        int level = bean.getLevel();
        holder.mDengjiText.setText(String.valueOf("lv :" + level));

        //得到沙发
        String lou = bean.getLou();
        holder.mTextsofa.setText(lou);

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

        holder.mTitleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonalActivity.class);
                intent.putExtra("id", bean.getUserID());
                context.startActivity(intent);


            }
        });


        //得到发表的图片
        if (bean.getImages().equals("")) {
            holder.mImageLinear.setVisibility(View.GONE);
        } else {
            holder.mImageLinear.setVisibility(View.VISIBLE);
            List<?> images = bean.getImages();
            for (Object image : images) {
                Glide.with(context).load(image).into(holder.mMsgImage);
            }

        }


        //得到么个人的等级，设置沙发，椅子等


        if (bean.getLImage().equals("")) {
            holder.mImageYizi.setVisibility(View.GONE);
            holder.mImageBenDeng.setVisibility(View.GONE);
            holder.mImageSofa.setVisibility(View.GONE);
            return;
        } else {
            String[] split = bean.getLImage().split(",");
            Glide.with(context).load(split[0]).into(holder.mImageSofa);
            if (split.length == 2) {
                Glide.with(context).load(split[0]).into(holder.mImageSofa);
                Glide.with(context).load(split[1]).into(holder.mImageBenDeng);

            } else {
                Glide.with(context).load(split[0]).into(holder.mImageSofa);
                Glide.with(context).load(split[1]).into(holder.mImageBenDeng);
                Glide.with(context).load(split[2]).into(holder.mImageYizi);
            }

        }

        //下面回复的内容
        if (bean.getClildReplyList() == null) {
            holder.mRelative.setVisibility(View.GONE);
            return;
        } else {
            holder.mRelative.setVisibility(View.VISIBLE);
            listBean = bean.getClildReplyList().get(0);
            holder.mPLcontent.setText(listBean.getBody());
            holder.mPLName.setText(listBean.getNick());
            String time1 = listBean.getCreateTime();
            String time2 = TimeUtils.getTime(time1);
            holder.mPLTime.setText(time2);

        }


    }

    @Override
    public int getItemCount() {
        return mList.size();//1
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        private ImageView mTitleImage, mMsgImage, mImageBenDeng, mImageSofa, mImageYizi;
        private TextView mTitleName, mDengjiText, mContentText, mTime, mTextAddress, mPLcontent, mPLTime, mPLName, mTextsofa;
        private RelativeLayout mRelative;
        private LinearLayout mImageLinear;

        public mViewHolder(View v) {
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
            mMsgImage = (ImageView) v.findViewById(R.id.naonao_item_imageContent);
            mImageBenDeng = (ImageView) v.findViewById(R.id.naonao_item_bandeng);
            mImageSofa = (ImageView) v.findViewById(R.id.naonao_item_sofaImage);
            mImageYizi = (ImageView) v.findViewById(R.id.naonao_item_Yizi);
            mImageLinear = (LinearLayout) v.findViewById(R.id.naonao_item_ImageLinear);

        }
    }
}
