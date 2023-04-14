package pe.edu.upc.avinka.model.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.avinka.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer>{
	
	Optional<User> findByUsername(String username) throws Exception;
}
