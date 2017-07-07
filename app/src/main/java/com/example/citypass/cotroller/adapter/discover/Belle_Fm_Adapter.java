package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.beele.Belle_FM_Bean;

import java.util.List;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/24 0024 17:36
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

public class Belle_Fm_Adapter extends RecyclerView.Adapter<Belle_Fm_Adapter.MyfmHolder> {
    private Context mcontext;
    private List<Belle_FM_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mlist;


    public Belle_Fm_Adapter(Context mcontext, List<Belle_FM_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @Override
    public MyfmHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.fengmian_item, null);
        MyfmHolder myfmHolder = new MyfmHolder(inflate);

        return myfmHolder;
    }

    @Override
    public void onBindViewHolder(MyfmHolder holder, int position) {
        final Belle_FM_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean figureTCoverInfoListBean
                = mlist.get(position);
        String nick = figureTCoverInfoListBean.getNick();
        String age = figureTCoverInfoListBean.getAge();
        String uXinZuo = figureTCoverInfoListBean.getUXinZuo();

        String mapName = figureTCoverInfoListBean.getMapName();
        String positionName = figureTCoverInfoListBean.getPositionName();
        String photo = figureTCoverInfoListBean.getPhoto();

        int likeTotal = figureTCoverInfoListBean.getLikeTotal();

        Glide.with(mcontext).load(photo).into(holder.fm_img);

        holder.fm_name.setText(nick);
        holder.fm_age.setText(age + "  " + uXinZuo);
        holder.fm_from.setText(mapName);
        holder.fm_job.setText(positionName);
        holder.fm_count.setText(likeTotal + "");

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, PersonalActivity.class);
                intent.putExtra("id", figureTCoverInfoListBean.getUserID());
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyfmHolder extends RecyclerView.ViewHolder {
        private ImageView fm_img;
        private TextView fm_name, fm_age, fm_lianai, fm_from, fm_job, fm_count;
        private RelativeLayout relativeLayout;


        public MyfmHolder(View itemView) {
            super(itemView);
            fm_img = (ImageView) itemView.findViewById(R.id.fengmian_item_img);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.fm_item_relative);

            fm_name = (TextView) itemView.findViewById(R.id.fengmian_item_name);
            fm_age = (TextView) itemView.findViewById(R.id.fengmian_item_age);
            fm_lianai = (TextView) itemView.findViewById(R.id.fengmian_item_lianai);
            fm_from = (TextView) itemView.findViewById(R.id.fengmian_item_from);
            fm_job = (TextView) itemView.findViewById(R.id.fengmian_item_job);
            fm_count = (TextView) itemView.findViewById(R.id.fengmian_item_count);

        }
    }
}
