package com.example.citypass.cotroller.activity.shequ;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.shequ.MyEmojiAdapter;
import com.example.citypass.cotroller.adapter.shequ.MyPagerAdapter;
import com.example.citypass.cotroller.fragment.shequ.BanQuFragment;
import com.example.citypass.utils.EmojiUtils;
import com.example.citypass.utils.FragmentUtils;
import com.example.citypass.utils.LogUtils;
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
import butterknife.OnClick;

import static com.example.citypass.R.id.location_text;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/29 8:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class ReleaseActivity extends BaseActivity {

    @BindView(R.id.release_qiangjiaodian)
    TextView releaseQiangjiaodian;
    @BindView(R.id.Fabu_back)
    ImageView FabuBack;
    @BindView(R.id.Title_Text)
    TextView TitleText;
    @BindView(R.id.Fabu_fabu)
    TextView FabuFabu;
    @BindView(R.id.tiezi_title)
    RelativeLayout tieziTitle;
    @BindView(R.id.release_xuanzebankuai)
    TextView releaseXuanzebankuai;
    @BindView(R.id.biaotieditext)
    EditText biaotieditext;
    @BindView(R.id.neirongeditext)
    EditText neirongeditext;
    @BindView(R.id.locationIcon)
    ImageView locationIcon;
    @BindView(R.id.location_text)
    TextView locationText;
    @BindView(R.id.location_quxaio)
    ImageView locationQuxaio;
    @BindView(R.id.location_view)
    LinearLayout locationView;
    @BindView(R.id.reply_bottom_location_layout)
    LinearLayout replyBottomLocationLayout;
    @BindView(R.id.xiaolian)
    ImageView xiaolian;
    @BindView(R.id.xaingji)
    ImageView xaingji;
    @BindView(R.id.lianxiren)
    ImageView lianxiren;
    @BindView(R.id.toupiao)
    ImageView toupiao;
    @BindView(R.id.daoji)
    ImageView daoji;
    @BindView(R.id.Fabu_Bianji)
    LinearLayout FabuBianji;
    private PopupWindow window;
    private PopupWindow window1;
    private PopupWindow windowImg;
    private PopupWindow windowTitle;
    private ViewPager viewPager;
    private List<View> viewList;
    private GridView gridView;
    private ImageView mImage;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<Emoji> emojiList;
    private int rowCount = 3;
    private int columCount = 6;
    //图片选择框架需要的
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    };
    private int REQUEST_CODE = 200;//相册请求码
    private int REQUEST_CODE1 = 201;//拍照的请求码
    private Uri photoUri;
    //装bitmap的集合
    private List<String> bList = new ArrayList<>();
    private Bitmap bm;
    private int count;
    private LinearLayout layout;


    @Override
    protected int getLayoutId() {
        return R.layout.shequ_fabu_tiezi;
    }

    @Override
    protected void initView() {
        App.activity = ReleaseActivity.this;
        showPopupWindow();
        showPopupWindow1();
        showPopupWindowImg();
        showPopupWindowTitle();
    }

    private void showPopupWindowTitle() {

        windowTitle = new PopupWindow(ReleaseActivity.this);
        BanQuFragment bqFragment = new BanQuFragment();
        View view = new View(ReleaseActivity.this);
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
                View inflate = LayoutInflater.from(ReleaseActivity.this).inflate(R.layout.piclist_item, null);
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

    String lastString = "";

    private void showPopupWindow() {
        View view = getLayoutInflater().inflate(R.layout.fabu_biaoqing_popwindow, null);
        viewPager = (ViewPager) view.findViewById(R.id.mViewPager);
        addBiaoQing();
        window1 = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 600);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window1.setFocusable(true);
        window1.setOutsideTouchable(true);
        window1.setBackgroundDrawable(new ColorDrawable());

        // 设置popWindow的显示和消失动画
        window1.setAnimationStyle(R.style.Animation);
    }

    private void addBiaoQing() {
        viewList = new ArrayList<>();
        emojiList = EmojiUtils.getEmojiList();
        for (int i = 0; i < getPagerCount(emojiList.size()); i++) {
            GridView gridView = getPagerItem(i);
            viewList.add(gridView);
        }
        myPagerAdapter = new MyPagerAdapter(viewList);
        viewPager.setAdapter(myPagerAdapter);
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

        MyEmojiAdapter adapter = new MyEmojiAdapter(App.activity, subEmojiList, R.layout.fragment_comment_grid_item1, neirongeditext);

        gridView.setAdapter(adapter);

        return gridView;
    }

    private int getPagerCount(int length) {
        return length % (rowCount * columCount) == 0 ? length / (rowCount * columCount) : length / (rowCount * columCount) + 1;
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

    @Override
    protected void initListener() {
        neirongeditext.addTextChangedListener(new TextWatcher() {
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
                    EmojiUtils.showEmojiTextView(App.activity, neirongeditext, s.toString());

                } else {
                    if (isDelete) {
                        neirongeditext.setSelection(this.start);
                    } else {
                        neirongeditext.setSelection(this.start + this.count);
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

    @OnClick({R.id.Fabu_back, R.id.Fabu_fabu, R.id.release_xuanzebankuai, R.id.biaotieditext, R.id.location_text, R.id.location_quxaio, R.id.xiaolian, R.id.xaingji, R.id.lianxiren, R.id.toupiao, R.id.daoji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Fabu_back:
                this.finish();
                break;
            case R.id.Fabu_fabu:

                break;
            case R.id.release_xuanzebankuai:
                windowTitle.showAtLocation(ReleaseActivity.this.findViewById(R.id.Fabu_Bianji),
                Gravity.BOTTOM,0,0);
                break;
            case R.id.biaotieditext:
                break;
            case location_text:
                break;
            case R.id.location_quxaio:
                locationText.setVisibility(View.GONE);
                locationIcon.setVisibility(View.GONE);
                locationQuxaio.setVisibility(View.GONE);
                break;
            case R.id.xiaolian:
                window1.showAtLocation(ReleaseActivity.this.findViewById(R.id.Fabu_Bianji),
                        Gravity.BOTTOM, 0, 0);
                break;

            case R.id.xaingji:
                windowImg.showAtLocation(ReleaseActivity.this.findViewById(R.id.Fabu_Bianji),
                        Gravity.BOTTOM, 0, 0);
                break;
            case R.id.lianxiren:
//                startActivity(new Intent(this, MyLianXiRen.class));
                break;
            case R.id.toupiao:
                Toast.makeText(this, "lv13或者lv13以上用户才能发表投票", Toast.LENGTH_SHORT).show();
                break;
            case R.id.daoji:
                // 在底部显示
                window.showAtLocation(ReleaseActivity.this.findViewById(R.id.Fabu_Bianji),
                        Gravity.BOTTOM, 0, 0);
                break;
        }

    }

}
