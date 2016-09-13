package com.jarvis.mytaobao.home;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvis.MyView.SpinerPopWindow;
import com.jarvis.mytaobao.MyActivity.Shop_F;
import com.jarvis.mytaobaotest.R;
import com.javis.Adapter.Adapter_GridView;
import com.javis.Adapter.Adapter_GridView_hot;
import com.javis.ab.view.AbOnItemClickListener;
import com.javis.ab.view.AbSlidingPlayView;

import java.util.ArrayList;
import java.util.List;




/**
 * 首页
 * @author http://yecaoly.taobao.com
 */
public class Home_F extends Fragment implements View.OnClickListener{
	private Shop_F shop_activity;
	private SpinerPopWindow<String> mSpinerPopWindow,mSpinerPopWindow1;
	private List<String> list;
	private TextView tvValue,tvValue1;
	private TextView goShop,goMap;
	//顶部标题栏
	private TextView tv_top_title;
	//分类的九宫格
	private GridView gridView_classify;
	//热门市场的九宫格
	private GridView my_gridView_hot;
	private Adapter_GridView adapter_GridView_classify;
	private Adapter_GridView_hot adapter_GridView_hot;
	//首页轮播
	private AbSlidingPlayView viewPager;
	//扫一扫
	private ImageView iv_shao;
	// 分类九宫格的资源文件
	private int[] pic_path_classify = { R.drawable.menu_index_1, R.drawable.menu_index_2, R.drawable.menu_index_3, R.drawable.menu_index_4, R.drawable.menu_index_5, R.drawable.menu_index_6, R.drawable.menu_index_7, R.drawable.menu_index_8 ,R.drawable.menu_index_9 ,R.drawable.menu_index_10 };
	// 热门市场的资源文件
	private int[] pic_path_hot = { R.drawable.menu_1, R.drawable.menu_2, R.drawable.menu_3, R.drawable.menu_4, R.drawable.menu_5, R.drawable.menu_6 };
	/**存储首页轮播的界面*/
	private ArrayList<View> allListView;
	/**首页轮播的界面的资源*/
	private int[] resId = { R.drawable.show_m1, R.drawable.menu_viewpager_1, R.drawable.menu_viewpager_2, R.drawable.menu_viewpager_3, R.drawable.menu_viewpager_4, R.drawable.menu_viewpager_5 };


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_f, null);

		initData();
		goMap= (TextView) view.findViewById(R.id.goMap);
		goShop= (TextView) view.findViewById(R.id.goShop);
		goMap.setOnClickListener(this);
		goShop.setOnClickListener(this);
		tvValue1= (TextView) view.findViewById(R.id.tv_value1);
		tvValue = (TextView) view.findViewById(R.id.tv_value);
		tvValue.setOnClickListener(clickListener);
		tvValue1.setOnClickListener(clickListener);
		mSpinerPopWindow = new SpinerPopWindow<String>(getActivity(), list,itemClickListener);
		mSpinerPopWindow.setOnDismissListener(dismissListener);
		mSpinerPopWindow1 = new SpinerPopWindow<String>(getActivity(), list,itemClickListener1);
		mSpinerPopWindow1.setOnDismissListener(dismissListener1);
		initView(view);
		return view;
	}

	private void initView(View view) {
		gridView_classify = (GridView) view.findViewById(R.id.my_gridview);
		my_gridView_hot = (GridView) view.findViewById(R.id.my_gridview_hot);
		gridView_classify.setSelector(new ColorDrawable(Color.TRANSPARENT));
		my_gridView_hot.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter_GridView_classify = new Adapter_GridView(getActivity(), pic_path_classify);
		adapter_GridView_hot = new Adapter_GridView_hot(getActivity(), pic_path_hot);
		gridView_classify.setAdapter(adapter_GridView_classify);
		my_gridView_hot.setAdapter(adapter_GridView_hot);

		viewPager = (AbSlidingPlayView) view.findViewById(R.id.viewPager_menu);
		//设置播放方式为顺序播放
		viewPager.setPlayType(1);
		//设置播放间隔时间
		viewPager.setSleepTime(3000);

		gridView_classify.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				//挑战到宝贝搜索界面
				Intent intent = new Intent(getActivity(), WareActivity.class);
				startActivity(intent);
			}
		});
		my_gridView_hot.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				//跳转到宝贝详情界面
				Intent intent = new Intent(getActivity(), BabyActivity.class);
				startActivity(intent);
			}
		});

		initViewPager();
	}

	private void initViewPager() {

		if (allListView != null) {
			allListView.clear();
			allListView = null;
		}
		allListView = new ArrayList<View>();

		for (int i = 0; i < resId.length; i++) {
			//导入ViewPager的布局
			View view = LayoutInflater.from(getActivity()).inflate(R.layout.pic_item, null);
			ImageView imageView = (ImageView) view.findViewById(R.id.pic_item);
			imageView.setImageResource(resId[i]);
			allListView.add(view);
		}


		viewPager.addViews(allListView);
		//开始轮播
		viewPager.startPlay();
		viewPager.setOnItemClickListener(new AbOnItemClickListener() {
			@Override
			public void onClick(int position) {
				//跳转到详情界面
				Intent intent = new Intent(getActivity(), BabyActivity.class);
				startActivity(intent);
			}
		});
	}
	/**
	 * 监听popupwindow取消
	 */
	private PopupWindow.OnDismissListener dismissListener=new PopupWindow.OnDismissListener() {
		@Override
		public void onDismiss() {
			setTextImage(R.drawable.icon_down);
		}
	};
	private PopupWindow.OnDismissListener dismissListener1=new PopupWindow.OnDismissListener() {
		@Override
		public void onDismiss() {
			setTextImage1(R.drawable.icon_down);
		}
	};

	/**
	 * popupwindow显示的ListView的item点击事件
	 */
	private OnItemClickListener itemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			mSpinerPopWindow.dismiss();

			tvValue.setText(list.get(position));

			Toast.makeText(getActivity(), "点击了:" + list.get(position),Toast.LENGTH_LONG).show();
		}
	};
	private OnItemClickListener itemClickListener1 = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			mSpinerPopWindow1.dismiss();
			tvValue1.setText(list.get(position));
			Toast.makeText(getActivity(), "点击了:" + list.get(position),Toast.LENGTH_LONG).show();
		}
	};

	/**
	 * 显示PopupWindow
	 */
	private View.OnClickListener clickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.tv_value:
					mSpinerPopWindow.setWidth(tvValue.getWidth());
					mSpinerPopWindow.showAsDropDown(tvValue);
					setTextImage(R.drawable.icon_up);
					break;
				case R.id.tv_value1:
					mSpinerPopWindow1.setWidth(tvValue1.getWidth());
					mSpinerPopWindow1.showAsDropDown(tvValue1);
					setTextImage1(R.drawable.icon_up);
					break;
			}
		}
	};

	/**
	 * 初始化数据
	 */
	private void initData() {
		list = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			list.add("test:" + i);
		}
	}

	/**
	 * 给TextView右边设置图片
	 * @param resId
	 */
	private void setTextImage(int resId) {
		Drawable drawable = getResources().getDrawable(resId);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
			tvValue.setCompoundDrawables(null, null, drawable, null);

	}
	private void setTextImage1(int resId) {
		Drawable drawable = getResources().getDrawable(resId);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
		tvValue1.setCompoundDrawables(null, null, drawable, null);
	}

	/**
	 * Called when a view has been clicked.
	 *
	 * @param v The view that was clicked.
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.goMap:
				break;
			case R.id.goShop:
				Main_FA.getMainActivity().onClick(v.findViewById(R.id.goShop));
			//	Main_FA.getMainActivity().addFragment(shop_activity);
			//	Main_FA.getMainActivity().showFragment(shop_activity);
				break;
		}
	}
}
