package solutions.javasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solutions.javasoft.dao.model.PriceList;
import solutions.javasoft.dao.model.Product;
import solutions.javasoft.dao.repository.PriceListRepository;
import solutions.javasoft.dao.repository.ProductRepository;
import solutions.javasoft.dto.PriceListDto;

import java.util.Optional;

@RequestMapping("priceList")
@CrossOrigin("http://localhost:4200")
@RestController
public class PriceListController {

    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Optional<PriceList> createPriceList(@RequestBody PriceListDto priceListDto) {
        Optional<Product> product = productRepository.findById(priceListDto.getProductCode());
        if (!product.isPresent()) {
            return Optional.empty();
        }
        PriceList priceList = new PriceList();
        priceList.setPrice(priceListDto.getPrice());
        priceList.setName(priceListDto.getName());
        priceList.setDescription(priceListDto.getDescription());
        priceList.setProduct(product.get());
        return Optional.of(priceListRepository.save(priceList));
    }

    @GetMapping
    public Iterable<PriceList> getPriceList() {
        return priceListRepository.findAll();
    }
}
