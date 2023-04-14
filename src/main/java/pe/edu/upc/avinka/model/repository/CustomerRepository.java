package pe.edu.upc.avinka.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.avinka.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByFirstname(String firstname) throws Exception;
	List<Customer> findByFirstnameStartingWith(String firstname) throws Exception;
	
}
