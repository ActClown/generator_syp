package com.syp.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * 
* <p>Title: Application</p>  
* <p>Description: </p>  
* @author syp  
* @date 2018年8月15日
 */
@SpringBootApplication
@MapperScan("com.syp.*.mapper")
@EnableCaching// 开启缓存，需要显示的指定
@EnableAsync// 开启异步
public class GenApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenApplication.class, args);
    }
}
