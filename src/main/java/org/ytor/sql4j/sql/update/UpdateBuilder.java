package org.ytor.sql4j.sql.update;

import org.ytor.sql4j.sql.AliasRegister;
import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.translate.ITranslator;
import org.ytor.sql4j.translate.support.base.BaseTranslator;

/**
 * UPDATE 构造器
 */
public class UpdateBuilder extends AliasRegister implements SqlBuilder {

    /**
     * SQL 翻译器
     */
    private ITranslator translator = new BaseTranslator();

    /**
     * UPDATE 阶段，指定表
     */
    private UpdateStage updateStage;

    /**
     * SET 阶段，指定更新的字段
     */
    private SetStage setStage;

    /**
     * WHERE 阶段，指定条件
     */
    private UpdateWhereStage whereStage;

    @Override
    public void setTranslator(ITranslator translator) {
        this.translator = translator;
    }

    @Override
    public ITranslator getTranslator() {
        return translator;
    }

    public void setUpdateStage(UpdateStage updateStage) {
        this.updateStage = updateStage;
    }

    public UpdateStage getUpdateStage() {
        return updateStage;
    }

    public void setSetStage(SetStage setStage) {
        this.setStage = setStage;
    }

    public SetStage getSetStage() {
        return setStage;
    }

    public void setWhereStage(UpdateWhereStage whereStage) {
        this.whereStage = whereStage;
    }

    public UpdateWhereStage getWhereStage() {
        return whereStage;
    }

    public static UpdateStage update(Class<?> table) {
        UpdateBuilder updateBuilder = new UpdateBuilder();
        return new UpdateStage(updateBuilder, table);
    }
}
