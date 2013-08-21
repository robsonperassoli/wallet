package com.robsonp.wallet.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

public class Encripter {

    private static String encrypt(String digest, String content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(digest);

        byte[] hash = md.digest(content.getBytes());

        StringBuffer sb = new StringBuffer();
        for (byte b : hash) {
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }

    public static String sha256(String toHash) {
        return DigestUtils.sha256Hex(toHash);
    }
    
    public static String sha512(String toHash) {
        return DigestUtils.sha512Hex(toHash);
    }
    
    public static String sha1(String toHash) {
        try {
            return encrypt("SHA-1", toHash);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Erro ao criar hash", ex);        
        }
    }
    
    public static String md5(String toHash) {
        return DigestUtils.md5Hex(toHash);
    }

}
