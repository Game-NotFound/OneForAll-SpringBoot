package com.hauhh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private TestConfigBean configBean;

    @GetMapping
    public String index(){
        return "Hello " + blogProperties.getName() + ", title: " + blogProperties.getTitle();
    }

    @GetMapping("/test")
    public String test(){
        return "Hello " + configBean.getName() + ", Age: " + configBean.getAge();
    }


}
