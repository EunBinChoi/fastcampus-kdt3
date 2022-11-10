package org.example.overview.members.dao;


import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Survey;
import org.example.overview.members.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class MemberDAO implements IMemberDAO {
    private MemberMapper memberMapper;

    @Autowired
    public MemberDAO(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<Member> searchMember(String q) {
        return memberMapper.searchMember(q);
    }

    @Override
    public Member selectMember(String uId) {
        return memberMapper.selectMember(uId);
    }

    @Override
    public List<Member> selectMembers() {
        return memberMapper.selectMembers();
    }

    @Override
    public List<Member> selectWithSurveys() {
        return memberMapper.selectWithSurveys();
    }

    @Override
    public Member selectWithSurvey(String uId) {
        return memberMapper.selectWithSurvey(uId);
    }

    @Override
    public BigInteger selectSurveyIdWithUserId(String uId) {
        return memberMapper.selectSurveyIdWithUserId(uId);
    }

    @Override
    public Survey selectSurvey(BigInteger sId) {
        return memberMapper.selectSurvey(sId);
    }

    @Override
    public List<Survey> selectSurveys() {
        return memberMapper.selectSurveys();
    }


    @Override
    public int insertMember(Member member) {
        return memberMapper.insertMember(member);
    }

    @Override
    public int insertSurvey(String uId, Survey survey) { // 서베이 결과 삽입
        Member member = memberMapper.selectMember(uId);
        if (member == null) return 0;

        int res = memberMapper.insertSurvey(survey); // 서베이 결과를 삽입

        System.out.println("survey = " + survey);
        // survey_id가 INCREMENT 되는 열이고 AUTO INCREMENT 된 결과를 sId에 반환하기 위해 setter 호출

        if (res > 0) return memberMapper.updateMemberSurveyId(uId, survey.getsId()); // 정상적으로 삽입되면 유저에 연결
        return 0;
    }

    @Override
    public int updateMemberSurveyId(String uId, BigInteger sId) {
        return memberMapper.updateMemberSurveyId(uId, sId);
    }

    @Override
    public int updateMemberPassword(String uId, String uPw) {
        return memberMapper.updateMemberPassword(uId, uPw);
    }

    @Override
    public int updateMemberEmail(String uId, String uEmail) {
        return memberMapper.updateMemberEmail(uId, uEmail);
    }

    @Override
    public int updateSurveySeason(BigInteger sId, String season) {
        return memberMapper.updateSurveySeason(sId, season);
    }

    @Override
    public int updateSurveyFruit(BigInteger sId, String fruit) {
        return memberMapper.updateSurveyFruit(sId, fruit);
    }

    @Override
    public int deleteSurvey(BigInteger sId) { // 서베이 내역 삭제
        String uId = memberMapper.selectUserIdWithSurveyId(sId); // 서베이와 연결된 유저 이름을 검색
        memberMapper.updateMemberSurveyId(uId, null); // 해당 유저의 서베이 값을 널로 수정
        return memberMapper.deleteSurvey(sId); // 서베이 내역 삭제
    }

    @Override
    public int deleteMember(String uId) {
        Member member = memberMapper.selectWithSurvey(uId);

        System.out.println(member);

        int res = memberMapper.deleteMember(uId);
        if (res == 0) return 0;

        if (member != null && member.getSurveyResult() != null) {
            memberMapper.deleteSurvey(member.getSurveyResult().getsId());
        }
        return res;
    }

    @Override
    public int deleteMembers() {
        int res = memberMapper.selectMembers().stream()
                .map(m -> deleteMember(m.getuId()))
                .reduce((x, y) -> x + y)
                .orElse(0);

        return res;
    }

    @Override
    public int deleteSurveys() {

        return memberMapper.selectSurveys().stream()
                .map(s -> deleteSurvey(s.getsId()))
                .reduce((x, y) -> x + y).orElse(0);


    }
}

