package pe.edu.upc.avinka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.avinka.model.entity.Product;
import pe.edu.upc.avinka.service.crud.ProductService;

@Controller
@RequestMapping("/products2")
@SessionAttributes("productEdit")
public class Product2Controller {
	
	@Autowired
	private ProductService productService;
		
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			List<Product> products = productService.getAll();
			model.addAttribute("products",products);
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Optional<Product> optional = productService.findById(id);
			//-----
			if(optional.isPresent()) {
				model.addAttribute("product",optional.get());
				return "products2/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/";
	}

}
