package com.example.citypass.cotroller.activity;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FaXianPerfectActivity extends BaseActivity {
    final int DATE_DIALOG = 1;
    int mYear;
    int mMonth;
    int mDay;
    @BindView(R.id.Perfect_back)
    ImageView PerfectBack;
    @BindView(R.id.Perfect_relativelayout)
    RelativeLayout PerfectRelativelayout;
    @BindView(R.id.Perfect_text)
    TextView PerfectText;
    @BindView(R.id.Perfect_guan)
    ImageView PerfectGuan;
    @BindView(R.id.Perfect_ed_name)
    EditText PerfectEdName;
    @BindView(R.id.Perfect_ed_birthday)
    EditText PerfectEdBirthday;
    @BindView(R.id.Perfect_ed_job)
    EditText PerfectEdJob;
    @BindView(R.id.radio_btn_danshen)
    RadioButton radioBtnDanshen;
    @BindView(R.id.radio_btn_lianai)
    RadioButton radioBtnLianai;
    @BindView(R.id.radio_btn_yihun)
    RadioButton radioBtnYihun;
    @BindView(R.id.Perfect_dariogroup)
    RadioGroup PerfectDariogroup;
    @BindView(R.id.Perfect_ed_domicile)
    EditText PerfectEdDomicile;
    @BindView(R.id.Perfect_ed_vx)
    EditText PerfectEdVx;
    @BindView(R.id.Perfect_ed_qq)
    EditText PerfectEdQq;
    @BindView(R.id.Perfect_ed_info)
    EditText PerfectEdInfo;
    @BindView(R.id.Perfect_next)
    Button PerfectNext;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_fa_xian_perfect;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    protected void initView() {

    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }


    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        PerfectEdBirthday.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };


    @OnClick({R.id.Perfect_back, R.id.Perfect_guan, R.id.Perfect_ed_birthday, R.id.Perfect_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Perfect_back:
                onBackPressed();
                break;
            case R.id.Perfect_guan:
                PerfectText.setVisibility(View.GONE);
                break;
            case R.id.Perfect_ed_birthday:
                showDialog(DATE_DIALOG);
                break;
            case R.id.Perfect_next:

                break;
        }
    }
}
