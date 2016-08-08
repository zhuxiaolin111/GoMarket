package com.jarvis.mytaobao.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jarvis.mytaobaotest.R;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class FuKuan_Activity extends Activity {
    private Button btn_fukuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_layout);
        btn_fukuan= (Button) findViewById(R.id.btn_fukuan);
        btn_fukuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FuKuan_Activity.this,Payment_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
