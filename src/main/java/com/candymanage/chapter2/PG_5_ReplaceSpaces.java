package com.candymanage.chapter2;

/**
 * @author: hyb
 * @date: 2020-04-27 上午 11:31
 * @description: 替换空格  把传入字符数组中的' '换成'&20',且传入数组保证有足够空间容纳修改后的字符
 */
public class PG_5_ReplaceSpaces {
    //由于java的字符数组没有结束符，所以需要多传入个原始长度
    //先计算好替换后的位置，从后向前替换，时间复杂度o(n)
    public static void replaceBlank(char[] data, int length) {
        int newLenth = length;
        for (int i = 0; i < length; i++) {
            if (data[i] == ' ') {
                newLenth += 2;
            }
        }
        for (int indexOfOld = length - 1, indexOfnew = newLenth - 1; indexOfOld >= 0 && indexOfOld != indexOfnew; indexOfOld--, indexOfnew--) {
            if (data[indexOfOld] == ' ') {
                data[indexOfnew--] = '0';
                data[indexOfnew--] = '2';
                data[indexOfnew] = '%';
            } else {
                data[indexOfnew] = data[indexOfOld];
            }

        }
    }

    public static void main(String[] args) {
        char[] predata = "we are famalily".toCharArray();
        char[] data = new char[20];
        for (int i = 0; i <predata.length ; i++)
            data[i]=predata[i];
        System.out.println(data);
        replaceBlank(data,predata.length);
        System.out.println(data);
    }

}
