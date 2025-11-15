package org.ytor.sql4j.sql.select;

import org.ytor.sql4j.sql.*;
import org.ytor.sql4j.enums.OrderType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * GROUP BY 阶段
 */
public class GroupByStage extends AbsSelect {

    private final List<SFunction<?, ?>> groupFields = new ArrayList<>();

    /**
     * 分组
     * @param selectBuilder SELECT 构造器
     * @param groupField 分组字段
     */
    public GroupByStage(SelectBuilder selectBuilder, SFunction<?, ?> groupField) {
        setSelectBuilder(selectBuilder);
        getSelectBuilder().setGroupByStage(this);
        this.groupFields.add(groupField);
    }

    /**
     * 分组
     * @param selectBuilder SELECT 构造器
     * @param groupFields 分组字段
     */
    public GroupByStage(SelectBuilder selectBuilder, List<SFunction<?, ?>> groupFields) {
        setSelectBuilder(selectBuilder);
        getSelectBuilder().setGroupByStage(this);
        this.groupFields.addAll(groupFields);
    }

    /**
     * GROUP BY 后可能是 HAVING 子句
     */
    public HavingStage orderBy(Consumer<ConditionExpressionBuilder> where) {
        return new HavingStage(getSelectBuilder(), where);
    }

    /**
     * GROUP BY 后可能是 ORDER BY 子句
     */
    public OrderByStage orderBy(SFunction<?, ?> orderField, OrderType orderType) {
        return new OrderByStage(getSelectBuilder(), new OrderItem(orderField, orderType));
    }

    /**
     * GROUP BY 后可能是 LIMIT 子句
     */
    public LimitStage limit(Long limit) {
        return new LimitStage(getSelectBuilder(), limit);
    }

    /**
     * GROUP BY 后可能结束
     */
    public SqlInfo end() {
        return getSelectBuilder().getTranslator().translate(getSelectBuilder());
    }

    public List<SFunction<?, ?>> getGroupFields() {
        return groupFields;
    }

}
