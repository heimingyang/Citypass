package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.information.Shop;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/29 14:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShopAdapter extends BaseAdapter<Shop.ServerInfoBean.CommodityListBean.ContentBean> {
    public ShopAdapter(Context context, List<Shop.ServerInfoBean.CommodityListBean.ContentBean> datas) {
        super(context, R.layout.shoplist_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Shop.ServerInfoBean.CommodityListBean.ContentBean contentBean) {
        holder.setText(R.id.shop_list_name,contentBean.getTitle());
        holder.setText(R.id.shop_list_city,contentBean.getSCoin()+"币");
        holder.setText(R.id.shop_list_textOne,contentBean.getCTypeName());
        holder.setText(R.id.shop_list_num,"已售出 "+contentBean.getBuySum());
        ImageView imageView=holder.getView(R.id.shop_list_img);
        Glide.with(context).load(contentBean.getShowImages()).into(imageView);
    }
}
