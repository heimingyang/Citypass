package com.example.citypass.cotroller.adapter.discover;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.model.http.bean.faxian.MyFaXian;
import com.example.citypass.view.MyGridView;

import java.util.List;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/20 0020 19:46
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

public class MyDiscoverAdapter extends BaseAdapter {
    private List<MyFaXian.ServerInfoBean> mlist;
    private Context context;
    private MyFaXian.ServerInfoBean serverInfoBean;

    public MyDiscoverAdapter(List<MyFaXian.ServerInfoBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.isEmpty() ? 0 : mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if (convertView == null) {
            myHolder = new MyHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.faxian_listitem, null);
            myHolder.textView = (TextView) convertView.findViewById(R.id.faxian_title);
            myHolder.gridView = (MyGridView) convertView.findViewById(R.id.faxian_gridview);
            convertView.setTag(myHolder);

        } else {
            myHolder = (MyHolder) convertView.getTag();
        }
        serverInfoBean = mlist.get(position);
        Log.e("aaaaa",position+"");
        Log.e("bbbbb",serverInfoBean.getData().get(0).getTitle());
        String name = serverInfoBean.getName();
        myHolder.textView.setText(name);

        myHolder.gridView.setAdapter(new MyGrilAdapter(context,serverInfoBean));

        return convertView;
    }

    class MyHolder {
        private TextView textView;
        private GridView gridView;

    }




}
