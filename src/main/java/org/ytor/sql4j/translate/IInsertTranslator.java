package org.ytor.sql4j.translate;

import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.sql.insert.InsertBuilder;

/**
 * INSERT 翻译器
 */
public interface IInsertTranslator {

    SqlInfo translate(InsertBuilder builder);
}
