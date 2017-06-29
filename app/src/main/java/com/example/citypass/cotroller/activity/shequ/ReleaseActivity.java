package com.example.citypass.cotroller.activity.shequ;

import android.graphics.drawable.ColorDrawable;
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

import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.cotroller.adapter.shequ.MyEmojiAdapter;
import com.example.citypass.cotroller.adapter.shequ.MyPagerAdapter;
import com.example.citypass.utils.EmojiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.Fabu_back)
    ImageView FabuBack;
    @BindView(R.id.Title_Text)
    TextView TitleText;
    @BindView(R.id.Fabu_fabu)
    TextView FabuFabu;
    @BindView(R.id.tiezi_title)
    RelativeLayout tieziTitle;
    @BindView(R.id.xuanzheBankuai_layout)
    LinearLayout xuanzheBankuaiLayout;
    @BindView(R.id.biaotieditext)
    EditText biaotieditext;
    @BindView(R.id.meiyongtextview)
    TextView meiyongtextview;
    @BindView(R.id.neirongeditext)
    EditText neirongeditext;
    @BindView(R.id.location_icon)
    ImageView locationIcon;
    @BindView(R.id.location_Where)
    TextView locationWhere;
    @BindView(R.id.location_quxaio)
    ImageView locationQuxaio;
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
    RelativeLayout FabuBianji;

    private PopupWindow window;
    private PopupWindow window1;
    private ViewPager viewPager;
    private List<View> viewList;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<Emoji> emojiList;
    private int rowCount = 3;
    private int columCount = 6;


    @Override
    protected int getLayoutId() {
        return R.layout.shequ_fabu_tiezi;
    }

    @Override
    protected void initView() {
        App.activity = ReleaseActivity.this;
        showPopupWindow();
        showPopupWindow1();
    }

    String lastString = "";

    private void showPopupWindow() {
        View view = getLayoutInflater().inflate(R.layout.fabu_biaoqing_popwindow, null);
        viewPager = (ViewPager) view.findViewById(R.id.mViewPager);
        addBiaoQing();
        window1 = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 300);
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
        subEmojiList.add(new Emoji("[删除]", R.drawable.face_delete));

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

    @OnClick({R.id.Fabu_back, R.id.Fabu_fabu, R.id.xuanzheBankuai_layout, R.id.biaotieditext, R.id.location_Where, R.id.location_quxaio, R.id.xiaolian, R.id.xaingji, R.id.lianxiren, R.id.toupiao, R.id.daoji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Fabu_back:
                this.finish();
                break;
            case R.id.Fabu_fabu:
                break;
            case R.id.xuanzheBankuai_layout:
                break;
            case R.id.biaotieditext:
                break;
            case R.id.location_Where:
                break;
            case R.id.location_quxaio:
                locationWhere.setVisibility(View.GONE);
                locationIcon.setVisibility(View.GONE);
                locationQuxaio.setVisibility(View.GONE);
                break;
            case R.id.xiaolian:
                window1.showAtLocation(ReleaseActivity.this.findViewById(R.id.Fabu_Bianji),
                        Gravity.BOTTOM, 0, 0);
                break;

            case R.id.xaingji:
//                startActivity(new Intent(this, FaBiaoTieZiPictureActivity.class));
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
