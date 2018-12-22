/*
 *  Copyright 2011 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jjl.demo.horizontalwheelview.horizontalWheelView.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjl.demo.horizontalwheelview.R;
import com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView;

import java.util.ArrayList;

/**
 * Abstract wheel adapter provides common functionality for adapters.
 */
public abstract class AbstractWheelTextImageAdapter extends AbstractWheelListenerAdapter {

	/** Text view resource. Used as a default view for adapter. */
	public static final int TEXT_VIEW_ITEM_RESOURCE = -1;

	/** No resource constant. */
	protected static final int NO_RESOURCE = 0;

	/** Default text color */
	public static final int DEFAULT_TEXT_COLOR = 0xFF101010;

	/** Default text color */
	public static final int LABEL_COLOR = 0xFF700070;

	/** Default text size */
	public static final int DEFAULT_TEXT_SIZE = 24;

	// Text settings
	private int textColor = DEFAULT_TEXT_COLOR;
	private int textSize = DEFAULT_TEXT_SIZE;

	// Current context
	protected Context context;
	// Layout inflater
	protected LayoutInflater inflater;

	// Items resources
	protected int itemResourceId;
	protected int itemTextResourceId;
	protected int itemImageResourceId;

	// Empty items resources
	protected int emptyItemResourceId;

	protected int currentIndex = 0;
	protected static int maxsize = 24;
	protected static int minsize = 14;
	protected ArrayList<View> arrayList = new ArrayList<View>();
	protected ArrayList<View> imageList = new ArrayList<View>();

	/**
	 * Constructor
	 *
	 * @param context
	 *            the current context
	 */
	protected AbstractWheelTextImageAdapter(Context context) {
		this(context, TEXT_VIEW_ITEM_RESOURCE);
	}

	/**
	 * Constructor
	 *
	 * @param context
	 *            the current context
	 * @param itemResource
	 *            the resource ID for a layout file containing a TextView to use
	 *            when instantiating items views
	 */
	protected AbstractWheelTextImageAdapter(Context context, int itemResource) {
		this(context ,itemResource, NO_RESOURCE, 0, maxsize, minsize);
	}

	/**
	 * Constructor
	 *
	 * @param context
	 *            the current context
	 * @param itemResource
	 *            the resource ID for a layout file containing a TextView to use
	 *            when instantiating items views
	 * @param itemTextResource
	 *            the resource ID for a text view in the item layout
	 */
	protected AbstractWheelTextImageAdapter(Context context, int itemResource, int itemTextResource, int currentIndex,
											int maxsize, int minsize ) {
		this.context = context;
		itemResourceId = itemResource;
		itemTextResourceId = itemTextResource;
		this.currentIndex = currentIndex;
		this.maxsize = maxsize;
		this.minsize = minsize;

		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	 * get the list of show textview
	 *
	 * @return the array of textview
	 */
	public ArrayList<View> getTestViews() {
		return arrayList;
	}

	public ArrayList<View> getImageViews() {
		return imageList;
	}

	/**
	 * Gets text color
	 *
	 * @return the text color
	 */
	public int getTextColor() {
		return textColor;
	}

	/**
	 * Sets text color
	 *
	 * @param textColor
	 *            the text color to set
	 */
	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	/**
	 * Gets text size
	 *
	 * @return the text size
	 */
	public int getTextSize() {
		return textSize;
	}

	/**
	 * Sets text size
	 *
	 * @param textSize
	 *            the text size to set
	 */
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	/**
	 * Gets resource Id for items views
	 *
	 * @return the item resource Id
	 */
	public int getItemResource() {
		return itemResourceId;
	}

	/**
	 * Sets resource Id for items views
	 *
	 * @param itemResourceId
	 *            the resource Id to set
	 */
	public void setItemResource(int itemResourceId) {
		this.itemResourceId = itemResourceId;
	}

	/**
	 * Gets resource Id for text view in item layout
	 *
	 * @return the item text resource Id
	 */
	public int getItemTextResource() {
		return itemTextResourceId;
	}

	/**
	 * Sets resource Id for text view in item layout
	 *
	 * @param itemTextResourceId
	 *            the item text resource Id to set
	 */
	public void setItemTextResource(int itemTextResourceId) {
		this.itemTextResourceId = itemTextResourceId;
	}

	public void setItemImageResource(int itemImageResourceId) {
		this.itemImageResourceId = itemImageResourceId;
	}

	/**
	 * Gets resource Id for empty items views
	 *
	 * @return the empty item resource Id
	 */
	public int getEmptyItemResource() {
		return emptyItemResourceId;
	}

	/**
	 * Sets resource Id for empty items views
	 *
	 * @param emptyItemResourceId
	 *            the empty item resource Id to set
	 */
	public void setEmptyItemResource(int emptyItemResourceId) {
		this.emptyItemResourceId = emptyItemResourceId;
	}

	/**
	 * Returns text for specified item
	 *
	 * @param index
	 *            the item index
	 * @return the text of specified items
	 */
	protected abstract CharSequence getItemText(int index);

	@Override
	public View getItem(int index, View convertView, ViewGroup parent) {
		if (index >= 0 && index < getItemsCount()) {
			if (convertView == null) {
				convertView = getView(itemResourceId, parent);
			}
			TextView textView = getTextView(convertView, itemTextResourceId);
			ImageView img = getImageView(convertView, itemImageResourceId);
			if (!arrayList.contains(textView)) {
				arrayList.add(textView);
			}
			if (!imageList.contains(img)) {
				imageList.add(img);
			}
			if (textView != null) {
				CharSequence text = getItemText(index);
				if (text == null) {
					text = "";
				}
				textView.setText(text);
				setupItem(index, textView, img);

				if (itemResourceId == TEXT_VIEW_ITEM_RESOURCE) {
					configureTextView(textView);
				}
			}
			return convertView;
		}
		return null;
	}

	/**
	 * @param index
	 * @param textView
	 * @param img
	 */
	protected abstract void setupItem(int index, TextView textView, ImageView img);

	@Override
	public View getEmptyItem(View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = getView(emptyItemResourceId, parent);
		}
		if (emptyItemResourceId == TEXT_VIEW_ITEM_RESOURCE && convertView instanceof TextView) {
			configureTextView((TextView) convertView);
		}

		return convertView;
	}

	/**
	 * Configures text view. Is called for the TEXT_VIEW_ITEM_RESOURCE views.
	 *
	 * @param view
	 *            the text view to be configured
	 */
	protected void configureTextView(TextView view) {
		view.setTextColor(textColor);
		view.setGravity(Gravity.CENTER);
		view.setTextSize(textSize);
		view.setLines(1);
		view.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
	}

	/**
	 * Loads a text view from view
	 *
	 * @param view
	 *            the text view or layout containing it
	 * @param textResource
	 *            the text resource Id in layout
	 * @return the loaded text view
	 */
	private TextView getTextView(View view, int textResource) {
		TextView text = null;
		try {
			if (textResource == NO_RESOURCE && view instanceof TextView) {
				text = (TextView) view;
			} else if (textResource != NO_RESOURCE) {
				text = (TextView) view.findViewById(textResource);
			}
		} catch (ClassCastException e) {
			Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
			throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", e);
		}

		return text;
	}

	/**
	 * Loads a text view from view
	 *
	 * @param view
	 *            the image view or layout containing it
	 * @param textResource
	 *            the text resource Id in layout
	 * @return the loaded image view
	 */
	private ImageView getImageView(View view, int textResource) {
		ImageView img = null;
		try {
			if (textResource == NO_RESOURCE && view instanceof ImageView) {
				img = (ImageView) view;
			} else if (textResource != NO_RESOURCE) {
				img = (ImageView) view.findViewById(textResource);
			}
		} catch (ClassCastException e) {
			Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
			throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", e);
		}

		return img;
	}

	/**
	 * Loads view from resources
	 *
	 * @param resource
	 *            the resource Id
	 * @return the loaded view or null if resource is not set
	 */
	private View getView(int resource, ViewGroup parent) {
		switch (resource) {
			case NO_RESOURCE:
				return null;
			case TEXT_VIEW_ITEM_RESOURCE:
				return new TextView(context);
			default:
				return inflater.inflate(resource, parent, false);
		}
	}
}

