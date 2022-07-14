package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService agent;

    @GetMapping("/{id}")
    public User get_user(@PathVariable("id") long id){
        return agent.getUserById(id);
    }
}
