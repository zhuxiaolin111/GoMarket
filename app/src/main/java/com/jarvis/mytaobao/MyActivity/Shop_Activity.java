package com.jarvis.mytaobao.MyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarvis.mytaobao.home.BabyActivity;
import com.jarvis.mytaobao.home.Main_FA;
import com.jarvis.mytaobaotest.R;
import com.javis.ab.view.AbOnItemClickListener;
import com.javis.ab.view.AbSlidingPlayView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class Shop_Activity extends Fragment {
    private AbSlidingPlayView viewPager;
    private ArrayList<View> allListView;
    private int[] resId = {R.drawable.show_m1, R.drawable.menu_viewpager_1, R.drawable.menu_viewpager_2, R.drawable.menu_viewpager_3, R.drawable.menu_viewpager_4, R.drawable.menu_viewpager_5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.shop_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_goback_index);
        TextView textView = (TextView) view.findViewById(R.id.tv_go_index);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main_FA.class);
                startActivity(intent);

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main_FA.class);
                startActivity(intent);

            }
        });

        initView(view);
        return view;

    }

    private void initView(View view) {
        viewPager = (AbSlidingPlayView) view.findViewById(R.id.viewPager_menu);
        //设置播放方式为顺序播放
        viewPager.setPlayType(1);
        //设置播放间隔时间
        viewPager.setSleepTime(3000);
        initViewPager();
    }

    /*  @Override

      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.shop_layout);
          ImageView imageView = (ImageView) findViewById(R.id.img_goback_index);
          TextView textView = (TextView) findViewById(R.id.tv_go_index);
          viewPager = (AbSlidingPlayView)findViewById(R.id.viewPager_menu);
          //设置播放方式为顺序播放
          viewPager.setPlayType(1);
          //设置播放间隔时间
          viewPager.setSleepTime(3000);
          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(Shop_Activity.this, Main_FA.class);
                  startActivity(intent);
                  finish();
              }
          });
          textView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(Shop_Activity.this, Main_FA.class);
                  startActivity(intent);
                  finish();
              }
          });
          initViewPager();
      }*/
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
}
