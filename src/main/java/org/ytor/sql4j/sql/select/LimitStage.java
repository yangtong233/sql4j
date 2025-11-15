package org.ytor.sql4j.sql.select;

import org.ytor.sql4j.sql.SqlInfo;

/**
 * LIMIT 阶段
 */
public class LimitStage extends AbsSelect {

    private final Integer limit;

    public LimitStage(SelectBuilder selectBuilder, Integer limit) {
        setSelectBuilder(selectBuilder);
        getSelectBuilder().setLimitStage(this);
        this.limit = limit;
    }

    /**
     * LIMIT 后可能是 OFFSET 子句
     */
    public OffsetStage offset(Integer offset) {
        return new OffsetStage(getSelectBuilder(), offset);
    }

    /**
     * LIMIT 后可能结束
     */
    public SqlInfo end() {
        return getSelectBuilder().getTranslator().translate(getSelectBuilder());
    }

    public Integer getLimit() {
        return limit;
    }

}
