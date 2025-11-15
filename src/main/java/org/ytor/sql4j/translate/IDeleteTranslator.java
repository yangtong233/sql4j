package org.ytor.sql4j.translate;

import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.sql.delete.DeleteBuilder;

/**
 * DELETE 翻译器
 */
public interface IDeleteTranslator {

    SqlInfo translate(DeleteBuilder builder);
}
