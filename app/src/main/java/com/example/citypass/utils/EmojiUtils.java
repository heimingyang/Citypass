package com.example.citypass.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.cotroller.activity.shequ.Emoji;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class EmojiUtils {

    public static ArrayList<Emoji> getEmojiList(){
        ArrayList<Emoji> arrayList=new ArrayList<>();
        for (int i=0;i<emojiResArray.length;i++){
            Emoji emoji=new Emoji();
            emoji.setEmojiName(emojiTextArray[i]);
            emoji.setEmojiUri(emojiResArray[i]);
            arrayList.add(emoji);
        }
        return arrayList;
    }

    public static Bitmap getEmojiItem(Resources resources,int resid,int reqWidth,int reqHeight){

        BitmapFactory.Options options=new BitmapFactory.Options();

        options.inJustDecodeBounds=true;

        BitmapFactory.decodeResource(resources,resid,options);

        options.inSampleSize=convertEmojiisSimpleSize(options,reqWidth,reqHeight);

        options.inJustDecodeBounds=false;

        return BitmapFactory.decodeResource(resources,resid,options);
    }

    public static void showEmojiTextView(Context context, TextView textView,String content){

        SpannableString spannableString=new SpannableString(content);

        String regex="\\[(\\S+?)\\]";

        Pattern pattern=Pattern.compile(regex);

        Matcher matcher=pattern.matcher(content);

        ArrayList<Emoji> emojiArrayList=getEmojiList();

        while(matcher.find()){
            Iterator<Emoji> iterator=emojiArrayList.iterator();

            String contentGroup=matcher.group();

            while(iterator.hasNext()){

                Emoji emoji=iterator.next();

                if (emoji.getEmojiName().equals(contentGroup)){
                    spannableString.setSpan(new ImageSpan(context,getEmojiItem(context.getResources(),emoji.getEmojiUri(),68,68)),matcher.start(),matcher.end(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            }
        }
        textView.setText(spannableString);

    }

    private static int convertEmojiisSimpleSize(BitmapFactory.Options options,int reqWidth,int reqHeight) {

        int width=options.outWidth;

        int height=options.outHeight;

        int inSimpleSize=1;

        if (width>reqWidth || height>reqHeight){
            int widthRadio=Math.round((float)width/reqWidth);
            int heightRadio=Math.round((float)height/reqHeight);
            return Math.min(widthRadio,heightRadio);
        }
        return inSimpleSize;
    }


    public static final int[] emojiResArray = {
            R.mipmap.sys1,
            R.mipmap.sys2,
            R.mipmap.sys3,
            R.mipmap.sys4,
            R.mipmap.sys5,
            R.mipmap.sys6,
            R.mipmap.sys7,
            R.mipmap.sys8,
            R.mipmap.sys9,
            R.mipmap.sys10,
            R.mipmap.sys11,
            R.mipmap.sys12,
            R.mipmap.sys13,
            R.mipmap.sys14,
            R.mipmap.sys15,
            R.mipmap.sys16,
            R.mipmap.sys17,
            R.mipmap.sys18,
            R.mipmap.sys19,
            R.mipmap.sys20,
            R.mipmap.sys21,
            R.mipmap.sys22,
            R.mipmap.sys23,
            R.mipmap.sys24,
            R.mipmap.sys25,
            R.mipmap.sys26,
            R.mipmap.sys27,
            R.mipmap.sys28,
            R.mipmap.sys29,
            R.mipmap.sys30,
            R.mipmap.sys31,
            R.mipmap.sys32,
            R.mipmap.sys33,
            R.mipmap.sys34,
            R.mipmap.sys35,
            R.mipmap.sys36,
            R.mipmap.sys37,
            R.mipmap.sys38,
            R.mipmap.sys39,
            R.mipmap.sys40,
            R.mipmap.sys41,
            R.mipmap.sys42,
            R.mipmap.sys43,
            R.mipmap.sys44,
            R.mipmap.sys45,
            R.mipmap.sys46,
            R.mipmap.sys47,
            R.mipmap.sys48,
            R.mipmap.sys49,
            R.mipmap.sys50,
            R.mipmap.sys51,

    };

    public static final String[] emojiTextArray = {
            "[惊讶]",
            "[撇嘴]",
            "[色]",
            "[瞪眼]",
            "[帅气]",
            "[可怜]",
            "[害羞]",
            "[闭嘴]",
            "[睡]",
            "[哭]",
            "[尴尬]",
            "[生气]",
            "[可爱]",
            "[笑]",
            "[微笑]",
            "[伤心]",
            "[酷]",
            "[冷汗]",
            "[抓狂]",
            "[吐]",
            "[偷笑]",
            "[可爱]",
            "[白眼]",
            "[快哭了]",
            "[亲亲]",
            "[吓]",
            "[惊恐]",
            "[汗]",
            "[大笑]",
            "[大兵]",
            "[奋斗]",
            "[辱骂]",
            "[疑问]",
            "[嘘]",
            "[晕]",
            "[委屈]",
            "[衰]",
            "[骷髅]",
            "[鄙视]",
            "[再见]",
            "[鲜花]",
            "[枯萎]",
            "[嘴唇]",
            "[心碎]",
            "[爱心]",
            "[赞]",
            "[弱]",
            "[握手]",
            "[耶]",
            "[便便]",
            "[拍手]",

    };


}
