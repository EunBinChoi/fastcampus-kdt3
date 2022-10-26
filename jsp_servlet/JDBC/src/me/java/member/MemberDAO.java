package me.java.member;

import me.java.database.JDBCMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MemberDAO {

    private static MemberDAO memberDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String MEMBER_SELECT_ALL = "select * from member"; // 행 여러개
    private static final String MEMBER_SELECT = "select * from member where uId = ?"; // 행 1개
    private static final String MEMBER_INSERT = "insert into member values(?, ?, ?)";
    private static final String MEMBER_PASSWORD_UPDATE = "update member set uPw = ? where uId = ?";
    private static final String MEMBER_DELETE = "delete member where uId = ?";

    private MemberDAO() {}

    public static MemberDAO getInstance() {
        if (memberDAO == null) {
            memberDAO = new MemberDAO();
        }
        return memberDAO;
    }


    // "select * from member where uId = ?" (prepareStatement: 해당 SQL 문을 미리 컴파일, 성능 향상)
    public Member select(String uId) {
        Member member = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, uId);

            rs = stmt.executeQuery(); // executeQuery() => ResultSet => select 문에서 사용

            if (rs.next()) { // uId (Primary Key, 중복 불가) => 객체가 하나만 검색
                String mId = rs.getString("uId");
                String mPw = rs.getString("uPw");
                String mEmail = rs.getString("uEmail");
                member = new Member(mId, mPw, mEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return member;
    }

    public List<Member> selectAll() {
        List<Member> memberList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String uId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");

                memberList.add(new Member(uId, uPw, uEmail));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return memberList;
    }

    // "insert into member values(?, ?, ?)"
    public int insert(Member member) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1, member.getuId());
            stmt.setString(2, member.getuPw());
            stmt.setString(3, member.getuEmail());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    // "update member set uPw = ? where uId = ?"
    public int update(String uId, String uPw) { // uPw
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_PASSWORD_UPDATE);
            stmt.setString(1, uPw);
            stmt.setString(2, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    // "delete member where uId = ?"
    public int delete(String uId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

}
