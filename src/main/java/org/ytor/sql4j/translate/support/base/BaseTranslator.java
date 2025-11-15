package org.ytor.sql4j.translate.support.base;

import org.ytor.sql4j.Sql4JException;
import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.sql.delete.DeleteBuilder;
import org.ytor.sql4j.sql.insert.InsertBuilder;
import org.ytor.sql4j.sql.select.SelectBuilder;
import org.ytor.sql4j.sql.update.UpdateBuilder;
import org.ytor.sql4j.translate.*;

public class BaseTranslator implements ITranslator {

    private final ISelectTranslator selectTranslator = new BaseSelectTranslator();
    private final IInsertTranslator insertTranslator = new BaseInsertTranslator();
    private final IUpdateTranslator updateTranslator = new BaseUpdateTranslator();
    private final IDeleteTranslator deleteTranslator = new BaseDeleteTranslator();

    @Override
    public SqlInfo translate(SqlBuilder sqlBuilder) {
        if (sqlBuilder instanceof SelectBuilder) {
            return selectTranslator.translate((SelectBuilder) sqlBuilder);
        } else if (sqlBuilder instanceof InsertBuilder) {
            return insertTranslator.translate((InsertBuilder) sqlBuilder);
        } else if (sqlBuilder instanceof UpdateBuilder) {
            return updateTranslator.translate((UpdateBuilder) sqlBuilder);
        } else if (sqlBuilder instanceof DeleteBuilder) {
            return deleteTranslator.translate((DeleteBuilder) sqlBuilder);
        } else {
            throw new Sql4JException("翻译SQL时出错：未知的SqlBuilder类型【" + sqlBuilder.getClass().getName() + "】");
        }
    }

}
