package com.candymanage.test;

import com.candymanage.common.CommonUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

/**
 * @packageName: candy
 * @author: hyb
 * @date: 2020-09-17 上午 11:18
 * @description:
 */
public class Passwor {

    public static String encrypt(String plainText, String aesKey, String ivVal)
            throws Exception {
        byte data[] = plainText.getBytes();
        AlgorithmParameters iv = generateIV(ivVal);
        byte keyBytes[] = generateKey(aesKey);
        Key key = convertToKey(keyBytes);
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, key, iv);
        byte encryptData[] = cipher.doFinal(data);
        return bytesToHexString(encryptData);
    }

    public static String decrypt(String encryptedStr, String aesKey, String ivVal) {
        try {
            byte encryptedData[] = hexStringToByte(encryptedStr);
            byte keyBytes[] = generateKey(aesKey);
            Key key = convertToKey(keyBytes);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            AlgorithmParameters iv = generateIV(ivVal);
            cipher.init(2, key, iv);
            byte decryptData[] = cipher.doFinal(encryptedData);
            return new String(decryptData);
        } catch (Exception e) {
            return "";
        }
    }

    private static byte[] hexStringToByte(String hex) {
        int len = hex.length() / 2;
        byte result[] = new byte[len];
        char achar[] = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }

        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789abcdef".indexOf(c);
        return b;
    }

    private static byte[] generateKey(String aesKey) {
        Security.addProvider(new BouncyCastleProvider());
        return aesKey.getBytes();
    }

    private static AlgorithmParameters generateIV(String ivVal)
            throws Exception {
        byte iv[] = ivVal.getBytes();
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }

    private static Key convertToKey(byte keyBytes[]) {
        javax.crypto.SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        return secretKey;
    }

    private static final String bytesToHexString(byte bArray[])
    {
        StringBuffer sb = new StringBuffer(bArray.length);
        for(int i = 0; i < bArray.length; i++)
        {
            String sTemp = Integer.toHexString(0xff & bArray[i]);
            if(sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toLowerCase());
        }

        return sb.toString();
    }


    public static void main(String[] args) throws Exception{
        String password = encrypt("123456","MnYg7Tm8NR1YiYBJ", CommonUtils.parseStr("ivKey"));
        System.out.println(password);
    }

}
