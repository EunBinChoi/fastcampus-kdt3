package org.example.overview.config;

import org.example.overview.lifecycle.AnotherLifeCycle;
import org.example.overview.lifecycle.LifeCycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "org.example.overview",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Component.class, Repository.class, Service.class})}
)
public class WebAppConfig {
    // applicationContext.xml

    @Bean(name = "lifeCycle", initMethod = "initMethod", destroyMethod = "destroyMethod")
    public LifeCycle lifeCycle() {
        return new LifeCycle(anotherLifeCycle());
    }

    @Bean(name="anotherLifeCycle", initMethod = "anotherInitMethod", destroyMethod = "anotherDestroyMethod")
	public AnotherLifeCycle anotherLifeCycle() {
		return new AnotherLifeCycle();
	}

}
