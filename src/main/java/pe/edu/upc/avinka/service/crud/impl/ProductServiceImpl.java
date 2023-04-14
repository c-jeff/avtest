package pe.edu.upc.avinka.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;
import pe.edu.upc.avinka.model.repository.ProductRepository;
import pe.edu.upc.avinka.service.crud.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public JpaRepository<Product, Integer> getRepository() {
		return productRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Product> findByName(String name) throws Exception {
		return productRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> findByNameStartingWith(String name) throws Exception {
		return productRepository.findByNameStartingWith(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> findByCategory(Category category) throws Exception {
		return productRepository.findByCategory(category);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> findByNameContaining(String name) throws Exception {
		return productRepository.findByNameContaining(name);
	}

}
