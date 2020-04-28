package com.candymanage.chapter2.treeNode;

/**
 * @author: hyb
 * @date: 2020-04-28 下午 5:52
 * @description: 打印从1到最大的n位数
 */
public class PG_8_Print1ToMaxOfdigits {
    //在字符串上模拟加法
    public static void print1ToMaxOfdigits(int num) {
        if (num < 0) {
            return;
        }
        StringBuilder number = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            number.append("0");
            while (increment(number)) {
                printNumber(number);
            }
        }

    }

    public static boolean increment(StringBuilder str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) < '9' && str.charAt(i) >= '0') {
                str.setCharAt(i, (char) (str.charAt(i) + 1));
                return true;
            } else if (str.charAt(i) == '9') {
                str.setCharAt(i, '0');
            } else {
                return false;
            }
        }

        return false;
    }
        public static void  printNumber(StringBuilder number){
            boolean flag = false;
            for (int i = 0; i < number.length(); i++) {
                if(flag)
                    System.out.print(number.charAt(i));
            else {
                    if (number.charAt(i) != '0') {
                        flag = true;
                        System.out.print(number.charAt(i));
                    }
                }
            }
            System.out.println();
        }


    public static void main(String[] args) {
        print1ToMaxOfdigits(3);
    }
}
