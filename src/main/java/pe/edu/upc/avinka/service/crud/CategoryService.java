package pe.edu.upc.avinka.service.crud;

import java.util.List;

import java.util.Optional;

import pe.edu.upc.avinka.model.entity.Category;




public interface CategoryService extends CrudService<Category, Integer> {
	
	Optional<Category> findByName(String name) throws Exception;
	List<Category> findByNameStartingWith(String name) throws Exception;
	List<Category>findByNameContaining(String name) throws Exception;
}
