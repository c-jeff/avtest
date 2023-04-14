package pe.edu.upc.avinka.service.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;


public interface ProductService extends CrudService<Product, Integer>{

	Optional<Product> findByName(String name) throws Exception;
	List<Product> findByNameStartingWith(String name)  throws Exception;
	List<Product> findByCategory(Category category) throws Exception;
	// List<Show> findByOrganiser(Organiser organiser) throws Exception;
	List<Product>findByNameContaining(String name)throws Exception;
}
