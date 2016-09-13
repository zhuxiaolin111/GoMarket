package com.jarvis.mytaobao.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jarvis.mytaobaotest.R;

/**
 * 购物车界面中的降价宝贝界面
 * @author http://yecaoly.taobao.com
 *
 */
public class Order_shouhuo_F extends Fragment {
	private LinearLayout linearLayout,linearLayout1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view=LayoutInflater.from(getActivity()).inflate(R.layout.order_shouhuo_layout, null);
		initView(view);
		return view;
	}

	private void initView(View view){
		linearLayout= (LinearLayout) view.findViewById(R.id.ll_cart_shouhuo);
		linearLayout1= (LinearLayout) view.findViewById(R.id.ll_cart_shouhuo1);
		linearLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),Order_Detail1_A.class);
				startActivity(intent);
			}
		});
		linearLayout1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),Order_Detail1_A.class);
				startActivity(intent);
			}
		});
	}

}
