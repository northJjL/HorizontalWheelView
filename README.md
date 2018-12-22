# HorizontalWheelView

根据WheelView修改的水平滚轮选择器

<img src="https://github.com/northJjL/HorizontalWheelView/blob/master/img.gif" width="320" alt="gif">

### 介绍

HorizontalWheelView是通过WheelView简单修改的，拥有WheelView相同功能。由于HorizontalWheelView有对宽度specMode做判断，为了能设置显示itme数目，所以默认使用wrap_content,可以通过父布局去控制它的宽高和位置。

### 简单使用

##### 布局: 

```xml
    <LinearLayout
        android:layout_marginTop="20dp"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:gravity="center"
        >
        <com.jjl.demo.horizontalwheelview.horizontalWheelView.HorizontalWheelView
            android:id="@+id/horizontalWheelView"
            android:layout_gravity="center_horizontal"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"/>
    </LinearLayout>
```

##### 设置: 

```java
	private List<String> wheelList;//滚轮的列表
	private List<String> signInList;//签到的列表
	private String currentText = "5";//初始化选中的文字
	protected int maxsize = 26;// 最大的字体
	protected int minsize = 14;// 最小字体
	   
	horizontalWheelView = findViewById(R.id.horizontalWheelView);
	horizontalWheelView.setVisibleItems(7);//显示的条目
	horizontalWheelView.setCyclic(true);//是否循环
	wheelTextImageAdapter = new WheelTexImageAdapter(this , wheelList, signInList,
	        wheelList.indexOf(currentText) , maxsize, minsize);
	horizontalWheelView.setViewAdapter(wheelTextImageAdapter);
	horizontalWheelView.setCurrentItem(wheelList.indexOf(currentText));
```

      



