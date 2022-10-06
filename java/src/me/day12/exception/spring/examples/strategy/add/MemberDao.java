package me.day12.exception.spring.examples.strategy.add;

import java.sql.SQLException;

public class MemberDao {
    private final JdbcTemplate jdbcTemplate;

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add(Member member) throws DuplicateUserIdException {
        try {
            // JDBC API
            // DB에 전달된 member 추가하는 코드 (SQLException 발생 가능)
            throw new SQLException();
        } catch (SQLException e) {
            if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
                throw new DuplicateUserIdException(e);
            } else {
                throw new RuntimeException(e);
            }
        }
    }

}
