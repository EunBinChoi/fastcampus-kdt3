package org.example.overview.members.dao;


import org.example.overview.members.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemberDAO implements IMemberDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String MEMBER_SEARCH = "select * from member where uId like ? or uEmail like ?";

    private static final String MEMBER_SELECT_ALL = "select * from member";
    private static final String MEMBER_SELECT = "select * from member where uId = ?";
    private static final String MEMBER_INSERT = "insert into member values(?, ?, ?)";

    private static final String MEMBER_PASSWORD_UPDATE = "update member set uPw = ? where uId = ?";
    private static final String MEMBER_EMAIL_UPDATE = "update member set uEmail = ? where uId = ?";
    private static final String MEMBER_DELETE = "delete member where uId = ?";
    private static final String MEMBER_DELETE_ALL = "delete member";


    @Override
    public List<Member> search(String q) { // 이름이나 이메일로 검색
        // table 열의 구조 != 객체의 필드 구조

        return jdbcTemplate.query(MEMBER_SEARCH, (rs, rowNum) -> new Member(
                rs.getString("uId"),
                rs.getString("uPw"),
                rs.getString("uEmail")), "%" + q + "%", "%" + q + "%");
    }

    @Override
    public Member select(String uId) {
        List<Member> memberList = jdbcTemplate.query(MEMBER_SELECT, (rs, rowNum) -> new Member(
                rs.getString("uId"),
                rs.getString("uPw"),
                rs.getString("uEmail")), uId);

        if (memberList.isEmpty()) return null;
        return memberList.get(0);

    }

    @Override
    public List<Member> selectAll() {
        return jdbcTemplate.query(MEMBER_SELECT_ALL, (rs, rowNum) -> new Member(
                rs.getString("uId"),
                rs.getString("uPw"),
                rs.getString("uEmail")));
    }

    @Override
    public int insert(Member member) {
        return jdbcTemplate.update(MEMBER_INSERT, ps -> {
            ps.setString(1, member.getuId());
            ps.setString(2, member.getuPw());
            ps.setString(3, member.getuEmail());
        });
    }

    @Override
    public int insertAll(List<Member> members) {
        return members.stream().map(m -> insert(m)) // 1
                .collect(Collectors.toList()) // [1, 1, 1, 1, 1]
                .stream()
                .reduce((x, y) -> x + y) // 1 + 1 + 1 + 1 + 1
                .orElse(0);
    }

    @Override
    public int updatePassword(String uId, String uPw) {
        return jdbcTemplate.update(MEMBER_PASSWORD_UPDATE, ps -> {
            ps.setString(1, uPw);
            ps.setString(2, uId);
        });
    }

    @Override
    public int updateEmail(String uId, String uEmail) {
        return jdbcTemplate.update(MEMBER_EMAIL_UPDATE, ps -> {
            ps.setString(1, uEmail);
            ps.setString(2, uId);
        });
    }


    @Override
    public int delete(String uId) {
        return jdbcTemplate.update(MEMBER_DELETE, ps -> ps.setString(1, uId));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update(MEMBER_DELETE_ALL, ps -> {});
    }

}

