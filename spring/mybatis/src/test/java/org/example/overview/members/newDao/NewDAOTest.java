package org.example.overview.members.newDao;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.NewMember;
import org.example.overview.members.entity.NewSurvey;
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
    private NewDAO newDAO;

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 검색 테스트")
    public void 뉴멤버_테이블_사용자_데이터_검색_테스트() {
        List<NewMember> newMemberList = newDAO.searchMember("gmail");
        newMemberList.stream().forEach(m -> m.printWithoutSurveyResult());
    }

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 한명 조회 테스트")
    public void 뉴멤버_테이블_사용자_데이터_한명_조회_테스트() {
        NewMember newMember = newDAO.selectMember("a");
        if (newMember != null) newMember.printWithoutSurveyResult();
    }

    @Test
    @DisplayName("뉴멤버 뉴서베이 조인 테이블 전체 조회 테스트")
    public void 뉴멤버_뉴서베이_조인_테이블_전체_조회_테스트() {
        List<NewMember> newMemberList = newDAO.selectWithSurveys();
        newMemberList.stream().forEach(m -> m.printWithSurveyResult());
    }

    @Test
    @DisplayName("뉴멤버 뉴서베이 조인 테이블 한명 조회 테스트")
    public void 뉴멤버_뉴서베이_조인_테이블_한명_조회_테스트() {
        NewMember newMember = newDAO.selectWithSurvey("a");
        System.out.println(newMember);
    }


    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 일괄 삽입 테스트")
    public void 뉴멤버_테이블_사용자_데이터_일괄_삽입_테스트() {
        newDAO.deleteMembers();

        for (int i = 'a'; i <= 'z'; i++) {
            newDAO.insertMember(new NewMember(Character.toString(i),
                    Password.of(Character.toString(i) + "1234", true).getuPw(),
                    Character.toString(i) + "@gmail.com"));
        }

        newDAO.selectMembers().stream().forEach(m -> System.out.println(m));

    }


    @Test
    @DisplayName("뉴멤버 테이블 서베이 일괄 삽입 테스트")
    public void 뉴멤버_테이블_서베이_일괄_삽입_테스트() {
        newDAO.deleteSurveys();

        String[] seasons = {"spring", "summer", "autumn", "winter"};
        String[] fruits = {"watermelon", "melon", "apple", "orange"};

        for (int i = 'a'; i <= 'e'; i++) {
            newDAO.insertSurvey(Character.toString(i), new NewSurvey(seasons[i % seasons.length], fruits[i % fruits.length]));
        }

    }


    @Test
    @DisplayName("뉴멤버 테이블 서베이 삽입 테스트")
    public void 뉴멤버_테이블_서베이_삽입_테스트() {
        NewSurvey newSurvey = new NewSurvey("spring", "watermelon");
        newDAO.insertSurvey("x", newSurvey);

        System.out.println("newSurvey = " + newSurvey);
    }

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 수정 테스트")
    public void 뉴멤버_테이블_사용자_데이터_수정_테스트() {
        newDAO.updateMemberPassword("a", "admin");
        newDAO.updateMemberEmail("a", "asdads@gmail.com");

        newDAO.selectMembers().stream().forEach(m -> System.out.println(m));
    }

    @Test
    @DisplayName("뉴멤버 테이블 서베이 수정 테스트")
    public void 뉴멤버_테이블_서베이_수정_테스트() {
        newDAO.updateSurveySeason(BigInteger.valueOf(53), "winter");
        newDAO.updateSurveyFruit(BigInteger.valueOf(53), "apple");

        NewSurvey newSurvey = newDAO.selectSurvey(BigInteger.valueOf(53));
        System.out.println("newSurvey = " + newSurvey);

    }



    @Test
    @DisplayName("뉴멤버 테이블 서베이 한개 삭제 테스트")
    public void 뉴멤버_테이블_서베이_한개_삭제_테스트() {
        int res = newDAO.deleteSurvey(BigInteger.valueOf(53));

        System.out.println("res = " + res);
        NewSurvey newSurvey = newDAO.selectSurvey(BigInteger.valueOf(53));
        System.out.println("newSurvey = " + newSurvey);

    }

    @Test
    @DisplayName("뉴멤버 테이블 서베이 전체 삭제 테스트")
    public void 뉴멤버_테이블_서베이_전체_삭제_테스트() {
        int res = newDAO.deleteSurveys();
        System.out.println("res = " + res);
    }

    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 한명 삭제 테스트")
    public void 뉴멤버_테이블_사용자_데이터_한명_삭제_테스트() {
        int res = newDAO.deleteMember("b");
        System.out.println("res = " + res);
    }



    @Test
    @DisplayName("뉴멤버 테이블 사용자 데이터 전체 삭제 테스트")
    public void 뉴멤버_테이블_사용자_데이터_전체_삭제_테스트() {
        int res = newDAO.deleteMembers();
        System.out.println("res = " + res);
    }

}
