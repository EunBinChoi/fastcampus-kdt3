package org.example.overview.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.vo.MessageVO;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


@Interceptor
public class LocaleInterceptor implements HandlerInterceptor {


    private Logger logger = LogManager.getLogger(LocaleInterceptor.class);

    private LocaleResolver localeResolver;
    private MessageSource messageSource;

    private CookieMgr cookieMgr;

    @Lazy // 다른 참조되는 빈에 의해 사용되거나 실제 참조될 때 로드됨 (vs 즉시로딩: 빈 팩토리가 초기화될 때 싱글톤 형태로 즉시로딩)
    @Autowired
    public LocaleInterceptor(LocaleResolver localeResolver, MessageSource messageSource, CookieMgr cookieMgr) {
        this.localeResolver = localeResolver;
        this.messageSource = messageSource;
        this.cookieMgr = cookieMgr;
    }

    /* 컨트롤러로 request 객체가 들어가기 전에 수행됨 */
    /* 반환값이 true -> 컨트롤러 호출 O */
    /* 반환값이 false -> 컨트롤러 호출 X */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!UtilsMethod.isNullOrEmpty(request.getParameter("lang"))) {
            String lang = request.getParameter("lang");

            Locale locale = new Locale(lang);
            localeResolver.setLocale(request, response, locale); // ko, en, ja

            cookieMgr.set(request, response, "lang", locale.toString());
        }

        return true;
    }

    /* 컨트롤러 실행 후, 뷰 실행 전에 수행됨 */
    /* 뷰 단에 전달해야하는 값을 수정하거나 추가해야할 경우에 사용 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Locale locale = localeResolver.resolveLocale(request);

        MessageVO messageVO = MessageVO.builder()
                .INDEX_MESSAGE(messageSource.getMessage("index.message", null, locale))
                .INDEX_MESSAGE_WITH_USERID(messageSource.getMessage("index.message.with.userID",
                        new String[] {(String) request.getSession().getAttribute("SESSION_ID")}, locale))
                .INDEX_TIME(messageSource.getMessage("index.time", null, locale))
                .INDEX_MENU_HOME(messageSource.getMessage("index.menu.home", null, locale))
                .INDEX_MENU_SEARCH(messageSource.getMessage("index.menu.search", null, locale))
                .INDEX_MENU_SURVEY(messageSource.getMessage("index.menu.survey", null, locale))
                .PRIVATE_MENU_UPDATE(messageSource.getMessage("private.menu.update", null, locale))
                .PRIVATE_MENU_WITHDRAW(messageSource.getMessage("private.menu.withdraw", null, locale))
                .PRIVATE_MENU_COOKIE(messageSource.getMessage("private.menu.cookie", null, locale)).build();

        System.out.println("messageVO = " + messageVO);
        //modelAndView.addObject("message", messageVO);

    }

    /* 뷰에 response 객체가 전달된 후에 실행됨 */
    /* 로그 찍을 때 사용 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("Current Locale " + localeResolver.resolveLocale(request));

    }
}
