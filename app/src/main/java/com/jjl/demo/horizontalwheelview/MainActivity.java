package com.jjl.demo.horizontalwheelview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView;
import com.jjl.demo.horizontalwheelview.horizontalWheelView.view.OnWheelChangedListener;
import com.jjl.demo.horizontalwheelview.horizontalWheelView.view.OnWheelScrollListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HorizontalWheelView mHorizontalWheelView;
    private WheelTexImageAdapter bankTextAdapter;
    private List<String> datas;
    private List<String> mList;
    private String currentText = "5";
    protected int maxsize = 26;// 最大的字体
    protected int minsize = 14;// 最小字体

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initData();
        mHorizontalWheelView = findViewById(R.id.select_personalinfo_wheelview);
        mHorizontalWheelView.setVisibleItems(7);//显示的条目
        mHorizontalWheelView.setCyclic(true);//是否循环
        bankTextAdapter = new WheelTexImageAdapter(this , datas ,mList,
                datas.indexOf(currentText) , maxsize, minsize);
        mHorizontalWheelView.setViewAdapter(bankTextAdapter);
        mHorizontalWheelView.setCurrentItem(datas.indexOf(currentText));
    }


    private void initData() {
        datas = new ArrayList<>();
        for (int i = 1; i <31; i++) {
            datas.add("" + i);
        }
        mList = new ArrayList<>();
        mList.add("5");
        mList.add("11");
        mList.add("15");
        mList.add("22");
        mList.add("2");
        mList.add("29");
    }
}
