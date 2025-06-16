package com.uta.edu.ec.students.infrastructure.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SpringWebConfig {

    // Intercepta todas las peticiones HTTP POST y las convierte en peticiones HTTP PUT o DELETE
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> registration = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        registration.addUrlPatterns("/*");

        return registration;
    }

}
