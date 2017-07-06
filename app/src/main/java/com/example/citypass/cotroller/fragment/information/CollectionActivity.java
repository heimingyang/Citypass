package com.example.citypass.cotroller.fragment.information;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压卫士
 * 类描述: 我的兑换
 * 创建人: 马杰
 * 创建时间: 2017/6/27 19:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CollectionActivity extends BaseActivity {
    @BindView(R.id.collection_back)
    ImageView collectionBack;
    @BindView(R.id.collection_Relative)
    RelativeLayout collectionRelative;
    @BindView(R.id.collection_Text_one)
    TextView collectionTextOne;
    @BindView(R.id.collection_Text_two)
    TextView collectionTextTwo;
    @BindView(R.id.collection_Text_three)
    TextView collectionTextThree;
    @BindView(R.id.collection_Text_four)
    TextView collectionTextFour;
    @BindView(R.id.collection_Text_five)
    TextView collectionTextFive;
    @BindView(R.id.collection_Text_six)
    TextView collectionTextSix;
    @BindView(R.id.collection_Text_seven)
    TextView collectionTextSeven;
    @BindView(R.id.collection_RelativeOne)
    RelativeLayout collectionRelativeOne;
    @BindView(R.id.collection_List)
    ListView collectionList;
    @BindView(R.id.collection_Text)
    TextView collectionText;
    @BindView(R.id.collection_Title)
    TextView collectionTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        String title = intent.getStringExtra("title");
        int id = intent.getIntExtra("id", 0);
        if(title==null) {
            collectionTitle.setText("收藏列表");
        }else{
            collectionTitle.setText(title);
        }
        setView(type);
    }

    private void setView(int type){
        if(type==0){
            collectionTextOne.setOnClickListener(clickOne);
            collectionTextTwo.setOnClickListener(clickOne);
            collectionTextThree.setOnClickListener(clickOne);
            collectionTextFour.setOnClickListener(clickOne);
            collectionTextFive.setOnClickListener(clickOne);
            collectionTextSix.setOnClickListener(clickOne);
        }else if(type==3){
            collectionTextOne.setText("找工作");
            collectionTextTwo.setText("新楼盘");
            collectionTextThree.setText("找房子");
            collectionTextFour.setText("二手信息");
            collectionTextFive.setText("车辆买卖");
            collectionTextSix.setText("生活服务");
            collectionTextSeven.setText("黄页大全");
            collectionTextSeven.setVisibility(View.VISIBLE);
            collectionTextOne.setOnClickListener(clickTwo);
            collectionTextTwo.setOnClickListener(clickTwo);
            collectionTextThree.setOnClickListener(clickTwo);
            collectionTextFour.setOnClickListener(clickTwo);
            collectionTextFive.setOnClickListener(clickTwo);
            collectionTextSix.setOnClickListener(clickTwo);
            collectionTextSeven.setOnClickListener(clickTwo);
        }else if(type==9){
            collectionTextOne.setText("房屋出售收藏");
            collectionTextTwo.setText("房屋出租收藏");
            collectionTextThree.setText("房屋求租收藏");
            collectionTextFour.setText("房屋求购收藏");
            collectionTextFive.setText("小区");
            collectionTextSix.setText("店铺转让");
            collectionTextOne.setOnClickListener(clickThree);
            collectionTextTwo.setOnClickListener(clickThree);
            collectionTextThree.setOnClickListener(clickThree);
            collectionTextFour.setOnClickListener(clickThree);
            collectionTextFive.setOnClickListener(clickThree);
            collectionTextSix.setOnClickListener(clickThree);
        }else{
            collectionRelativeOne.setVisibility(View.GONE);
            collectionText.setVisibility(View.VISIBLE);
        }
        collectionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private View.OnClickListener clickOne=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.collection_Text_one:
                    start(1,"电话收藏",0);
                    break;
                case R.id.collection_Text_two:
                    start(2,"商家收藏",0);
                    break;
                case R.id.collection_Text_three:
                    start(3,"生活收藏列表",0);
                    break;
                case R.id.collection_Text_four:
                    start(4,"城事收藏",0);
                    break;
                case R.id.collection_Text_five:
                    start(5,"闹闹收藏",0);
                    break;
                case R.id.collection_Text_six:
                    start(6,"社区收藏",0);
                    break;
            }
        }
    };

    private View.OnClickListener clickTwo=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.collection_Text_one:
                    start(7,"工作收藏",0);
                    break;
                case R.id.collection_Text_two:
                    start(8,"新楼盘收藏",0);
                    break;
                case R.id.collection_Text_three:
                    start(9,"找房子收藏列表",0);
                    break;
                case R.id.collection_Text_four:
                    start(10,"二手信息收藏",0);
                    break;
                case R.id.collection_Text_five:
                    start(11,"车辆买卖收藏",0);
                    break;
                case R.id.collection_Text_six:
                    start(12,"生活服务收藏",0);
                    break;
                case R.id.collection_Text_seven:
                    start(13,"黄页收藏",0);
                    break;
            }
        }
    };

    private View.OnClickListener clickThree=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.collection_Text_one:
                    start(14,"房屋出售收藏",0);
                    break;
                case R.id.collection_Text_two:
                    start(15,"房屋出租收藏",0);
                    break;
                case R.id.collection_Text_three:
                    start(16,"房屋求租收藏",0);
                    break;
                case R.id.collection_Text_four:
                    start(17,"房屋求购收藏",0);
                    break;
                case R.id.collection_Text_five:
                    start(18,"小区收藏",0);
                    break;
                case R.id.collection_Text_six:
                    start(19,"店铺转让收藏",0);
                    break;
            }
        }
    };

    private void start(int type,String title,int id){
        Intent intent=new Intent(CollectionActivity.this,CollectionActivity.class);
        intent.putExtra("type",type);
        intent.putExtra("id",id);
        intent.putExtra("title",title);
        startActivity(intent);
    }

}