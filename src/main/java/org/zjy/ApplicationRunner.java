package org.zjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
@MapperScan("org.zjy.mapper")
public class ApplicationRunner {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationRunner.class,args);
        System.out.println("success");
    }
}
