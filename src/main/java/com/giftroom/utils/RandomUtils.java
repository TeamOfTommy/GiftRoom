package com.giftroom.utils;

/**
 * Created by tommy on 2017/10/22.
 */
public class RandomUtils {

    public static int getSixRandNum() {
        int randNum = (int)((Math.random() * 9 + 1) * 100000);
        return randNum;
    }

}
