package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Survey;

import java.math.BigInteger;
import java.util.List;

public interface IMemberDAO {

    List<Member> searchMember(String q);
    Member selectMember(String uId);
    List<Member> selectMembers();

    List<Member> selectWithSurveys();

    Member selectWithSurvey(String uId);

    BigInteger selectSurveyIdWithUserId(String uId);

    Survey selectSurvey(BigInteger sId);

    List<Survey> selectSurveys();

    int insertMember(Member member);

    int insertSurvey(String uId, Survey survey);

    int updateMemberSurveyId(String uId, BigInteger sId);
    int updateMemberPassword(String uId, String uPw);

    int updateMemberEmail(String uId, String uEmail);

    int updateSurveySeason(BigInteger sId, String season);

    int updateSurveyFruit(BigInteger sId, String fruit);

    int deleteSurvey(BigInteger sId);

    int deleteMember(String uId);
    int deleteMembers();

    int deleteSurveys();
}
