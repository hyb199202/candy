package com.candymanage.chapter2;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author: hyb
 * @date: 202004下午 4:35
 * @description: 一个长度为n的数组，值的范围在0~n-1内，有一个或多个数字重复，求其中任意一个
 */
public class PG_3_DuplicationInArray {
    //方法1：暴力求解，不会修改元数据，时间复杂度o（n^2）, 空间复杂度o（1）
    public static int getDuplicationInArray(int[] data) {
        if (data == null | data.length < 2) {
            return -1;
        }
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] == data[j]) {
                    return data[i];
                }
            }
        }
        return -1;
    }

    //借助哈希表，不会修改原始数据，时间o（n） ，空间复杂度o（n）
    public static int getDuplication3(int[] data) {
        if (data == null || data.length <2) {
            return -1;
        }
        int[] hashTable = new int[data.length];

        for (int item : data) {
            if (hashTable[item] >= 1)
                return item;
            else {
                hashTable[item] = 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] data = {2, 2, 3, 3, 5, 6, 7, 8};

        //System.out.println(getDuplicationInArray(data));
        System.out.println(getDuplication3(data));

    }


}
