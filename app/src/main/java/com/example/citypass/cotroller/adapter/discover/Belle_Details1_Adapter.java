package com.example.citypass.cotroller.adapter.discover;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.R;
import com.example.citypass.model.bean.beele.Belle_xq1_Bean;
import com.yuyh.library.imgsel.bean.Image;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/7/5 0005 10:05
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

public class Belle_Details1_Adapter extends BaseAdapter<Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean.CoverReplyListBean> {


    public Belle_Details1_Adapter(Context context, List<Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean.CoverReplyListBean> datas) {
        super(context, R.layout.belle_details_item, datas);
    }


    @Override
    public void convert(ViewHolder holder, Belle_xq1_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean.CoverReplyListBean mdata) {
        holder.setText(R.id.xq1_item_name, mdata.getNick())
                .setText(R.id.xq1_item_age, mdata.getAge() + " ")
                .setText(R.id.xq1_item_dj, "LV. " + mdata.getLevel() + "")
                .setText(R.id.xq1_item_time, mdata.getLastTime())
                .setText(R.id.xq1_item_location, mdata.getMapName())
                .setText(R.id.xq1_item_content, mdata.getContent());

        final ImageView imageView = (ImageView) holder.getView(R.id.xq1_item_tx);
        Glide.with(context).load(mdata.getUserface()).asBitmap().centerCrop().into(new BitmapImageViewTarget((ImageView) holder.getView(R.id.xq1_item_tx)) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                ciDrawable.setCircular(true);
                imageView.setImageDrawable(ciDrawable);
            }
        });


    }


}
