package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.R;
import com.example.citypass.model.bean.beele.Belle_Xrx_Bean;
import com.example.citypass.utils.LogUtils;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 0026 9:30
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

public class Belle_Xrx_Adapter extends RecyclerView.Adapter<Belle_Xrx_Adapter.MyXrxHolder> {
    private List<Belle_Xrx_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mlist;
    private Context mcontext;

    public Belle_Xrx_Adapter(List<Belle_Xrx_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    public void setList(List<Belle_Xrx_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> mlist) {
        this.mlist = mlist;

    }

    @Override
    public MyXrxHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.xinrenxiu_item, null);
        MyXrxHolder myXrxHolder = new MyXrxHolder(view);
        return myXrxHolder;
    }

    @Override
    public void onBindViewHolder(final MyXrxHolder holder, int position) {
        Belle_Xrx_Bean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean figureTCoverInfoListBean
                = mlist.get(position);

        String nick = figureTCoverInfoListBean.getNick();
        String age = figureTCoverInfoListBean.getAge();
        String positionName = figureTCoverInfoListBean.getPositionName();
        String mapName = figureTCoverInfoListBean.getMapName();
        String createTime = figureTCoverInfoListBean.getCreateTime();
        String photo = figureTCoverInfoListBean.getPhoto();
        holder.tv_time.setText(nick);
        holder.tv_age.setText(" " + age + " ");
        holder.tv_job.setText(positionName);
        holder.tv_from.setText(mapName);
        holder.tv_time.setText(createTime);

        Glide.with(mcontext).load(photo).into(holder.img_touxiang);
        Glide.with(mcontext).load(photo).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.img_touxiang) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable ciDrawable = RoundedBitmapDrawableFactory.create(mcontext.getResources(), resource);
                ciDrawable.setCircular(true);
                holder.img_touxiang.setImageDrawable(ciDrawable);
            }
        });

        String picUrls = figureTCoverInfoListBean.getPicUrls();
        int i = picUrls.indexOf(",");
        //第一个图片
        String substring = picUrls.substring(0, i);
        LogUtils.e("第一个图片", substring);
        Glide.with(mcontext).load(substring).into(holder.img_1);

        //第二张图片
        String substring1 = picUrls.substring(i + 1, picUrls.length());
        LogUtils.e("剩下的字符串", substring);
        int i1 = substring1.indexOf(",");
        String substring2 = substring1.substring(0, i1);
        LogUtils.e("第二张图片", substring2);
        Glide.with(mcontext).load(substring2).into(holder.img_2);


        //第三张图片
        String substring3 = substring1.substring(i1 + 1, substring1.length());
        LogUtils.e("第三章图片", substring3);
        Glide.with(mcontext).load(substring3).into(holder.img_3);


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyXrxHolder extends RecyclerView.ViewHolder {
        private ImageView img_touxiang;
        private ImageView img_1, img_2, img_3;


        private TextView tv_name, tv_age, tv_job, tv_from, tv_time;

        public MyXrxHolder(View itemView) {
            super(itemView);
            img_touxiang = (ImageView) itemView.findViewById(R.id.xinrenxiu_img);
            img_1 = (ImageView) itemView.findViewById(R.id.xinrenxiu_item_img1);
            img_2 = (ImageView) itemView.findViewById(R.id.xinrenxiu_item_img2);
            img_3 = (ImageView) itemView.findViewById(R.id.xinrenxiu_item_img3);
            tv_name = (TextView) itemView.findViewById(R.id.xinrenxiu_item_name);
            tv_age = (TextView) itemView.findViewById(R.id.xinrenxiu_item_age);
            tv_job = (TextView) itemView.findViewById(R.id.xinrenxiu_item_job);
            tv_from = (TextView) itemView.findViewById(R.id.xinrenxiu_item_from);
            tv_time = (TextView) itemView.findViewById(R.id.xinrenxiu_item_time);

        }
    }
}
