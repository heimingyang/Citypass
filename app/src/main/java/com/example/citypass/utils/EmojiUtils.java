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
            R.drawable.sys1,
            R.drawable.sys2,
            R.drawable.sys3,
            R.drawable.sys4,
            R.drawable.sys5,
            R.drawable.sys6,
            R.drawable.sys7,
            R.drawable.sys8,
            R.drawable.sys9,
            R.drawable.sys10,
            R.drawable.sys11,
            R.drawable.sys12,
            R.drawable.sys13,
            R.drawable.sys14,
            R.drawable.sys15,
            R.drawable.sys16,
            R.drawable.sys17,
            R.drawable.sys18,
            R.drawable.sys19,
            R.drawable.sys20,
            R.drawable.sys21,
            R.drawable.sys22,
            R.drawable.sys23,
            R.drawable.sys24,
            R.drawable.sys25,
            R.drawable.sys26,
            R.drawable.sys27,
            R.drawable.sys28,
            R.drawable.sys29,
            R.drawable.sys30,
            R.drawable.sys31,
            R.drawable.sys32,
            R.drawable.sys33,
            R.drawable.sys34,
            R.drawable.sys35,
            R.drawable.sys36,
            R.drawable.sys37,
            R.drawable.sys38,
            R.drawable.sys39,
            R.drawable.sys40,
            R.drawable.sys41,
            R.drawable.sys42,
            R.drawable.sys43,
            R.drawable.sys44,
            R.drawable.sys45,
            R.drawable.sys46,
            R.drawable.sys47,
            R.drawable.sys48,
            R.drawable.sys49,
            R.drawable.sys50,
            R.drawable.sys51,

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
