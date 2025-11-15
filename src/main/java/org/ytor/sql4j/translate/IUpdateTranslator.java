package org.ytor.sql4j.translate;

import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.sql.update.UpdateBuilder;

/**
 * UPDATE 翻译器
 */
public interface IUpdateTranslator {

    SqlInfo translate(UpdateBuilder builder);

}
