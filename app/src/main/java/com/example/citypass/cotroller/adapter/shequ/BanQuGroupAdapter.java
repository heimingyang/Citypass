package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.citypass.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/26 10:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class BanQuGroupAdapter extends BaseAdapter {

    onItem item;

    public void setItem(onItem item) {
        this.item = item;
    }

    public interface onItem {
        void onItem(int position);
    }

    private View lastView;
    private List<String> list;
    private Context contxt;
    private LinearLayout lastLayout;

    public BanQuGroupAdapter(List<String> list, Context context) {
        this.list = list;
        this.contxt = context;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.contxt).inflate(R.layout.banqu_item_group, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (lastView == null) {
            holder.itemBbsBqGroupNametwo.setVisibility(View.GONE);
            holder.itemBbsBqGroupxuan.setVisibility(View.VISIBLE);

            lastView = holder.itemBbsBqGroupNametwo;
            lastLayout = holder.itemBbsBqGroupxuan;
        }
        holder.itemBbsBqGroupName.setText(list.get(position));
        holder.itemBbsBqGroupNametwo.setText(list.get(position));
        final ViewHolder finalHolder = holder;
        holder.itemBbsBqGroupNametwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastView != null) {
                    lastView.setVisibility(View.VISIBLE);
                    lastLayout.setVisibility(View.GONE);
                }
                item.onItem(position);
                lastView = finalHolder.itemBbsBqGroupNametwo;
                lastLayout = finalHolder.itemBbsBqGroupxuan;
                finalHolder.itemBbsBqGroupNametwo.setVisibility(View.GONE);
                finalHolder.itemBbsBqGroupxuan.setVisibility(View.VISIBLE);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_bbs_bq_group_name)
        TextView itemBbsBqGroupName;
        @BindView(R.id.item_bbs_bq_groupxuan)
        LinearLayout itemBbsBqGroupxuan;
        @BindView(R.id.item_bbs_bq_group_nametwo)
        TextView itemBbsBqGroupNametwo;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
