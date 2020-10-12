package br.com.templatex.appmvctemplate.controller;

import br.com.templatex.appmvctemplate.Repository.UserRepository;
import br.com.templatex.appmvctemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public List<User> list(){
        List<User> users = null;
        try {
            users = userRepository.findAll();
            return users;
        }catch(Error e){
            System.out.println(e.getMessage());
            logger(e.getMessage());
        }
        return null;
    }
}
