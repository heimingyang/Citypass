package com.example.citypass.cotroller.adapter.faxian;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.CircleImageView;
import com.example.citypass.model.bean.beele.Belle_Enjoy_Bean;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/23 0023 20:58
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

public class Belle_XinShang_Adapter extends RecyclerView.Adapter<Belle_XinShang_Adapter.MyViewHoder> {

    private List<Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> coverXinShangInfoListBeanX;
    private Context context;

    public Belle_XinShang_Adapter(List<Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> coverXinShangInfoListBeanX, Context context) {
        this.coverXinShangInfoListBeanX = coverXinShangInfoListBeanX;
        this.context = context;
    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.xinshang_item, null);
        MyViewHoder myViewHoder = new MyViewHoder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
        Belle_Enjoy_Bean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean coverXinShangInfoListBean
                = coverXinShangInfoListBeanX.get(position);
        //姓名
        String name = coverXinShangInfoListBean.getNick();
        //年龄
        String age = coverXinShangInfoListBean.getAge();
        //性别
        String sex = coverXinShangInfoListBean.getSex();
        //排名
        int number = coverXinShangInfoListBean.getNumber();
        //行业
        String positionName = coverXinShangInfoListBean.getPositionName();
        //点赞次数
        String likeTotal = coverXinShangInfoListBean.getLikeTotal();

        holder.tv_name.setText(name);
        holder.tv_num.setText(number + "");
        holder.tv_job.setText(positionName);
        holder.tv_zannum.setText("点赞数:" + likeTotal);
        holder.tv_age.setText(age+"  ");
        if (sex.equals("男")) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.xinshang_back_nan);
            holder.linearLayout.setBackground(drawable);
            Drawable drawable1 = context.getResources().getDrawable(R.drawable.nan);
            holder.img_sex.setImageDrawable(drawable1);
        } else if (sex.equals("女")) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.xinshang_back_nv);
            holder.linearLayout.setBackground(drawable);
            Drawable drawable1 = context.getResources().getDrawable(R.drawable.nv);
            holder.img_sex.setImageDrawable(drawable1);
        }
        Glide.with(context).load(coverXinShangInfoListBean.getUserface()).into(holder.img_touxiang);
    }


    @Override
    public int getItemCount() {
        return coverXinShangInfoListBeanX.size();
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        private TextView tv_num, tv_name, tv_age, tv_job, tv_zannum;
        private CircleImageView img_touxiang;
        private ImageView img_sex;
        private LinearLayout linearLayout;


        public MyViewHoder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.xinshang_item_linear);
            img_sex = (ImageView) itemView.findViewById(R.id.xinshang_item_sex);
            tv_num = (TextView) itemView.findViewById(R.id.xinshang_item_num);
            tv_name = (TextView) itemView.findViewById(R.id.xinshang_item_name);
            tv_age = (TextView) itemView.findViewById(R.id.xinshang_item_age);
            tv_job = (TextView) itemView.findViewById(R.id.xinshang_item_job);
            tv_zannum = (TextView) itemView.findViewById(R.id.xinshang_item_zan);
            img_touxiang = (CircleImageView) itemView.findViewById(R.id.xinshang_item_img);
        }
    }
}
