package com.example.citypass.cotroller.adapter.naonao.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.detail.DetailSendBean;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/30 14:45
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DetailSendListAdapter extends BaseAdapter {
    private List<DetailSendBean.ServerInfoBean> mList;
    private Context context;
    private mViewHodler h = null;

    public DetailSendListAdapter(List<DetailSendBean.ServerInfoBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            h = new mViewHodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.naonao_detail_listviewitem, null);
            h.mTitleImage = (ImageView) convertView.findViewById(R.id.naonao_newItem_Image);
            h.mContentText = (TextView) convertView.findViewById(R.id.naonao_item_content);
            h.mTextAddress = (TextView) convertView.findViewById(R.id.naonao_itemAddress);
            h.mTime = (TextView) convertView.findViewById(R.id.naonao_itemTime);
            h.mDengjiText = (TextView) convertView.findViewById(R.id.naonao_item_dengji);
            h.mTextsofa = (TextView) convertView.findViewById(R.id.naonao_item_sofa);
            h.mTitleName = (TextView) convertView.findViewById(R.id.naonao_item_titlename);
            h.mTextContent = (TextView) convertView.findViewById(R.id.naonao_itemlistview_text);
            convertView.setTag(h);
        } else {
            h = (mViewHodler) convertView.getTag();
        }
        DetailSendBean.ServerInfoBean bean = mList.get(position);
        if (bean != null) {
            h.mTextContent.setVisibility(View.GONE);
            //评论内容
            h.mContentText.setText(bean.getBody());

            String address = bean.getMapName();
            h.mTextAddress.setText(address);

            int level = bean.getLevel();
            h.mDengjiText.setText(String.valueOf("lv :"+level));

            //得到沙发
            String lou = bean.getLou();
            h.mTextsofa.setText(lou);

            String createTime = bean.getCreateTime();
            String time = TimeUtils.getTime(createTime);
            h.mTime.setText(time);

            //得到姓名
            h.mTitleName.setText(bean.getNick());
        } else {
            h.mTextContent.setVisibility(View.VISIBLE);
        }

        Glide.with(context).load(bean.getUserface()).asBitmap().centerCrop().into(new BitmapImageViewTarget(h.mTitleImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);

                drawable.setCircular(true);

                h.mTitleImage.setImageDrawable(drawable);

            }
        });
        return convertView;
    }

    public class mViewHodler {
        private ImageView mTitleImage;
        private TextView mTitleName, mDengjiText, mContentText, mTime, mTextAddress, mTextContent, mTextsofa;

    }
}
