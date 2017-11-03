package com.wind.mvp.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by H on 2017/9/17.
 * 用专门的集合类对所有的活动进行管理
 * 郭霖版
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //移除马上要销毁的活动
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    //全部销毁List中存储的活动
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
        //杀掉一个进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            ActivityCollector.finishAll();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception ignored) {}
    }
}
