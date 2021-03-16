package org.carlos.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @Description:
 * @Author: CarlosWu
 * @Date: 2021/3/13 19:22
 * @Version: 0.0.1
 */
@SpringBootApplication
@MapperScan("org.carlos.server.mapper")
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class,args);
    }
}
