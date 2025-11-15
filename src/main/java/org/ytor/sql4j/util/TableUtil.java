package org.ytor.sql4j.util;

/**
 * 表工具栏
 */
public class TableUtil {

    /**
     * 从 CLASS 对象中解析出表名称
     */
    public static String parseTableNameFromClass(Class<?> table) {
        return StrUtil.toLowerUnderline(table.getSimpleName());
    }

}
