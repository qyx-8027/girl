package com.chan.girl.controller;

import com.chan.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/girl")
public class HelloController {

    @Value("${cupSize}")    //拿到配置文件中cupSize的值并注入变量中
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value="/{id1}/say/{id2}",method = RequestMethod.POST)
    public String say(@PathVariable("id1") String id1,@PathVariable("id2") String id2) {
        return   cupSize + " " + age + "    "
                + content + "    "
                + girlProperties.getCupSize() + " " +girlProperties.getAge() + "    "
                + "id1 = " + id1 + "    "
                + "id2 = " + id2;
    }
}
