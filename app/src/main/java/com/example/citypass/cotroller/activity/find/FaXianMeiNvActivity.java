package com.example.citypass.cotroller.activity.find;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.fragment.information.LoginActivity;
import com.example.citypass.cotroller.adapter.discover.Discover_Belle_Adapter;
import com.example.citypass.cotroller.fragment.faxian_belle.FengMian_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.LengYan_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.MeiLi_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.MengMeiZi_Framgment;
import com.example.citypass.cotroller.fragment.faxian_belle.NvHanZi_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.QiZhi_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.TuHao_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.XinRenXiu_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.XinShang_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.XingGan_Fragment;
import com.example.citypass.cotroller.fragment.faxian_belle.ZuiXin_Fragment;
import com.example.citypass.model.bean.information.Information;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/21 0021 15:36
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

public class FaXianMeiNvActivity extends BaseActivity {
    @BindView(R.id.Belle_back)
    ImageView BelleBack;
    @BindView(R.id.Belle_title)
    TextView BelleTitle;
    @BindView(R.id.Belle_camera)
    ImageView BelleCamera;
    @BindView(R.id.Belle_relative)
    RelativeLayout BelleRelative;
    @BindView(R.id.Belle_Tablayout)
    TabLayout BelleTablayout;
    @BindView(R.id.Belle_viewpager)
    ViewPager BelleViewpager;
    private TuHao_Fragment tuHao_fragment;
    private XinShang_Fragment xinShang_fragment;
    private MeiLi_Fragment meiLi_fragment;
    private ZuiXin_Fragment zuiXin_fragment;
    private FengMian_Fragment fengMian_fragment;
    private XinRenXiu_Fragment xinRenXiu_fragment;
    private XingGan_Fragment xingGan_fragment;
    private LengYan_Fragment lengYan_fragment;
    private QiZhi_Fragment qiZhi_fragment;
    private MengMeiZi_Framgment mengMeiZi_framgment;
    private NvHanZi_Fragment nvHanZi_fragment;
    private List<Fragment> flist = new ArrayList<>();
    private List<String> mlist = new ArrayList<>();
    //viewpager适配器
    private Discover_Belle_Adapter discoverBelle_adapter;
    private AlertDialog alertDialog;
    private View inflate;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_faxianmeinv;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //实例化需要的所有Fragment，并且将其都添加到集合
        tuHao_fragment = new TuHao_Fragment();
        xinShang_fragment = new XinShang_Fragment();
        meiLi_fragment = new MeiLi_Fragment();
        zuiXin_fragment = new ZuiXin_Fragment();
        fengMian_fragment = new FengMian_Fragment();
        xinRenXiu_fragment = new XinRenXiu_Fragment();
        xingGan_fragment = new XingGan_Fragment();
        lengYan_fragment = new LengYan_Fragment();
        qiZhi_fragment = new QiZhi_Fragment();
        mengMeiZi_framgment = new MengMeiZi_Framgment();
        nvHanZi_fragment = new NvHanZi_Fragment();

        flist.add(tuHao_fragment);
        flist.add(xinShang_fragment);
        flist.add(meiLi_fragment);
        flist.add(zuiXin_fragment);
        flist.add(fengMian_fragment);
        flist.add(xinRenXiu_fragment);
        flist.add(xingGan_fragment);
        flist.add(lengYan_fragment);
        flist.add(qiZhi_fragment);
        flist.add(mengMeiZi_framgment);
        flist.add(nvHanZi_fragment);

        //添加tablayout 的 title
        mlist.add("土豪榜");
        mlist.add("欣赏榜");
        mlist.add("魅力榜");
        mlist.add("最新");
        mlist.add("封面女郎");
        mlist.add("新人秀");
        mlist.add("性感");
        mlist.add("冷艳");
        mlist.add("气质");
        mlist.add("萌妹子");
        mlist.add("女汉子");


        discoverBelle_adapter = new Discover_Belle_Adapter(getSupportFragmentManager(), flist, mlist);
        BelleViewpager.setAdapter(discoverBelle_adapter);
        BelleTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        BelleTablayout.setupWithViewPager(BelleViewpager);


        //默认选项
        BelleTablayout.getTabAt(3).select();


    }


    @OnClick({R.id.Belle_back, R.id.Belle_camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //返回键
            case R.id.Belle_back:
                onBackPressed();
                break;
            case R.id.Belle_camera:
                cameraClicked();

                break;
        }
    }

    //点击右上角的相机
    private void cameraClicked() {

        //判断是否登录
        if (SpUtils.getSp().getBoolean(LoginUtils.LOGIN, false)) {
            Information.ServerInfoBean serverInfo = LoginUtils.information.getServerInfo();

            LogUtils.e("真实姓名", serverInfo.getName());
            //男生弹出dialog
            if (LoginUtils.information.getServerInfo().getSex().equals("男")) {
                Toast.makeText(this, "男", Toast.LENGTH_SHORT).show();
                showMyDialog();
            } else {
                Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
                //女生再判断 资料有没有完善
                if (serverInfo.getName() == "") {

                    //没有完善就跳转去完善
                    Intent intent = new Intent(this, FaXianPerfectActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //完善了就去发表
                    String sex = LoginUtils.information.getServerInfo().getSex();
                    Intent intent = new Intent(FaXianMeiNvActivity.this, PublishActivity.class);
                    intent.putExtra("sex", sex);
                    startActivity(intent);

                }
            }

            //没登录，跳转到登录
        } else {
            Intent intent = new Intent(FaXianMeiNvActivity.this, LoginActivity.class);
            startActivityForResult(intent, 200);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 200:
                switch (resultCode) {
                    case 111:
                        cameraClicked();
                        break;
                }

                break;

        }
    }

    private TextView gotoBoy;
    private Button okBoy;

    //本页面男生的dialog
    private void showMyDialog() {

        alertDialog = new AlertDialog.Builder(this).create();

        inflate = LayoutInflater.from(this).inflate(R.layout.boy_dialog_item, null);
        gotoBoy = (TextView) inflate.findViewById(R.id.dialog_gotoboy);
        okBoy = (Button) inflate.findViewById(R.id.dialog_Button);
        //点击去帅男秀场
        gotoBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginUtils.information.getServerInfo().getUserName().isEmpty()) {
                    Intent intent = new Intent(FaXianMeiNvActivity.this, FaXianPerfectActivity.class);
                    intent.putExtra("sex", LoginUtils.information.getServerInfo().getSex());
                    startActivity(intent);
                    alertDialog.dismiss();
                } else {
                    Intent intent = new Intent(FaXianMeiNvActivity.this, PublishActivity.class);
                    intent.putExtra("sex", LoginUtils.information.getServerInfo().getSex());
                    startActivity(intent);
                    alertDialog.dismiss();
                }


            }
        });
        okBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.setView(inflate);
        alertDialog.show();


    }


}
