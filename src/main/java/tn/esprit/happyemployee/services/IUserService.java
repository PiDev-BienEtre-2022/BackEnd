package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.AutheticationLog;
import tn.esprit.happyemployee.entities.CalculCnx;
import tn.esprit.happyemployee.entities.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    public void deleteUser(Long id);
    public User findUserById(Long id);
    public User updateUser (User user);
    public List<User> findAllUsers();
    public User addUser(User user);
    public CalculCnx CalculDureeCnx(String email);


}
