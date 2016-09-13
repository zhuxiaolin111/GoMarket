package com.jarvis.mytaobao.user;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jarvis.MyView.SpinerPopWindow_ShopManager;
import com.jarvis.mytaobaotest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
public class ShopManager_A extends Activity {
    private SpinerPopWindow_ShopManager<String> mSpinerPopWindow, mSpinerPopWindow1, mSpinerPopWindow2;
    TextView tv_value_sheng, tv_value_shi, tv_value_qu;
    private List<String> list, list1, list2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_manager_layout);
        initData();
        initData1();
        initData2();
        mSpinerPopWindow = new SpinerPopWindow_ShopManager<String>(this, list, itemClickListener);
        mSpinerPopWindow.setOnDismissListener(dismissListener);
        mSpinerPopWindow1 = new SpinerPopWindow_ShopManager<String>(this, list1, itemClickListener1);
        mSpinerPopWindow1.setOnDismissListener(dismissListener1);
        mSpinerPopWindow2 = new SpinerPopWindow_ShopManager<String>(this, list2, itemClickListener2);
        mSpinerPopWindow2.setOnDismissListener(dismissListener2);
        tv_value_sheng = (TextView) findViewById(R.id.tv_value_sheng);
        tv_value_shi = (TextView) findViewById(R.id.tv_value_shi);
        tv_value_qu = (TextView) findViewById(R.id.tv_value_qu);
        tv_value_sheng.setOnClickListener(clickListener);
        tv_value_shi.setOnClickListener(clickListener);
        tv_value_qu.setOnClickListener(clickListener);


    }

    /**
     * 监听popupwindow取消
     */
    private PopupWindow.OnDismissListener dismissListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            setTextImage(R.drawable.icon_down);
        }
    };
    private PopupWindow.OnDismissListener dismissListener1 = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            setTextImage1(R.drawable.icon_down);
        }
    };
    private PopupWindow.OnDismissListener dismissListener2 = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            setTextImage2(R.drawable.icon_down);
        }
    };
    /**
     * popupwindow显示的ListView的item点击事件
     */
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow.dismiss();
            //  tv_value_sheng.setText(sheng[position]);
            tv_value_sheng.setText(list.get(position));

            // Toast.makeText(this,"点击了:" + list.get(position),Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemClickListener itemClickListener1 = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow1.dismiss();
            //   tv_value_shi.setText(shi[position]);
            tv_value_shi.setText(list1.get(position));
            //  Toast.makeText(getActivity(), "点击了:" + list.get(position),Toast.LENGTH_LONG).show();
        }
    };
    private AdapterView.OnItemClickListener itemClickListener2 = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow2.dismiss();
            //  tv_value_qu.setText(qu[position]);
            tv_value_qu.setText(list2.get(position));
            //  Toast.makeText(getActivity(), "点击了:" + list.get(position),Toast.LENGTH_LONG).show();
        }
    };
    /**
     * 显示PopupWindow
     */
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_value_sheng:
                    mSpinerPopWindow.setWidth(tv_value_sheng.getWidth());
                    mSpinerPopWindow.showAsDropDown(tv_value_sheng);
                    setTextImage(R.drawable.icon_up);
                    break;
                case R.id.tv_value_shi:
                    mSpinerPopWindow1.setWidth(tv_value_shi.getWidth());
                    mSpinerPopWindow1.showAsDropDown(tv_value_shi);
                    setTextImage1(R.drawable.icon_up);
                    break;
                case R.id.tv_value_qu:
                    mSpinerPopWindow2.setWidth(tv_value_qu.getWidth());
                    mSpinerPopWindow2.showAsDropDown(tv_value_qu);
                    setTextImage2(R.drawable.icon_up);
                    break;
            }
        }
    };

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<String>();
        list.add("辽宁");
        list.add("吉林");
        list.add("黑龙江");
    }

    private void initData1() {
        list1 = new ArrayList<String>();
        list1.add("沈阳");
        list1.add("大连");
        list1.add("朝阳");
    }

    private void initData2() {
        list2 = new ArrayList<String>();
        list2.add("沈河");
        list2.add("和平");
        list2.add("大东");
    }

    /**
     * 给TextView右边设置图片
     *
     * @param resId
     */
    private void setTextImage(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tv_value_sheng.setCompoundDrawables(null, null, drawable, null);

    }

    private void setTextImage1(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tv_value_shi.setCompoundDrawables(null, null, drawable, null);
    }

    private void setTextImage2(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tv_value_qu.setCompoundDrawables(null, null, drawable, null);
    }
}
