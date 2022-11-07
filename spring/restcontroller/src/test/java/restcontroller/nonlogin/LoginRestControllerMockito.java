package restcontroller.nonlogin;

import org.example.overview.config.DispatcherServletConfig;
import org.example.overview.config.WebAppConfig;
import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Member;
import org.example.overview.members.restcontroller.nonlogin.LoginRestController;
import org.example.overview.members.service.MemberService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class) // JUnit4에서 Mockito를 활용하기 위한 어노테이션
//@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
//@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class LoginRestControllerMockito {

//    @Autowired
//    private WebApplicationContext webApplicationContext;


    @InjectMocks
    private LoginRestController loginRestController;

    @Mock
    private MemberService memberService;


    private MockMvc mockMvc; // request 수행해주는 mock 객체


    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(loginRestController).build();


//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        // test 하기 위한 MockMvc 객체 생성. 스프링이 로드한 WebApplicationContext 인스턴스로 작동.

    }



    @DisplayName("로그인 테스트")
    @Test
    public void 로그인_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("uId", "a")
                        .param("uPw", "a12345"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

}