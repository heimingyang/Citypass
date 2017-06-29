package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.information.CityActivity;
import com.example.citypass.cotroller.fragment.information.TaskActivity;
import com.example.citypass.cotroller.fragment.life.WebViewActivity;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/29 10:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShopViewAdapter extends StaticPagerAdapter {
    private Context context;

    public ShopViewAdapter(Context context) {
        this.context = context;
    }

    private int[] mList={R.drawable.mall_guanggao1,R.drawable.mall_guanggao2,R.drawable.mall_guanggao3};

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        Glide.with(container.getContext()).load(mList[position]).diskCacheStrategy(DiskCacheStrategy.ALL).into(view);
        if(position==0){
            onClickOne(view);
        }else if(position==1){
            onClickTwo(view);
        }else if(position==2){
            onClickThree(view);
        }
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    private void onClickOne(ImageView view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, CityActivity.class);
                context.startActivity(intent);
            }
        });
    }

    private void onClickTwo(ImageView view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, TaskActivity.class);
                context.startActivity(intent);
            }
        });
    }

    private void onClickThree(ImageView view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwo = new Intent(context, WebViewActivity.class);
                intentTwo.putExtra("url","http://m.yanqing.ccoo.cn/choujiang.aspx");
                intentTwo.putExtra("webview_title","抽奖活动");
                context.startActivity(intentTwo);
            }
        });
    }

    @Override
    public int getCount() {
        return mList.length;
    }
}
