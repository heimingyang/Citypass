package com.example.citypass.cotroller.adapter.naonao;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Carmer_FaBu_NaoNao_Collect_Pop_Bean;
import com.example.citypass.view.GlideRoundTransform;

import java.util.List;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/7/7 0007 9:02
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


public class Carmer_FaBu_NaoNao_Collect_Pop_Adapter extends BaseAdapter<Carmer_FaBu_NaoNao_Collect_Pop_Bean.ServerInfoBean> {


    public Carmer_FaBu_NaoNao_Collect_Pop_Adapter(Context context, List<Carmer_FaBu_NaoNao_Collect_Pop_Bean.ServerInfoBean> datas) {
        super(context, R.layout.carmer_fabu_naonao_collect_pop_item, datas);

    }

    @Override
    public void convert(ViewHolder holder, Carmer_FaBu_NaoNao_Collect_Pop_Bean.ServerInfoBean serverInfoBean) {
        holder.setText(R.id.carmer_fabu_naonao_collect_pop_item_body,serverInfoBean.getDescription()+"");
        holder.setText(R.id.carmer_fabu_naonao_collect_pop_item_title,serverInfoBean.getTitle()+"   (剩余0个)");
        ImageView im = holder.getView(R.id.carmer_fabu_naonao_collect_pop_item_img);
        Glide.with(App.activity).load(serverInfoBean.getImages()).transform(new GlideRoundTransform(context, 10)).into(im);
        holder.setOnclickListener(R.id.carmer_fabu_naonao_collect_pop_item_dui, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "城市币余额不足 请充值", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
