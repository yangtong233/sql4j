package org.ytor.sql4j.sql.delete;

import org.ytor.sql4j.sql.AliasRegister;
import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.translate.ITranslator;
import org.ytor.sql4j.translate.support.base.BaseTranslator;

/**
 * DELETE 构造器
 */
public class DeleteBuilder extends AliasRegister implements SqlBuilder {

    /**
     * SQL 翻译器
     */
    private ITranslator translator = new BaseTranslator();

    /**
     * DELETE 阶段
     */
    private DeleteStage deleteStage;

    /**
     * FROM 阶段，指定要删除的目标表
     */
    private FromStage fromStage;

    /**
     * WHERE 阶段，指定删除条件
     */
    private DeleteWhereStage whereStage;

    @Override
    public void setTranslator(ITranslator translator) {
        this.translator = translator;
    }

    @Override
    public ITranslator getTranslator() {
        return translator;
    }

    public void setDeleteStage(DeleteStage deleteStage) {
        this.deleteStage = deleteStage;
    }

    public DeleteStage getDeleteStage() {
        return deleteStage;
    }

    public void setFromStage(FromStage fromStage) {
        this.fromStage = fromStage;
    }

    public FromStage getFromStage() {
        return fromStage;
    }

    public void setWhereStage(DeleteWhereStage whereStage) {
        this.whereStage = whereStage;
    }

    public DeleteWhereStage getWhereStage() {
        return whereStage;
    }

    public static DeleteStage delete() {
        DeleteBuilder deleteBuilder = new DeleteBuilder();
        return new DeleteStage(deleteBuilder);
    }
}
