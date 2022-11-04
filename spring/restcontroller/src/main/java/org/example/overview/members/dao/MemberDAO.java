package org.example.overview.members.dao;


import org.example.overview.members.database.ConnectionPoolMgr;
import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Member;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemberDAO implements IMemberDAO {
//    private static MemberDAO memberDAO = null;

    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String MEMBER_SEARCH = "select * from member where uId like ? or uEmail like ?";

    private static final String MEMBER_SELECT_ALL = "select * from member";
    private static final String MEMBER_SELECT = "select * from member where uId = ?";
    private static final String MEMBER_INSERT = "insert into member values(?, ?, ?)";

    private static final String MEMBER_PASSWORD_UPDATE = "update member set uPw = ? where uId = ?";
    private static final String MEMBER_PASSWORD_EMAIL_UPDATE = "update member set uPw = ?, uEmail = ? where uId = ?";
    private static final String MEMBER_DELETE = "delete member where uId = ?";
    private static final String MEMBER_DELETE_ALL = "delete member";

    public MemberDAO () {

        if (connectionPoolMgr == null) {
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }

//    public static MemberDAO getInstance() {
//        if (memberDAO == null) {
//            memberDAO = new MemberDAO();
//        }
//        return memberDAO;
//    }

    @Override
    public List<Member> search(String q) { // 이름이나 이메일로 검색
        List<Member> memberList = new LinkedList<>();
        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SEARCH);
            stmt.setString(1, "%" + q + "%");
            stmt.setString(2, "%" + q + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {
                String mId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");

                memberList.add(new Member(mId, uPw, uEmail));
            }
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt, rs);
        }

        return memberList;
    }

    @Override
    public Member select(String uId) {
        Member member = null;
        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, uId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String mId = rs.getString("uId");
                String mPw = rs.getString("uPw");
                String mEmail = rs.getString("uEmail");
                member = new Member(mId, mPw, mEmail);
            }
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt, rs);
        }
        return member;
    }

    @Override
    public List<Member> selectAll() {
        List<Member> memberList = new LinkedList<>();
        try {
            conn = ConnectionPoolMgr.getInstance().getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String uId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");

                memberList.add(new Member(uId, uPw, uEmail));
            }
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt, rs);
        }
        return memberList;
    }

    @Override
    public int insert(Member member) {
        int res = 0;
        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1, member.getuId());
            stmt.setString(2, member.getuPw());
            stmt.setString(3, member.getuEmail());
            res = stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt);
        }
        return res;
    }

    @Override
    public int insertAll(List<Member> members) {
        return members.stream().map(m -> insert(m)).collect(Collectors.toList()).stream().reduce((x, y) -> x + y).orElse(0);
    }

//    @Override
//    public int update(Member member) {
//        int res = 0;
//        try {
//            conn = connectionPoolMgr.getConnection();
//            stmt = conn.prepareStatement(MEMBER_PASSWORD_UPDATE);
//            stmt.setString(1, member.getuPw());
//            stmt.setString(2, member.getuId());
//            res = stmt.executeUpdate();
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connectionPoolMgr.freeConnection(conn, stmt);
//
//        }
//        return res;
//    }

    @Override
    public int update(Member member) {
        int res = 0;
        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_PASSWORD_EMAIL_UPDATE);
            stmt.setString(1, member.getuPw());
            stmt.setString(2, member.getuEmail());
            stmt.setString(3, member.getuId());
            res = stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt);

        }
        return res;
    }


    @Override
    public int delete(String uId) {
        int res = 0;
        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt);

        }
        return res;
    }

    @Override
    public int deleteAll() {
        int res = 0;
        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE_ALL);
            res = stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPoolMgr.freeConnection(conn, stmt);

        }
        return res;
    }

}

