package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.information.PersonalActivity;
import com.example.citypass.model.bean.information.UpGuanZhu;
import com.example.citypass.model.http.HttpFacory;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/7 10:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MailAdapter extends BaseAdapter<UpGuanZhu.ServerInfoBean> {
    public MailAdapter(Context context, List<UpGuanZhu.ServerInfoBean> datas) {
        super(context, R.layout.mail_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final UpGuanZhu.ServerInfoBean serverInfoBean) {
        ImageView view = holder.getView(R.id.mail_item_img);
        HttpFacory.create().loadImage(serverInfoBean.getRoleImg(),view,true);
        holder.setText(R.id.mail_item_name,serverInfoBean.getRoleName());
        holder.setText(R.id.mail_item_infor,serverInfoBean.getOWERSIGN());
        TextView text=holder.getView(R.id.mail_item_sex);
        String sex = serverInfoBean.getSex();
        Drawable draw=null;
        if(sex.equals("男")){
            draw=context.getResources().getDrawable(R.drawable.regist_man_check);
            draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
        }else{
            draw=context.getResources().getDrawable(R.drawable.regist_woman_check);
            draw.setBounds(0, 0, draw.getMinimumWidth(), draw.getMinimumHeight());
        }
        text.setCompoundDrawables(draw,null,null,null);
        text.setText(serverInfoBean.getAge()+"");
        holder.setOnclickListener(R.id.mail_item_Relative, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PersonalActivity.class);
                intent.putExtra("id",serverInfoBean.getUserID());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });
    }
}
