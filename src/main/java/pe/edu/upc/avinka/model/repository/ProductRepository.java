package pe.edu.upc.avinka.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	

	Optional<Product> findByName(String name) throws Exception;
	List<Product> findByNameStartingWith(String name)  throws Exception;
	List<Product> findByCategory(Category category) throws Exception;
	// List<Show> findByOrganiser(Organiser organiser) throws Exception;
	List<Product>findByNameContaining(String name)throws Exception;
	
}
