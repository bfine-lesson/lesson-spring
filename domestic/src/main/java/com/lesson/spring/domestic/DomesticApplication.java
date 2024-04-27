package com.lesson.spring.domestic;

import com.lesson.spring.core.config.CoreJpaScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@CoreJpaScan
@SpringBootApplication
public class DomesticApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomesticApplication.class, args);
    }

}
