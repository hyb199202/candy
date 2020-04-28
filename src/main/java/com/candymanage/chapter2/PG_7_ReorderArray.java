package com.candymanage.chapter2;

/**
 * @author: hyb
 * @date: 2020-04-28 下午 5:26
 * @description: 调整数组顺序使奇数位于偶数前面
 */
public class PG_7_ReorderArray {
    public static void reoder(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            while (left < right && !isEven(data[left]))
                left++;
            while (left < right && isEven(data[right]))
                left--;
            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
    }

    public static boolean isEven(int n) {
        return (n&1) == 0;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        reoder(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }


    }


}
