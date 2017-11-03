package com.wind.mvp.utils;

import android.widget.Toast;

import com.wind.mvp.app.MyApp;

/**
 * Created by H on 2017/10/23.
 */

public class ToastUtil {
    public static Toast toast;


    public static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApp.getInstance(),text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}
