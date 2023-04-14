package pe.edu.upc.avinka.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.avinka.model.entity.Customer;
import pe.edu.upc.avinka.model.entity.User;
import pe.edu.upc.avinka.model.repository.UserRepository;
import pe.edu.upc.avinka.service.crud.UserService;



@Service
public class InitDB implements CommandLineRunner {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		if(userService.findByUsername("admin").isPresent()) {
			
			System.out.println("Bienvenido de nuevo.");
			
			
		}
		else {
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			
			Customer customerAdmin = new Customer();
			
			customerAdmin.setId(1);
			customerAdmin.setFirstname("Administrador");
			customerAdmin.setLastname("Avinka");
			customerAdmin.setEmail("admin@avinka.com.pe");
			customerAdmin.setPassword("admin");
			
			
			User admin = new User();
			admin.setCustomer(customerAdmin);
			customerAdmin.setUser(admin);
			
			admin.setId(1);
			admin.setUsername("admin");
			admin.setPassword(bcpe.encode("admin"));
			admin.setEnable(true);
			
			admin.addAuthority("ROLE_ADMIN");
			admin.addAuthority("ACCESS_ALL");
			
			// Creando a usuarios comunes
			
			Customer customerLiliana = new Customer();
			
			customerLiliana.setId(2);
			customerLiliana.setFirstname("Liliana");
			customerLiliana.setLastname("Yanqui");
			customerLiliana.setEmail("lilidev@gmail.com");
			customerLiliana.setPassword("1234");
			
			User Liliana = new User();
			Liliana.setCustomer(customerLiliana);
			customerLiliana.setUser(Liliana);
			
			Liliana.setId(2);
			Liliana.setUsername("lilidev");
			Liliana.setPassword(bcpe.encode("1234"));
			Liliana.setEnable(true);
			
			Liliana.addAuthority("ROLE_UNIQUE");
			Liliana.addAuthority("ACCESS_UNIQUE");
			
			
			//asignando
			userRepository.save(admin);
			userRepository.save(Liliana);
			System.out.println("Todo listo. Puedes empezar a utilizar Avinka.");
			
		}
		
			
			
			
		
		
	}

	
	
}
