package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
@EnableWebSecurity
public class UserController {
    @Autowired
    UserService agent;

    @GetMapping("/{id}")
    public User get_user(@PathVariable("id") long id){
        return agent.getUserById(id);
    }

    @GetMapping("/list")
    public List<User> get_users(){
        return agent.getUserss();
    }
}
