package com.wind.mvp.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by H on 2017/10/23.
 * 该类则用于反射获取指定泛型。
 */

public class ReflectUtil {
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType)
                    (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}