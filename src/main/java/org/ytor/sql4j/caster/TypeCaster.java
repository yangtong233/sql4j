package org.ytor.sql4j.caster;

import org.ytor.sql4j.caster.support.DateToLocalDateCaster;

import java.time.LocalDate;
import java.util.Date;

/**
 * 类型转换器
 */
public class TypeCaster extends TypeCasterRegister {

    {
        register(new TypePair(Date.class, LocalDate.class), new DateToLocalDateCaster());
    }

    /**
     * 将原始值转为目标类型
     * @param sourceVal 原始值
     * @param targetType 目标类型
     * @return 目标值
     * @param <T> 原始类型
     * @param <S> 目标类型
     */
    public <T, S> T cast(S sourceVal, Class<T> targetType) {
        if (sourceVal == null) {
            return null;
        }
        // 如果目标类型是枚举
        if (targetType.isEnum()) {
            for (T enumConstant : targetType.getEnumConstants()) {
                Enum<?> e = (Enum<?>) enumConstant;
                if (sourceVal.getClass().equals(String.class) && e.name().equalsIgnoreCase((String) sourceVal)
                        || sourceVal.getClass().isEnum() && e.equals(sourceVal)) {
                    return (T) e;
                }
            }
        }
        // 尝试调用自定义的类型转换器
        TypePair typePair = new TypePair(sourceVal.getClass(), targetType);
        Caster<S, T> caster = getCaster(typePair);
        return caster != null ? caster.cast(sourceVal, targetType) : null;
    }

}
