package org.carlos.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Description: 测试
 * @Author: CarlosWu
 * @Date: 2021/3/14 15:51
 * @Version: 0.0.1
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
