package org.ytor.sql4j.sql;

import org.ytor.sql4j.translate.ITranslator;

/**
 * SQL 构造器
 */
public interface SqlBuilder {

    void setTranslator(ITranslator translator);

    ITranslator getTranslator();
}
