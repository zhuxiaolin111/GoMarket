package com.My;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jarvis.mytaobaotest.R;

/**
 * Created by mn on 2016/7/8.
 */
public class Register_Avtivity extends Activity {
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zuce_layout);
        login= (Button) findViewById(R.id.login);
        register= (Button) findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register_Avtivity.this,Login_Activity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register_Avtivity.this,"功能还没实现",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
