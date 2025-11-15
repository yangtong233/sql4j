package org.ytor.sql4j.core;

public class ConnectionProviderHelper {

    private static IConnectionProvider connectionProvider;

    /**
     * 注册数据库连接提供组件
     */
    public static void registerConnectionProvider(IConnectionProvider connectionProvider) {
        ConnectionProviderHelper.connectionProvider = connectionProvider;
    }

    /**
     * 获取数据库连接提供组件
     */
    public static IConnectionProvider getConnectionProvider() {
        return connectionProvider;
    }
}
