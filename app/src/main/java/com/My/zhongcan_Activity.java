package com.My;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvis.mytaobaotest.R;

/**
 * Created by mn on 2016/7/8.
 */
public class zhongcan_Activity extends Activity{
    TextView index,my,exit;
    ImageView goback,shangjia,huangniu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhongcan_layout);
        index= (TextView) findViewById(R.id.index);
        my= (TextView) findViewById(R.id.my);
        exit= (TextView) findViewById(R.id.exit);
        shangjia= (ImageView) findViewById(R.id.shangjia_image);
        huangniu= (ImageView) findViewById(R.id.huangniu_image);
        goback= (ImageView) findViewById(R.id.goback);
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(zhongcan_Activity.this,Index_Activity.class);
                startActivity(intent);
             //    Toast.makeText(zhongcan_Activity.this, "已经是首页", Toast.LENGTH_SHORT).show();
            }
        });
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(zhongcan_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog b = new AlertDialog.Builder(zhongcan_Activity.this)
                        .setTitle("提示")
                        .setIcon(R.drawable.f020)
                        .setMessage("确定要退出吗？\n老实取消了吧？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent intent=new Intent(zhongcan_Activity.this,Login_Activity.class);
                                startActivity(intent);
                                //   Toast.makeText(Ex25Activity.this, "这就对了嘛！！！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                                Toast.makeText(zhongcan_Activity.this, "这就对了嘛！！！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                b.show();
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(zhongcan_Activity.this,Index_Activity.class);
                startActivity(intent);
            }
        });
        shangjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(zhongcan_Activity.this, "玩命实现中！！！", Toast.LENGTH_SHORT).show();
            }
        });
        huangniu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(zhongcan_Activity.this, "有待于开发", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private long startTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        // 手机按键按下都会触发该事件
        // 判断是否按下返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - startTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
                startTime = System.currentTimeMillis();
            } else {
                this.finish();
            }
        }
        return true;

    }
}
