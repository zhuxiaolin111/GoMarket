package com.jarvis.mytaobao.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvis.mytaobao.Data.Data;
import com.jarvis.mytaobao.MyActivity.Shop_F;
import com.jarvis.mytaobao.cart.Cart_F;
import com.jarvis.mytaobao.discover.Discover_F;
import com.jarvis.mytaobao.tao.Tao_F;
import com.jarvis.mytaobao.user.User_F;
import com.jarvis.mytaobaotest.R;
import com.javis.mytools.IBtnCallListener;
import com.zdp.aseo.content.AseoZdpAseo;

import java.util.HashMap;

/**
 * 整个程序最底层的框架Activity，所有的Fragment都是依赖于此Activity而存在的
 *
 * @author http://yecaoly.taobao.com
 */
public class Main_FA extends FragmentActivity implements OnClickListener, IBtnCallListener {
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    // 界面底部的菜单按钮
    private ImageView[] bt_menu = new ImageView[5];
    // 界面底部的菜单按钮id
    private int[] bt_menu_id = {R.id.iv_menu_0, R.id.iv_menu_1, R.id.iv_menu_2, R.id.iv_menu_3, R.id.iv_menu_4};

    // 界面底部的选中菜单按钮资源
//	private int[] select_on = { R.drawable.img_foot1sel, R.drawable.img_foot2sel, R.drawable.img_foot3sel, R.drawable.img_foot4sel, R.drawable.img_foot5sel };
    private int[] select_on = {R.drawable.img_foot1sel, R.drawable.img_foot2sel, R.drawable.img_foot3sel, R.drawable.img_foot4sel, R.drawable.img_foot5sel};
    // 界面底部的未选中菜单按钮资源
    private int[] select_off = {R.drawable.bt_menu_0_select, R.drawable.bt_menu_1_select, R.drawable.bt_menu_2_select, R.drawable.bt_menu_3_select, R.drawable.bt_menu_4_select};

    /**
     * 主界面
     */
    private Home_F home_F;
    /**
     * 微淘界面
     */
    private Tao_F tao_F;
    /**
     * 发现界面
     */
    private Discover_F discover_F;
    /**
     * 购物车界面
     */
    private Cart_F cart_F;
    /**
     * 我的淘宝界面
     */
    private User_F user_F;
    private Shop_F shop_activity;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fa);
        TextView textView = (TextView) findViewById(R.id.goShop);
        getSaveData();
        initView();
    }

    /**
     * 得到保存的购物车数据
     */
    private void getSaveData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        AseoZdpAseo.initTimer(this);
        SharedPreferences sp = getSharedPreferences("SAVE_CART", Context.MODE_PRIVATE);
        int size = sp.getInt("ArrayCart_size", 0);
        for (int i = 0; i < size; i++) {
            hashMap.put("type", sp.getString("ArrayCart_type_" + i, ""));
            hashMap.put("color", sp.getString("ArrayCart_color_" + i, ""));
            hashMap.put("num", sp.getString("ArrayCart_num_" + i, ""));
            Data.arrayList_cart.add(hashMap);
        }

    }

    // 初始化组件
    private void initView() {
        // 找到底部菜单的按钮并设置监听
        for (int i = 0; i < bt_menu.length; i++) {
            bt_menu[i] = (ImageView) findViewById(bt_menu_id[i]);
            bt_menu[i].setOnClickListener(this);
        }

        // 初始化默认显示的界面
        if (home_F == null) {
            home_F = new Home_F();
            addFragment(home_F);
            showFragment(home_F);
        } else {
            showFragment(home_F);
        }
        // 设置默认首页为点击时的图片
        bt_menu[0].setImageResource(select_on[0]);
        AseoZdpAseo.init(this, AseoZdpAseo.SCREEN_TYPE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu_0:
                // 主界面
                if (home_F == null) {
                    home_F = new Home_F();
                    // 判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏
                    addFragment(home_F);
                    showFragment(home_F);
                } else {
                    if (home_F.isHidden()) {
                        showFragment(home_F);
                    }
                }

                break;
            case R.id.iv_menu_1:
                // 微淘界面
                //钱包
                if (tao_F == null) {
                    tao_F = new Tao_F();
                    // 判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏
                    if (!tao_F.isHidden()) {
                        addFragment(tao_F);
                        showFragment(tao_F);
                    }
                } else {
                    if (tao_F.isHidden()) {
                        showFragment(tao_F);
                    }
                }

                break;
            case R.id.iv_menu_2:
                // 发现界面
                //收藏夹
                if (discover_F == null) {
                    discover_F = new Discover_F();
                    // 判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏
                    if (!discover_F.isHidden()) {
                        addFragment(discover_F);
                        showFragment(discover_F);
                    }
                } else {
                    if (discover_F.isHidden()) {
                        showFragment(discover_F);
                    }
                }

                break;
            case R.id.iv_menu_3:
                // 购物车界面//
                if (cart_F != null) {
                    removeFragment(cart_F);
                    cart_F = null;
                }
                cart_F = new Cart_F();
                // 判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏
                addFragment(cart_F);
                showFragment(cart_F);
                break;
            case R.id.iv_menu_4:
                // 我的淘宝界面
                //我的
                if (user_F == null) {
                    user_F = new User_F();
                    // 判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏
                    if (!user_F.isHidden()) {
                        addFragment(user_F);
                        showFragment(user_F);
                    }
                } else {
                    if (user_F.isHidden()) {
                        showFragment(user_F);
                    }
                }

                break;
            case R.id.goShop:
                if (shop_activity == null) {
                    shop_activity = new Shop_F();
                    // 判断当前界面是否隐藏，如果隐藏就进行添加显示，false表示显示，true表示当前界面隐藏
                    if (!shop_activity.isHidden()) {
                        addFragment(shop_activity);
                        showFragment(shop_activity);
                    }
                } else {
                    if (shop_activity.isHidden()) {
                        showFragment(shop_activity);
                    }
                }

                break;
        }

        // 设置按钮的选中和未选中资源
        for (int i = 0; i < bt_menu.length; i++) {
            bt_menu[i].setImageResource(select_off[i]);
            if (v.getId() == bt_menu_id[i]) {
                bt_menu[i].setImageResource(select_on[i]);
            }
        }
    }

    /**
     * 添加Fragment
     **/
    public void addFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.show_layout, fragment);
        ft.commit();
    }

    /**
     * 删除Fragment
     **/
    public void removeFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    /**
     * 显示Fragment
     **/
    public void showFragment(Fragment fragment) {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        // 设置Fragment的切换动画
        ft.setCustomAnimations(R.anim.cu_push_right_in, R.anim.cu_push_left_out);

        // 判断页面是否已经创建，如果已经创建，那么就隐藏掉
        if (home_F != null) {
            ft.hide(home_F);
        }
        if (tao_F != null) {
            ft.hide(tao_F);
        }
        if (discover_F != null) {
            ft.hide(discover_F);
        }
        if (cart_F != null) {
            ft.hide(cart_F);
        }
        if (user_F != null) {
            ft.hide(user_F);
        }
        if (shop_activity != null) {
            ft.hide(shop_activity);
        }

        ft.show(fragment);
        ft.commitAllowingStateLoss();

    }

    /**
     * 返回按钮的监听
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    /**
     * Fragment的回调函数
     */
    @SuppressWarnings("unused")
    private IBtnCallListener btnCallListener;

    @Override
    public void onAttachFragment(Fragment fragment) {
        try {
            btnCallListener = (IBtnCallListener) fragment;
        } catch (Exception e) {
        }

        super.onAttachFragment(fragment);
    }

    /**
     * 响应从Fragment中传过来的消息
     */
    @Override
    public void transferMsg() {
        if (home_F == null) {
            home_F = new Home_F();
            addFragment(home_F);
            showFragment(home_F);
        } else {
            showFragment(home_F);
        }
        bt_menu[3].setImageResource(select_off[3]);
        bt_menu[0].setImageResource(select_on[0]);

        System.out.println("由Fragment中传送来的消息");
    }

    public Main_FA() {
        Main_FA = this;
    }

    public static Main_FA getMainActivity() {
        return Main_FA;
    }

    private static Main_FA Main_FA;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
}
