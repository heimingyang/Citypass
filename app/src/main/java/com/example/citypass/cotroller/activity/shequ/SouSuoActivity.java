package com.example.citypass.cotroller.activity.shequ;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.shequ.SouSuoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/23 21:15
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class SouSuoActivity extends BaseActivity {
    @BindView(R.id.sousuo_editext)
    EditText sousuoEditext;
    @BindView(R.id.qingcu)
    ImageView qingcu;
    @BindView(R.id.quxiao)
    TextView quxiao;
    @BindView(R.id.weisousuo)
    LinearLayout weisousuo;
    @BindView(R.id.mListView)
    ListView mListView;
    @BindView(R.id.qingcu_Btn)
    Button qingcuBtn;
    @BindView(R.id.mListView_layout)
    RelativeLayout mListViewLayout;
    private List<String> list;
    private SouSuoAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shequ_sousuo;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        adapter = new SouSuoAdapter(this, list);
        mListView.setAdapter(adapter);
        sousuoEditext.addTextChangedListener(new TextWatcher() {
            //改变前
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                weisousuo.setVisibility(View.VISIBLE);
                qingcu.setVisibility(View.GONE);
                quxiao.setText("取消");
            }

            //改变中
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                weisousuo.setVisibility(View.GONE);
                if (count == 0) {
                    weisousuo.setVisibility(View.VISIBLE);
                    qingcu.setVisibility(View.GONE);
                    quxiao.setText("取消");
                    mListViewLayout.setVisibility(View.GONE);
                } else if (count > 0) {
                    qingcu.setVisibility(View.VISIBLE);
                    quxiao.setText("搜索");
                    weisousuo.setVisibility(View.GONE);
                    mListViewLayout.setVisibility(View.VISIBLE);
                }
            }

            //改变后
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.qingcu, R.id.quxiao, R.id.qingcu_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qingcu:
                sousuoEditext.setText(null);
                break;
            case R.id.quxiao:
                if (quxiao.getText().toString().trim().equals("取消")) {
                    this.finish();
                } else if (quxiao.getText().toString().trim().equals("搜索")) {

                    //Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                    list.add(sousuoEditext.getText().toString().trim());
                    if(list.size()>0){
                        qingcuBtn.setVisibility(View.VISIBLE);
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.qingcu_Btn:
                list.removeAll(list);

                if(list.size()==0){
                    qingcuBtn.setVisibility(View.GONE);
                }
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
