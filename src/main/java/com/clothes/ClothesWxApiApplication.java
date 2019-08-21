package com.clothes;


import com.alibaba.fastjson.JSON;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 15:48
 * @description：
 * @modified By：
 * @version:
 */

@SpringBootApplication
@MapperScan("com.clothes.modules.*.mapper")
@SpringBootConfiguration
@EnableTransactionManagement
@EnableScheduling
public class ClothesWxApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ClothesWxApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ClothesWxApiApplication.class, args);
    }

      @Bean
    public ConfigurableServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]\\"));
        return factory;
    }
}

