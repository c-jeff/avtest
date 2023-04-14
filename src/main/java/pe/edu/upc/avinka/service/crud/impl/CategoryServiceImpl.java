package pe.edu.upc.avinka.service.crud.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.repository.CategoryRepository;
import pe.edu.upc.avinka.service.crud.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	 private CategoryRepository categoryRepository;

	@Override
	public JpaRepository<Category, Integer> getRepository() {
		return categoryRepository;
	}
	

	@Transactional(readOnly = true)
	@Override
	public Optional<Category> findByName(String name) throws Exception {
		
		return categoryRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> findByNameStartingWith(String name) throws Exception {
		return categoryRepository.findByNameStartingWith(name);
	}

	@Override
	public List<Category> findByNameContaining(String name) throws Exception {
		return categoryRepository.findByNameContaining(name);
	}

	
	
	
	

	

}
