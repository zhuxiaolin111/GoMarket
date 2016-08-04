package com.jarvis.mytaobao.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarvis.mytaobao.home.Main_FA;
import com.jarvis.mytaobaotest.R;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
public class Address_A extends Activity implements View.OnClickListener {
    ImageView Goback_user;
    TextView Go_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        Goback_user= (ImageView) findViewById(R.id.img_goback_index);
        Go_index= (TextView) findViewById(R.id.tv_go_index);
        Go_index.setOnClickListener(this);
        Goback_user.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_goback_index:
                finish();
                break;
            case R.id. tv_go_index:
                Intent intent=new Intent(this, Main_FA.class);
                startActivity(intent);
                break;
        }
    }
}
