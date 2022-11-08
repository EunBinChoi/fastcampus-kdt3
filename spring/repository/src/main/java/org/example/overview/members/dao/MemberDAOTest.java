package org.example.overview.members.dao;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJunit4ClassRunner.class는 spring-test에서 제공하는 단위테스트를 위한 클래스 러너
@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;


    @Test
    @DisplayName("데이터베이스 데이터 삽입")
    public void addMembers() {
        int res = memberDAO.deleteAll();
        //if (res == 0) return;

        for (int i = 'a'; i <= 'z'; i++) {
            memberDAO.insert(new Member(Character.toString(i), Password.of(Character.toString(i) + "1234", true).getuPw(), Character.toString(i) + "@gmail.com"));
        }

        memberDAO.selectAll().stream().forEach(m -> System.out.println(m));
    }


}
