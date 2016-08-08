package com.jarvis.mytaobao.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.jarvis.mytaobaotest.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class DrawMoney_Activity extends Activity {
    ImageView img_goback_shang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_money);
        img_goback_shang = (ImageView) findViewById(R.id.img_goback_shang);
        img_goback_shang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
