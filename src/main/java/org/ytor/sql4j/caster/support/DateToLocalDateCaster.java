package org.ytor.sql4j.caster.support;

import org.ytor.sql4j.caster.Caster;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Date -> LocalDate 转换器
 */
public class DateToLocalDateCaster implements Caster<Date, LocalDate> {

    @Override
    public LocalDate cast(Date sourceVal, Class<LocalDate> targetType) {
        Instant instant = sourceVal.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
