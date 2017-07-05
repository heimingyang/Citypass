package com.example.citypass.cotroller.fragment.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;
import com.example.citypass.model.bean.information.DetailTasks;
import com.example.citypass.model.bean.information.TaskDetail;
import com.example.citypass.model.biz.infor.IMedalModel;
import com.example.citypass.model.biz.infor.MedaModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/7/5 16:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TaskDetailActivity extends BaseActivity {
    @BindView(R.id.task_detail_back)
    ImageView taskDetailBack;
    @BindView(R.id.task_detail_title)
    TextView taskDetailTitle;
    @BindView(R.id.task_detail_Relative)
    RelativeLayout taskDetailRelative;
    @BindView(R.id.task_detail_progress)
    TextView taskDetailProgress;
    @BindView(R.id.task_detail_progressBar)
    ProgressBar taskDetailProgressBar;
    @BindView(R.id.task_detail_Bar)
    RelativeLayout taskDetailBar;
    @BindView(R.id.task_detail_TextOne)
    TextView taskDetailTextOne;
    @BindView(R.id.task_detail_RelativeOne)
    RelativeLayout taskDetailRelativeOne;
    @BindView(R.id.task_detail_TextTwo)
    TextView taskDetailTextTwo;
    @BindView(R.id.task_detail_coin)
    TextView taskDetailCoin;
    @BindView(R.id.task_detail_RelativeTwo)
    RelativeLayout taskDetailRelativeTwo;
    @BindView(R.id.task_detail_chengz)
    TextView taskDetailChengz;
    @BindView(R.id.task_detail_RelativeThree)
    RelativeLayout taskDetailRelativeThree;
    @BindView(R.id.task_detail_time)
    TextView taskDetailTime;
    @BindView(R.id.task_detail_RelativeFour)
    RelativeLayout taskDetailRelativeFour;
    @BindView(R.id.task_detail_task)
    TextView taskDetailTask;
    @BindView(R.id.task_detail_RelativeFive)
    RelativeLayout taskDetailRelativeFive;
    @BindView(R.id.task_detail_TextThree)
    TextView taskDetailTextThree;
    @BindView(R.id.task_detail_TextFour)
    TextView taskDetailTextFour;
    private MedaModel model;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        model=new IMedalModel();
        getParam();
    }

    private void getParam(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        int type = intent.getIntExtra("type", 0);
        if(type==0){
            taskDetailRelativeOne.setVisibility(View.GONE);
        }
        TaskDetail detail=new TaskDetail();
        detail.setSiteID(LoginUtils.information.getServerInfo().getSiteID());
        detail.setUserID(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID,"")));
        detail.setId(id);
        String param = LoginUtils.getParam(detail, "PHSocket_APP_TaskConfigDetail");
        model.getMedal(param, new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                DetailTasks detailTasks = JSON.parseObject(result, DetailTasks.class);
                int code = detailTasks.getMessageList().getCode();
                if(code==1000){
                    DetailTasks.ServerInfoBean serverInfo = detailTasks.getServerInfo();
                    taskDetailTitle.setText(serverInfo.getTitle());
                    taskDetailCoin.setText(serverInfo.getCoin()+"");
                    taskDetailChengz.setText(serverInfo.getIntegral()+"");
                    taskDetailTime.setText(serverInfo.getETime());
                    taskDetailProgressBar.setProgress(serverInfo.getRate());
                    taskDetailTextFour.setText(serverInfo.getExplain());
                    taskDetailTextOne.setText(serverInfo.getRateInfo());
                    if(serverInfo.getRate()<100){
                        taskDetailTask.setText("立即前往");
                        taskDetailTask.setBackgroundResource(R.color.orange);
                    }
                }else{
                    Toast.makeText(TaskDetailActivity.this,detailTasks.getMessageList().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }


    @OnClick({R.id.task_detail_back, R.id.task_detail_task})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.task_detail_back:
                onBackPressed();
                break;
            case R.id.task_detail_task:
                break;
        }
    }
}
