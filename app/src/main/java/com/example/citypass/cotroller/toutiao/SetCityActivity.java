package com.example.citypass.cotroller.toutiao;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.toutiao.HSetCityAdapter;
import com.example.citypass.model.bean.toutiao.Person;
import com.example.citypass.view.HSetCityview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SetCityActivity extends BaseActivity implements HSetCityview.onWordsChangeListener {

    @BindView(R.id.list)
    ListView listView;
    @BindView(R.id.words)
    HSetCityview words;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.activity_set_city2)
    RelativeLayout activitySetCity2;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private ArrayList<Person> list;
    private HSetCityAdapter myAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_city2;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        words.setOnWordsChangeListener(this);
        initdata();
        myAdapter = new HSetCityAdapter(this,list);
        listView.setAdapter(myAdapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //当滑动列表的时候，更新右侧字母列表的选中状态
                words.setTouchIndex(list.get(firstVisibleItem).getHeaderWord());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void wordsChange(String words) {
        updataword(words);
        updateListView(words);
    }
    private void initdata() {
        list = new ArrayList<>();
        list.add(new Person("Dave"));
        list.add(new Person("阿钟"));
        list.add(new Person("杨金阳"));
        list.add(new Person("黑明阳"));
        list.add(new Person("张超"));
        list.add(new Person("赵振轩"));
        list.add(new Person("李艳东"));
        list.add(new Person("王奔"));
        list.add(new Person("李文茜"));
        list.add(new Person("王建"));
        list.add(new Person("孙铭泽"));
        list.add(new Person("续少杰"));
        list.add(new Person("胡继群"));
        list.add(new Person("隔壁老王"));
        list.add(new Person("姜宇航"));

        //对集合排序
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person lhs, Person rhs) {
                //根据拼音进行排序
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });
    }
    //更新中央字母提示
    private void updataword(String words) {
        tv.setText(words);
        tv.setVisibility(View.VISIBLE);
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setVisibility(View.GONE);
            }
        }, 500);
    }
    /**
     * @param words 首字母
     */
    private void updateListView(String words) {
        for (int i = 0; i < list.size(); i++) {
            String headerWord = list.get(i).getHeaderWord();
            //将手指按下的字母与列表中相同字母开头的项找出来
            if (words.equals(headerWord)) {
                //将列表选中哪一个
                listView.setSelection(i);
                //找到开头的一个即可
                return;
            }
        }
    }
}
