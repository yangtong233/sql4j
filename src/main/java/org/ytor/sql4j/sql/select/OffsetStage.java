package org.ytor.sql4j.sql.select;

import org.ytor.sql4j.sql.SqlInfo;

/**
 * OFFSET 阶段
 */
public class OffsetStage extends AbsSelect {

    private final Long offset;

    public OffsetStage(SelectBuilder selectBuilder, Long offset) {
        setSelectBuilder(selectBuilder);
        getSelectBuilder().setOffsetStage(this);
        this.offset = offset;
    }

    /**
     * OFFSET 后可能结束
     */
    public SqlInfo end() {
        return getSelectBuilder().getTranslator().translate(getSelectBuilder());
    }

    public Long getOffset() {
        return offset;
    }
}
