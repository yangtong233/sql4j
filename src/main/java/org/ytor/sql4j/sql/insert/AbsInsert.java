package org.ytor.sql4j.sql.insert;

import org.ytor.sql4j.sql.AbsSql;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.enums.SqlType;

import java.util.ArrayList;
import java.util.List;

/**
 * INSERT 阶段的抽象基类
 */
public abstract class AbsInsert extends AbsSql {

    protected InsertBuilder getInsertBuilder() {
        return (InsertBuilder) register;
    }

    protected void setInsertBuilder(InsertBuilder insertBuilder) {
        this.register = insertBuilder;
    }

    /**
     * 结束当前 SQL 的链式调用，并返回 SQL 解析结果
     */
    public SqlInfo toSql() {
        // 将当前调用链翻译成 SQL
        String sql = getInsertBuilder().getTranslator().translate(getInsertBuilder());
        // 经过翻译后，会将有序的占位符参数放进params数组
        List<Object> params = new ArrayList<>(getInsertBuilder().getParams());
        return new SqlInfo(SqlType.INSERT, sql, params);
    }
}
