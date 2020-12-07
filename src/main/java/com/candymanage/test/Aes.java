package com.candymanage.test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.*;

/**
 * @packageName: candy
 * @author: hyb
 * @date: 2020-09-17 下午 3:05
 * @description:
 */
public class Aes {
    public static String encodePassword(String rawPass, String salt) {
        String saltedPass = mergePasswordAndSalt(rawPass, salt, false);
        MessageDigest messageDigest = getMessageDigest();
        byte digest[];
        try {
            digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported!");
        }
        return new String(Hex.encodeHex(digest));
    }

    protected static String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null)
            password = "";
        if (strict && salt != null && (salt.toString().lastIndexOf("{") != -1 || salt.toString().lastIndexOf("}") != -1))
            throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
        if (salt == null || "".equals(salt))
            return password;
        else
            return (new StringBuilder(String.valueOf(password))).append("{").append(salt.toString()).append("}").toString();
    }

    protected  static  final MessageDigest getMessageDigest() {
        String algorithm = "MD5";
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException((new StringBuilder("No such algorithm [")).append(algorithm).append("]").toString());
        }
    }

    public static void main(String[] args) {
        String s = encodePassword("123456", null);
        System.out.println(s);
    }

}
