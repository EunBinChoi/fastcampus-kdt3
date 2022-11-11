package org.example.overview.config;

import org.example.overview.interceptor.AuthInterceptor;
import org.example.overview.interceptor.LocaleInterceptor;
import org.example.overview.interceptor.LoginInterceptor;
import org.example.overview.interceptor.NoneAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Locale;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableWebMvc
@ComponentScan(basePackages = "org.example.overview",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})}
)
public class DispatcherServletConfig implements WebMvcConfigurer {


    LocaleInterceptor localeInterceptor;


    AuthInterceptor authInterceptor;

    NoneAuthInterceptor noneAuthInterceptor;

    LoginInterceptor loginInterceptor;


    @Autowired
    public DispatcherServletConfig(LocaleInterceptor localeInterceptor, AuthInterceptor authInterceptor, NoneAuthInterceptor noneAuthInterceptor, LoginInterceptor loginInterceptor) {
        this.localeInterceptor = localeInterceptor;
        this.authInterceptor = authInterceptor;
        this.noneAuthInterceptor = noneAuthInterceptor;
        this.loginInterceptor = loginInterceptor;
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


        WebMvcConfigurer.super.addInterceptors(registry);
    }



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
