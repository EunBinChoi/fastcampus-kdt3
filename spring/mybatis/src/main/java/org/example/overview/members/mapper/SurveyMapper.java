package org.example.overview.members.mapper;

import org.apache.ibatis.annotations.*;
import org.example.overview.members.entity.Survey;

import java.util.List;

@Mapper
public interface SurveyMapper {
    @ResultType(Survey.class)
    @Select("select * from survey where uId = #{uId}")
    Survey select(@Param("uId") String uId);

    @ResultType(List.class)
    @Select("select * from survey")
    List<Survey> selectAll();

    @ResultType(Integer.class)
    @Insert("insert into survey values(#{survey.uId}, #{survey.season}, #{survey.fruit})")
    int insert(@Param("survey") Survey survey);

    @ResultType(Integer.class)
    @Update("update survey set season = #{season} where uId = #{uId}")
    int updateSeason(@Param("uId") String uId, @Param("season") String season);

    @ResultType(Integer.class)
    @Update("update survey set fruit = #{fruit} where uId = #{uId}")
    int updateFruit(@Param("uId") String uId, @Param("fruit") String fruit);

    @ResultType(Integer.class)
    @Delete("delete survey where uId = #{uId}")
    int delete(@Param("uId") String uId);

    @ResultType(Integer.class)
    @Delete("delete survey")
    int deleteAll();
}
