package org.ytor.sql4j.sql.select;

import org.ytor.sql4j.sql.SqlInfo;

/**
 * LIMIT 阶段
 */
public class LimitStage extends AbsSelect {

    private final Long limit;

    public LimitStage(SelectBuilder selectBuilder, Long limit) {
        setSelectBuilder(selectBuilder);
        getSelectBuilder().setLimitStage(this);
        this.limit = limit;
    }

    /**
     * LIMIT 后可能是 OFFSET 子句
     */
    public OffsetStage offset(Long offset) {
        return new OffsetStage(getSelectBuilder(), offset);
    }

    /**
     * LIMIT 后可能结束
     */
    public SqlInfo end() {
        return getSelectBuilder().getTranslator().translate(getSelectBuilder());
    }

    public Long getLimit() {
        return limit;
    }

}
