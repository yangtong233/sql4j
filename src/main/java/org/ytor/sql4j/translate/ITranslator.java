package org.ytor.sql4j.translate;

import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.sql.SqlInfo;

/**
 * SQL 翻译器
 */
public interface ITranslator {

    SqlInfo translate(SqlBuilder sqlBuilder);

}
