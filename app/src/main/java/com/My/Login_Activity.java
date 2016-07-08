package com.My;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jarvis.mytaobao.home.Main_FA;
import com.jarvis.mytaobaotest.R;

/**
 * Created by mn on 2016/7/8.
 */
public class Login_Activity extends Activity{
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_lyaout);
        login= (Button) findViewById(R.id.login);
        register= (Button) findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login_Activity.this, Main_FA.class);
                startActivity(intent);
              //  Toast.makeText(Login_Activity.this,"还没有这个功能·",Toast.LENGTH_SHORT).show();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login_Activity.this,Register_Avtivity.class);
                startActivity(intent);
            }
        });
    }
}
