package br.com.templatex.appmvctemplate.controller;

import br.com.templatex.appmvctemplate.Repository.UserRepository;
import br.com.templatex.appmvctemplate.model.User;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User getUser(){

        User user = userRepository.getOne((long) 1);
        System.out.println(user);
        return user;

        //TODO: resolver returno do use

    }
}
