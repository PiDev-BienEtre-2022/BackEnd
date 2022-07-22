package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.happyemployee.entities.AutheticationLog;

import java.util.List;

@Repository
public interface AuthenticationLogRepository extends JpaRepository<AutheticationLog, Long> {

    List<AutheticationLog> findByUserEmail(String email);
}
