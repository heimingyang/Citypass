package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.cotroller.activity.find.PublishActivity;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/30 0030 18:42
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

public class Belle_Select_Adapter extends RecyclerView.Adapter<Belle_Select_Adapter.MyHolder> {
    private Context context;
    private List<String> bitmapList;
    private ImageView publishImg;
    private View inflate;
    private OnItemClickListener mOnItemClickListener = null;
    public Belle_Select_Adapter(Context context, List<String> bitmapList) {
        this.context = context;
        this.bitmapList = bitmapList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.camera_select_item, null);
        MyHolder myHolder = new MyHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    //注意这里使用getTag方法获取position
                    mOnItemClickListener.onItemClick(v,(int)v.getTag());
                }
            }
        });
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        inflate = LayoutInflater.from(context).inflate(R.layout.activity_publish, null);
        publishImg = (ImageView) inflate.findViewById(R.id.Publish_img);
        Glide.with(context).load(bitmapList.get(position)).into(holder.imageView);
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Glide.with(context).load(bitmapList.get(position)).into(publishImg);
//            }
//        });

//        holder.imageView.setImageResource(Integer.parseInt(bitmapList.get(position)));
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return bitmapList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.camera_select_img);
        }
    }

       public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
}
