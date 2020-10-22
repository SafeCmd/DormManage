package com.tdysj.dorm.common.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * @author mjy
 */
@UtilityClass
public class MD5Util {

    /**
     * 加密密码，使用用户名和盐作为唯一盐，md5两次
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public static String encryptPassword(String username, String password, String salt) {
        MessageDigest messageDigest = DigestUtils.getMd5Digest();
        if (StringUtils.isNotBlank(username + salt)) {
            messageDigest.reset();
            messageDigest.update((username + salt).getBytes());
        }
        byte[] hashed = messageDigest.digest(password.getBytes());
        messageDigest.reset();
        hashed = messageDigest.digest(hashed);
        return Hex.encodeHexString(hashed);
    }
}
