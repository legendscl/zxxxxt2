package com.atguigu.ggkt.vod.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//6.6/bq.bq

@Configuration
@MapperScan("com.atguigu.ggkt.vod.mapper")
public class VodConfig {
    //.14.bq.bq

    /* 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    //14.14.bq.bq

}
//6.6/bq.bq
