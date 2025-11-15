package org.ytor.sql4j.sql;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 函数式接口，用于接收方法引用类型的参数
 */
@FunctionalInterface
public interface SFunction<T, R> extends Function<T, R>, Serializable {

}
