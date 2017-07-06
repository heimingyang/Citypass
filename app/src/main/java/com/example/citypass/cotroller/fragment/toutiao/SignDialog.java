package com.example.citypass.cotroller.fragment.toutiao;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citypass.R;
import com.example.citypass.cotroller.fragment.life.WebViewActivity;

public class SignDialog extends Dialog {
//
	private ImageView delete, daysImage,submit;
    private TextView coinTextView, integerTextView, content1, content2;

	private Context context;

	public SignDialog(Context context) {
		super(context, R.style.JiaodianDialog);
		this.context = context;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_dialog_layout);
		init();
		set();
	}

	private void init() {
		delete = (ImageView) findViewById(R.id.delete_imageview);
		submit = (ImageView) findViewById(R.id.submit);
		daysImage = (ImageView) findViewById(R.id.days_imageview);
		coinTextView = (TextView) findViewById(R.id.coin_textview);
		integerTextView = (TextView) findViewById(R.id.integer_textview);
		content1 = (TextView) findViewById(R.id.content1_textview);
		content2 = (TextView) findViewById(R.id.content2_textview);

	}

	public void showDialog(int coin, int integer, int days, String con1,
			String con2) {
		coinTextView.setText("城市币 +" + coin);
		integerTextView.setText("成长值 +" + integer);
		content1.setText(con1);
		content2.setText(con2);
		switch (days) {
		case 1:
			daysImage.setImageResource(R.drawable.sign_icon1);
			break;
		case 2:
			daysImage.setImageResource(R.drawable.sign_icon2);
			break;
		case 3:
			daysImage.setImageResource(R.drawable.sign_icon3);
			break;
		case 4:
			daysImage.setImageResource(R.drawable.sign_icon4);
			break;
		case 5:
			daysImage.setImageResource(R.drawable.sign_icon5);
			break;
		case 6:
			daysImage.setImageResource(R.drawable.sign_icon6);
			break;
		case 7:
			daysImage.setImageResource(R.drawable.sign_icon7);
			break;

		default:
			break;
		}
		super.show();
	}

	private void set() {
		Window window = this.getWindow();
		// 设置动画效果
		window.setWindowAnimations(R.style.dialog_out_animstyle);

		delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				SignDialog.this.dismiss();
			}
		});
		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentTwo = new Intent(context, WebViewActivity.class);
				intentTwo.putExtra("url","http://m.yanqing.ccoo.cn/choujiang.aspx");
				intentTwo.putExtra("webview_title","抽奖活动");
				context.startActivity(intentTwo);
			}
		});
	}

}