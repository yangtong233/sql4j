package org.ytor;

import org.ytor.sql4j.sql.SqlInfo;
import org.ytor.sql4j.sql.select.OffsetStage;
import org.ytor.sql4j.sql.select.SelectBuilder;
import org.ytor.sql4j.enums.OrderType;

/**
 * 完整的链式调用示例并生成SQL
 */
public class SqlBuilderTest {

    /**
     * 测试用实体类
     */
    public static class SysUser {
        private String name;
        private Long id;

        public String getName() { return name; }
        public Long getId() { return id; }
    }

    public static class User2 {
        private String name;
        private Long id;

        public String getName() { return name; }
        public Long getId() { return id; }
    }

    public static class User3 {
        private Integer age;

        public Integer getAge() { return age; }
    }

    public static void main(String[] args) {
        // 执行链式调用并输出SQL
        SqlInfo sqlInfo = testCompleteQuery();
        System.out.println("生成的 SQL 查询语句：");
        System.out.println(sqlInfo);
    }

    /**
     * 完整的链式查询示例，展示 SELECT + JOIN + WHERE + AND/OR 等
     */
    private static SqlInfo testCompleteQuery() {
        OffsetStage john = SelectBuilder
                .select(SysUser::getName, SysUser::getId)         // SELECT u1.name, u1.id
                .select(User2::getName, User2::getId)         // SELECT u2.name, u2.id
                .from(SysUser.class)                            // FROM user1 u1
                .leftJoin(User2.class, on ->                  // LEFT JOIN user2 u2 ON u2.name = u1.name
                        on.eq(User2::getName, SysUser::getName)
                )
                .leftJoin(User3.class, on ->                  // LEFT JOIN user3 u3 ON u3.age = u1.id
                        on.eq(User3::getAge, SysUser::getId)
                )
                .where(w -> w.eq(true, SysUser::getName, "John")  // WHERE u1.name = 'John'
                        .and(w1 -> w1.gt(User3::getAge, 18)      // AND (u3.age > 18)
                                .or().lt(User3::getAge, 30))    // OR u3.age < 30
                        .or().isNull(User2::getName))         // OR u2.name IS NULL
                .orderBy(SysUser::getId, OrderType.DESC)         // ORDER BY u1.id DESC
                .limit(10L)                                   // LIMIT 10
                .offset(5L);

        // 链式调用，构建查询语句
        return john.toSql();
    }
}
