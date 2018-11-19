![Logo](https://raw.githubusercontent.com/leotyndale/EnFloatingView/master/preview/logo.png)

EnDebugBubble
==========================
[![Muxuan](https://img.shields.io/badge/Powered_by-Muxuan-green.svg?style=flat)](http://www.imuxuan.com/)

A good Debug tool entry is a must for every app. For the unified use of messy debugging tools and debugging features, you need a neat, internal display container.

### Traditional scheme

##### Scenario 1: The general debugging tool provides a unified debugging interface by adding an entry at a certain point on the main interface of the application.

- The entrance is fixed. Entering the deep interface, calling the Debug tool must be returned to the Debug fixed entrance.
- There is a need for UI debugging, and debugging tools are not flexible enough

##### Scenario 2: Traditional floating window implementation debugging entry

- The floating window faces the permission problem
- The function of the general floating window is too single
- Floating on the app affects the overall experience

### Features

This tool only provides a floating window style debugging tool interface practice, users can fill in the debugging test function to use.

- In-app display, no need to apply for any permissions;
- Support for drag and drop;
- Move beyond the screen limit;
- Automatically snap to the edge of the screen;
- Destroy the floating window flexibly;
- Real-time display of information such as memory usage;
- Click on the floating window to pop up the floating layer for function setting;
- The height of the floating layer can be flexibly adjusted;
- Debugging the floating layer can add multiple pages;
- Provide a variety of display controls, such as radio controls, multi-select controls, rich multi-select information controls, text controls, etc.
- Filling test function is convenient and convenient for maintenance;
- APP can be called out at any location, and the APP is automatically hidden outside;
- Chained calls, simple to call.

### Usage rules

1. Add the following code to onStart and onStop in the base class Activity (note that it must be the base class Activity)

```java
   @Override
   protected void onStart() {
       super.onStart();
       DebugTools.get().attach(this);
   }

   @Override
   protected void onStop() {
       super.onStop();
       DebugTools.get().detach(this);
   }
```


2. Display the Debug tool

```java
   DebugTools.get().add();
```

### Other settings

Dismiss

```java
   DebugTools.get().remove();
```

onBackPressed

```java
    @Override
    public void onBackPressed() {
        if (!DebugTools.get().dismissMenu()){
            super.onBackPressed();
        }
    }
```

Fill data and display (in advance in onCreate, you need to call the attach once)

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DebugTools.get().attach(this)
                .fillMenuData(DebugConfig.getList())
                .add();
    }
```

Update floating window display information

```java
    DebugTools.get().updateInfo(memorySize, percent);
```

### Fill Data

Support for four types of control fill lists

1.Radio

```java
    new RadioEntity().setGroupBtnName("接口类型1#接口类型2#接口类型3")
            .setCheckPosition(getSelectedHostId())
            .setOnCheckedChangeListener(getHostCheckedChangeListener()).setTitle("接口类型:");
```

![Logo](https://raw.githubusercontent.com/leotyndale/EnDebugBubble/03e3341926c2c550502b6b60ff589cbf002b45ab/sc/2.2.jpg)

2.Switch

```java
    new SwitchEntity().setChecked(true)
            .setTitle("test feature toggle1")
            .setInfo("动态功能开关测试1")
            .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                }
            });
```

![Logo](https://raw.githubusercontent.com/leotyndale/EnDebugBubble/03e3341926c2c550502b6b60ff589cbf002b45ab/sc/2.3.jpg)

![Logo](https://raw.githubusercontent.com/leotyndale/EnDebugBubble/03e3341926c2c550502b6b60ff589cbf002b45ab/sc/2.4.jpg)

3.Title

```java
    new TextEntity().setTitle("测试页面");
```

4.Simple

```java
    new SimpleEntity().setTitle("测试1")
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                }
            });
```

![Logo](https://raw.githubusercontent.com/leotyndale/EnDebugBubble/03e3341926c2c550502b6b60ff589cbf002b45ab/sc/2.1.jpg)

### Preview

![Logo](https://raw.githubusercontent.com/leotyndale/EnDebugBubble/03e3341926c2c550502b6b60ff589cbf002b45ab/sc/1.gif)

### Special thanks

This open source library draws on several open source libraries, thanks to the following open source libraries for the contribution of open source power:

https://github.com/zzz40500/AndroidSweetSheet

https://github.com/txusballesteros/bubbles-for-android

https://github.com/LongMaoC/WaterView

https://github.com/leotyndale/EnFloatingView

https://github.com/gyw520gyw/GroupButtonView

