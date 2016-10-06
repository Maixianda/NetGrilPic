# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\myprogram\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

###################### 代码中使用了反射,泛型 ######################
-keepattributes Signature
-keepattributes EnclosingMethod
-keepattributes InnerClasses
###################### 代码中使用了反射 ######################
























###################### 不混淆json对应的实体类 ######################
#使用GSON、fastjson等JSON解析框架所生成的对象类，加入下面的混淆规则即可.假设com.clock.bean包下所有的类都是JSON解析生成对象的类
#-keep class com.clock.bean.**{*;}//不混淆所有的com.clock.bean包下的类和这些类的所有成员变量
###################### 不混淆json对应的实体类 ######################

























###################### 要添加的东西 ######################
#不混淆json对应的实体类
#第三方库不混淆
#有用到WEBView的JS调用接口
###################### 要添加的东西 ######################

























###################### 继承了Serializable接口的类 ######################
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
###################### 继承了Serializable接口的类 ######################

























###################### 第三方库不混淆 ######################

-dontwarn com.android.**
-keep class com.android.** { *; }

-dontwarn android.app.**
-keep class android.app.** { *; }

-dontwarn android.content.**
-keep class android.content.** { *; }

-dontwarn android.support.**
-keep class android.support.** { *; }

-dontwarn android.os.**
-keep class android.os.** { *; }

-dontwarn android.databinding.**
-keep class android.databinding.** { *; }

-dontwarn junit.**
-keep class junit.** { *; }

-dontwarn javax.**
-keep class javax.** { *; }

-dontwarn java.**
-keep class java.** { *; }

-dontwarn de.**
-keep class de.** { *; }

-dontwarn org.**
-keep class org.** { *; }

-dontwarn uk.**
-keep class uk.** { *; }

-dontwarn bolts.**
-keep class bolts.** { *; }

-dontwarn com.squareup.**
-keep class com.squareup.** { *; }

-dontwarn okio.**
-keep class okio.** { *; }

-dontwarn retrofit.**
-keep class retrofit.** { *; }

-dontwarn com.octo.**
-keep class com.octo.** { *; }

-dontwarn u.aly.**
-keep class u.aly.** { *; }

-dontwarn com.baidu.**
-keep class com.baidu.** { *; }

-dontwarn com.facebook.**
-keep class com.facebook.** { *; }

-dontwarn com.facebook.Session
-keep class com.facebook.Session { *; }

-dontwarn com.google.**
-keep class com.google.** { *; }

-dontwarn com.afollestad.**
-keep class com.afollestad.** { *; }

-dontwarn jp.wasabeef.**
-keep class jp.wasabeef.** { *; }

-dontwarn me.imid.**
-keep class me.imid.** { *; }

-dontwarn me.nereo.**
-keep class me.nereo.** { *; }

-dontwarn org.apache.**
-keep class org.apache.** { *; }

-dontwarn uk.co.chrisjenx.**
-keep class uk.co.chrisjenx.** { *; }

-dontwarn uk.co.senab.**
-keep class uk.co.senab.** { *; }

-dontwarn taobe.tec.**
-keep class taobe.tec.** { *; }

-dontwarn me.leolin.**
-keep class me.leolin.** { *; }

-dontwarn org.jsoup.**
-keep class org.jsoup.** { *; }

-dontwarn de.hdodenhof.**
-keep class de.hdodenhof.** { *; }

-dontwarn libcore.icu.**
-keep class libcore.icu.** { *; }

-dontwarn sun.misc.**
-keep class sun.misc.** { *; }

-dontwarn com.parse.**
-keep class com.parse.** { *; }

-dontwarn com.millennialmedia.**
-keep class com.millennialmedia.** { *; }

-dontwarn com.inmobi.**
-keep class com.inmobi.** { *; }

-dontwarn com.flurry.**
-keep class com.flurry.** { *; }

-dontwarn com.umeng.**
-keep class com.umeng.** { *; }

-dontwarn com.ecloud.**
-keep class com.ecloud.** { *; }

-dontwarn com.github.**
-keep class com.github.** { *; }

-dontwarn com.loopj.**
-keep class com.loopj.** { *; }

-dontwarn com.mcxiaoke.**
-keep class com.mcxiaoke.** { *; }

-dontwarn com.nostra13.**
-keep class com.nostra13.** { *; }

-dontwarn com.readystatesoftware.**
-keep class com.readystatesoftware.** { *; }

-dontwarn com.kyleduo.**
-keep class com.kyleduo.** { *; }

-dontwarn com.handmark.**
-keep class com.handmark.** { *; }

-dontwarn com.nineoldandroids.**
-keep class com.nineoldandroids.** { *; }

-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }

-dontwarn cn.sharesdk.**
-keep class cn.sharesdk.** { *; }

-dontwarn com.mob.**
-keep class com.mob.** { *; }

-dontwarn com.zhy.**
-keep class com.zhy.** { *; }

-dontwarn com.qiniu.**
-keep class com.qiniu.** { *; }

-dontwarn com.sina.**
-keep class com.sina.** { *; }

-dontwarn me.zhanghai.**
-keep class me.zhanghai.** { *; }

-dontwarn com.tencent.**
-keep class com.tencent.** { *; }

-dontwarn com.baidu.**
-keep class com.baidu.** { *; }

-dontwarn com.sumsung.**
-keep class com.sumsung.** { *; }
###################### 第三方库不混淆 ######################

























###################### 有用到WEBView的JS调用接口 ######################
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
######### webview中的js不混淆 #########
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}
#-keep class com.xxx.xxx.** { *; }//保持WEB接口不被混淆 此处xxx.xxx是自己接口的包名
###################### 有用到WEBView的JS调用接口 ######################