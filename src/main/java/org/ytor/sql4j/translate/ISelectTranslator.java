package org.ytor.sql4j.translate;

import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.sql.select.SelectBuilder;

/**
 * SELECT 翻译器
 */
public interface ISelectTranslator {

    SqlInfo translate(SelectBuilder builder);
}
