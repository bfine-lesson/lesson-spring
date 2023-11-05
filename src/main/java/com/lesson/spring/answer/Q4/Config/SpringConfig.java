package com.lesson.spring.answer.Q4.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public SpringService springService() {
        return new SpringService(springRepository());
    }

    @Bean
    public SpringRepository springRepository() {
        return new SpringRepository();
    }
}
