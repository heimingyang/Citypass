package com.example.citypass.cotroller.adapter.naonao;

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
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Recommond_NaoNao_Bean;

import java.util.ArrayList;
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


public class Recommond_NaoNao_Recycle_Adapter extends RecyclerView.Adapter<Recommond_NaoNao_Recycle_Adapter.MyViewHolder> {
    private List<Recommond_NaoNao_Bean.ServerInfoBean> mList;
    private OnItemClikListener onItemClikListener;
    private List<String> strList = new ArrayList<>();
    private LinearLayout myGridLayout;

    public void setOnItemClikListener(OnItemClikListener onItemClikListener) {
        this.onItemClikListener = onItemClikListener;
    }
    public Recommond_NaoNao_Recycle_Adapter(List<Recommond_NaoNao_Bean.ServerInfoBean> mList) {
        this.mList = mList;
        Log.e("aaa", mList.size() + "");
    }
    public void setNewData(List<Recommond_NaoNao_Bean.ServerInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.square_naonao_recycle_item, null);
        v.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recommond_NaoNao_Bean.ServerInfoBean bean = mList.get(position);

        holder.mPinLun.setText(bean.getDing() + "");
        holder.mZan.setText(bean.getTchild() + "");
        holder.mAddress.setText(bean.getMapName() + "");
        holder.mBody.setText(bean.getTitle() + "");
        holder.mLevel.setText("lv." + bean.getLevel() + "");
        holder.mName.setText(bean.getNick() + "");
        holder.mTime.setText(bean.getLastTime() + "");
        final ImageView img = holder.mTouXiang;
        Glide.with(App.activity).load(bean.getUserFace()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(App.activity.getResources(), resource);
                ciDrawable.setCircular(true);
                img.setImageDrawable(ciDrawable);
            }
        });

        if (bean.getReplyJson1() != null) {
            holder.mTextPinLunName.setText(bean.getReplyJson1().getNick() + " : ");
            holder.mTextPinLun.setText(bean.getReplyJson1().getContent() + "");
        } else {
            holder.mTextPinLun.setVisibility(View.GONE);
            holder.mTextPinLunName.setVisibility(View.GONE);
        }
        //得到所有的网址，
        String images = bean.getImage();
        if (images != null) {
//            if (bean.getImageCount() > 1) {
//                holder.mOne.setVisibility(View.VISIBLE);
//                holder.mImageView.setVisibility(View.VISIBLE);
//                holder.mImageView_One.setVisibility(View.VISIBLE);
//                int i = bean.getImage().indexOf("|");
//                String substring = bean.getImage().substring(0, i);
//                Glide.with(App.activity).load(substring).into(holder.mImageView);
//                String substring1 = bean.getImage().substring(i + 1, bean.getImage().length());
//                Glide.with(App.activity).load(substring1).into(holder.mImageView_One);
//            } else {
//                holder.mOne.setVisibility(View.VISIBLE);
//                holder.mImageView.setVisibility(View.VISIBLE);
//                holder.mImageView_One.setVisibility(View.GONE);
//                holder.mImageView_Two.setVisibility(View.GONE);
//
//                Glide.with(App.activity).load(bean.getImage()).into(holder.mImageView);
//
//            }
//        } else {
//            holder.mOne.setVisibility(View.GONE);
//            holder.mTwo.setVisibility(View.GONE);
//        }
            String[] split = images.split("\\|");
//            strList.clear();
//            for (String s : split) {
//
//                Log.d("Square_NaoNao_Recycle_A", s);
//                strList.add(s);
//            }
//            myGridLayout.setmList(strList);
        }
    }
    @Override
    public int getItemViewType(int position) {


        return super.getItemViewType(position);
    }
    //要在数据中截取到imageview url路径的方法
    private String getJson_Url(String jsons) {

        /**
         * 判断json串里有没有“|”
         * 有的话就让它把从开始到“|”前面的截取走
         * 如果没有了就让它直接从0截取到json串结束
         * */

        if (jsons.contains("|")) {
            //第一个"|"出现的索引
            int i = jsons.indexOf("|");
            String sub = jsons.substring(0, i)+"|";
            Log.i("截取出来的img--------->", sub);
            getJson_Url(sub);
            return jsons.substring(i, jsons.length());

        } else {
            return jsons;
        }


    }




    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mTouXiang, mImageView,mImageView_One,mImageView_Two,mImageView_Three,mImageView_Four,mImageView_Five;
        private TextView mName, mLevel, mTime, mBody, mAddress, mZan, mPinLun, mTextPinLun, mTextPinLunName;
        private LinearLayout mOne,mTwo;
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
            mTextPinLunName = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun_name);
            mTextPinLun = (TextView) v.findViewById(R.id.square_naonao_recycle_item_text_pinlun);
//            mImageView = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView);
//            mImageView_One = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_one);
//            mImageView_Two = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_two);
            mImageView_Three = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_three);
            mImageView_Four = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_four);
            mImageView_Five = (ImageView) v.findViewById(R.id.square_naonao_recycle_item_imageView_five);
            mOne = (LinearLayout) v.findViewById(R.id.square_naonao_recycle_item_img_one);
            mTwo = (LinearLayout) v.findViewById(R.id.square_naonao_recycle_item_img_two);
            //自定义点击事件
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClikListener.ItemClick(getLayoutPosition());
                }
            });
        }
    }

    public interface OnItemClikListener {

        void ItemClick(int positon);
    }


}
