package org.ytor.sql4j.sql.update;

import org.ytor.sql4j.sql.AbsSql;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.enums.SqlType;

import java.util.ArrayList;
import java.util.List;

/**
 * UPDATE 阶段的抽象基类
 */
public abstract class AbsUpdate extends AbsSql {

    protected UpdateBuilder getUpdateBuilder() {
        return (UpdateBuilder) register;
    }

    protected void setUpdateBuilder(UpdateBuilder UpdateBuilder) {
        this.register = UpdateBuilder;
    }

    /**
     * 结束当前 SQL 的链式调用，并返回 SQL 解析结果
     */
    public SqlInfo toSql() {
        // 将当前调用链翻译成 SQL
        String sql = getUpdateBuilder().getTranslator().translate(getUpdateBuilder());
        // 经过翻译后，会将有序的占位符参数放进params数组
        List<Object> params = new ArrayList<>(getUpdateBuilder().getParams());
        return new SqlInfo(SqlType.UPDATE, sql, params);
    }
}
