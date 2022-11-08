package org.example.overview.members.dao;

import org.example.overview.members.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SurveyDAO implements ISurveyDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SurveyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static final String SURVEY_SELECT_ALL = "select * from survey";
    private static final String SURVEY_SELECT = "select * from survey where uId = ?";
    private static final String SURVEY_INSERT = "insert into survey values(?, ?, ?)";
    private static final String SURVEY_SEASON_UPDATE = "update survey set season = ? where uId = ?";
    private static final String SURVEY_FRUIT_UPDATE = "update survey set fruit = ? where uId = ?";
    private static final String SURVEY_DELETE = "delete survey where uId = ?";
    private static final String SURVEY_DELETE_ALL = "delete survey";


    @Override
    public Survey select(String uId) { // PK를 통한 SELECT
        List<Survey> surveyList = jdbcTemplate.query(SURVEY_SELECT, (rs, rowNum) -> new Survey(
                rs.getString("uId"),
                rs.getString("season"),
                rs.getString("fruit")), uId);

        if (surveyList.isEmpty()) return null;
        return surveyList.get(0);
    }

    @Override
    public List<Survey> selectAll() {
        return jdbcTemplate.query(SURVEY_SELECT_ALL, (rs, rowNum) -> new Survey(
                rs.getString("uId"),
                rs.getString("season"),
                rs.getString("fruit")));
    }

    @Override
    public int insert(Survey survey) {
        return jdbcTemplate.update(SURVEY_INSERT,
                survey.getuId(),
                survey.getSeason(),
                survey.getFruit());
    }

    @Override
    public int insertAll(List<Survey> surveys) {
        return surveys.stream()
                .map(s -> insert(s))
                .collect(Collectors.toList()).stream()
                .reduce((x, y) -> x + y)
                .orElse(0);
    }

    @Override
    public int updateSeason(String uId, String season) {
        return jdbcTemplate.update(SURVEY_SEASON_UPDATE, season, uId);
    }

    @Override
    public int updateFruit(String uId, String fruit) {
        return jdbcTemplate.update(SURVEY_FRUIT_UPDATE, fruit, uId);
    }

    @Override
    public int delete(String uId) {
        return jdbcTemplate.update(SURVEY_DELETE, uId);
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update(SURVEY_DELETE_ALL);
    }
}
