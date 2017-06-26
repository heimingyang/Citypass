package com.example.citypass.cotroller.activity.naonao;

import android.graphics.Bitmap;
import android.os.Environment;
import android.widget.ImageView;

import com.cjt2325.cameralibrary.CheckPermissionsUtil;
import com.cjt2325.cameralibrary.JCameraView;
import com.example.citypass.App;
import com.example.citypass.R;
import com.example.citypass.base.BaseActivity;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: XI
 * 创建时间: 2017/6/24 0024 15:00
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


public class NaoNao_Carmer_Activity extends BaseActivity {
    private JCameraView mJCameraView;
    private ImageView mView;
    @Override
    protected int getLayoutId() {
        return R.layout.naonao_carmer_activity;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        CheckPermissionsUtil checkPermissionsUtil = new CheckPermissionsUtil(this);
        checkPermissionsUtil.requestAllPermission(this);
        mView = (ImageView) findViewById(R.id.naonao_carmer_shandian);
        mJCameraView = (JCameraView) findViewById(R.id.naonao_carmer);
//(0.0.7+)设置视频保存路径（如果不设置默认为Environment.getExternalStorageDirectory().getPath()）
        mJCameraView.setSaveVideoPath(Environment.getExternalStorageDirectory().getPath());
//(0.0.8+)设置手动/自动对焦，默认为自动对焦
        mJCameraView.setAutoFoucs(false);
        mJCameraView.setCameraViewListener(new JCameraView.CameraViewListener() {
            @Override
            public void quit() {
                //返回按钮的点击时间监听
                App.activity.finish();
            }
            @Override
            public void captureSuccess(Bitmap bitmap) {
                //获取到拍照成功后返回的Bitmap
            }
            @Override
            public void recordSuccess(String url) {
                //获取成功录像后的视频路径
            }
        });

    }

    @Override
    protected void initView() {

    }
    @Override
    protected void onResume() {
        super.onResume();
        mJCameraView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mJCameraView.onPause();
    }
}
