package org.example.overview.config;

import org.example.overview.filter.GlobalFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebInitializer implements WebApplicationInitializer  { // web.xml
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerApplicationContext(servletContext);
        registerDispatcherServletContext(servletContext);
        registerCharacterEncodingFilter(servletContext);
        registerGlobalFilter(servletContext);
    }

    private void registerApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext appConfig = new AnnotationConfigWebApplicationContext();
        appConfig.register(WebAppConfig.class);

        servletContext.setInitParameter("contextConfigLocation", WebAppConfig.class.getName());
        servletContext.addListener(new ContextLoaderListener(appConfig));
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
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    private void registerGlobalFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic globalFilter = servletContext.addFilter("globalFilter", GlobalFilter.class);
        globalFilter.setInitParameter("param", "Filter Param");
        globalFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

}
