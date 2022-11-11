package org.example.overview.interceptor;

import net.sf.cglib.core.Local;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.overview.members.vo.MessageVO;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;


@Component
public class LocaleInterceptor implements HandlerInterceptor {

    private Logger logger = LogManager.getLogger(LocaleInterceptor.class);

    private Locale locale;
    private LocaleResolver localeResolver;
    private MessageSource messageSource;


    @Autowired
    public LocaleInterceptor(LocaleResolver localeResolver, MessageSource messageSource) {
        this.localeResolver = localeResolver;
        this.messageSource = messageSource;
    }

    /* 컨트롤러로 request 객체가 들어가기 전에 수행됨 */
    /* 반환값이 true -> 컨트롤러 호출 O */
    /* 반환값이 false -> 컨트롤러 호출 X */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!UtilsMethod.isNullOrEmpty(request.getParameter("lang"))) {
            String lang = request.getParameter("lang");

            if (!UtilsMethod.isNullOrEmpty(lang)) {
                locale = new Locale(lang);
                localeResolver.setLocale(request, response, locale); // ko, en, ja
                return true;
            }
        }

        locale = Locale.US;
        localeResolver.setLocale(request, response, locale); // 디폴트 값

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /* 컨트롤러 실행 후, 뷰 실행 전에 수행됨 */
    /* 뷰 단에 전달해야하는 값을 수정하거나 추가해야할 경우에 사용 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("locale = " + locale);
        MessageVO messageVO = MessageVO.builder()
                .INDEX_MESSAGE(messageSource.getMessage("index.message", null, locale))
                .INDEX_MESSAGE_WITH_USERID(messageSource.getMessage("index.message.with.userID", new String[] {(String) request.getSession().getAttribute("SESSION_ID")}, locale))
                .INDEX_TIME(messageSource.getMessage("index.time", null, locale))
                .INDEX_MENU_HOME(messageSource.getMessage("index.menu.home", null, locale))
                .INDEX_MENU_SEARCH(messageSource.getMessage("index.menu.search", null, locale))
                .INDEX_MENU_SURVEY(messageSource.getMessage("index.menu.survey", null, locale))
                .PRIVATE_MENU_UPDATE(messageSource.getMessage("private.menu.update", null, locale))
                .PRIVATE_MENU_WITHDRAW(messageSource.getMessage("private.menu.withdraw", null, locale))
                .PRIVATE_MENU_COOKIE(messageSource.getMessage("private.menu.cookie", null, locale)).build();

        modelAndView.addObject("message", messageVO);

        System.out.println("messageVO = " + messageVO);

    }

    /* 뷰에 response 객체가 전달된 후에 실행됨 */
    /* 로그 찍을 때 사용 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("Current Locale " + locale);

    }
}
