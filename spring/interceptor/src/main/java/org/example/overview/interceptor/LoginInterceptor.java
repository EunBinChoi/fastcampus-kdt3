package org.example.overview.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그인한 사용자에 대해 세션에 사용자 정보 저장하는 클래스
 * */

@Interceptor
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LogManager.getLogger(LoginInterceptor.class);

    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;

    private MemberService memberService;


    @Lazy // 다른 참조되는 빈에 의해 사용되거나 실제 참조될 때 로드됨 (vs 즉시로딩: 빈 팩토리가 초기화될 때 싱글톤 형태로 즉시로딩)
    @Autowired
    public LoginInterceptor(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    /* 컨트롤러로 request 객체가 들어가기 전에 수행됨 */
    /* 반환값이 true -> 컨트롤러 호출 O */
    /* 반환값이 false -> 컨트롤러 호출 X */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");
        String cookieId = cookieMgr.get(request, "COOKIE_ID");

        System.out.println("autoLogin = " + autoLogin);
        System.out.println("cookieId = " + cookieId);

        if (autoLogin != null && cookieId != null) {
            if (memberService.autoLogin(autoLogin, cookieId)) {
                sessionMgr.create(session, cookieId);

                response.sendRedirect("/");
                return false;
            }
        }

        return true;
    }

    /* 컨트롤러 실행 후, 뷰 실행 전에 수행됨 */
    /* 뷰 단에 전달해야하는 값을 수정하거나 추가해야할 경우에 사용 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        String uId = request.getParameter("uId");
        String save = request.getParameter("save");

        System.out.println("uId = " + uId);
        System.out.println("save = " + save);

        // 로그인 성공시 세션에 로그인 아이디 정보 저장하고 초기 화면으로 이동
        if (uId != null) {
            sessionMgr.create(session, uId);
            saveCookieForAutoLogin(uId, save, response);
        }

    }

    /* 뷰에 response 객체가 전달된 후에 실행됨 */
    /* 로그 찍을 때 사용 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpSession session = request.getSession();
        logger.info("ID : " + sessionMgr.get(session) + " Login Success!");
    }

    private void saveCookieForAutoLogin(String uId, String save, HttpServletResponse response) {
        if (save == null) return;

        if (save.equals("on")) {
            cookieMgr.create(response, new String[] {uId, "true"});
        }
    }
}
