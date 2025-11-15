package org.ytor.sql4j.sql.select;

import org.ytor.sql4j.sql.SFunction;
import org.ytor.sql4j.sql.SqlInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SELECT 阶段
 */
public class SelectStage extends AbsSelect {

    /**
     * SELECT 查询字段
     */
    private final List<SFunction<?, ?>> selectFields = new ArrayList<>();

    public SelectStage(SelectBuilder selectBuilder, SFunction<?, ?> selectField) {
        setSelectBuilder(selectBuilder);
        selectBuilder.setSelectStage(this);
        this.selectFields.add(selectField);
    }

    public SelectStage(SelectBuilder selectBuilder, List<SFunction<?, ?>> selectFields) {
        setSelectBuilder(selectBuilder);
        selectBuilder.setSelectStage(this);
        this.selectFields.addAll(selectFields);
    }

    /**
     * SELECT 后可能继续 SELECT
     */
    @SafeVarargs
    public final <T> SelectStage select(SFunction<T, ?>... field) {
        Collections.addAll(selectFields, field);
        return this;
    }

    /**
     * SELECT 后可能进入 FROM 阶段
     */
    public <T> FromStage from(Class<T> table) {
        return new FromStage(getSelectBuilder(), table);
    }

    /**
     * SELECT 后可能结束
     */
    public SqlInfo end() {
        return getSelectBuilder().getTranslator().translate(getSelectBuilder());
    }

    public List<SFunction<?, ?>> getSelectFields() {
        return selectFields;
    }
}
