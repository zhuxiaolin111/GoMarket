package com.My;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.jarvis.mytaobaotest.R;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class Shop_Activity extends Activity {
    private int[] resId = { R.drawable.show_m1, R.drawable.menu_viewpager_1, R.drawable.menu_viewpager_2, R.drawable.menu_viewpager_3, R.drawable.menu_viewpager_4, R.drawable.menu_viewpager_5 };
  ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_layout);
    }

}
