package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.beele.Belle_QiZhi_Bean;
import com.example.citypass.view.ImageViewPlus;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 0026 14:20
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

public class Belle_QZ_Adapter extends RecyclerView.Adapter<Belle_QZ_Adapter.MyQZHolder> {
    private List<Belle_QiZhi_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> mlist;
    private Context mcontext;

    public Belle_QZ_Adapter(List<Belle_QiZhi_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    public void setMlist(List<Belle_QiZhi_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean> mlist) {
        this.mlist = mlist;
    }

    @Override

    public MyQZHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.zuixin_item, null);
        MyQZHolder myxinHolder = new MyQZHolder(inflate);

        return myxinHolder;
    }

    @Override
    public void onBindViewHolder(MyQZHolder holder, int position) {
        Belle_QiZhi_Bean.ServerInfoBean.CoverPhotoDetailsInfoBeanX.CoverPhotoDetailsInfoBean coverPhotoDetailsInfoBean
                = mlist.get(position);
        //头像
        String photo = coverPhotoDetailsInfoBean.getPhoto();
        //名字
        String nick = coverPhotoDetailsInfoBean.getNick();

        //年龄
        String positionName = coverPhotoDetailsInfoBean.getPositionName();

        //来自
        String mapName = coverPhotoDetailsInfoBean.getMapName();

        //时间
        String createTime = coverPhotoDetailsInfoBean.getCreateTime();

        Glide.with(mcontext).load(photo).into(holder.imageView);

        holder.tv_name.setText(nick);

        holder.tv_age.setText(positionName);

        holder.tv_from.setText(mapName);

        holder.tv_time.setText(createTime);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyQZHolder extends RecyclerView.ViewHolder {
        private ImageViewPlus imageView;
        private TextView tv_name, tv_age, tv_from, tv_time;


        public MyQZHolder(View itemView) {
            super(itemView);
            imageView = (ImageViewPlus) itemView.findViewById(R.id.zuixin_item_img);
            tv_name = (TextView) itemView.findViewById(R.id.zuixin_item_name);
            tv_age = (TextView) itemView.findViewById(R.id.zuixin_item_age);
            tv_from = (TextView) itemView.findViewById(R.id.zuixin_item_from);
            tv_time = (TextView) itemView.findViewById(R.id.zuixin_item_time);

        }
    }
}
