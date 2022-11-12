package org.example.overview.config;

import org.example.overview.interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.overview",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Interceptor.class, Controller.class})}
)
public class DispatcherServletConfig implements WebMvcConfigurer {

    private AuthInterceptor authInterceptor;
    private LocaleInterceptor localeInterceptor;
    private LoginInterceptor loginInterceptor;
    private NoneAuthInterceptor noneAuthInterceptor;

//    @Lazy
    @Autowired
    public DispatcherServletConfig(AuthInterceptor authInterceptor, LocaleInterceptor localeInterceptor, LoginInterceptor loginInterceptor, NoneAuthInterceptor noneAuthInterceptor) {
        this.authInterceptor = authInterceptor;
        this.localeInterceptor = localeInterceptor;
        this.loginInterceptor = loginInterceptor;
        this.noneAuthInterceptor = noneAuthInterceptor;
    }

    /* 인터셉터 등록 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor)
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**");

        registry.addInterceptor(authInterceptor)
                .order(2)
                .addPathPatterns("/members/**");

        registry.addInterceptor(noneAuthInterceptor)
                .order(3)
                .addPathPatterns("/login/**", "/signup/**");


        registry.addInterceptor(loginInterceptor)
                .order(4)
                .addPathPatterns("/login/**");
//

    }


    /**
     * 변경된 언어 정보를 기억할 locale 리졸버 등록
     * */
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new AcceptHeaderLocaleResolver();
//    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        return sessionLocaleResolver;
//    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieName("lang");
        cookieLocaleResolver.setCookieMaxAge(-1);
        cookieLocaleResolver.setCookiePath("/**");

        return cookieLocaleResolver;
    }

//    @Bean
//    public LocaleResolver localeResolver() {
//        FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
//        fixedLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        return fixedLocaleResolver;
//    }



    /** @Valid 사용을 위함 */
    @Bean
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }


    /** Message Converter 등록 */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(createXmlHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        WebMvcConfigurer.super.extendMessageConverters(converters);
    }

    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);

        return xmlConverter;
    }


    /** View Resolver */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    /** Resource Handler */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }



}
