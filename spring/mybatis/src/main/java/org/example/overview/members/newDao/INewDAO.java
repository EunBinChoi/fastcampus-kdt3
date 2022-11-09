package org.example.overview.members.newDao;

import org.example.overview.members.entity.NewMember;
import org.example.overview.members.entity.NewSurvey;

import java.math.BigInteger;
import java.util.List;

public interface INewDAO {

    List<NewMember> searchMember(String q);
    NewMember selectMember(String uId);
    List<NewMember> selectMembers();

    List<NewMember> selectWithSurveys();

    NewMember selectWithSurvey(String uId);

    BigInteger selectSurveyIdWithUserId(String uId);

    NewSurvey selectSurvey(BigInteger sId);

    List<NewSurvey> selectSurveys();

    int insertMember(NewMember member);

    int insertSurvey(String uId, NewSurvey survey);

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
