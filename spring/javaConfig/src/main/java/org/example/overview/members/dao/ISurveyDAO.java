package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Survey;

import java.util.List;

public interface ISurveyDAO {
    Survey select(String uId);
    List<Survey> selectAll();
    int insert(Survey survey);
    int insertAll(List<Survey> surveys);
    int updateSeason(String uId, String season);
    int updateFruit(String uId, String fruit);
    int delete(String uId);
    int deleteAll();
}
