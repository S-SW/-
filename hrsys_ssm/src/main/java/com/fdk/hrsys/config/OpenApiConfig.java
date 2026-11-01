package com.fdk.hrsys.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger 在线接口文档配置
 * 个人标识：FDK 范帝康  学号 24102011031
 * 页面地址：http://localhost:8080/swagger-ui.html
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hrSysOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("人力资源管理系统 API 文档")
                .description("员工 / 部门 REST 接口在线文档 —— FDK 范帝康 学号 24102011031")
                .version("1.0.0")
                .contact(new Contact().name("FDK 范帝康").email("24102011031")));
    }
}
