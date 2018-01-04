# Android多屏幕适配

前段时间在开发APP的平板适配，经过一段时间的学习、整理、填坑后，写下了这篇文章。

## 理论

在Android开发中使用的单位都是dp和sp(字体大小)，这个不是由屏幕的尺寸决定的而是取决于dpi,所以对于屏幕适配我们着重考虑dpi。

注：dpi是每英寸的像素点数，单位是dp(密度无关像素)

说到屏幕适配，就不得不说一下目前Android设备的屏幕尺寸了。[支持多种屏幕](https://developer.android.com/guide/practices/screens_support.html?hl=zh-cn)

![Android屏幕分布](http://upload-images.jianshu.io/upload_images/4759690-54c1cb337db36f07.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

如上图，目前手机主流的dpi是xhdpi和xxhdpi两种，平板均是xhdpi。

## 适配

一般适配，我们通过对资源使用配置限定符

![表1](http://upload-images.jianshu.io/upload_images/4759690-bb37332a1e374759.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![表2](http://upload-images.jianshu.io/upload_images/4759690-acd2744be20290c5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 1.对于需要加载图片资源的View、layout使用wrap_content设置高度,根据不同dpi图片进行高度自动适配

![wrap_content设置高度](http://upload-images.jianshu.io/upload_images/4759690-69feb508dc460f2f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 2.根据不同的分辨率加载不同的布局，如平板和手机分别加载不同的布局:在layout和layout-sw600dp目录下创建相同名字的布局

![加载不同的布局](http://upload-images.jianshu.io/upload_images/4759690-3b91e528203b1e01.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 3.在同一个布局中,可以根据配置values的限定符来实现控件的尺寸、位置、大小的控制，如分别在values和values-sw600dp目录下创建dimens文件展示不同的字体大小

![配置values的限定符](http://upload-images.jianshu.io/upload_images/4759690-f9b00fdb96f70631.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 4.最后可以用代码判断当前设备的屏幕宽度dp来做不同的处理

![用代码判断当前设备的屏幕宽度dp](http://upload-images.jianshu.io/upload_images/4759690-dadccb8565a38d8e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

结果展示：

![手机展示](http://upload-images.jianshu.io/upload_images/4759690-9f044be3a8bbf693.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![平板展示](http://upload-images.jianshu.io/upload_images/4759690-4216f4949348ec45.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 填坑

##### 1.平板和低分辨率手机都是dpi相同,从一图我们可以看到，两者均是xhdpi。那么我们如何区分呢？

不要急，先看下官方文档：[提供资源](https://developer.android.com/guide/topics/resources/providing-resources.html?hl=zh-cn#SmallestScreenWidthQualifier)。

[提供资源](https://developer.android.com/guide/topics/resources/providing-resources.html?hl=zh-cn#SmallestScreenWidthQualifier)中的表2.就是配置限定符名称（由于表格过长就不展示了），在表2的下方有限定符命名规则。如图：

![微信截图_20180104161606.png](http://upload-images.jianshu.io/upload_images/4759690-6503eb18d01db72e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

其中红框中的比较重要:

第一点，表示我们可以指定多个限定符

第二点，表示我们必须遵循表2中的列表的顺序。

OK!这样对于平板和手机的区分可以写成这样mipmap-xhdpi和mipmap-sw600dp-xhdpi。

对于最后一点，表示系统会为我们找最优的结果，如果找不到则会去在默认资源中寻找，这样不用每个目录把所有资源都放进去。

## 总结

自此，关于屏幕适配基本就讲完了。这里没有做过多细节的讲解，主要是提供思路抛砖引玉，如果有什么不清楚的地方可以看我的[Demo源码](https://github.com/Fitem/SmartScaleDemo)，也可以看官方文档：[支持多种屏幕](https://developer.android.com/guide/practices/screens_support.html?hl=zh-cn) 和 [提供资源](https://developer.android.com/guide/topics/resources/providing-resources.html?hl=zh-cn#SmallestScreenWidthQualifier)。

简书地址:https://www.jianshu.com/p/ed2570189c7d)

E-mail:931675174@qq.com
