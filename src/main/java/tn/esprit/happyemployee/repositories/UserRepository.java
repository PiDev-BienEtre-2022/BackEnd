package tn.esprit.happyemployee.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
	
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	@Query("SELECT count(f) FROM User f where f.equipe=:equipe")
	public Long getUserCountPerEquipe(@Param("equipe") Equipe equipe);
}
