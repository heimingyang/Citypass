package com.example.citypass.model.ddb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 2017/5/25.
 */

public class MyManger {
    private MyHelper myHelper;
    private SQLiteDatabase database;
    private Context context;

    public MyManger(Context context) {
        this.context = context;
        myHelper = new MyHelper(context, "yao.db", 1);
        database = myHelper.getWritableDatabase();
    }

    public boolean insert(String name) {
        boolean boo;
        ContentValues con = new ContentValues();
        con.put("name", name);
        long ins = database.insert("hehe", null, con);
        if (ins > 0) {
            boo = true;
        } else {
            boo = false;
        }
        return boo;
    }

    public void delete() {
        database.delete("hehe", null, null);
    }

    public List<String> getList() {
        List<String> mList = new ArrayList<>();
        Cursor cursor = database.query("hehe", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String ss = cursor.getString(cursor.getColumnIndex("name"));
            mList.add(ss);
        }
        return mList;
    }
}
