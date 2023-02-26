package com.atguigu.ggkt.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//5.5/bq.bq




//11.11.bq.bqscanBasePackages = "com.atguigu"
@SpringBootApplication
@ComponentScan(basePackages ="com.atguigu")
@EnableDiscoveryClient
//11.11.bq.bqscanBasePackages = "com.atguigu"扫描别的模块的配置类（swagger带有configuration的配置类）
public class ServiceVodApplication {
    public static void main(String[] args) {


        SpringApplication.run(ServiceVodApplication.class, args);
        System.out.println("chenggong");
    }

}
//5.5/bq.bq

