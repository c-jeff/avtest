package pe.edu.upc.avinka.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.avinka.model.entity.Customer;
import pe.edu.upc.avinka.model.repository.CustomerRepository;
import pe.edu.upc.avinka.service.crud.CustomerService;

@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public JpaRepository<Customer, Integer> getRepository() {
		
		return customerRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> findByFirstname(String firstname) throws Exception {
		return customerRepository.findByFirstname(firstname);
	}

	@Override
	public List<Customer> findByFirstnameStartingWith(String firstname) throws Exception {
		return customerRepository.findByFirstnameStartingWith(firstname);
	}

}
