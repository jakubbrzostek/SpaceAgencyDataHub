package j.brzostek.spaceagency.api;

import j.brzostek.spaceagency.DAO.entity.Product;
import j.brzostek.spaceagency.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productsList;

    @Autowired
    public ProductController(ProductService productList) {
        this.productsList = productList;
    }

    @GetMapping("/all")
    public Iterable<Product> getAll() {
        return productsList.findAll();
    }

    @GetMapping
    public Product getById(@RequestParam Long index) {
       return productsList.findById(index);
    }

    @GetMapping
    public List<Product> getByProductIdIn(@RequestParam Long[] indexes) {
        return productsList.findByProductIdIn(indexes);
    }

    @GetMapping
    public List<Product> getByAcquisition(@RequestParam Instant acquisition) {
        return productsList.findByAcquisitionDate(acquisition);
    }

    @GetMapping
    public List<Product> getByAcquisitionDateGreaterThan(@RequestParam Instant acquisition) {
        return productsList.findByAcquisitionDateGreaterThan(acquisition);
    }

    @GetMapping
    public List<Product> getByAcquisitionDateLessThan(@RequestParam Instant acquisition) {
        return productsList.findByAcquisitionDateLessThan(acquisition);
    }

    @GetMapping
    public List<Product> getByAcquisitionDateBetween(@RequestParam Instant acquisition, @RequestParam Instant acquisition2 ) {
        return productsList.findByAcquisitionDateBetween(acquisition, acquisition2);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productsList.save(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Long index) {
        productsList.deleteById(index);
    }
}
