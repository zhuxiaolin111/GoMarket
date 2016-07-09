package com.jarvis.mytaobao.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarvis.mytaobaotest.R;
import com.zdp.aseo.content.AseoZdpAseo;

/**
 * �����������
 * @author http://yecaoly.taobao.com
 *
 */
public class User_opinion extends Activity implements OnClickListener { 

	private ImageView iv_back;
	private TextView tv_goMyShop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.user_opinion);
		initView();
	}
	
	private void initView(){
		
		iv_back=(ImageView) findViewById(R.id.iv_opinion_back);

		AseoZdpAseo.initType(this, AseoZdpAseo.INSERT_TYPE);
		iv_back.setOnClickListener(this);
		tv_goMyShop.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.iv_opinion_back:
			finish();
			break;

		default:
			break;
		}
	}
	
	

}
