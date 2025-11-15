package org.ytor.sql4j.sql.insert;

import org.ytor.sql4j.sql.AliasRegister;
import org.ytor.sql4j.sql.SqlBuilder;
import org.ytor.sql4j.translate.ITranslator;
import org.ytor.sql4j.translate.support.base.BaseTranslator;

import java.util.ArrayList;
import java.util.List;

/**
 * INSERT 构造器
 */
public class InsertBuilder extends AliasRegister implements SqlBuilder {

    /**
     * SQL 翻译器
     */
    private ITranslator translator = new BaseTranslator();

    /**
     * INSERT 阶段，指定表
     */
    private InsertStage insertStage;

    /**
     * INTO 阶段，指定字段
     */
    private IntoStage intoStage;

    /**
     * VALUES 阶段，指定数据
     */
    private ValuesStage valuesStage;

    @Override
    public void setTranslator(ITranslator translator) {
        this.translator = translator;
    }

    @Override
    public ITranslator getTranslator() {
        return translator;
    }

    public void setInsertStage(InsertStage insertStage) {
        this.insertStage = insertStage;
    }

    public InsertStage getInsertStage() {
        return insertStage;
    }

    public void setIntoStage(IntoStage intoStage) {
        this.intoStage = intoStage;
    }

    public IntoStage getIntoStage() {
        return intoStage;
    }

    public void setValuesStage(ValuesStage valuesStage) {
        this.valuesStage = valuesStage;
    }

    public ValuesStage getValuesStage() {
        return valuesStage;
    }

    public static InsertStage insert(Class<?> table) {
        InsertBuilder insertBuilder = new InsertBuilder();
        return new InsertStage(insertBuilder, table);
    }
}
