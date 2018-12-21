package com.jjl.demo.horizontalwheelview;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView;
import com.jjl.demo.horizontalwheelview.horizontalWheelView.adapter.AbstractWheelTextImageAdapter;

import java.util.List;

/**
 * 设置WheelTextAdapter
 *
 * @author weiyunchao
 *
 */
public class WheelTexImageAdapter extends AbstractWheelTextImageAdapter {

    List<String> datas;
    List<String> signDayList;

    protected WheelTexImageAdapter(Context context, List<String> datas, List<String> signDayList,
                                   int currentItem, int maxsize, int minsize) {
        super(context, R.layout.item_day_sign_in, NO_RESOURCE, currentItem,
                maxsize, minsize);
        this.datas = datas;
        this.signDayList = signDayList;
        setItemTextResource(R.id.dayNumber);
        setItemImageResource(R.id.signRight );
    }

    @Override
    public int getItemsCount() {
        return datas.size();
    }

    @Override
    protected CharSequence getItemText(int index) {
        return datas.get(index);
    }

    @Override
    protected void setupItem(int index, TextView textView, ImageView img) {
        img.setVisibility(signDayList.contains(datas.get(index)) ? View.VISIBLE : View.GONE);
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
        setupView(horizontalWheelView);
    }

    /**
     * 修改List中View的显示
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