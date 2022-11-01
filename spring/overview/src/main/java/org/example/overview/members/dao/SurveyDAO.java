package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Survey;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SurveyDAO implements ISurveyDAO {
    private static SurveyDAO surveyDAO  = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String SURVEY_SELECT_ALL = "select * from survey";
    private static final String SURVEY_SELECT = "select * from survey where uId = ?";
    private static final String SURVEY_INSERT = "insert into survey values(?, ?, ?)";
    private static final String SURVEY_SEASON_UPDATE = "update survey set season = ? where uId = ?";
    private static final String SURVEY_FRUIT_UPDATE = "update survey set fruit = ? where uId = ?";
    private static final String SURVEY_DELETE = "delete survey where uId = ?";
    private static final String SURVEY_DELETE_ALL = "delete survey";

    public static SurveyDAO getInstance() {
        if (surveyDAO == null) {
            surveyDAO = new SurveyDAO();
        }
        return surveyDAO;
    }

    @Override
    public Survey select(String uId) {
        Survey survey = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_SELECT);
            stmt.setString(1, uId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String mId = rs.getString("uId");
                String season = rs.getString("season");
                String fruit = rs.getString("fruit");
                survey = new Survey(mId, season, fruit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return survey;
    }

    @Override
    public List<Survey> selectAll() {
        List<Survey> surveyList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String uId = rs.getString("uId");
                String season = rs.getString("season");
                String fruit = rs.getString("fruit");

                surveyList.add(new Survey(uId, season, fruit));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return surveyList;
    }

    @Override
    public int insert(Survey survey) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_INSERT);
            stmt.setString(1, survey.getuId());
            stmt.setString(2, survey.getSeason());
            stmt.setString(3, survey.getFruit());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int insertAll(List<Survey> surveys) {
        return surveys.stream().map(s -> surveyDAO.insert(s)).collect(Collectors.toList()).stream().reduce((x, y) -> x + y).orElse(0);
    }

    @Override
    public int updateSeason(String uId, String season) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_SEASON_UPDATE);
            stmt.setString(1, season);
            stmt.setString(2, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int updateFruit(String uId, String fruit) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_FRUIT_UPDATE);
            stmt.setString(1, fruit);
            stmt.setString(2, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int delete(String uId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_DELETE);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int deleteAll() {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SURVEY_DELETE_ALL);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
}
