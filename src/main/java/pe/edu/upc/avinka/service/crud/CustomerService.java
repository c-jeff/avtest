package pe.edu.upc.avinka.service.crud;

import java.util.List;
import pe.edu.upc.avinka.model.entity.Customer;

public interface CustomerService extends CrudService<Customer, Integer>{

	List<Customer> findByFirstname(String firstname) throws Exception;
	List<Customer> findByFirstnameStartingWith(String firstname) throws Exception;
	
}
