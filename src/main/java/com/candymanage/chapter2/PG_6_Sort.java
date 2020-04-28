package com.candymanage.chapter2;

/**
 * @author: hyb
 * @date: 2020-04-28 下午 5:08
 * @description: 冒泡排序
 */
public class PG_6_Sort {
    //冒泡排序，时间o(n^2) 空间o(1)
    public static void bubbleSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - 1; j++) {
                if (data[j - 1] > data[j]) {
                    int tmep = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmep;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] data = {11, 54, 66, 22, 43, 55, 77};
        bubbleSort(data);
        for (int item : data) {
            System.out.println(item);
        }
    }

}
