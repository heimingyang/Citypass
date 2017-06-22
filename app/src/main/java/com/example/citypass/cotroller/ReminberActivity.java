package com.example.citypass.cotroller;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.utils.ReminderUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述: 消息提醒页面
 * 创建人: 马杰
 * 创建时间: 2017/6/22 8:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ReminberActivity extends BaseActivity {
    @BindView(R.id.reminder_back)
    ImageView reminderBack;
    @BindView(R.id.reminder_Relative)
    RelativeLayout reminderRelative;
    @BindView(R.id.Push_notifications)
    TextView PushNotifications;
    @BindView(R.id.Push_check)
    CheckBox PushCheck;
    @BindView(R.id.Interactive_reminder)
    TextView InteractiveReminder;
    @BindView(R.id.Interactive_check)
    CheckBox InteractiveCheck;
    @BindView(R.id.Shock_reminder)
    TextView ShockReminder;
    @BindView(R.id.Shock_check)
    CheckBox ShockCheck;
    @BindView(R.id.Sound_reminder)
    TextView SoundReminder;
    @BindView(R.id.Sound_check)
    CheckBox SoundCheck;
    @BindView(R.id.night_reminder)
    TextView nightReminder;
    @BindView(R.id.night_check)
    CheckBox nightCheck;
    private boolean push;
    private boolean interActive;
    private boolean shock;
    private boolean sound;
    private boolean night;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        push = SpUtils.getSp().getBoolean(ReminderUtils.PUSH, true);
        interActive=SpUtils.getSp().getBoolean(ReminderUtils.INTERACTIVE,true);
        shock=SpUtils.getSp().getBoolean(ReminderUtils.SHOCK,false);
        sound=SpUtils.getSp().getBoolean(ReminderUtils.SOUND,true);
        night=SpUtils.getSp().getBoolean(ReminderUtils.NIGHT,true);
        PushCheck.setChecked(push);
        InteractiveCheck.setChecked(interActive);
        ShockCheck.setChecked(shock);
        SoundCheck.setChecked(sound);
        nightCheck.setChecked(night);
    }

    @OnClick({R.id.reminder_back, R.id.Push_check, R.id.Interactive_check, R.id.Shock_check, R.id.Sound_check, R.id.night_check})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reminder_back:
                onBackPressed();
                break;
            case R.id.Push_check:
                break;
            case R.id.Interactive_check:
                break;
            case R.id.Shock_check:
                break;
            case R.id.Sound_check:
                break;
            case R.id.night_check:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SpUtils.upSp().putBoolean(ReminderUtils.PUSH,PushCheck.isChecked());
        SpUtils.upSp().putBoolean(ReminderUtils.INTERACTIVE,InteractiveCheck.isChecked());
        SpUtils.upSp().putBoolean(ReminderUtils.SHOCK,ShockCheck.isChecked());
        SpUtils.upSp().putBoolean(ReminderUtils.SOUND,SoundCheck.isChecked());
        SpUtils.upSp().putBoolean(ReminderUtils.NIGHT,nightCheck.isChecked());
        SpUtils.upSp().commit();
    }
}
