package com.example.citypass.cotroller.adapter.naonao;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.citypass.R;
import com.example.citypass.model.bean.naonao.Square_NaoNao_Bean;

import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 16:10
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class NaoNao_GvAdapter extends BaseAdapter {
    private List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList;
    private Context context;

    public NaoNao_GvAdapter(List<Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     mViewHodler hodler = null;
        if(convertView == null){
            hodler = new mViewHodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_naonao_gvitem,null);
            hodler.image = (ImageView) convertView.findViewById(R.id.naonao_gv_item);
            convertView.setTag(hodler);
        }else{
            hodler = (mViewHodler) convertView.getTag();
        }
        Square_NaoNao_Bean.ServerInfoBean.GetPostWorkListBeanX.GetPostWorkListBean bean = mList.get(position);
        Log.d("NaoNao_GvAdapter", bean.getImage());
        hodler.image.setImageResource(Integer.parseInt(bean.getImage()));
        Log.d("NaoNao_GvAdapter", "mList.size():" + mList.size());
        return convertView;
    }

    class mViewHodler{
        private ImageView image;
    }
}
