package pe.edu.upc.avinka.service.crud;

import java.util.Optional;

import pe.edu.upc.avinka.model.entity.User;

public interface UserService extends CrudService<User, Integer>{
	
	Optional<User> findByUsername(String username) throws Exception;
	
}
