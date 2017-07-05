package com.example.citypass.cotroller.fragment.information;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.activity.shequ.Emoji;
import com.example.citypass.cotroller.activity.shequ.ReleaseActivity;
import com.example.citypass.cotroller.adapter.life.IssueApdater;
import com.example.citypass.cotroller.adapter.shequ.MyEmojiAdapter;
import com.example.citypass.cotroller.adapter.shequ.MyPagerAdapter;
import com.example.citypass.cotroller.fragment.shequ.BanQuFragment;
import com.example.citypass.utils.EmojiUtils;
import com.example.citypass.utils.FragmentUtils;
import com.example.citypass.utils.LogUtils;
import com.example.citypass.utils.LoginUtils;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.rowCount;
import static com.example.citypass.R.id.mImage;
import static com.example.citypass.R.id.neirongeditext;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/3 19:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IssuePostActivity extends BaseActivity {
    @BindView(R.id.issue_back)
    ImageView issueBack;
    @BindView(R.id.issue_post)
    TextView issuePost;
    @BindView(R.id.issue_Relative)
    RelativeLayout issueRelative;
    @BindView(R.id.issue_Section)
    TextView issueSection;
    @BindView(R.id.issue_Title)
    EditText issueTitle;
    @BindView(R.id.issue_imgOne)
    ImageView issueImgOne;
    @BindView(R.id.issue_imgTwo)
    ImageView issueImgTwo;
    @BindView(R.id.issue_imgThree)
    ImageView issueImgThree;
    @BindView(R.id.issue_imgFour)
    ImageView issueImgFour;
    @BindView(R.id.issue_imgFive)
    ImageView issueImgFive;
    @BindView(R.id.issue_RelativeTwo)
    RelativeLayout issueRelativeTwo;
    @BindView(R.id.issue_delete)
    ImageView issueDelete;
    @BindView(R.id.issue_RelativeOne)
    RelativeLayout issueRelativeOne;
    @BindView(R.id.issue_order)
    EditText issueOrder;
    @BindView(R.id.issue_post_Relative)
    RelativeLayout issuePostRelative;
    @BindView(R.id.issue_viewpager)
    ViewPager issueViewpager;
    @BindView(R.id.issue_radio_one)
    RadioButton issueRadioOne;
    @BindView(R.id.issue_radio_two)
    RadioButton issueRadioTwo;
    @BindView(R.id.issue_radio_three)
    RadioButton issueRadioThree;
    @BindView(R.id.issue_add_biaoqing)
    ImageView issueAddBiaoqing;
    @BindView(R.id.issue_biaoqingOne)
    TextView issueBiaoqingOne;
    @BindView(R.id.issue_bottom_Linear)
    LinearLayout issueBottomLinear;
    @BindView(R.id.issue_RelativeThree)
    RelativeLayout issueRelativeThree;
    private ArrayList<Emoji> emojiList;
    private List<View> viewList;
    private int rowCount = 3;
    private int columCount = 6;
    private MyPagerAdapter myPagerAdapter;
    private List<String> bList = new ArrayList<>();
    private PopupWindow window;
    private PopupWindow windowImg;
    private PopupWindow windowTitle;
    private ImageView mImage;
    private LinearLayout layout;
    private int REQUEST_CODE = 200;//相册请求码
    private int REQUEST_CODE1 = 201;//拍照的请求码
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post_issue;
    }
    String lastString = "";
    @Override
    protected void initListener() {
        issueViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    issueRadioOne.setChecked(true);
                }else if(position==1){
                    issueRadioTwo.setChecked(true);
                }else if(position==2){
                    issueRadioThree.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        issueOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueRelativeThree.setVisibility(View.GONE);
            }
        });
        issueOrder.addTextChangedListener(new TextWatcher() {
            int start;
            boolean isDelete;
            int count;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("FragmentComment", "start:" + start + ",before=" + before + "count=" + count);
                if (!lastString.equals(s.toString())) {
                    this.start = start;
                    this.count = count;
                    if (lastString.length() > s.toString().length()) {
                        isDelete = true;
                    } else {
                        isDelete = false;
                    }
                    lastString = s.toString();
                    EmojiUtils.showEmojiTextView(App.activity, issueOrder, s.toString());

                } else {
                    if (isDelete) {
                        issueOrder.setSelection(this.start);
                    } else {
                        issueOrder.setSelection(this.start + this.count);
                    }
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        showPopupWindowTitle();
        showPopupWindowImg();
        showPopupWindow1();
    }


    @OnClick({R.id.issue_back, R.id.issue_post, R.id.issue_Section, R.id.issue_imgOne, R.id.issue_imgTwo, R.id.issue_imgThree, R.id.issue_imgFour, R.id.issue_imgFive, R.id.issue_RelativeOne, R.id.issue_delete,R.id.issue_radio_one, R.id.issue_radio_two, R.id.issue_radio_three, R.id.issue_add_biaoqing, R.id.issue_biaoqingOne})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.issue_back:
                onBackPressed();
                break;
            case R.id.issue_post:
                break;
            case R.id.issue_Section:
                break;
            case R.id.issue_imgOne:
                setBottmView();
                break;
            case R.id.issue_imgTwo:
                windowImg.showAtLocation(IssuePostActivity.this.findViewById(R.id.issue_post_Relative),
                        Gravity.BOTTOM, 0, 0);
                break;
            case R.id.issue_imgThree:
                break;
            case R.id.issue_imgFour:
                int level = LoginUtils.information.getServerInfo().getLevel();
                if (level >= 13) {

                } else {
                    Toast.makeText(IssuePostActivity.this, "lv.13及以上等级用户才能发投票贴", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.issue_imgFive:
                window.showAtLocation(IssuePostActivity.this.findViewById(R.id.issue_post_Relative),
                        Gravity.BOTTOM, 0, 0);
                break;
            case R.id.issue_RelativeOne:
                break;
            case R.id.issue_delete:
                issueRelativeOne.setVisibility(View.INVISIBLE);
                break;
            case R.id.issue_radio_one:
                issueViewpager.setCurrentItem(0);
                break;
            case R.id.issue_radio_two:
                issueViewpager.setCurrentItem(1);
                break;
            case R.id.issue_radio_three:
                issueViewpager.setCurrentItem(2);
                break;
            case R.id.issue_add_biaoqing:
                break;
            case R.id.issue_biaoqingOne:
                break;
        }
    }

    private void setBottmView() {
        handler.post(runnable);
    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            viewList = new ArrayList<>();
            emojiList = EmojiUtils.getEmojiList();
            for (int i = 0; i < getPagerCount(emojiList.size()); i++) {
                GridView gridView = getPagerItem(i);
                viewList.add(gridView);
            }
            handler.sendEmptyMessage(0);
        }
    };
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    issueRelativeThree.setVisibility(View.VISIBLE);
                    myPagerAdapter = new MyPagerAdapter(viewList);
                    issueViewpager.setAdapter(myPagerAdapter);
                    break;
            }
        }
    };
    private int getPagerCount(int length) {
        return length % (rowCount * columCount) == 0 ? length / (rowCount * columCount) : length / (rowCount * columCount) + 1;
    }
    private GridView getPagerItem(int position) {
        View view = LayoutInflater.from(App.activity).inflate(R.layout.fragment_item_comment1, null);
        GridView gridView = (GridView) view.findViewById(R.id.mGrid);
        List<Emoji> subEmojiList = new ArrayList<>();
        for (int i = 0; i < (columCount * rowCount) - 1; i++) {
            if (columCount * rowCount * (position + 1) <= 52) {
                subEmojiList.add(emojiList.get(i + position * (columCount * rowCount)));
            } else {
                if (i <= 2) {
                    subEmojiList.add(emojiList.get(i + position * (columCount * rowCount)));
                }
            }

        }
        subEmojiList.add(new Emoji("[删除]", R.mipmap.face_delete));

        MyEmojiAdapter adapter = new MyEmojiAdapter(App.activity, subEmojiList, R.layout.fragment_comment_grid_item1, issueOrder);

        gridView.setAdapter(adapter);

        return gridView;
    }
    private void showPopupWindowTitle() {

        windowTitle = new PopupWindow(IssuePostActivity.this);
        BanQuFragment bqFragment = new BanQuFragment();
        View view = new View(IssuePostActivity.this);
        view.setId(0X00000000000000);
        FragmentUtils.addFragment(getSupportFragmentManager(), bqFragment, view.getId());
        windowTitle.setAnimationStyle(R.style.Animation);
        windowTitle.setBackgroundDrawable(new ColorDrawable());
        windowTitle.setFocusable(true);
        windowTitle.setOutsideTouchable(true);
    }

    private void showPopupWindowImg() {
        View view = getLayoutInflater().inflate(R.layout.fabu_picture_popwindow, null);
        mImage = (ImageView) view.findViewById(R.id.add_img);
        layout = (LinearLayout) view.findViewById(R.id.pic_list);
        windowImg = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 600);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        windowImg.setFocusable(true);
        windowImg.setOutsideTouchable(true);
        windowImg.setBackgroundDrawable(new ColorDrawable());
        // 设置popWindow的显示和消失动画
        windowImg.setAnimationStyle(R.style.Animation);

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bList.clear();
                multiselect();
            }


        });

    }
    //图片多选
    private void multiselect() {
        ImgSelConfig config = new ImgSelConfig.Builder(loader)
                .multiSelect(true)
                // 使用沉浸式状态栏
                .maxNum(9 - bList.size())
                .statusBarColor(Color.parseColor("#3F51B5")).build();

        ImgSelActivity.startActivity(this, config, REQUEST_CODE);

    }

    //选择图片后的接口回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //选择图片返回数据
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);

            for (String path : pathList) {
                LogUtils.e("返回图片数据,-", path + "\n");
                bList.add(path);
                View inflate = LayoutInflater.from(IssuePostActivity.this).inflate(R.layout.piclist_item, null);
                ImageView image= (ImageView) inflate.findViewById(R.id.pic_ss);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize=2;
                Bitmap bitmap = BitmapFactory.decodeFile(path, options);
                image.setImageBitmap(bitmap);
                layout.addView(inflate);
            }
        }


        //拍照返回数据
        if (requestCode == REQUEST_CODE1 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            // 获取相机返回的数据，并转换为Bitmap图片格式，这是缩略图
            Bitmap bitmap = (Bitmap) bundle.get("data");

            String sbmap = bitmap.toString();
            LogUtils.e("拍照返回数据", sbmap);
            int i = sbmap.indexOf("@");
            String bitmapname = sbmap.substring(i + 1, sbmap.length());
            //用这个当做图片名（bitmap值有唯一性，这样也让图片名字有唯一性）
            LogUtils.e("截取后的数据", bitmapname);

            //将bitmap对象转成图片，保存在SD卡
            saveMyBitmap(bitmap, bitmapname);
            bList.add("/sdcard/" + bitmapname + ".png");
        }

    }

    private void saveMyBitmap(Bitmap bitmap, String bitmapname) {
        File f = new File("/sdcard/" + bitmapname + ".png");
        try {
            f.createNewFile();
        } catch (IOException e) {

        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPopupWindow1() {
        View view = getLayoutInflater().inflate(R.layout.fabu_daoju_popwindow, null);
        window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 600);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(new ColorDrawable());

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.Animation);
    }
}
