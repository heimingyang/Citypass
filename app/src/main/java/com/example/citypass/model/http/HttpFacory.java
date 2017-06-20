package com.example.citypass.model.http;

/**
 * Created by 黑明阳 on 2017/5/11.
 */

public  class HttpFacory {
    private static final int OKHTTP=0;
    private static final int VOLLEY=1;

    private static final int TYPE=OKHTTP;

    public static FactoryIn create(){
        FactoryIn factoryIn =null;

        switch (TYPE){
            case  OKHTTP:
                factoryIn=new OkHttpUtils();
                break;
            case  VOLLEY:
                break;
        }
        return factoryIn;
    }
}
