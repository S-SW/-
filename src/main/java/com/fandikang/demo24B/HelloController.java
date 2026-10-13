package com.fandikang.demo24B;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/nihao")
    public String sayHello() {
        return "你好,范帝康24102011031";
    }
}
