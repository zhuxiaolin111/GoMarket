package com.jarvis.mytaobao.tao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.jarvis.mytaobao.home.Deposit_Activity;
import com.jarvis.mytaobao.home.Dispose_Activity;
import com.jarvis.mytaobao.home.DrawMoney_Activity;
import com.jarvis.mytaobaotest.R;

/**
 * 微淘主界面
 * @author http://yecaoly.taobao.com
 *
 */
public class Tao_F extends Fragment {

	private ListView listView_tao;
	Button btn_draw,btn_deposit,btn_dispose;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view=LayoutInflater.from(getActivity()).inflate(R.layout.my_wallet_wallet, null);
		initView(view);
		return view;
	}




	private void initView(View view){
		btn_draw= (Button) view.findViewById(R.id.btn_drawMoney);
		btn_deposit= (Button) view.findViewById(R.id.btn_deposit);
		btn_dispose= (Button) view.findViewById(R.id.btn_dispose);
		//提款
		btn_draw.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(), DrawMoney_Activity.class);
				startActivity(intent);
			}
		});
		//存款
		btn_deposit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(), Deposit_Activity.class);
				startActivity(intent);
			}
		});
		// 处理结果
		btn_dispose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),Dispose_Activity.class);
				startActivity(intent);
			}
		});
	/*	listView_tao=(ListView) view.findViewById(R.id.listView_tao);
		listView_tao.setAdapter(new Adapter_ListView_tao(getActivity()));
		listView_tao.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent=new Intent(getActivity(),BabyActivity.class);
				startActivity(intent);
			}
		});*/

	}


}
