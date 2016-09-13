package com.jarvis.mytaobao.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jarvis.mytaobao.home.FuKuan_Activity;
import com.jarvis.mytaobaotest.R;


/**
 * 购物车界面中的库存界面
 *
 * @author http://yecaoly.taobao.com
 */
public class Order_all_F extends Fragment {
    LinearLayout ll_wancheng, ll_zhifu, ll_shouhuo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.order_all_layout, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ll_shouhuo = (LinearLayout) view.findViewById(R.id.ll_cart_shouhuo);
        ll_wancheng = (LinearLayout) view.findViewById(R.id.ll_cart_wancheng);
        ll_zhifu = (LinearLayout) view.findViewById(R.id.ll_cart_fukuan);
        ll_shouhuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Order_Detail1_A.class);
                startActivity(intent);
            }
        });
        ll_zhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FuKuan_Activity.class);
                startActivity(intent);
            }
        });
        ll_wancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Order_Detail2_A.class);
                startActivity(intent);
            }
        });


    }

}
