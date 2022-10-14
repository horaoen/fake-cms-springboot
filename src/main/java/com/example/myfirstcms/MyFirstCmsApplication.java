package com.example.myfirstcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.myfirstcms.mapper"})
public class MyFirstCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstCmsApplication.class, args);
    }

}
