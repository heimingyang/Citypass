package com.example.citypass.cotroller.adapter.naonao;

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
import com.example.citypass.model.bean.naonao.Carmer_FaBu_AiTe_NaoNao_Bean;

import java.util.List;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/5 0005 15:30
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


public class Carmer_FaBu_AiTe_NaoNao_Adapter extends BaseAdapter {
    private List<Carmer_FaBu_AiTe_NaoNao_Bean.ServerInfoBean> mList;
    private Context mContext;

    public Carmer_FaBu_AiTe_NaoNao_Adapter(List<Carmer_FaBu_AiTe_NaoNao_Bean.ServerInfoBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    public void setNewData(List<Carmer_FaBu_AiTe_NaoNao_Bean.ServerInfoBean> mlist){
        this.mList = mlist;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.isEmpty()?0:mList.size();
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
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.carmer_fabu_aite_naonao_item,null);
            holder.mImg = (ImageView) convertView.findViewById(R.id.carmer_fabu_aite_naonao_item_img);
            holder.mXaun = (ImageView) convertView.findViewById(R.id.carmer_fabu_aite_naonao_item_xuan);
            holder.mText = (TextView) convertView.findViewById(R.id.carmer_fabu_aite_naonao_item_text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Carmer_FaBu_AiTe_NaoNao_Bean.ServerInfoBean bean = mList.get(position);
        holder.mText.setText(bean.getRoleName()+"");
        final ViewHolder finalHolder = holder;
        Glide.with(mContext).load(bean.getRoleImg()).asBitmap().centerCrop().into(new BitmapImageViewTarget(finalHolder.mImg) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                ciDrawable.setCircular(true);
                finalHolder.mImg.setImageDrawable(ciDrawable);
            }
        });
//        holder.mXaun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finalHolder.mXaun.setImageResource(R.drawable.btn_choose_photo_s);
//
//            }
//        });
         return convertView;
    }
     class ViewHolder {
         private ImageView mImg,mXaun;
         private TextView mText;

     }
}
