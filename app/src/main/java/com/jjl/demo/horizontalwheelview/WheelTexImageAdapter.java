package com.jjl.demo.horizontalwheelview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView;
import com.jjl.demo.horizontalwheelview.horizontalWheelView.adapter.AbstractWheelTextImageAdapter;

import java.util.List;

/**
 * 设置WheelTextAdapter
 */
public class WheelTexImageAdapter extends AbstractWheelTextImageAdapter {

    List<String> wheelList;
    List<String> signInList;

    protected WheelTexImageAdapter(Context context, List<String> wheelList, List<String> signInList,
                                   int currentItem, int maxsize, int minsize) {
        super(context, R.layout.item_day_sign_in, NO_RESOURCE, currentItem,
                maxsize, minsize);
        this.wheelList = wheelList;
        this.signInList = signInList;
        setItemTextResource(R.id.dayNumber);
        setItemImageResource(R.id.signRight );
    }

    @Override
    public int getItemsCount() {
        return wheelList.size();
    }

    @Override
    protected CharSequence getItemText(int index) {
        return wheelList.get(index);
    }

    @Override
    protected void setupItem(int index, TextView textView, ImageView img) {
        //getItem中的抽象函数，初始化操作
        img.setVisibility(signInList.contains(wheelList.get(index)) ? View.VISIBLE : View.GONE);
        if (index == currentIndex) {
            textView.setTextSize(maxsize);
            textView.setTextColor(Color.BLACK);
            img.setImageResource(R.mipmap.sign_big_rigth);
        } else {
            textView.setTextSize(minsize);
            textView.setTextColor(Color.GRAY);
            img.setImageResource(R.mipmap.sign_default_right);
        }
    }

    @Override
    public void onChange(HorizontalWheelView horizontalWheelView) {
        //滚轮滑动的监听，目前添加了onChanged、onScrollingStarted、onScrollingFinished
        setupView(horizontalWheelView);
    }

    /**
     * 滚轮滚动时，修改显示的所有Item的状态
     */
    protected void setupView(HorizontalWheelView horizontalWheelView) {
        String currentText = (String)getItemText(horizontalWheelView .getCurrentItem());
        int size = arrayList.size();
//        int size = imageList.size();
        for (int i = 0; i < size; i++) {
            TextView textView = (TextView) arrayList.get(i);
            ImageView imageView = (ImageView) imageList.get(i);
            String text = textView.getText().toString();
            if (currentText.equals(text)) {
                textView.setTextSize(maxsize);
                textView.setTextColor(Color.BLACK);
                imageView.setImageResource(R.mipmap.sign_big_rigth);
            } else {
                textView.setTextSize(minsize);
                textView.setTextColor(Color.GRAY);
                imageView.setImageResource(R.mipmap.sign_default_right);
            }
        }
    }
}