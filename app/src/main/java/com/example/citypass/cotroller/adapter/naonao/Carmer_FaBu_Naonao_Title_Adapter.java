package com.example.citypass.cotroller.adapter.naonao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Carmer_FaBu_Naonao_Title_Bean;

import java.util.List;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/2 0002 20:36
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


public class Carmer_FaBu_Naonao_Title_Adapter extends RecyclerView.Adapter<Carmer_FaBu_Naonao_Title_Adapter.Carmer_FaBu_NaoNao_TiTle_ViewHolder> {
    private List<Carmer_FaBu_Naonao_Title_Bean.ServerInfoBean> mList ;
    private Context mContext;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public Carmer_FaBu_Naonao_Title_Adapter(List<Carmer_FaBu_Naonao_Title_Bean.ServerInfoBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;

    }

    public void setNewData(List<Carmer_FaBu_Naonao_Title_Bean.ServerInfoBean> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }


    @Override
    public Carmer_FaBu_NaoNao_TiTle_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.carmer_fabu_naonao_title_item,null);
        final Carmer_FaBu_NaoNao_TiTle_ViewHolder holder = new Carmer_FaBu_NaoNao_TiTle_ViewHolder(v);
        //将创建的View注册点击事件
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    //注意这里使用getTag方法获取数据
                    mOnItemClickListener.onItemClick(v,v.getTag().toString());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(Carmer_FaBu_NaoNao_TiTle_ViewHolder holder, int position) {
       Carmer_FaBu_Naonao_Title_Bean.ServerInfoBean bean = mList.get(position);
        Glide.with(mContext).load(bean.getImage()).into(holder.mImg);
        holder.mTitle.setText("#"+bean.getTitle()+"#");
        holder.mBody.setText(bean.getDescription()+"");
        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }
    class Carmer_FaBu_NaoNao_TiTle_ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImg;
        private TextView mTitle,mBody;
        public Carmer_FaBu_NaoNao_TiTle_ViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.carmer_fabu_naonao_title_item_imng);
            mTitle = (TextView) itemView.findViewById(R.id.carmer_fabu_naonao_title_item_title);
            mBody = (TextView) itemView.findViewById(R.id.carmer_fabu_naonao_title_item_body);
        }
    }
    //定义一个接口
    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
