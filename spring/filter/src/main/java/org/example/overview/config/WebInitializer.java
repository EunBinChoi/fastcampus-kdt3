package org.example.overview.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebInitializer implements WebApplicationInitializer  { // web.xml
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerApplicationContext(servletContext);
        registerSecurityFilter(servletContext);
        registerDispatcherServletContext(servletContext);
        registerCharacterEncodingFilter(servletContext);
        registerSecurityFilter(servletContext);
    }

    private void registerApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext appConfig = new AnnotationConfigWebApplicationContext();
        appConfig.register(WebAppConfig.class);

        servletContext.setInitParameter("contextConfigLocation", WebAppConfig.class.getName());
        servletContext.addListener(new ContextLoaderListener(appConfig));
    }

    private void registerSecurityContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext securityConfig = new AnnotationConfigWebApplicationContext();
        securityConfig.register(SecurityConfig.class);

        servletContext.setInitParameter("contextConfigLocation", SecurityConfig.class.getName());
        servletContext.addListener(new ContextLoaderListener(securityConfig));
    }

    private void registerDispatcherServletContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext webapp = new AnnotationConfigWebApplicationContext();
        webapp.register(DispatcherServletConfig.class);


        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webapp));
        dispatcher.setInitParameter("contextConfigLocation", DispatcherServletConfig.class.getName());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }




    private void registerCharacterEncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, "/**");
    }

    private void registerSecurityFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("securityFilter", new DelegatingFilterProxy());
        securityFilter.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, "/**");
    }



}
