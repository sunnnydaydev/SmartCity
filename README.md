
###### 一、先看看实现的效果
![新闻中心.gif](https://upload-images.jianshu.io/upload_images/3695408-518d9c45bcc30548.gif?imageMogr2/auto-orient/strip)

![组图.gif](https://upload-images.jianshu.io/upload_images/3695408-3811f2a9017daee6.gif?imageMogr2/auto-orient/strip)

![快看.png](https://upload-images.jianshu.io/upload_images/3695408-662ce0bc74dc3825.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![设置.png](https://upload-images.jianshu.io/upload_images/3695408-8640f36bbbc46845.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![主页.png](https://upload-images.jianshu.io/upload_images/3695408-b1086b18c4f9d322.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


###### 二、项目结构图
![image.png](https://upload-images.jianshu.io/upload_images/3695408-30155839a173f342.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)![结构.png](https://upload-images.jianshu.io/upload_images/3695408-62619c1ae1ff58ca.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

>实现架构上没有采用mvp，mvvm、也没有使用模块化，使用了安卓原生的mvc实现的，其实模块化不错的，解耦分离，模块分开，打算下一个项目做个开源电商的，使用模块化搭建。

###### 三、 技术分享 
1 、首先是BaseActivity的设计 所有的activity要继承我们的BaseActivity，在这个activity中我们做了统一子布局处理，标题栏处理，沉浸式状态栏处理，butterknife注册解绑统一处理，以及对封装，抽象类的具体实践。对面向对象的深刻理解。
>收获：
1 [BaseActivity源码参考](https://github.com/sunnnydaydev/SmartCity/blob/master/app/src/main/java/com/example/administrator/smartcity/activities/BaseActivity.java)
2 想要熟练面向对象推荐书籍  java编程思想
3 [butterknife](https://github.com/JakeWharton/butterknife)的使用当然是[杰克沃顿](https://github.com/JakeWharton)大神的框架了（推荐先别用最新版本的[有坑](https://blog.csdn.net/qq_38350635/article/details/87785551)）
4 和butterknife类似功能的[Xutils](https://github.com/wyouflf/xUtils3)的ViewUtils也可以了解一下
5 学会了[ViewUtils](https://github.com/sunnnydaydev/ViewUtilsDemo)的手写实现

2 、闪屏界(splashActivity)面主要是动画的熟练运用
>收获：
[view动画和属性动画](https://www.jianshu.com/p/b117c974deaf)参考这篇学习,写的不错而且是刚哥推荐（任玉刚知识星球学习路线中的哈）

3 、新手引导页面主要是对ViewPager的运用
>收获:
1 viewPager自定义指示器的实现，网上好多可以自己手写实现下
2 鸿洋大佬的[巧用ViewPager 打造不一样的广告轮播切换效果](https://blog.csdn.net/lmj623565791/article/details/51339751)很不错，可以学习下
3 开源[Banner](https://github.com/sunnnydaydev/banner)可以实现ViewPager的功能，可以尝试下,作者看着不错赶紧fork了哈哈
4 如果嵌套布局比如viewpager套ViewPager很容易发生滑动冲突，可以看[掘金自定义view集合](https://juejin.im/entry/586e1f988d6d810058b67f3e)作者看了下，冲突的解决方法，是总结刚哥的开发艺术这本书上的。

4 、ContentFragment主要是五个子View的抽取
>收获：
1 对面向对象的理解，这个要多练习。
2 底部导航栏的使用，在结合Viewapger使用时比传统的RadioGroup+Radiobutton使用还方便，[源码参考](https://github.com/sunnnydaydev/SmartCity/blob/master/app/src/main/java/com/example/administrator/smartcity/fragments/ContentFragment.java)。

5 其他收获
>收获：
1 Viewpager加载数据的细节优化，可以通过事件监听再加载数据，数据使用时在加载（现不在adapter的实例化view中加载），引起原因viewpager默认加载两页数据。
2 数据缓存
得到网络数据可以先缓存本地，例如以url为key，以json为value保存。
注意缓存有效期
缓存意义：节流，用户界面友好。
3 [鸿洋大佬okHttp+Gson的封装](https://blog.csdn.net/lmj623565791/article/details/49734867/)写的不错可以参考下
4 自定义下拉刷新的实现[参考](https://blog.csdn.net/crazyman2010/article/details/52735433)
5 三级缓存思想，优先从内存中缓存，在从本地，最后从网络。
6 手机适配的收获（屏幕，布局，代码等等）
7 第三方集成比如[shareSdk](https://blog.csdn.net/qq_38350635/article/details/87969785)
8 页面的跳转事件的处理可以学习下路由，和eventBus这个在下个开源电商中再实践。

###### 自定义通用View
[参考](https://blog.csdn.net/qq_38350635/article/details/88040908)

###### 三 资源链接
>1 [玩安卓](http://www.wanandroid.com/index)对于安卓开发来说不错的网站，作者的mock数据就借助了此网站。
> 2 进阶书籍推荐 安卓开发艺术探讨，深入理解jvm 、headFirst设计模式、java编程思想，effect java 作者买了这些书，正在慢慢地肯哈。

###### 小结
成为大佬的道路任重而道远，我们必须动手练习，看见不错的开源项目作者上手就fork，然后慢慢分析学习，项目写的匆匆有诸多不足之处望小伙伴们多多指点，共同进步。

###### The end





