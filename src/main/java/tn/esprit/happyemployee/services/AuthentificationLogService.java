package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.AutheticationLog;
import tn.esprit.happyemployee.repositories.AuthenticationLogRepository;

@Service
public class AuthentificationLogService implements IAuthentificationLogService {

    @Autowired
    private AuthenticationLogRepository auth;

    @Override
    public void addAuthLog(AutheticationLog authLog) {
        auth.save(authLog);
    }
}
