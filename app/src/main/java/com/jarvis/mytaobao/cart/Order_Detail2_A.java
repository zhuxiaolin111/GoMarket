package com.jarvis.mytaobao.cart;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jarvis.mytaobaotest.R;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class Order_Detail2_A extends Activity{
    ImageView img_goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail2_layout);
        img_goback= (ImageView) findViewById(R.id.img_goback_shang);
        img_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
