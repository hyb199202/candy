package com.candymanage.chapter2;

/**
 * @author: hyb
 * @date: 2020-04-26 下午 5:52
 * @description: 二维数组，从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有
 */
public class PG_4_FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrix(int[][] data, int target) {

        if (data == null || data.length == 0 || data[0].length == 0) {
            return false;
        }
        int rowMax = data.length - 1, colMax = data[0].length - 1;
        int rowCur = data.length - 1, colCur = 0;
        while (true) {
            if (rowCur < 0 | rowCur > rowMax | colCur < 0 | colCur > colMax) {
                return false;
            }
            if(data[rowCur][colCur]==target){
                return true;
            }
            else if(data[rowCur][colCur]>target)
                rowCur--;
            else
                colCur++;
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,3},{4,5,6},{7,6,9},{12,21,31},};

        System.out.println(findInPartiallySortedMatrix(data, 12));
    }

}
