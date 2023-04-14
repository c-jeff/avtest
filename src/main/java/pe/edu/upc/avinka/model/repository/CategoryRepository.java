package pe.edu.upc.avinka.model.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.avinka.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Optional<Category> findByName(String name) throws Exception;
	List<Category> findByNameStartingWith(String name) throws Exception;
	List<Category>findByNameContaining(String name) throws Exception;
}
