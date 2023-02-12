package solutions.javasoft.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solutions.javasoft.dao.model.Product;
import solutions.javasoft.dao.repository.ProductRepository;

@RequestMapping("product")
@CrossOrigin("http://localhost:4200")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> getProducts(@RequestParam String code) {

        if (StringUtils.isEmpty(code)) {
            return productRepository.findAll();
        }
        return productRepository.findByIdContaining(code + "%");
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
