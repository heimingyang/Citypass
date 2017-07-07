package com.example.citypass.cotroller.fragment.shequ;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.model.ddb.MyManger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 王奔 on 2017/5/25.
 */

public class SearchListFragment extends BaseFragment {
    @BindView(R.id.Search_List)
    ListView SearchList;
    @BindView(R.id.Text_Clear)
    TextView TextClear;
    Unbinder unbinder;

    private List<String> mList = new ArrayList<>();
    private MyManger manager;
    private MyAdapter mAdapter;
    private FragmentManager fragmentManager = App.activity.getSupportFragmentManager();
    private FragmentTransaction transaction;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    @Override
    public int getLayoutId() {
        return R.layout.search_list;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

        manager = new MyManger(getActivity().getApplicationContext());
        mList = manager.getList();
        mAdapter = new MyAdapter();
        if (mList != null) {
            SearchList.setAdapter(mAdapter);
            TextClear.setVisibility(View.VISIBLE);
        } else {
            TextClear.setText("");
        }
        mShared = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    @Override
    public void initListener() {
        SearchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mList.get(position);
                mEditor.putString("name", s);
                mEditor.commit();
               /* transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.Search_FrameLayout, new SearchFragment());
                transaction.commit();*/
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.Text_Clear)
    public void onViewClicked() {
        mList.clear();
        manager.delete();
        mAdapter.notifyDataSetChanged();
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder = null;
            if (convertView == null) {
                holder = new Holder();
                convertView = LayoutInflater.from(getActivity().getApplication()).inflate(R.layout.list_item, null);
                holder.mText = (TextView) convertView.findViewById(R.id.ListView_Text);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            String ss = mList.get(position);
            holder.mText.setText(ss + "");
            return convertView;
        }

        class Holder {
            private TextView mText;
        }
    }
}
