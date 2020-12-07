package com.candymanage.test;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;

/**
 * @packageName: candy
 * @author: hyb
 * @date: 2020-09-17 上午 11:46
 * @description:
 */
public class PassAES {
    // 初始化是否完成，防止多次初始化内存泄漏
    public static boolean initialized = false;
    // 设置编码方式
    public static final String CHARSET = "UTF-8";
    // 加密算法的名称
    public static final String AES_ALGORITHM = "AES";
    // 加密填充的方式   算法/模式/填充
    public static final String AES_MOD_PADDING = "AES/CBC/PKCS7Padding";

    /**
     * 保证只初始化一次数据持有安全提供者的名称
     */
    public static void initialize(){
        if (initialized) return;
        // 将提供程序添加到下一个可用位置，介于java不支持PKCS7Padding，只支持PKCS5Padding，要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    /**
     * AES加解密
     * @param data
     * 			内容
     * @param key
     * 			密钥key
     * @param mode
     * 			加解密模式
     * @param iv
     * 			偏移量
     * @return
     */
    public static String doAES(String data, String key, int mode, String iv) {
        try {
            // 初始化
            initialize();
            // 加解密内容
            byte[] content = null;
            if (mode == Cipher.ENCRYPT_MODE) {
                content = data.getBytes(CHARSET);
            } else {
                content = Base64.decodeBase64(data);
            }
            // 加解密密钥
            byte[] keyByte = Base64.decodeBase64(key);
            // 偏移量(16位的数据)
            byte[] ivByte = Base64.decodeBase64(iv);
            // 构造一个密钥
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, AES_ALGORITHM);
            // 创建密码器(算法/模式/填充)
            Cipher cipher = Cipher.getInstance(AES_MOD_PADDING);
            // 初始化
            cipher.init(mode, keySpec, generateIV(ivByte));
            // 加密或解密
            byte[] result = cipher.doFinal(content);
            if (mode == Cipher.ENCRYPT_MODE) {
                return Base64.encodeBase64String(result);
            } else {
                return new String(result,CHARSET);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 生成iv 加密算法的初始向量
     *
     * @param iv
     * @return
     * @throws Exception
     */
    private static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance(AES_ALGORITHM);
        params.init(new IvParameterSpec(iv));
        return params;
    }


    /**
     * 随机生成秘钥(CBC模式下只能使用此方法生成126位密钥)
     */
    @SuppressWarnings("unused")
    private static String getKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
            // 要生成多少位，只需要修改这里即可128, 192或256
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            String key = Base64.encodeBase64String(secretKey.getEncoded());
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 密钥16位，实际开发中不足应该补足
        String key = "1234567812345678";
        key = Base64.encodeBase64String(key.getBytes("UTF-8"));
        System.out.println("AES密钥：" + key);
        // 偏移向量16位
        String iv = "1234567890123456";
        iv = Base64.encodeBase64String(iv.getBytes("UTF-8"));
        System.out.println("iv：" + iv);
        String data = "123abc";
        System.out.println("被加密数据原文：" + data);
        // AES加密
        String enctyptData = PassAES.doAES(data, key, Cipher.ENCRYPT_MODE, iv);
        System.out.println("AES加密：" + enctyptData);
        // AES解密
        String dectyptData = PassAES.doAES(enctyptData, key, Cipher.DECRYPT_MODE, iv);
        System.out.println("AES解密：" + dectyptData);
    }
}
