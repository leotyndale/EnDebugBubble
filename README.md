![Logo](https://raw.githubusercontent.com/leotyndale/EnFloatingView/master/preview/logo.png)

EnDebugBubble
==========================
[![Muxuan](https://img.shields.io/badge/Powered_by-Muxuan-green.svg?style=flat)](http://www.imuxuan.com/)

一个良好的Debug工具入口，是每个app所必备的，对于凌乱的调试工具整理和调试功能的统一使用方法，需要一个外观整洁，内部具体的显示容器。

### 传统方案

##### 方案一：一般的调试工具，借助在应用主界面某一处增加入口的方式，提供统一调试界面

- 入口固定，进入深层次界面调用Debug工具必须退回Debug固定入口处
- 出现UI调试等需求，调试工具不够灵活

##### 方案二：传统悬浮窗实现调试入口

- 悬浮窗面临权限问题
- 一般悬浮窗的功能过于单一
- 浮在应用上影响整体使用体验

### 功能

此工具只提供一个悬浮窗样式的调试工具界面的实践，使用者可以自行填充调试测试功能进行使用。

- 应用内显示，无需申请任何权限；
- 支持拖拽；
- 超出屏幕限制移动；
- 可自动吸附到屏幕边缘；
- 销毁悬浮窗灵活；
- 可实时显示内存占用等信息；
- 点击悬浮窗可弹出浮层进行功能设定；
- 浮层高度可灵活调整；
- 调试浮层可增加多页；
- 提供多种显示控件，如单选控件、多选控件、富多选信息控件、文字控件等
- 填充测试功能方便，利于维护；
- APP任意位置灵活唤出，APP外部自动隐藏；
- 链式调用，调用简单。

### 使用规则

1. 在基类Activity（注意必须是基类Activity）中的onStart和onStop添加如下代码

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


2. 显示Debug工具

   ```java
       DebugTools.get().add();
   ```

3. 销毁Debug工具

   ```java
       DebugTools.get().remove();
   ```

增强设置

### 效果图



### 特别鸣谢

本开源库借鉴多个开源库，感谢以下开源库为开源力量做出的贡献：

https://github.com/zzz40500/AndroidSweetSheet

https://github.com/txusballesteros/bubbles-for-android

https://github.com/LongMaoC/WaterView

https://github.com/leotyndale/EnFloatingView

https://github.com/gyw520gyw/GroupButtonView

