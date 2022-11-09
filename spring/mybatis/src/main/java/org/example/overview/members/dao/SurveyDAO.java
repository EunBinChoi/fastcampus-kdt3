package org.example.overview.members.dao;

import org.example.overview.members.entity.Survey;
import org.example.overview.members.mapper.SurveyMapper;
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

    private SurveyMapper surveyMapper;


    @Autowired
    public SurveyDAO(SurveyMapper surveyMapper) {
        this.surveyMapper = surveyMapper;
    }


    @Override
    public Survey select(String uId) { // PK를 통한 SELECT
        return surveyMapper.select(uId);
    }

    @Override
    public List<Survey> selectAll() {
        return surveyMapper.selectAll();
    }

    @Override
    public int insert(Survey survey) {
        return surveyMapper.insert(survey);
    }


    @Override
    public int updateSeason(String uId, String season) {
        return surveyMapper.updateSeason(uId, season);

    }

    @Override
    public int updateFruit(String uId, String fruit) {
        return surveyMapper.updateFruit(uId, fruit);
    }

    @Override
    public int delete(String uId) {
        return surveyMapper.delete(uId);
    }

    @Override
    public int deleteAll() {
        return surveyMapper.deleteAll();
    }
}
