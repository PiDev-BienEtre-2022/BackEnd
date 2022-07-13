package tn.esprit.happyemployee.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	@Query("SELECT count(f) FROM User f where f.equipe=:equipe")
	public Long getUserCountPerEquipe(@Param("equipe") Equipe equipe);
}
