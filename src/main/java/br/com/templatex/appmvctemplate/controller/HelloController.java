package br.com.templatex.appmvctemplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(){
        log.info("is logger into hello world");
        return "hello is here!";
    }
}
