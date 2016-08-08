package com.jarvis.mytaobao.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.jarvis.mytaobao.home.Main_FA;
import com.jarvis.mytaobaotest.R;
import com.javis.Adapter.Adapter_GridView;

/**
 * 我的淘宝主界面
 *
 * @author http://yecaoly.taobao.com
 */
public class User_F extends Fragment implements OnClickListener {
    private GridView my_gridView_user;
    private Adapter_GridView adapter_GridView;
    //资源文件
    private int[] pic_path = {R.drawable.user_3, R.drawable.user_4, R.drawable.user_5, R.drawable.user_6, R.drawable.user_7};

    private LinearLayout ll_user_life;
    private LinearLayout ll_user_members;
    private LinearLayout ll_user_store;
    private LinearLayout ll_user_opinion;
    private LinearLayout go_myEdit, go_favorites, go_cart, go_myWallet, go_address, go_shop_manager;



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.my_layout, null);

        initView(view);
        return view;
    }


    private void initView(View view) {

        go_myEdit = (LinearLayout) view.findViewById(R.id.linear_go_myedit);
        go_address = (LinearLayout) view.findViewById(R.id.liner_go_address);
        go_favorites = (LinearLayout) view.findViewById(R.id.iv_menu_2);
        go_cart = (LinearLayout) view.findViewById(R.id.iv_menu_3);
        go_myWallet = (LinearLayout) view.findViewById(R.id.iv_menu_1);
        go_shop_manager = (LinearLayout) view.findViewById(R.id.linear_go_shop_manager);
        go_myEdit.setOnClickListener(this);
        go_favorites.setOnClickListener(this);
        go_cart.setOnClickListener(this);
        go_address.setOnClickListener(this);
        go_myWallet.setOnClickListener(this);
        go_shop_manager.setOnClickListener(this);

		/*((TextView)view.findViewById(R.id.tv_top_txtTitle)).setText("我的淘宝");
        ll_user_life=(LinearLayout) view.findViewById(R.id.ll_user_life);
		ll_user_members=(LinearLayout) view.findViewById(R.id.ll_user_members);
		ll_user_store=(LinearLayout) view.findViewById(R.id.ll_user_store);
		ll_user_opinion=(LinearLayout) view.findViewById(R.id.ll_user_opinion);
		ll_user_life.setOnClickListener(this);
		ll_user_members.setOnClickListener(this);
		ll_user_store.setOnClickListener(this);
		ll_user_opinion.setOnClickListener(this);


		my_gridView_user=(GridView)view.findViewById(R.id.gridView_user);
		my_gridView_user.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter_GridView=new Adapter_GridView(getActivity(), pic_path);
		my_gridView_user.setAdapter(adapter_GridView);
		my_gridView_user.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
									long arg3) {
				//进入本机拥有传感器界面
				Intent intent=new Intent(getActivity(),HelloSensor.class);
				startActivity(intent);

			}
		});*/


    }


    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.ll_user_life:
                //进入刮刮乐界面
                Intent intent1 = new Intent(getActivity(), User_life.class);
                startActivity(intent1);
                break;
            case R.id.ll_user_members:
                //进入刮刮乐界面
                Intent intent2 = new Intent(getActivity(), User_life.class);
                startActivity(intent2);
                break;
            case R.id.ll_user_store:
                //进入刮刮乐界面
                Intent intent3 = new Intent(getActivity(), User_life.class);
                startActivity(intent3);
                break;
            case R.id.ll_user_opinion:
                //意见反馈界面
                Intent intent4 = new Intent(getActivity(), User_opinion.class);
                startActivity(intent4);
                break;
            case R.id.linear_go_myedit:
                //进入手机号界面 my_edit
                Intent i1 = new Intent(getActivity(), MyEdit_A.class);
                startActivity(i1);
                break;
            case R.id.iv_menu_2:
                //进入收藏夹
                Main_FA.getMainActivity().onClick(arg0.findViewById(R.id.iv_menu_2));

                break;
            case R.id.iv_menu_3:
                //进入订单
                Main_FA.getMainActivity().onClick(arg0.findViewById(R.id.iv_menu_3));

                break;
            case R.id.iv_menu_1:
                //进入钱包
                Main_FA.getMainActivity().onClick(arg0.findViewById(R.id.iv_menu_1));
              /*  Intent i4 = new Intent(getActivity(), User_opinion.class);
                startActivity(i4);*/
                break;
            case R.id.liner_go_address:
                //进入收货地址
                Intent i5 = new Intent(getActivity(), Address_A.class);
                startActivity(i5);
                break;
            case R.id.linear_go_shop_manager:
                //进入我的店铺
                Intent i6 = new Intent(getActivity(), ShopManager_A.class);
                startActivity(i6);
                break;
            default:
                break;
        }

    }


}
