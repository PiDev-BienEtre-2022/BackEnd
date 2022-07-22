package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.AutheticationLog;
import tn.esprit.happyemployee.entities.CalculCnx;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.exception.UserNotFoundException;
import tn.esprit.happyemployee.repositories.AuthenticationLogRepository;
import tn.esprit.happyemployee.repositories.UserRepository;

import java.time.Duration;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationLogRepository authLog;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser (User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }

    public CalculCnx CalculDureeCnx(String email){
        List <AutheticationLog> listAuth = this.authLog.findByUserEmail(email);

        long days = 0;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;

        for(AutheticationLog log : listAuth) {
            Duration duration = Duration.between(log.getStartDate(), log.getEndDate());

            days += duration.toDays();
            hours += duration.toHours();
            minutes += duration.toMinutes();
            seconds += duration.getSeconds();
        }

        do {
            seconds = seconds % 60;
            minutes++;
        } while (seconds > 60);
        do {
            minutes = minutes % 60;
            hours++;
        } while (hours > 60);
        do {
            hours = hours % 24;
            days++;
        } while (hours > 24);

        return new CalculCnx(days, hours, minutes, seconds);
    }


}
