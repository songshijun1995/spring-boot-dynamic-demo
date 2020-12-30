package com.dynamic.dynamicdemo;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableSwaggerBootstrapUI
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.dynamic.dynamicdemo")
public class DynamicDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDemoApplication.class, args);
    }

}
