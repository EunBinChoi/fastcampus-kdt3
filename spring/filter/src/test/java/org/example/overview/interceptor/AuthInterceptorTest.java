package org.example.overview.interceptor;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;
import org.example.overview.sessions.SessionMgr;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class AuthInterceptorTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SessionMgr sessionMgr;

    @Autowired
    private MemberDAO memberDAO;

    private MockMvc mockMvc; // request 수행해주는 mock 객체


    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        // test 하기 위한 MockMvc 객체 생성. 스프링이 로드한 WebApplicationContext 인스턴스로 작동.

    }

    @Before
    @Transactional
    public void 테스트_위한_객체_생성() {
        Member member = Member.builder()
                .uId("test")
                .uPw(Password.of("test1234").getuPw())
                .uEmail("test@gmail.com")
                .build();
        memberDAO.insertMember(member);
    }

    @After
    @Transactional
    public void 테스트_위한_객체_소멸() {
        memberDAO.deleteMember("test");
    }


    @Test
    @Transactional
    @DisplayName("인가 인터셉터 허용 테스트")
    public void 인가_인터셉터_허용_테스트() throws Exception {
        MockHttpSession session = new MockHttpSession();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .session(session)
                        .param("uId", "test")
                        .param("uPw", "test1234"))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getRequest().getSession().getAttribute("SESSION_ID")).isEqualTo("test"))
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));


        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/members/test")
                        .session(session))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));

    }

    @Test
    @Transactional
    @DisplayName("인가 인터셉터 실패 테스트")
    public void 인가_인터셉터_실패_테스트() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/members/test"))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));
    }

}
