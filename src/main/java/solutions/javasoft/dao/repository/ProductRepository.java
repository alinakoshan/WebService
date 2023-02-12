package solutions.javasoft.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import solutions.javasoft.dao.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select p from Product p where upper(p.id) like upper(?1)")
    List<Product> findByIdContaining(String id);
}
