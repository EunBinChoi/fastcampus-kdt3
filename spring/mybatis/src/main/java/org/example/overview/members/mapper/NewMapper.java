
package org.example.overview.members.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.overview.members.entity.NewMember;
import org.example.overview.members.entity.NewSurvey;
import org.example.overview.members.entity.Survey;

import java.math.BigInteger;
import java.util.List;

import static org.h2.message.Trace.JDBC;


@Mapper
public interface NewMapper {
    @Results(id = "newMemberMap", value = {
            @Result(property = "uId", column = "USER_ID"),
            @Result(property = "uPw", column = "USER_PW"),
            @Result(property = "uEmail", column = "USER_EMAIL")
    })
    @ResultType(List.class)
    @Select("select user_id, user_pw, user_email " +
            "from new_member " +
            "where user_id like concat('%', #{q}, '%') or user_email like concat('%', #{q}, '%')")
    List<NewMember> searchMember(@Param("q") String q);


    @ResultMap("newMemberMap")
    @ResultType(NewMember.class)
    @Select("select * from new_member where user_id = #{uId}")
    NewMember selectMember(@Param("uId") String uId);


    @Results(id = "newMemberSurveyMap", value = {
            @Result(property = "uId", column = "USER_ID"),
            @Result(property = "uPw", column = "USER_PW"),
            @Result(property = "uEmail", column = "USER_EMAIL"),
            @Result(property = "surveyResult", column = "SURVEY_ID", one = @One(select = "selectSurvey"))
    })
    @ResultType(List.class)
    @Select("select * from new_member as a left join new_survey as b on a.survey_id = b.survey_id")
    List<NewMember> selectWithSurveys();


    @Results(id = "newSurveyMap", value = {
            @Result(property = "sId", column = "SURVEY_ID"),
            @Result(property = "season", column = "SURVEY_SEASON"),
            @Result(property = "fruit", column = "SURVEY_FRUIT")
    })
    @ResultType(NewSurvey.class)
    @Select("select * from new_survey where survey_id = #{sId}")
    NewSurvey selectSurvey(@Param("sId") BigInteger sId);


    @ResultMap("newMemberSurveyMap")
    @ResultType(NewMember.class)
    @Select("select * from new_member as a left join new_survey as b on a.survey_id = b.survey_id " +
            "where user_id = #{uId}")
    NewMember selectWithSurvey(@Param("uId") String uId);


    @ResultType(Integer.class)
    @Select("select survey_id from new_member where user_id = #{uId}")
    BigInteger selectSurveyIdWithUserId(@Param("uId") String uId);

    @ResultType(String.class)
    @Select("select user_id from new_member where survey_id = #{sId}")
    String selectUserIdWithSurveyId(@Param("sId") BigInteger sId);



    @ResultMap("newSurveyMap")
    @ResultType(List.class)
    @Select("select * from new_survey")
    List<NewSurvey> selectSurveys();


    @ResultMap("newMemberMap")
    @ResultType(List.class)
    @Select("select * from new_member")
    List<NewMember> selectMembers();


    @ResultType(Integer.class)
    @Insert("insert into new_member(user_id, user_pw, user_email) values(#{newMember.uId}, #{newMember.uPw}, #{newMember.uEmail})")
    int insertMember(@Param("newMember") NewMember newMember);

    @ResultType(Integer.class)
    @Insert("insert into new_survey(survey_season, survey_fruit) values(#{survey.season}, #{survey.fruit})")
    @Options(useGeneratedKeys = true, keyColumn = "survey_id", keyProperty = "sId")
    // insert sId (AUTO INCREMENT)
    // insert season, fruit
    // survey.setsId(survey_id) // 문제점! (survey entity @Setter 없음......)
    int insertSurvey(@Param("survey") NewSurvey survey); // ("spring", "melon") => (5, "spring", "melon")

    @ResultType(Integer.class)
    @Update("update new_member set survey_id = #{sId} where user_id = #{uId}")
    int updateMemberSurveyId(@Param("uId") String uId, @Param("sId") BigInteger sId);

    @ResultType(Integer.class)
    @Update("update new_member set user_pw = #{uPw} where user_id = #{uId}")
    int updateMemberPassword(@Param("uId") String uId, @Param("uPw") String uPw);


    @ResultType(Integer.class)
    @Update("update new_member set user_email = #{uEmail} where user_id = #{uId}")
    int updateMemberEmail(@Param("uId") String uId, @Param("uEmail") String uEmail);

    @ResultType(Integer.class)
    @Update("update new_survey set survey_season = #{season} where survey_id = #{sId}")
    int updateSurveySeason(@Param("sId") BigInteger sId, @Param("season") String season);

    @ResultType(Integer.class)
    @Update("update new_survey set survey_fruit = #{fruit} where survey_id = #{sId}")
    int updateSurveyFruit(@Param("sId") BigInteger sId, @Param("fruit") String fruit);

    @ResultType(Integer.class)
    @Delete("delete new_survey where survey_id = #{sId}")
    int deleteSurvey(@Param("sId") BigInteger sId);


    @ResultType(Integer.class)
    @Delete("delete new_member where user_id = #{uId}")
    int deleteMember(@Param("uId") String uId);

    @ResultType(Integer.class)
    @Delete("delete new_member")
    int deleteMembers();

    @ResultType(Integer.class)
    @Delete("delete new_survey")
    int deleteSurveys();
}
