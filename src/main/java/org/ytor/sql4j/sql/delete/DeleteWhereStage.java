package org.ytor.sql4j.sql.delete;

import org.ytor.sql4j.sql.ConditionExpressionBuilder;
import org.ytor.sql4j.sql.SqlInfo;

import java.util.function.Consumer;

/**
 * DELETE 阶段，指定要删除的目标表
 */
public class DeleteWhereStage extends AbsDelete {

    private final Consumer<ConditionExpressionBuilder> where;

    public DeleteWhereStage(DeleteBuilder deleteBuilder, Consumer<ConditionExpressionBuilder> where) {
        setDeleteBuilder(deleteBuilder);
        getDeleteBuilder().setWhereStage(this);
        this.where = where;
    }

    /**
     * WHERE 后可能结束
     */
    public SqlInfo end() {
        return getDeleteBuilder().getTranslator().translate(getDeleteBuilder());
    }

    public Consumer<ConditionExpressionBuilder> getWhere() {
        return where;
    }
}
