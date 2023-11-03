package com.lesson.spring.answer.q4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseConfiguration {

    @Bean
    public Example makeConfig() {
        return new Example();
    }


}
