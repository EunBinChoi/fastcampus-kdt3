package org.example.overview.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 사용자가 특정 경로를 임의로 작성하여 접근하는 경우 사용자가 로그인하지 않은 상태인지 확인하는 클래스
 * */

@Component
public class NoneAuthInterceptor implements HandlerInterceptor {

    private Logger logger = LogManager.getLogger(NoneAuthInterceptor.class);
    private SessionMgr sessionMgr;

    @Autowired
    public NoneAuthInterceptor(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (sessionMgr.get(session) != null) {

            // 로그인한 사용자일 경우 인덱스 페이지로 이동
            response.sendRedirect("/");
            return false;
        }

        // 로그인하지 않은 사용자일 경우 컨트롤러 호출
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpSession session = request.getSession();
        logger.info("ID : " + sessionMgr.get(session) + " Authorization Not Success!");

    }
}
