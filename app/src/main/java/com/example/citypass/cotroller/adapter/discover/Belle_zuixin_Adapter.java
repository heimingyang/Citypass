package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.cotroller.activity.find.Find_DetailsActivity;
import com.example.citypass.model.bean.beele.Beele_Zuixin_Bean;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.view.ImageViewPlus;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/24 0024 11:28
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

public class Belle_zuixin_Adapter extends RecyclerView.Adapter<Belle_zuixin_Adapter.MyxinHolder> {
    private List<Beele_Zuixin_Bean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> mlist;
    private Context mcontext;

    public Belle_zuixin_Adapter(List<Beele_Zuixin_Bean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    public void setMlist(List<Beele_Zuixin_Bean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> mlist) {
        this.mlist = mlist;
    }

    @Override

    public MyxinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.zuixin_item, null);
        MyxinHolder myxinHolder = new MyxinHolder(inflate);

        return myxinHolder;
    }

    @Override
    public void onBindViewHolder(MyxinHolder holder, int position) {
        final Beele_Zuixin_Bean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean newTCoverInfoListBean
                = mlist.get(position);
        //头像
        String photo = newTCoverInfoListBean.getPhoto();
        //名字
        String nick = newTCoverInfoListBean.getNick();

        //年龄
        String positionName = newTCoverInfoListBean.getPositionName();

        //来自
        String mapName = newTCoverInfoListBean.getMapName();

        //时间
        String createTime = newTCoverInfoListBean.getCreateTime();

        Glide.with(mcontext).load(photo).into(holder.imageView);

        holder.tv_name.setText(nick);

        holder.tv_age.setText(positionName);

        holder.tv_from.setText(mapName);

        holder.tv_time.setText(createTime);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
//                    Toast.makeText(mcontext, "请先登录", Toast.LENGTH_SHORT).show();
//                } else {
                    Intent intent = new Intent(mcontext, Find_DetailsActivity.class);
                    intent.putExtra("id", newTCoverInfoListBean.getId());
                    mcontext.startActivity(intent);
//                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyxinHolder extends RecyclerView.ViewHolder {
        private ImageViewPlus imageView;
        private TextView tv_name, tv_age, tv_from, tv_time;
        private RelativeLayout relativeLayout;


        public MyxinHolder(View itemView) {
            super(itemView);
            imageView = (ImageViewPlus) itemView.findViewById(R.id.zuixin_item_img);
            tv_name = (TextView) itemView.findViewById(R.id.zuixin_item_name);
            tv_age = (TextView) itemView.findViewById(R.id.zuixin_item_age);
            tv_from = (TextView) itemView.findViewById(R.id.zuixin_item_from);
            tv_time = (TextView) itemView.findViewById(R.id.zuixin_item_time);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.zuixin_relative);

        }
    }
}
