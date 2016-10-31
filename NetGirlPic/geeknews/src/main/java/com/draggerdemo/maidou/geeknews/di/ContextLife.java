package com.draggerdemo.maidou.geeknews.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2016/10/22.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/22 15:02
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife {
    String value() default "Application";
}
