package org.example.overview.interceptor;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그인한 사용자에 대해 세션에 사용자 정보 저장하는 클래스
 * */
public class LoginInterceptor implements HandlerInterceptor {
    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;

    private MemberService memberService;

    public LoginInterceptor() {
    }

    @Autowired
    public void setSessionMgr(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @Autowired
    public void setCookieMgr(CookieMgr cookieMgr) {
        this.cookieMgr = cookieMgr;
    }

    @Autowired
    public void setMemberService(MemberService memberService) {
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

        // 로그인 성공시 세션에 로그인 아이디 정보 저장하고 초기 화면으로 이동
        if (uId != null) {
            sessionMgr.create(session, uId);
            saveCookieForAutoLogin(uId, save, response);

            response.sendRedirect("/");
        }

    }

    /* 뷰에 response 객체가 전달된 후에 실행됨 */
    /* 로그 찍을 때 사용 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private void saveCookieForAutoLogin(String uId, String save, HttpServletResponse response) {
        if (save == null) return;

        if (save.equals("on")) {
            cookieMgr.create(response, new String[] {uId, "true"});
        }
    }
}
