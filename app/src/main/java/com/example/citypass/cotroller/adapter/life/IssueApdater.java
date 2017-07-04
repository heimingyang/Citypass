package com.example.citypass.cotroller.adapter.life;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.citypass.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.citypass.R.id.view;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/4 8:58
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IssueApdater extends PagerAdapter {
    private Context mContext;

    public IssueApdater(Context mContext) {
        this.mContext = mContext;
    }

    private int[] biaoqing={R.drawable.sys1,R.drawable.sys2,R.drawable.sys3,R.drawable.sys4
    ,R.drawable.sys5,R.drawable.sys6,R.drawable.sys7,R.drawable.sys8,R.drawable.sys9,R.drawable.sys10,R.drawable.sys11,R.drawable.sys12
    ,R.drawable.sys13,R.drawable.sys14,R.drawable.sys15,R.drawable.sys16,R.drawable.sys17,R.drawable.sys18
    };
    private int[] biaoqingOne={R.drawable.sys19,R.drawable.sys20
            ,R.drawable.sys21,R.drawable.sys22,R.drawable.sys23,R.drawable.sys24,R.drawable.sys25,R.drawable.sys26,R.drawable.sys27,R.drawable.sys28
            ,R.drawable.sys29,R.drawable.sys30,R.drawable.sys31,R.drawable.sys32,R.drawable.sys33,R.drawable.sys34,R.drawable.sys35,R.drawable.sys36};
    private int[] biaoqingTwo={
            R.drawable.sys37,R.drawable.sys38,R.drawable.sys39,R.drawable.sys40,R.drawable.sys41,R.drawable.sys42,R.drawable.sys43,R.drawable.sys44
            ,R.drawable.sys45,R.drawable.sys46,R.drawable.sys47,R.drawable.sys48,R.drawable.sys49,R.drawable.sys50,R.drawable.sys51
    };
    private List<int[]> mList=new ArrayList<>();
    @Override
    public int getCount() {
        mList.add(biaoqing);
        mList.add(biaoqingOne);
        mList.add(biaoqingTwo);
        return 3;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v =LayoutInflater.from(mContext).inflate(R.layout.issue_post_grid,null);
        GridView gridView= (GridView) v.findViewById(R.id.issue_grid);
        int[] ints = mList.get(position);
        BiaoQingAdapter adapter=new BiaoQingAdapter(ints);
        gridView.setAdapter(adapter);
        container.addView(v);
        return v;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    class BiaoQingAdapter extends BaseAdapter{
        private int[] a;

        public BiaoQingAdapter(int[] a) {
            this.a = a;
        }

        @Override
        public int getCount() {
            return a.length;
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
            convertView= LayoutInflater.from(mContext).inflate(R.layout.issue_item,null);
            ImageView view= (ImageView) convertView.findViewById(R.id.issue_grid_item);
            view.setImageResource(a[position]);
            return convertView;
        }
    }
}
