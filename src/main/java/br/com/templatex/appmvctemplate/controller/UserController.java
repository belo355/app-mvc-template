package br.com.templatex.appmvctemplate.controller;

import br.com.templatex.appmvctemplate.Repository.UserRepository;
import br.com.templatex.appmvctemplate.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list(){
        List<User> users = null;
        log.info("List into user is null");
        try {
            users = userRepository.findAll();
            log.info("List into user is completed", users);
            return users;
        }catch(Error e){
            System.out.println(e.getMessage());
            log.info(e.getMessage());
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<User> findUser(@PathVariable(required = true) Long id){
        Optional<User> user = null;

        try {
            user = userRepository.findById(id);
            log.info("return the user sucessfull", user);
            return user;
        }catch (Error e){
            log.info(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Response<Entity> delete(@PathVariable(required = true) Long id){
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()){
                userRepository.deleteById(id);
                return (Response<Entity>) ResponseEntity.ok().build();
            }else{
                return (Response<Entity>) ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

}
