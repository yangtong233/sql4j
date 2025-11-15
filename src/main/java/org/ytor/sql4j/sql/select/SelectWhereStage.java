package org.ytor.sql4j.sql.select;

import org.ytor.sql4j.sql.*;
import org.ytor.sql4j.enums.OrderType;

import java.util.function.Consumer;

/**
 * WHERE 阶段
 */
public class SelectWhereStage extends AbsSelect {

    private final Consumer<ConditionExpressionBuilder> where;

    public SelectWhereStage(SelectBuilder selectBuilder, Consumer<ConditionExpressionBuilder> where) {
        setSelectBuilder(selectBuilder);
        getSelectBuilder().setWhereStage(this);
        this.where = where;
    }

    /**
     * WHERE 后可能是 GROUP BY 子句
     */
    public <T> GroupByStage groupBy(SFunction<T, ?> groupFields) {
        return new GroupByStage(getSelectBuilder(), groupFields);
    }

    /**
     * WHERE 后可能是 ORDER BY 子句
     */
    public <T> OrderByStage orderBy(SFunction<T, ?> orderField, OrderType orderType) {
        return new OrderByStage(getSelectBuilder(), new OrderItem(orderField, orderType));
    }

    /**
     * WHERE 后可能是 LIMIT 子句
     */
    public LimitStage limit(Long limit) {
        return new LimitStage(getSelectBuilder(), limit);
    }

    /**
     * WHERE 后可能结束
     */
    public SqlInfo end() {
        return getSelectBuilder().getTranslator().translate(getSelectBuilder());
    }

    public Consumer<ConditionExpressionBuilder> getWhere() {
        return where;
    }

}
