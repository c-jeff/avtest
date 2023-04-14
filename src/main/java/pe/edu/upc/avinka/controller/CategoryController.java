package pe.edu.upc.avinka.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.avinka.model.entity.Category;
import pe.edu.upc.avinka.model.entity.Product;
import pe.edu.upc.avinka.service.crud.CategoryService;

@Controller
@RequestMapping("/categories")
@SessionAttributes("categoyEdit")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String listar (Model model) {
		try {
			Category categorySearch = new Category();
			model.addAttribute("categorySearch",categorySearch);
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			//----
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories",categories);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "categories/lista";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Optional<Category> optional = categoryService.findById(id);
			//-----
			if(optional.isPresent()) {
				model.addAttribute("category",optional.get());
				return "categories/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/categories";
	}
	
	@GetMapping("{id}/edit")
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			Optional<Category> optional = categoryService.findById(id);
			
			if(optional.isPresent()) {
				model.addAttribute("categoryEdit",optional.get());
				return "categories/edit";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/categories";
	}
	
	@PostMapping("save")
	public String saveEdit(Model model,@ModelAttribute("categoryEdit") Category category) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		try {
			String AltNombre = category.getName().toUpperCase();
			category.setName(AltNombre);
			Category categoryReturn = categoryService.update(category);
			model.addAttribute("category",categoryReturn);
			return "categories/view";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/categories";
	}
	
	@GetMapping("new") //GET: /genders/{id}
	public String newItem(Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		try {
			Category category = new Category();
			model.addAttribute("categoryNew",category);
			//----
			return "categories/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/categories";
	}
	
	@PostMapping("savenew") //Post: /genders/saves
	public String saveNew(Model model,@ModelAttribute("categoryNew") Category category) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		try {
			String AltNombre = category.getName().toUpperCase();
			category.setName(AltNombre);
			Category categoryReturn = categoryService.create(category);
			model.addAttribute("category", categoryReturn);
						
			return "categories/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/categories";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") Integer id, Model model) {
		Product productSearch = new Product();
		model.addAttribute("productSearch",productSearch);
		try {
			Optional<Category> optional = categoryService.findById(id);
			//----
			if(optional.isPresent()) {
				categoryService.deleteById(id);
			}
			else {
				return "redirect:/categories";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/categories";
	}
	

}
