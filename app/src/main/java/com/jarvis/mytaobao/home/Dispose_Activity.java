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
public class Dispose_Activity extends Activity {
    ImageView img_goback_sahng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispose_layout);
        img_goback_sahng = (ImageView) findViewById(R.id.img_goback_shang);
        img_goback_sahng.setOnClickListener(new View.OnClickListener() {
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
