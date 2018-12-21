package com.jjl.demo.horizontalwheelview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView;
import com.jjl.demo.horizontalwheelview.horizontalWheelView.adapter.AbstractWheelTextAdapter;

import java.util.List;

/**
 * 设置WheelTextAdapter
 *
 * @author weiyunchao
 *
 */
public class WheelTextAdapter extends AbstractWheelTextAdapter {

    List<?> datas;

    protected WheelTextAdapter(Context context, List<?> datas,
                               int currentItem, int maxsize, int minsize) {
        super(context, R.layout.item_person, NO_RESOURCE, currentItem,
                maxsize, minsize);
        this.datas = datas;
        setItemTextResource(R.id.tempValue);
    }

    @Override
    public View getItem(int index, View cachedView, ViewGroup parent) {
        View view = super.getItem(index, cachedView, parent);
        return view;
    }

    @Override
    public int getItemsCount() {
        return datas.size();
    }

    @Override
    protected CharSequence getItemText(int index) {
        return null;
    }

}