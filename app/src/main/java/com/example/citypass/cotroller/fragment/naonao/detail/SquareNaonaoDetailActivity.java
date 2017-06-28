package com.example.citypass.cotroller.fragment.naonao.detail;

import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/26 11:21
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class SquareNaonaoDetailActivity extends BaseActivity {
    @BindView(R.id.square_naonao_TitleText)
    TextView TitleText;
    @BindView(R.id.square_naonao_recycle_item_touxiang)
    ImageView Touxiang;
    @BindView(R.id.square_naonao_recycle_item_name)
    TextView ItemName;
    @BindView(R.id.square_naonao_recycle_item_level)
    TextView squareNaonaoRecycleItemLevel;
    @BindView(R.id.square_naonao_recycle_item_time)
    TextView ItemTime;
    @BindView(R.id.square_naonao_guanzhu_btn)
    Button GuanzhuBtn;
    @BindView(R.id.square_naonao_detail_shuatie)
    TextView Shuatie;
    @BindView(R.id.square_naonao_detail_ImageLinear)
    MyGridLayout myGridView;
    @BindView(R.id.square_naonao_recycle_item_address)
    TextView ItemAddress;
    @BindView(R.id.square_naonao_Textzan)
    TextView Textzan;
    @BindView(R.id.square_naonao_zanImage)
    ImageView ZanImage;
    @BindView(R.id.square_naonao_shareImage)
    ImageView ShareImage;
    @BindView(R.id.square_naonao_dashangImage)
    ImageView DashangImage;
    @BindView(R.id.square_naonao_zanText)
    TextView ZanText;
    @BindView(R.id.square_naonao_mTab)
    TabLayout mTablayout;
    @BindView(R.id.square_naonao_viewpager)
    ViewPager mViewpager;
    private List<String> strList = new ArrayList<>();
    private String images;

    @Override
    protected int getLayoutId() {
        return R.layout.square_naonao_detail_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
//        getImage();

        String[] splite = images.split("\\|");
        for (String s : splite) {
            Log.d("SquareNaonaoDetailActiv", "截取的" + s);
            strList.add(s);

        }
        myGridView.setmList(strList);
        Log.d("SquareNaonaoDetailActiv", "strList.size():" + strList.size());

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMainThreadEvent(final SquareDetailBean detailBean) {
        String titleName = detailBean.getTitle();
        String body = detailBean.getBody();
        ItemName.setText(body);

        Shuatie.setText(titleName);

        String image = detailBean.getImage();

        Glide.with(this).load(image).asBitmap().centerCrop().into(new BitmapImageViewTarget(Touxiang) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);

                drawable.setCircular(true);

                Touxiang.setImageDrawable(drawable);

            }
        });

        String address = detailBean.getAddress();
        ItemAddress.setText(address);

        String time = detailBean.getTime();

        ItemTime.setText(time);

        images = detailBean.getImages();

//        //把所有的网址遍历出来，添加到Imageview
//        for (int i = 0; i < images.length(); i++) {
//            ImageView mImage = new ImageView(this);
//            int n = images.indexOf("|");
//            Glide.with(this).load(images.substring(0, n)).into(mImage);
//            ImageLinear.addView(mImage);
//
//            ImageView mImage1 = new ImageView(this);
//            Glide.with(this).load(images.substring(n + 1, i)).into(mImage1);
//            ImageLinear.addView(mImage1);
//
//
//        }


    }

    private void getImage() {
        Log.d("SquareNaonaoDetailActiv", "            " + images);
        boolean boo = true;
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        while (boo) {
            if (images.indexOf("jpeg", count) != -1 || images.indexOf("jpg", count) != -1 || images.indexOf("png", count) != -1 || images.indexOf("jpg", count) != -1) {
                list.add(images.indexOf("jpeg", count));
                list.add(images.indexOf("jpg", count));
                list.add(images.indexOf("png", count));
                list.add(images.indexOf("gif", count));
////                count = images.indexOf("jpeg", count) + 1;
//                count = images.indexOf("jpg", count) + 1;
//                count = images.indexOf("png", count) + 1;
//                count = images.indexOf("gif", count) + 1;
            } else {
                Log.d("SquareNaonaoDetailActiv", "list.size():" + list.size());
                boo = false;
            }
        }

        //集合中存入的是字符串中的 J, 从0开始截取，到最后每个字母JPEG。
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                String i1 = images.substring(0, list.get(i) + 4);
//                String jpg = images.substring(0, images.indexOf("|"));
                strList.add(i1);
//                strList.add(jpg);
                Log.d("SquareNaonaoDetailActiv", "这是第一张" + i1);
            } else {
                try {
                    String i2 = images.substring(list.get(i - 1) + 5, list.get(i) + 4);
//                    String i3 = images.substring(images.indexOf("|") + 1, images.indexOf("jpeg") + 4);
                    strList.add(i2);
//                    strList.add(i3);
//                    Log.d("SquareNaonaoDetailActiv", "   i3" + i3);
                    Log.d("SquareNaonaoDetailActiv", "i2" + i2);
                } catch (Exception e) {

                }
            }
        }
//        myGridView.setmList(strList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
