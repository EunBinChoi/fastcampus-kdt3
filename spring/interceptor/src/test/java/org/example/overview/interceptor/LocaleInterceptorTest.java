package org.example.overview.interceptor;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.Locale;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class LocaleInterceptorTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private LocaleResolver localeResolver;

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
    @DisplayName("로케일 인터셉터 테스트")
    public void 로케일_인터셉터_테스트() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));

        Assertions.assertEquals(localeResolver.resolveLocale(mvcResult.getRequest()), new Locale("en"));
    }

    @Test
    @Transactional
    @DisplayName("로케일 인터셉터 한국어 테스트")
    public void 로케일_인터셉터_한국어_테스트() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("lang", "ko"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));

        Assertions.assertEquals(localeResolver.resolveLocale(mvcResult.getRequest()), new Locale("ko"));
    }

    @Test
    @Transactional
    @DisplayName("로케일 인터셉터 일본어 테스트")
    public void 로케일_인터셉터_일본어_테스트() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("lang", "ja"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));

        Assertions.assertEquals(localeResolver.resolveLocale(mvcResult.getRequest()), new Locale("ja"));
    }

    @Test
    @Transactional
    @DisplayName("로케일 인터셉터 영어 테스트")
    public void 로케일_인터셉터_영어_테스트() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("lang", "en"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Arrays.stream(mvcResult.getInterceptors()).forEach(i -> System.out.println(i));

        Assertions.assertEquals(localeResolver.resolveLocale(mvcResult.getRequest()), new Locale("en"));
    }


}
