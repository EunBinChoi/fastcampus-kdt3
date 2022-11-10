package org.example.overview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
//@PropertySources(@PropertySource("classpath:/messages/messages.properties"))
public class LocaleConfig {

    /**
     * 변경된 언어 정보를 기억할 locale 리졸버 등록
     * */
//    @Bean(name = "localeResolver")
//    public AcceptHeaderLocaleResolver localeResolver() {
//        return new AcceptHeaderLocaleResolver();
//    }
//
//    @Bean(name = "localeResolver")
//    public SessionLocaleResolver localeResolver() {
//
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        return sessionLocaleResolver;
//    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieName("lang");
        cookieLocaleResolver.setCookieMaxAge(-1);
        cookieLocaleResolver.setCookiePath("/");

        return cookieLocaleResolver;
    }
//
//    @Bean(name = "localeResolver")
//    public FixedLocaleResolver localeResolver() {
//        FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
//        fixedLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        return fixedLocaleResolver;
//    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        /*
         * ResourceBundleMessageSource: 서버를 배포할 때 messageSource 파일을 읽음
         * ReloadableResourceBundleMessageSource: 서버 재배포 없이도 리로딩할 시간을 지정해서 해당 시간마다 messageSource 파일을 다시 읽기 위함
         * */


        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages/messages"); // 메세지 properties 위치와 이름을 지정함 (기본 확장자 *.properties)
        /*
         * 만약 Locale 값이 있으면 messageSource_언어코드_국가코드.properties
         *                없으면 messageSource.properties
         * */

        messageSource.setDefaultEncoding("UTF-8"); // 기본 인코딩을 지정함
        messageSource.setCacheSeconds(1); // 리소스를 1초 간격으로 다시 리로드

        return messageSource;
    }

}
