package org.ytor.sql4j.sql.delete;

import org.ytor.sql4j.sql.AbsSql;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.enums.SqlType;

import java.util.ArrayList;
import java.util.List;

/**
 * DELETE 阶段的抽象基类
 */
public abstract class AbsDelete extends AbsSql {

    protected DeleteBuilder getDeleteBuilder() {
        return (DeleteBuilder) register;
    }

    protected void setDeleteBuilder(DeleteBuilder DeleteBuilder) {
        this.register = DeleteBuilder;
    }

    /**
     * 结束当前 SQL 的链式调用，并返回 SQL 解析结果
     */
    public SqlInfo toSql() {
        // 将当前调用链翻译成 SQL
        String sql = getDeleteBuilder().getTranslator().translate(getDeleteBuilder());
        // 经过翻译后，会将有序的占位符参数放进params数组
        List<Object> params = new ArrayList<>(getDeleteBuilder().getParams());
        return new SqlInfo(SqlType.DELETE, sql, params);
    }
}
