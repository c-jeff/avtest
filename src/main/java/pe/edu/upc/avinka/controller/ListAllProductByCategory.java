package pe.edu.upc.avinka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;
import pe.edu.upc.avinka.service.crud.CategoryService;
import pe.edu.upc.avinka.service.crud.ProductService;

@Controller
@RequestMapping("/listAllProductByCategory")
public class ListAllProductByCategory {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String listar(Model model) {
		
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		
		Category productbycategorySearch = new Category();
		model.addAttribute("productbycategorySearch",productbycategorySearch);
		try {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories",categories);
			List<Product> products = productService.getAll();
			model.addAttribute("products",products);
			List<Product> category = productService.getAll();
			model.addAttribute("category",category);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "findProductsByCategory/listProductsByCategory";
		
	}

}
