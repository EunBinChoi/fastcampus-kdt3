package org.example.overview.members.controller;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.controller.nonlogin.SignupController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJunit4ClassRunner.class는 spring-test에서 제공하는 단위테스르를 위한 클래스 러너
@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
public class SignupControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext; // MockMvc 객체 생성을 위한 context
    private MockMvc mockMvc; // controller에 request를 수행해주는 mock 객체

    @Autowired
    private SignupController signupController; // 테스트를 진행할 컨트롤러



    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(signupController).build();     // test를 위한 MockMvc 객체 생성. signupController 1개만 주입.
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();  // test를 위한 MockMvc 객체 생성. 스프링이 로드한 WebApplicationContext의 인스턴스로 작동.(standaloneSetup() 중 택 1)
    }

    @Test
    public void doSignupTest() throws Exception {
        mockMvc.perform(post("/members/signup")
                        .param("uEmail", "asd@gmail.com")
                        .param("uId", "abc")
                        .param("uPw", "a1234")
                        .session(new MockHttpSession()))
                        .andExpect(status().isOk())
                        .andDo(print());
    }
}
