package org.ytor.sql4j.util;

/**
 * 字符串工具类
 */
public class StrUtil {

    public static String toLowerUnderline(String targetStr) {
        if (targetStr == null || targetStr.isEmpty()) {
            return targetStr;
        }

        StringBuilder result = new StringBuilder();
        char[] chars = targetStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isUpperCase(ch)) {
                // 前面不是开头，也不是连续大写，则插入分隔符
                if (i > 0 && (Character.isLowerCase(chars[i - 1]) ||
                        (i + 1 < chars.length && Character.isLowerCase(chars[i + 1])))) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

}
