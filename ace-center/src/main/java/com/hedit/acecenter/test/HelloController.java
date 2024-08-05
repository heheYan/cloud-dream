package com.hedit.acecenter.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${hedit.age}")
    private Integer age;

    @GetMapping("hello")
    public String hello() {
        return "Hello World！" + age;
    }
}
