package com.uta.edu.ec.students.infrastructure.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class SpringWebConfig {

    // Intercepta todas las peticiones HTTP POST y las convierte en peticiones HTTP PUT o DELETE
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        return new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
    }
}
