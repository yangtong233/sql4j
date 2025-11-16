package org.ytor.sql4j.log.support;

import org.ytor.sql4j.log.ISqlLogger;

/**
 * 默认的 SQL 日志记录器
 */
public class DefaultSqlLogger implements ISqlLogger {
    @Override
    public void error(String msg) {
        System.err.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println(msg);
    }

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println(msg);
    }
}
