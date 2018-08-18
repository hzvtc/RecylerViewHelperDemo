package com.fjq.recylerviewhelper.util;

/**
 * Created by 2 on 2017/10/31.
 */

public class NoFastClickUtils {
    private  static long lastClickTime=0;//上次点击的时间
    private  static int spaceTime = 500;//时间间隔
    public  static boolean isAllowClick() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > spaceTime) {
            lastClickTime = currentTime;
            return true;
        }
        return false;
    }
}
