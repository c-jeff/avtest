package pe.edu.upc.avinka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.avinka.init.Message;
import pe.edu.upc.avinka.model.entity.Product;

import pe.edu.upc.avinka.service.crud.ProductService;

@Controller
@RequestMapping("/")
@SessionAttributes("message")
public class IndexController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/")
	public String indexGet(Model model) {
		
		try {
			model.addAttribute("message", new Message());
			String response = "HOLA";
			model.addAttribute("response", response);
			
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			List<Product> products = productService.getAll();
			model.addAttribute("products",products);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
				
		return "index";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		return "login";
	}
	
	@GetMapping("signup")
	public String signup(Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		return "signup";
	}
	
	@GetMapping("reclamaciones")
	public String reclamaciones(Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		return "reclamaciones";
	}
	
	@GetMapping("recomendacion")
	public String recomendacion(Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		return "recomendacion";
	}
	
	@GetMapping("map")
	public String cobertura(Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		return "map";
	}
	
	@GetMapping("access-denied")
	public String accessDeniedModel() {
		return "access-denied";
	}
	
	
	
}
