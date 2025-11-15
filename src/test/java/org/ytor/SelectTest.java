package org.ytor;

import org.ytor.sql4j.sql.select.SelectBuilder;

/**
 * created by YT on 2025/11/14 16:02:23
 * <br/>
 */
public class SelectTest {
    public static void main(String[] args) {
        SelectBuilder.select(Person::getName, Person::getAge)
                .select(User::getUsername, User::getId)
                .from(Person.class)
                .leftJoin(User.class, on -> on.eq(User::getUsername, 1))
                .where(w -> w.eq(Person::getName, 12))
                .limit(1L)
                .offset(12L)
        ;
    }

}
