package com.example.citypass.cotroller.fragment.information;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.life.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.umeng.socialize.a.b.d.m;

/**
 * 项目名称: 血压卫士
 * 类描述: 通讯录
 * 创建人: 马杰
 * 创建时间: 2017/6/24 16:00
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MailActivity extends BaseActivity {
    @BindView(R.id.mail_back)
    ImageView mailBack;
    @BindView(R.id.mail_Relative)
    RelativeLayout mailRelative;
    @BindView(R.id.mail_one)
    RadioButton mailOne;
    @BindView(R.id.mail_two)
    RadioButton mailTwo;
    @BindView(R.id.mail_radio)
    RadioGroup mailRadio;
    @BindView(R.id.mail_text_one)
    TextView mailTextOne;
    @BindView(R.id.mail_text_two)
    TextView mailTextTwo;
    @BindView(R.id.mail_linear)
    LinearLayout mailLinear;
    @BindView(R.id.mail_viewpager)
    ViewPager mailViewpager;
    private List<Fragment> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mail_list;
    }

    @Override
    protected void initListener() {
        mailViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    mailOne.setChecked(true);
                    mailTextOne.setVisibility(View.VISIBLE);
                    mailTextTwo.setVisibility(View.INVISIBLE);
                }else if(position==1){
                    mailTwo.setChecked(true);
                    mailTextOne.setVisibility(View.INVISIBLE);
                    mailTextTwo.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        MailFragment mailOnes=new MailFragment();
        mailOnes.setType(1);
        MailFragment mailTwos=new MailFragment();
        mailTwos.setType(2);
        mList.add(mailOnes);
        mList.add(mailTwos);
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),MailActivity.this,mList);
        mailViewpager.setAdapter(adapter);
        if(getIntent().getIntExtra("type",1)==2){
            mailOne.setChecked(true);
            mailTextOne.setVisibility(View.VISIBLE);
            mailTextTwo.setVisibility(View.INVISIBLE);
        }else if(getIntent().getIntExtra("type",1)==1){
            mailTwo.setChecked(true);
            mailTextOne.setVisibility(View.INVISIBLE);
            mailTextTwo.setVisibility(View.VISIBLE);
        }
    }


    @OnClick({R.id.mail_back, R.id.mail_one, R.id.mail_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mail_back:
                onBackPressed();
                break;
            case R.id.mail_one:
                mailViewpager.setCurrentItem(0);
                if(mailOne.isChecked()){
                    mailTextOne.setVisibility(View.VISIBLE);
                    mailTextTwo.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.mail_two:
                mailViewpager.setCurrentItem(2);
                if(mailTwo.isChecked()){
                    mailTextOne.setVisibility(View.INVISIBLE);
                    mailTextTwo.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
