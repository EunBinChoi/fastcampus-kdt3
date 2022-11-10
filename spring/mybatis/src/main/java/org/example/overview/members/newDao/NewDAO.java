package org.example.overview.members.newDao;


import org.example.overview.members.entity.NewMember;
import org.example.overview.members.entity.NewSurvey;
import org.example.overview.members.mapper.NewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NewDAO implements INewDAO {
    private NewMapper newMapper;

    @Autowired
    public NewDAO(NewMapper newMapper) {
        this.newMapper = newMapper;
    }


    @Override
    public List<NewMember> searchMember(String q) {
        return newMapper.searchMember(q);
    }

    @Override
    public NewMember selectMember(String uId) {
        return newMapper.selectMember(uId);
    }

    @Override
    public List<NewMember> selectMembers() {
        return newMapper.selectMembers();
    }

    @Override
    public List<NewMember> selectWithSurveys() {
        return newMapper.selectWithSurveys();
    }

    @Override
    public NewMember selectWithSurvey(String uId) {
        return newMapper.selectWithSurvey(uId);
    }

    @Override
    public BigInteger selectSurveyIdWithUserId(String uId) {
        return newMapper.selectSurveyIdWithUserId(uId);
    }

    @Override
    public NewSurvey selectSurvey(BigInteger sId) {
        return newMapper.selectSurvey(sId);
    }

    @Override
    public List<NewSurvey> selectSurveys() {
        return newMapper.selectSurveys();
    }


    @Override
    public int insertMember(NewMember member) {
        return newMapper.insertMember(member);
    }

    @Override
    public int insertSurvey(String uId, NewSurvey survey) { // 서베이 결과 삽입
        NewMember member = newMapper.selectMember(uId);
        if (member == null) return 0;

        int res = newMapper.insertSurvey(survey); // 서베이 결과를 삽입

        System.out.println("survey = " + survey);
        // survey_id가 INCREMENT 되는 열이고 AUTO INCREMENT 된 결과를 sId에 반환하기 위해 setter 호출

        if (res > 0) return newMapper.updateMemberSurveyId(uId, survey.getsId()); // 정상적으로 삽입되면 유저에 연결
        return 0;
    }

    @Override
    public int updateMemberSurveyId(String uId, BigInteger sId) {
        return newMapper.updateMemberSurveyId(uId, sId);
    }

    @Override
    public int updateMemberPassword(String uId, String uPw) {
        return newMapper.updateMemberPassword(uId, uPw);
    }

    @Override
    public int updateMemberEmail(String uId, String uEmail) {
        return newMapper.updateMemberEmail(uId, uEmail);
    }

    @Override
    public int updateSurveySeason(BigInteger sId, String season) {
        return newMapper.updateSurveySeason(sId, season);
    }

    @Override
    public int updateSurveyFruit(BigInteger sId, String fruit) {
        return newMapper.updateSurveyFruit(sId, fruit);
    }

    @Override
    public int deleteSurvey(BigInteger sId) { // 서베이 내역 삭제
        String uId = newMapper.selectUserIdWithSurveyId(sId); // 서베이와 연결된 유저 이름을 검색
        if (uId != null) newMapper.updateMemberSurveyId(uId, null); // 해당 유저의 서베이 값을 널로 수정
        return newMapper.deleteSurvey(sId); // 서베이 내역 삭제
    }

    @Override
    public int deleteMember(String uId) { // 유저 삭제
        // 서베이 결과는 무조건 유저 아이디가 있어야지만 등록
        // 유저 삭제 -> 서베이 삭제
        NewMember member = newMapper.selectWithSurvey(uId);
        System.out.println(member);

        int res = newMapper.deleteMember(uId);
        if (res == 0) return 0;

        if (member != null && member.getSurveyResult() != null) {
            newMapper.deleteSurvey(member.getSurveyResult().getsId());
        }

        // 서베이 삭제 -> 유저 삭제
        // 서베이의 sId를 유저 테이블에서 참조하고 있기 때문에 오류 (FK 제약조건)
//        BigInteger sId = newMapper.selectSurveyIdWithUserId(uId);
//        int res = newMapper.deleteSurvey(sId);
//        if (res > 0) return newMapper.deleteMember(uId);

        return res;
    }

    @Override
    public int deleteMembers() {

        // List<NewMember>
        return newMapper.selectMembers().stream()
                .map(m -> deleteMember(m.getuId()))
                .reduce((x, y) -> x + y)
                .orElse(0);
    }

    @Override
    public int deleteSurveys() {

        // List<NewSurvey>
        return newMapper.selectSurveys().stream()
                .map(s -> deleteSurvey(s.getsId()))
                .reduce((x, y) -> x + y)
                .orElse(0);

    }
}

