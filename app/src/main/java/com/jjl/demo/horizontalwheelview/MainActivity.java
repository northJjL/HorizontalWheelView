package com.jjl.demo.horizontalwheelview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HorizontalWheelView horizontalWheelView;
    private WheelTexImageAdapter wheelTextImageAdapter;
    private List<String> wheelList;//滚轮的列表
    private List<String> signInList;//签到的列表
    private String currentText = "5";//初始化选中的文字
    protected int maxsize = 26;// 最大的字体
    protected int minsize = 14;// 最小字体

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        horizontalWheelView = findViewById(R.id.horizontalWheelView);
        horizontalWheelView.setVisibleItems(7);//显示的条目
        horizontalWheelView.setCyclic(true);//是否循环
        wheelTextImageAdapter = new WheelTexImageAdapter(this , wheelList, signInList,
                wheelList.indexOf(currentText) , maxsize, minsize);
        horizontalWheelView.setViewAdapter(wheelTextImageAdapter);
        //setCurrentItem有对Adapter为null的判断，所以必须在设置Adapter之后；
        // 由于日期一定是包含当日的天数，所以这里不做-1的判断，animated 是否通过动画效果移动，默认为false
        horizontalWheelView.setCurrentItem(wheelList.indexOf(currentText));
    }


    private void initData() {
        //calendar替换
        wheelList = new ArrayList<>();
        for (int i = 1; i <31; i++) {
            wheelList.add("" + i);
        }
        //签到天数
        signInList = new ArrayList<>();
        signInList.add("5");
        signInList.add("11");
        signInList.add("15");
        signInList.add("22");
        signInList.add("2");
        signInList.add("29");
    }
}
