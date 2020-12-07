package com.candymanage.test;

import java.util.UUID;

/**
 * @packageName: candy
 * @author: hyb
 * @date: 2020-08-04 下午 5:11
 * @description:
 */
public class UUIDUtils {

    public static String getUUID(){
        return  UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }

}
