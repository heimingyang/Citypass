package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.citypass.R;
import com.example.citypass.model.bean.shequ.BanQuBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/26 9:57
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class BanQuAdapter extends BaseAdapter {

    private List<BanQuBean.ServerInfoBean> list;
    private Context context;
    private int isc = 0;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void on(int position);

    }
    boolean isUser;
    public BanQuAdapter(Context context, List<BanQuBean.ServerInfoBean> list) {
        this.context = context;
        this.list = list;
    }
    public void setIsc(int isc) {
        this.isc = isc;
    }

    @Override
    public int getCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.banqu_item_child, null);
            holder = new ViewHolder(convertView);
            holder.itemBbsBqChildGzcount = (TextView) convertView.findViewById(R.id.item_bbs_bq_child_gzcount);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (list.get(position).isShowTwo()) {
            holder.itemBbsBqChildTwo.setVisibility(View.VISIBLE);
            holder.itemBbsBqChildTwoname.setText(list.get(position).getParentName());
        } else {
            holder.itemBbsBqChildTwo.setVisibility(View.GONE);
        }

        holder.itemBbsBqChildName.setText(list.get(position).getBoardName());
        holder.itemBbsBqChildGzcount.setText("关注：" + list.get(position).getFollowNum() + "");
        Glide.with(context).load(list.get(position).getIcon()).into(holder.itemBbsBqChildIv);
//        Toast.makeText(contxt, list.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        final ViewHolder finalHolder = holder;
        if (list.get(position).isChax()) {
            holder.itemBbsBqChildGz.setChecked(true);
        } else {
            holder.itemBbsBqChildGz.setChecked(false);
        }
        holder.itemBbsBqChildGz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    //Toast.makeText(context, "已关注~", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, "已取消关注~", Toast.LENGTH_SHORT).show();

                }
            }
        });

        if (list.get(position).isChax()) {
            holder.itemBbsBqChildGz.setChecked(true);
            isUser = false;

        } else {
            holder.itemBbsBqChildGz.setChecked(false);
            isUser = false;
        }


        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.item_bbs_bq_child_twoname)
        TextView itemBbsBqChildTwoname;
        @BindView(R.id.item_bbs_bq_child_two)
        LinearLayout itemBbsBqChildTwo;
        @BindView(R.id.item_bbs_bq_child_iv)
        ImageView itemBbsBqChildIv;
        @BindView(R.id.item_bbs_bq_child_name)
        TextView itemBbsBqChildName;
        @BindView(R.id.item_bbs_bq_child_gzcount)
        TextView itemBbsBqChildGzcount;
        @BindView(R.id.item_bbs_bq_child_gz)
        CheckBox itemBbsBqChildGz;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
