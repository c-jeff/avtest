package pe.edu.upc.avinka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import pe.edu.upc.avinka.init.Message;
import pe.edu.upc.avinka.model.entity.Product;

@Controller
@RequestMapping("/assistant")
public class AssistantController {

	@PostMapping("/sendMessage")
	public String sendMessage(@ModelAttribute("message") Message message, Model model) {
		
		try {
			Product productSearch = new Product();
			model.addAttribute("productSearch",productSearch);
			
			WebClient.Builder builder = WebClient.builder();
			
			//enviar mensaje de usuario a dialogflow mediante servidor node
			builder.build().post().uri("https://18c1-2001-1388-6c0-1e3d-f4b1-1756-b0cc-25f.ngrok-free.app").bodyValue(message).retrieve().bodyToMono(String.class).block();
			
			System.out.println("----------------------------------------------");
			System.out.println("Enviado: " + message.getMessage());
			
			//obtener respuesta de dialogflow desde servidor node
			String res = builder.build().get().uri("https://18c1-2001-1388-6c0-1e3d-f4b1-1756-b0cc-25f.ngrok-free.app").retrieve().bodyToMono(String.class).block();
			
			System.out.println("----------------------------------------------");
			System.out.println("Recibido: " + res);
			
			model.addAttribute("message", new Message());
			model.addAttribute("response", res);
			

			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
				
		return "index";
	}
	
}
