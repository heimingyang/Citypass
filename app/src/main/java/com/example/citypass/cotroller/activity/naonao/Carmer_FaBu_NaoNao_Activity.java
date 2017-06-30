package com.example.citypass.cotroller.activity.naonao;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/29 0029 15:10
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


public class Carmer_FaBu_NaoNao_Activity extends BaseActivity {

    @BindView(R.id.carmer_fabu_naonao_cancel)
    ImageView carmerFabuNaonaoCancel;
    @BindView(R.id.carmer_fabu_naonao_fabu)
    TextView carmerFabuNaonaoFabu;
    @BindView(R.id.mail_Relative)
    RelativeLayout mailRelative;
    @BindView(R.id.weixin_addLayout)
    LinearLayout weixinAddLayout;
    @BindView(R.id.weixin_scroovie)
    HorizontalScrollView weixinScroovie;
    @BindView(R.id.carmer_fabu_naonao_edit)
    EditText carmerFabuNaonaoEdit;
    @BindView(R.id.carmer_fabu_naonao_worry)
    ImageView carmerFabuNaonaoWorry;
    @BindView(R.id.carmer_fabu_naonao_address)
    RelativeLayout carmerFabuNaonaoAddress;
    @BindView(R.id.carmer_fabu_naonao_emoji)
    ImageView carmerFabuNaonaoEmoji;
    @BindView(R.id.carmer_fabu_naonao_aite)
    ImageView carmerFabuNaonaoAite;
    @BindView(R.id.carmer_fabu_naonao_yuyin)
    ImageView carmerFabuNaonaoYuyin;
    @BindView(R.id.carmer_fabu_naonao_collect)
    ImageView carmerFabuNaonaoCollect;
    @BindView(R.id.hehe)
    RelativeLayout hehe;

    @Override
    protected int getLayoutId() {
        return R.layout.carmer_fabu_naonao_activity;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        weixinAddLayout.addView(LayoutInflater.from(this).inflate(R.layout.carmer_fabu_naonao_img, null));
    }



    @OnClick({R.id.carmer_fabu_naonao_cancel, R.id.carmer_fabu_naonao_fabu, R.id.carmer_fabu_naonao_worry, R.id.carmer_fabu_naonao_emoji, R.id.carmer_fabu_naonao_aite, R.id.carmer_fabu_naonao_yuyin, R.id.carmer_fabu_naonao_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.carmer_fabu_naonao_cancel:
                onBackPressed();
                break;
            case R.id.carmer_fabu_naonao_fabu:
                break;
            case R.id.carmer_fabu_naonao_worry:

                break;
            case R.id.carmer_fabu_naonao_emoji:

                break;
            case R.id.carmer_fabu_naonao_aite:
                break;
            case R.id.carmer_fabu_naonao_yuyin:
                break;
            case R.id.carmer_fabu_naonao_collect:
                break;
        }
    }
}
