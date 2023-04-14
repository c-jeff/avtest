package pe.edu.upc.avinka.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;
import pe.edu.upc.avinka.service.crud.CategoryService;
import pe.edu.upc.avinka.service.crud.ProductService;

@Controller
@RequestMapping("/products")
@SessionAttributes("productEdit")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String listar (Model model) {
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			//----
			List<Product> products = productService.getAll();
			model.addAttribute("products",products);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "products/lista";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Optional<Product> optional = productService.findById(id);
			//-----
			if(optional.isPresent()) {
				model.addAttribute("product",optional.get());
				return "products/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/products";
	}
	
	@GetMapping("{id}/edit")
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Optional<Product> optional = productService.findById(id);
			
			if(optional.isPresent()) {
				model.addAttribute("productEdit",optional.get());
				List<Category> categories = categoryService.getAll();
				model.addAttribute("categories",categories);
				return "products/edit";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/products";
	}
	
	@PostMapping("save")
	public String saveEdit(Model model,@ModelAttribute("productEdit") Product product) {
		
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			String Altnombre = product.getName().toUpperCase();
			product.setName(Altnombre);
			Product productReturn = productService.update(product);
			model.addAttribute("product",productReturn);
			return "products/view";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/categories";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Product product = new Product();
			model.addAttribute("productNew",product);
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories",categories);
			//----
			return "products/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("productNew") Product product) {
		
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			String Altnombre = product.getName().toUpperCase();
			product.setName(Altnombre);
			
			/*if(!imagen.isEmpty()) {
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					product.setImagen(imagen.getOriginalFilename());
					
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
				
				
			}
			*/
			
			Product productReturn = productService.create(product);
			model.addAttribute("product", productReturn);
						
			return "products/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Optional<Product> optional = productService.findById(id);
			//----
			if(optional.isPresent()) {
				productService.deleteById(id);
				return "redirect:/products";
			}
			else {
				return "redirect:/products";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/products";
	}
	
	
}
