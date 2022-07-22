package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    List<User> getUserss();

}
