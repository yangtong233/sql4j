package org.ytor.sql4j.sql;

import org.ytor.sql4j.enums.OrderType;

/**
 * 排序字段
 */
public class OrderItem {

    /**
     * 排序字段
     */
    private SFunction<?, ?> orderField;

    /**
     * 排序类型
     */
    private OrderType orderType;

    public OrderItem(SFunction<?, ?> orderField, OrderType orderType) {
        this.orderField = orderField;
        this.orderType = orderType;
    }

    public void setOrderField(SFunction<?, ?> orderField) {
        this.orderField = orderField;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public SFunction<?, ?> getOrderField() {
        return orderField;
    }
}
