package com.My;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jarvis.mytaobaotest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mn on 2016/7/10.
 */
public class Shangjia_Activity extends Activity {
    GridView gridView;
     SlidingMenu mleftMenu;
    Button queren;
    ImageView goback;
    TextView cart;
    ListView menuListView;
    int[] imgs = {R.drawable.cafe4, R.drawable.cafe1, R.drawable.cafe3, R.drawable.cafe2,
    };
    String[] name = {"咖啡1", "咖啡2", "咖啡3", "咖啡4"};
    String[] price = {"￥50.00", "￥50.00", "￥50.00", "￥50.00",};
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shangjia1_layout);
        mleftMenu= (SlidingMenu) findViewById(R.id.mLeftMenu);
        gridView = (GridView) findViewById(R.id.my_gridview);
        Map<String, Object> map0 = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        map0.put("name", name[0]);
        map0.put("image", imgs[0]);
        map0.put("price", price[0]);
        list.add(map0);
        map1.put("name", name[1]);
        map1.put("image", imgs[1]);
        list.add(map3);
        map1.put("price", price[1]);
        list.add(map1);
        map2.put("name", name[2]);
        map2.put("image", imgs[2]);
        map2.put("price", price[2]);
        list.add(map2);
        map3.put("name", name[3]);
        map3.put("image", imgs[3]);
        map3.put("price", price[3]);

     /*  for(int i=0;i<imgs.length;i++){
            map.put("image",imgs[i]);
           list.add(map);
        }
        for(int i=0;i<price.length;i++){
            map.put("price",price[i]);
           list.add(map);
        }*/

        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.shangjia_img_lyaout, new String[]{"image", "name", "price"}, new int[]{R.id.image, R.id.name, R.id.price});
        gridView.setAdapter(sa);
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.dialog_layout,
                                (ViewGroup) findViewById(R.id.dialog));   new AlertDialog.Builder(Shangjia_Activity.this).setTitle("点餐提示").setView(layout)
                            .setPositiveButton("确定", null)
                            .setNegativeButton("取消", null).show();
                     /*  // AlertDialog b = new AlertDialog.Builder(Shangjia_Activity.this)
                        new AlertDialog.Builder(Shangjia_Activity.this).setTitle("点餐提示").setIcon(
                                android.R.drawable.ic_dialog_info).setMessage("亲请输入数量：").
                                setView(
                                new EditText(Shangjia_Activity.this))
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Intent intent=new Intent(Index_Activity.this,Login_Activity.class);
                                        //startActivity(intent);
                                        Toast.makeText(Shangjia_Activity.this, "这就对了嘛！！！", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Toast.makeText(Shangjia_Activity.this, "这就对了嘛！！！", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .create().show();
*/

                }
            }
        });
    }
    public void toggleMenu(View view){
          mleftMenu.toggle();
    }

}




