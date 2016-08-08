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
public class Payment_Activity extends Activity {
    Button btn_zhifu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_layout);
        btn_zhifu= (Button) findViewById(R.id.btn_zhifu);
        btn_zhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Payment_Activity.this,TiJiao_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
