package pe.edu.upc.avinka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;
import pe.edu.upc.avinka.service.crud.CategoryService;
import pe.edu.upc.avinka.service.crud.ProductService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("categories")
	public String searchCategoryGet(Model model, @ModelAttribute("categorySearch") Category categorySearch ) {
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			List<Category>categoriesFound = categoryService.findByNameContaining(categorySearch.getName().toUpperCase());
			model.addAttribute("categoriesFound",categoriesFound);
			model.addAttribute("categorySearch",categorySearch);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/categories-result";
	}
	
	
	@GetMapping("products")
	public String searchProductGet(Model model, @ModelAttribute("productSearch") Product productSearch) {
		try {
			
			List<Product> productsFound = productService.findByNameContaining(productSearch.getName().toUpperCase());
			model.addAttribute("productsFound",productsFound);
			model.addAttribute("productSearch",productSearch);
			
			if(productsFound.isEmpty()) {
				
				return "redirect:/";
				
			}
			else if(productSearch.getName().isBlank() ||productSearch.getName().isEmpty() ){
				
				return "redirect:/";
			}
			else {
				return "search/products-result";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/";
		
	}
	@GetMapping("productsbycategory")
	public String searchProductByCstegory(Model model, @ModelAttribute("productbycategorySearch") Category productbycategorySearch ) {
		
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			List<Category> categoriesFound = categoryService.findByNameStartingWith(productbycategorySearch.getName());
			model.addAttribute("productbycategoryFound",categoriesFound);
			model.addAttribute("productbycategorySearch",productbycategorySearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "search/products-by-category";
	}
	
	
}
