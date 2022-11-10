package org.example.overview.members.newDao;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Survey;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJunit4ClassRunner.class는 spring-test에서 제공하는 단위테스트를 위한 클래스 러너
@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class NewDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 검색 테스트")
    public void 뉴멤버_테이블_사용자_데이터_검색_테스트() {
        List<Member> newMemberList = memberDAO.searchMember("z");
        newMemberList.stream().forEach(m -> m.printWithoutSurveyResult());
    }

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 한명 조회 테스트")
    public void 뉴멤버_테이블_사용자_데이터_한명_조회_테스트() {
        Member newMember = memberDAO.selectMember("a");
        newMember.printWithoutSurveyResult();
    }

    @Test
    @DisplayName("뉴멤버 뉴서베이 조인 테이블 전체 조회 테스트")
    public void 뉴멤버_뉴서베이_조인_테이블_전체_조회_테스트() {
        List<Member> newMemberList = memberDAO.selectWithSurveys();
        newMemberList.stream().forEach(m -> m.printWithSurveyResult());
    }

    @Test
    @DisplayName("뉴멤버 뉴서베이 조인 테이블 한명 조회 테스트")
    public void 뉴멤버_뉴서베이_조인_테이블_한명_조회_테스트() {
        Member newMember = memberDAO.selectWithSurvey("a");
        System.out.println(newMember);
    }


    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 일괄 삽입 테스트")
    public void 뉴멤버_테이블_사용자_데이터_일괄_삽입_테스트() {
        memberDAO.deleteMembers();

        for (int i = 'a'; i <= 'z'; i++) {
            memberDAO.insertMember(new Member(Character.toString(i), Password.of(Character.toString(i) + "1234", true).getuPw(), Character.toString(i) + "@gmail.com"));
        }

        memberDAO.selectMembers().stream().forEach(m -> System.out.println(m));

    }


    @Test
    @DisplayName("뉴멤버 테이블 서베이 일괄 삽입 테스트")
    public void 뉴멤버_테이블_서베이_일괄_삽입_테스트() {
        memberDAO.deleteSurveys();

        String[] seasons = {"spring", "summer", "autumn", "winter"};
        String[] fruits = {"watermelon", "melon", "apple", "orange"};

        for (int i = 'a'; i <= 'e'; i++) {
            memberDAO.insertSurvey(Character.toString(i), new Survey(seasons[i % seasons.length], fruits[i % fruits.length]));
        }

    }


    @Test
    @DisplayName("뉴멤버 테이블 서베이 삽입 테스트")
    public void 뉴멤버_테이블_서베이_삽입_테스트() {
        Survey newSurvey = new Survey("spring", "watermelon");
        memberDAO.insertSurvey("b", newSurvey);

        System.out.println("newSurvey = " + newSurvey);
    }

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 수정 테스트")
    public void 뉴멤버_테이블_사용자_데이터_수정_테스트() {
        memberDAO.updateMemberPassword("a", "admin");
        memberDAO.updateMemberEmail("a", "asdads@gmail.com");

        memberDAO.selectMembers().stream().forEach(m -> System.out.println(m));
    }

    @Test
    @DisplayName("뉴멤버 테이블 서베이 수정 테스트")
    public void 뉴멤버_테이블_서베이_수정_테스트() {
        memberDAO.updateSurveySeason(BigInteger.ONE, "winter");
        memberDAO.updateSurveyFruit(BigInteger.ONE, "apple");

        Survey newSurvey = memberDAO.selectSurvey(BigInteger.ONE);
        System.out.println("newSurvey = " + newSurvey);

    }



    @Test
    @DisplayName("뉴멤버 테이블 서베이 한개 삭제 테스트")
    public void 뉴멤버_테이블_서베이_한개_삭제_테스트() {
        int res = memberDAO.deleteSurvey(BigInteger.valueOf(17));

        System.out.println("res = " + res);
        Survey newSurvey = memberDAO.selectSurvey(BigInteger.valueOf(17));
        System.out.println("newSurvey = " + newSurvey);

    }

    @Test
    @DisplayName("뉴멤버 테이블 서베이 전체 삭제 테스트")
    public void 뉴멤버_테이블_서베이_전체_삭제_테스트() {
        int res = memberDAO.deleteSurveys();
        System.out.println("res = " + res);
    }

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 한명 삭제 테스트")
    public void 뉴멤버_테이블_사용자_데이터_한명_삭제_테스트() {
        int res = memberDAO.deleteMember("b");
        System.out.println("res = " + res);
    }



    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 전체 삭제 테스트")
    public void 뉴멤버_테이블_사용자_데이터_전체_삭제_테스트() {
        int res = memberDAO.deleteMembers();
        System.out.println("res = " + res);
    }

}
