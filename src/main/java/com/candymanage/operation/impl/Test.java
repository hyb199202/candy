package com.candymanage.operation.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

  /*  public static String  codeGet(String code) {
        String resultCode  ;
        if(code.length()==2){
            resultCode = "0"+code + "0";
        }else {
            resultCode =  "0"+code ;
        }

        return  resultCode;
    }*/

    public static void main(String[] args) {
       /* String str = "abc";
        System.out.println(str.indexOf("abc"));
        System.out.println(str.charAt(1));
        System.out.println(str.replace("1", "2"));
        System.out.println(str.trim());
        System.out.println(str.split(""));
        byte[] bytes = str.getBytes();
        System.out.println(bytes);
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println("abc".equals(str));*/
        /*//三元表达式
        String code = "374";
        String resultCode = !"".equals(code)?"":"371";
        System.out.println(resultCode);
*/

  /*      int A,B,C;
        A = 2;
        B = 3;
        C = A > B ? 100 : 200;
        System.out.println(C);*/
        String a = "0371";
        String b = "".equals(a) ? "000" : "111";
        System.out.println(b);
    }

}
