package org.example.overview.members.restcontroller.nonlogin;

import exception.InputInvalidException;
import org.example.overview.members.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(MockitoJUnitRunner.class) // JUnit4에서 Mockito를 활용하기 위한 어노테이션
//@ContextConfiguration(classes = {WebAppConfig.class, DispatcherServletConfig.class})
//@WebAppConfiguration // WebApplicationContext 생성할 수 있도록 하는 어노테이션
public class LoginRestControllerMockito {

    /*
     * transactionManager 를 빈으로 등록 (WebAppConfig)
     * - @Transactional 통해 transactionManager 빈을 실행시켜 @Test 환경에서 RollBack 시킴
     * - 스프링에서 자동적으로 이러한 Transaction 에 대해 정의되어있는 함수를
     * - TransactionTestExecutionListener 에서 탐색 후 탐색이 되면 이를 Rollback 시킴
     *
     * @Before (JUnit 4), @BeforeEach (JUnit 5)
     * @After (JUnit 4),  @AfterEach (JUnit 5)
     * - 메소드 단위의 라이프 사이클을 가지는 어노테이션
     * - @Test 와 동일한 Transactional 을 공유함
     *
     *
     * @BeforeClass (JUnit 4), @BeforeAll (JUnit 5)
     * @AfterClass (JUnit 4),  @AfterAll (JUnit 5)
     * - 클래스 단위의 라이프 사이클을 가지는 어노테이션
     * - @Test 와 동일한 Transactional 을 공유하지 않음
     * */

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



    @Test
    @Transactional
    @DisplayName("로그인 테스트")
    public void 로그인_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("uId", "a")
                        .param("uPw", "a12345"))
                .andExpect(result -> assertThat(result.getResolvedException().getClass())
                        .isAssignableFrom(InputInvalidException.class))
                .andDo(print());
    }

}