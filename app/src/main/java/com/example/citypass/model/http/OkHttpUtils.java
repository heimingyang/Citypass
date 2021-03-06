package com.example.citypass.model.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.citypass.App;
import com.example.citypass.cotroller.fragment.toutiao.MyProgressDialog;
import com.example.citypass.utils.GlideCircleTransform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dell on 2017/6/9.
 */

public class OkHttpUtils implements FactoryIn {
    private static OkHttpUtils okhttpUtils=null;
    private OkHttpClient okHttpClient=null;
    private SharedPreferences shared;
    private SharedPreferences.Editor editor;
    private MyProgressDialog Hdialog= new MyProgressDialog(App.activity);

    public OkHttpUtils(){
        shared= App.activity.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor=shared.edit();
        cookie();
    }
    public static OkHttpUtils getInstance(){
        if(okhttpUtils==null){
            synchronized (OkHttpUtils.class){
                okhttpUtils=new OkHttpUtils();
                return okhttpUtils;
            }
        }
        return okhttpUtils;
    }
    private void cookie(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.cookieJar(new CookieJar() {
            private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url, cookies);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = cookieStore.get(url);
                return cookies != null ? cookies : new ArrayList<Cookie>();
            }
        });
        okHttpClient=builder.build();
    }
    @Override
    public void GET(String url, Map<String, String> map, String cookie, final MyCallBack callBack) {
      //  DialogUtils.dialog();
//        Hdialog.show();
        StringBuffer sb=new StringBuffer("?");
        if(map.size()>0){
            Set<String> values = map.keySet();
            int sum=0;
            for(String key:values){
                String value = map.get(key);
                if(sum==0){
                    sb.append(key+"="+value);
                    sum++;
                }else{
                    sb.append("&"+key+"="+value);
                }
            }
        }
        url=url+sb.toString();
        Log.e("url",url);
        Request request=null;
        if(cookie!=null) {
            request = new Request.Builder().get().url(url).addHeader("cookie", cookie).build();
        }else{
            request = new Request.Builder().get().url(url).build();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e.getMessage());
                       // DialogUtils.dismiss();
//                        Hdialog.dismiss();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsondata = response.body().string();
                if(jsondata!=null) {
                    App.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(jsondata);
                            //DialogUtils.dismiss();
//                            Hdialog.dismiss();
                        }
                    });
                }else{
                    Toast.makeText(App.activity,"请求数据为空",Toast.LENGTH_SHORT).show();
                    //DialogUtils.dismiss();
//                    Hdialog.dismiss();
                }
            }
        });
    }

    @Override
    public void POST(String url, Map<String, String> map, String cookie, final MyCallBack callBack) {
        //DialogUtils.dialog();
//        Hdialog.show();
        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        if(map!=null&&map.size()>0) {
            for (String key : map.keySet()) {
                String value = map.get(key);
                if(key.equals("button")){
                    builder.addPart(MultipartBody.create(MediaType.parse("image/*"),value));
                }
                if(value==null){

                }else {
                    builder.addFormDataPart(key, value);
                    if (value.endsWith(".jpg") || value.endsWith(".png")) {
                        String imgName = value.substring(value.lastIndexOf("/") + 1);
                        builder.addFormDataPart(key, value, MultipartBody.create(MediaType.parse("image/*"), new File(value)));
                    }
                }
            }
        }
        Request request=null;
        if(cookie!=null) {
            request = new Request.Builder().url(url)
                    .addHeader("cookie", cookie)
                    .post(builder.build()).build();
        }else{
            request=new Request.Builder().url(url).post(builder.build()).build();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(e!=null)
                callBack.onError(e.getMessage());
                //DialogUtils.dismiss();
//                Hdialog.dismiss();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsondata=response.body().string();
                Headers headers = response.headers();
                String cookie=null;
                for(String key:headers.names()){
                    List<String> value=headers.values(key);
                    if(key.contains("Set-Cookie")){
                        cookie+=value+";";
                    }
                }
                if(cookie!=null){
                    cookie=cookie.substring(0,cookie.length()-1);
                }
                boolean coo=shared.getBoolean("login",false);
                if(!coo){
                    editor.putString("cookie",cookie);
                    editor.commit();
                }
                if(jsondata!=null) {
                    App.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(jsondata);
//                            DialogUtils.dismiss();
//                            Hdialog.dismiss();

                        }
                    });
                }else{
                    Toast.makeText(App.activity,"请求数据为空",Toast.LENGTH_SHORT).show();
//                    DialogUtils.dismiss();
//                    Hdialog.dismiss();

                }
            }
        });
    }

    @Override
    public void downLoad(String url, MyCallBack callBack) {

    }

    // TODO: 2017/6/28  加载数据
    @Override
    public void loadImage(String url, ImageView view, boolean boo) {
        if(boo){
            Glide.with(App.activity).load(url).transform(new GlideCircleTransform(App.activity)).into(view);
        }else{
            Glide.with(App.activity).load(url).into(view);
        }
    }
}
