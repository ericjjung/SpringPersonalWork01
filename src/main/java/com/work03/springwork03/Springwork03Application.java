package com.work03.springwork03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class Springwork03Application {

    public static void main(String[] args) {

        SpringApplication.run(Springwork03Application.class, args);

    }

}
