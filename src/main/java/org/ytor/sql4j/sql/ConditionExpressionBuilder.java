package org.ytor.sql4j.sql;

import java.util.function.Consumer;

/**
 * 带有条件的表达式构造父类（用于 WHERE / HAVING / ON）
 */
public class ConditionExpressionBuilder extends ExpressionBuilder {

    public ConditionExpressionBuilder(AliasRegister register) {
        super(register);
    }

    // 覆盖父类的方法，返回子类类型
    @Override
    public <T> ConditionExpressionBuilder eq(SFunction<T, ?> field, Object value) {
        super.eq(field, value);
        return this;
    }

    @Override
    public <L, R> ConditionExpressionBuilder eq(SFunction<L, ?> leftField, SFunction<R, ?> rightField) {
        super.eq(leftField, rightField);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder ne(SFunction<T, ?> field, Object value) {
        super.ne(field, value);
        return this;
    }

    @Override
    public <L, R> ConditionExpressionBuilder ne(SFunction<L, ?> leftField, SFunction<R, ?> rightField) {
        super.ne(leftField, rightField);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder gt(SFunction<T, ?> field, Object value) {
        super.gt(field, value);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder ge(SFunction<T, ?> field, Object value) {
        super.ge(field, value);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder lt(SFunction<T, ?> field, Object value) {
        super.lt(field, value);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder le(SFunction<T, ?> field, Object value) {
        super.le(field, value);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder isNull(SFunction<T, ?> field) {
        super.isNull(field);
        return this;
    }

    @Override
    public <T> ConditionExpressionBuilder isNotNull(SFunction<T, ?> field) {
        super.isNotNull(field);
        return this;
    }

    @Override
    public ConditionExpressionBuilder and() {
        super.and();
        return this;
    }

    @Override
    public ConditionExpressionBuilder and(Consumer<ExpressionBuilder> nested) {
        super.and(nested);
        return this;
    }

    @Override
    public ConditionExpressionBuilder or() {
        super.or();
        return this;
    }

    @Override
    public ConditionExpressionBuilder or(Consumer<ExpressionBuilder> nested) {
        super.or(nested);
        return this;
    }

    /*=========================== ConditionExpressionBuilder特有的方法 =================================*/

    /**
     * 等值匹配：field1 = value
     */
    public <T> ConditionExpressionBuilder eq(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) {
            return eq(field, value);
        }
        return this;
    }

    /**
     * 等值匹配：field1 = field2
     */
    public <L, R> ConditionExpressionBuilder eq(boolean condition, SFunction<L, ?> leftField, SFunction<R, ?> rightField) {
        if (condition) {
            return eq(leftField, rightField);
        }
        return this;
    }

    /**
     * 不等于：field != value
     */
    public <T> ConditionExpressionBuilder ne(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) {
            return ne(field, value);
        }
        return this;
    }

    /**
     * 不等于：field1 != field2
     */
    public <L, R> ConditionExpressionBuilder ne(boolean condition, SFunction<L, ?> leftField, SFunction<R, ?> rightField) {
        if (condition) {
            return ne(leftField, rightField);
        }
        return this;
    }

    /**
     * 大于：field > value
     */
    public <T> ConditionExpressionBuilder gt(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) {
            return gt(field, value);
        }
        return this;
    }

    /**
     * 大于等于：field >= value
     */
    public <T> ConditionExpressionBuilder ge(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) {
            return ge(field, value);
        }
        return this;
    }

    /**
     * 小于：field < value
     */
    public <T> ConditionExpressionBuilder lt(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) {
            return lt(field, value);
        }
        return this;
    }

    /**
     * 小于等于：field <= value
     */
    public <T> ConditionExpressionBuilder le(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) {
            return le(field, value);
        }
        return this;
    }

    /**
     * IS NULL
     */
    public <T> ConditionExpressionBuilder isNull(boolean condition, SFunction<T, ?> field) {
        if (condition) {
            return isNull(field);
        }
        return this;
    }

    /**
     * IS NOT NULL
     */
    public <T> ConditionExpressionBuilder isNotNull(boolean condition, SFunction<T, ?> field) {
        if (condition) {
            return isNotNull(field);
        }
        return this;
    }

    public ConditionExpressionBuilder and(boolean condition, Consumer<ExpressionBuilder> nested) {
        if (condition) {
            return and(nested);
        }
        return this;
    }

    public ConditionExpressionBuilder or(boolean condition, Consumer<ExpressionBuilder> nested) {
        if (condition) {
            return or(nested);
        }
        return this;
    }
}
