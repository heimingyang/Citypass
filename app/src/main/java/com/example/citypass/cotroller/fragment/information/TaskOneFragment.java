package com.example.citypass.cotroller.fragment.information;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.citypass.R;
import com.example.citypass.base.BaseFragment;
import com.example.citypass.cotroller.adapter.life.TaskAdapter;
import com.example.citypass.model.bean.information.Task;
import com.example.citypass.model.bean.information.TaskUp;
import com.example.citypass.model.biz.infor.ITaskModel;
import com.example.citypass.model.biz.infor.TaskModel;
import com.example.citypass.model.http.MyCallBack;
import com.example.citypass.utils.LoginUtils;
import com.example.citypass.utils.SpUtils;
import com.example.citypass.utils.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

import static com.example.citypass.utils.LoginUtils.USERID;
import static com.example.citypass.utils.LoginUtils.information;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 15:28
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TaskOneFragment extends BaseFragment {
    @BindView(R.id.task_List)
    ListView taskList;
    Unbinder unbinder;
    private int property;
    private TaskModel model;

    public void setProperty(int property) {
        this.property = property;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        model = new ITaskModel();
        model.getParam(getParam(), new MyCallBack() {
            @Override
            public void onSuccess(String result) {
                Task task = JSON.parseObject(result, Task.class);
                int code = task.getMessageList().getCode();
                if (code == 1000) {
                    List<Task.ServerInfoBean> serverInfo = task.getServerInfo();
                    TaskAdapter adapter = new TaskAdapter(serverInfo, getActivity(), property);
                    taskList.setAdapter(adapter);
                }
            }

            @Override
            public void onError(String errormsg) {

            }
        });
    }

    private String getParam() {
        TaskUp up = new TaskUp();
        up.setCustomerID(8001);
        up.setRequestTime(TimeUtils.getStringTime(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss"));
        up.setMethod("PHSocket_UserTaskConfigList");
        up.setCustomerKey("D5607EBE573BE2B59A4D5A1CAE882615");
        up.setAppName("CcooCity");
        up.setVersion("4.5");
        TaskUp.ParamBean paramBean = new TaskUp.ParamBean();
        paramBean.setSiteID(information.getServerInfo().getSiteID());
        paramBean.setPageSize(10);
        paramBean.setCurPage(1);
        paramBean.setProperty(property);
        paramBean.setUserID(Integer.parseInt(SpUtils.getSp().getString(USERID, "")));
       up.setParam(paramBean);
        TaskUp.StatisBean statisBean = new TaskUp.StatisBean();
        statisBean.setPhoneId(Build.SERIAL);
        statisBean.setPhoneNum("+86" + LoginUtils.information.getServerInfo().getTel());
        statisBean.setUserId(Integer.parseInt(SpUtils.getSp().getString(LoginUtils.USERID, "")));
        statisBean.setSiteId(LoginUtils.information.getServerInfo().getSiteID());
        String model = Build.MODEL;
        statisBean.setPhoneNo(model);
        statisBean.setSystemNo(2);
        int currentapiVersion = Build.VERSION.SDK_INT;
        statisBean.setSystem_VersionNo(currentapiVersion + "");
        up.setStatis(statisBean);
        String s = JSON.toJSONString(up);
        return s;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frangment_task;
    }

}
