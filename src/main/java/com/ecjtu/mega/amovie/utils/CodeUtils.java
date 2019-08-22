package com.ecjtu.mega.amovie.utils;

import java.util.UUID;

/**
 * @author mega
 */
public class CodeUtils {
    /**
     * 生成唯一的激活码
     *
     * @return
     */
    public static String generateUniqueCode() {
        return UUID.
                randomUUID().
                toString().
                replaceAll("-", "");
    }
}
