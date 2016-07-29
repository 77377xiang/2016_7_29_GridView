package com.xiang.gridviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    ImageView image;
    int[] images = new int[]{
            R.drawable.man_1,
            R.drawable.man_2,
            R.drawable.man_3,
            R.drawable.man_4,
            R.drawable.man_5,
            R.drawable.man_6,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView) findViewById(R.id.grid);
        image = (ImageView) findViewById(R.id.image);
        //创建list 对象 元素为map
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <images.length ; i++) {
            Map<String, Object> listItem=new HashMap<String, Object>();
            listItem.put("image",images[i]);
            listItems.add(listItem);
        }

        //创建适配器
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,listItems,R.layout.cell_item,new String[]{"image"},new int[]{R.id.image1});
        grid.setAdapter(simpleAdapter);
        //添加列表被选中的事件
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //显示当前选中图片
                image.setImageResource(images[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //添加列表的单击事件
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(images[position]);
            }
        });
    }
}
