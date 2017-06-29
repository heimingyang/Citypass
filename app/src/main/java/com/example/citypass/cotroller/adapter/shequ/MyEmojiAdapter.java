package com.example.citypass.cotroller.adapter.shequ;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.citypass.R;
import com.example.citypass.cotroller.activity.shequ.CommonViewHolder;
import com.example.citypass.cotroller.activity.shequ.Emoji;

import java.util.List;



public class MyEmojiAdapter extends MyCommonBaseAdapter<Emoji> {

    private EditText editText;

    public MyEmojiAdapter(Context context, List<Emoji> datas, int layoutId, EditText editText) {
        super(context, datas, layoutId);
        this.editText=editText;
    }

    @Override
    protected void display(CommonViewHolder holder, Emoji emoji) {
        ImageView mImage=holder.getView(R.id.mImage);

        mImage.setImageResource(emoji.getEmojiUri());

        mImage.setTag(emoji);

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emoji emoji = (Emoji) v.getTag();

                String text = editText.getText().toString();

                StringBuffer sb = new StringBuffer(text);


                if (emoji.getEmojiName().equals("[删除]")) {
                    if (sb.length()>0) {
                        if (text.toString().endsWith("]")) {
                            sb.delete(sb.lastIndexOf("["), sb.length());
                        } else {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                } else {
                    sb.append(emoji.getEmojiName());
                }
                editText.setText(sb);
            }
        });

    }
}
