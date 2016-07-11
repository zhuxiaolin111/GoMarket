package com.My;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.jarvis.mytaobaotest.R;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by mn on 2016/7/11.
 */
public class SlidingMenu extends HorizontalScrollView {
    LinearLayout mWapper;
    ViewGroup mMenu, mContent;
    int mScreenWidth;
    int mMenuWidth;
    int mMenuRightPadding = 50;
    boolean once = false;
    boolean isOpen = false;

    public SlidingMenu(Context context) {
        this(context, null);
    }

    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SlidingMenu, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SlidingMenu_leftPadding:
                    mMenuRightPadding = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().
                            getDisplayMetrics()));
                    break;
            }
            a.recycle();
            WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
            DisplayMetrics outMetrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(outMetrics);
            mScreenWidth = outMetrics.widthPixels;
//工具类 把int 强转成dp；
         /*   mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().
                    getDisplayMetrics());*/
        }

    }


    /*public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm= (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics outMetrics=new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        mScreenWidth=outMetrics.widthPixels;
        //
       mMenuRightPadding= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().
                getDisplayMetrics());
    }*/


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mWapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWapper.getChildAt(0);
            mContent = (ViewGroup) mWapper.getChildAt(1);
            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth - mMenuRightPadding;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.scrollTo(mMenuWidth, 0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX >= mMenuWidth / 2) {
                    this.smoothScrollTo(mMenuWidth, 0);
                } else {
                    this.smoothScrollTo(0, 0);
                }
                return true;

        }
        return super.onTouchEvent(ev);
    }

    public void openMenu() {
        if (isOpen) return;
        this.smoothScrollTo(0, 0);
        isOpen = true;
    }

    public void closeMenu() {
        if (!isOpen) return;
        this.smoothScrollTo(mMenuWidth, 0);
        isOpen = false;
    }

    public void toggle() {
        if (isOpen) {
            closeMenu();
        } else {
            openMenu();
        }

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        float scale = l * mMenuWidth * 1.0f;
        float leftScale = 1.0f - scale * 0.3f;
        float leftAlpha = 0.6f + 0.4f * (1 - scale);
        float rightScale = 0.7f + 0.3f * scale;
        ViewHelper.setTranslationX(mMenu, scale * mMenuWidth);
        //设置缩放中心点
        //  ViewHelper.setPivotX(mContent,0);
        // ViewHelper.setPivotY(mContent,mContent.getHeight()/2);
        //缩放方法

        // ViewHelper.setScaleX(mContent, rightScale);ViewHelper.setScaleY(mContent, rightScale);
        // ViewHelper.setScaleY(mMenu, 0.5f + 0.5f * mMenuWidth);

        //ViewHelper.setAlpha(mMenu, mMenuWidth);
     /*  getBackground().setColorFilter(
                evaluate(mMenuWidth, Color.BLACK, Color.TRANSPARENT),
                PorterDuff.Mode.SRC_OVER);*/
    }
}