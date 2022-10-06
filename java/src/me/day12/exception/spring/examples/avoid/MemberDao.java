package me.day12.exception.spring.examples.avoid;

import java.sql.SQLException;

public class MemberDao {
    private final JdbcTemplate jdbcTemplate;

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add1(Member member) throws SQLException {
        // JDBC API
        // DB에 전달된 member 추가하는 코드 (SQLException 발생 가능)
    }

    /*
     * Example 2
     */
    public void add2(Member member) throws SQLException {
        try {
            // JDBC API
            // DB에 전달된 member 추가하는 코드 (SQLException 발생 가능)
            throw new SQLException();
        } catch (SQLException e) {
            // 로그 출력
            throw e;
        }
    }

}
