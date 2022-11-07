package org.example.overview.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LocaleInterceptor implements HandlerInterceptor {

    /* 컨트롤러로 request 객체가 들어가기 전에 수행됨 */
    /* 반환값이 true -> 컨트롤러 호출 O */
    /* 반환값이 false -> 컨트롤러 호출 X */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /* 컨트롤러 실행 후, 뷰 실행 전에 수행됨 */
    /* 뷰 단에 전달해야하는 값을 수정하거나 추가해야할 경우에 사용 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /* 뷰에 response 객체가 전달된 후에 실행됨 */
    /* 로그 찍을 때 사용 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
