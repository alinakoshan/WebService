package solutions.javasoft.dao.repository;

import org.springframework.data.repository.CrudRepository;
import solutions.javasoft.dao.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {


}
