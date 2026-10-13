package com.fandikang.demo24B;

import com.fandikang.demo24B.controller.Testcontroller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo24BfdkApplicationTests {

    @Autowired
    private Testcontroller testController;

    @Test
    void contextLoads() {
        // 调用 test() 方法，并打印返回值
        System.out.println(testController.test());
    }
}