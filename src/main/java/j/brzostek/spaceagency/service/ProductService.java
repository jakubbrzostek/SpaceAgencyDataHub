package j.brzostek.spaceagency.service;

import j.brzostek.spaceagency.DAO.entity.Product;
import j.brzostek.spaceagency.DAO.ProductRepository;
import j.brzostek.spaceagency.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found")); // sample exception usage
    }

    public List<Product> findByProductIdIn(Long[] ids) {
        return productRepository.findByProductIdIn(ids);
    }

    public List<Product> findByAcquisitionDate(Instant acquisition) {
        return productRepository.findByAcquisitionDate(acquisition);
    }

    public List<Product> findByAcquisitionDateGreaterThan(Instant acquisition) {
        return productRepository.findByAcquisitionDateGreaterThan(acquisition);
    }

    public List<Product> findByAcquisitionDateLessThan(Instant acquisition) {
        return productRepository.findByAcquisitionDateLessThan(acquisition);
    }

    public List<Product> findByAcquisitionDateBetween(Instant acquisition, Instant acquisition2) {
        return productRepository.findByAcquisitionDateBetween(acquisition, acquisition2);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    //test purposes
    public void fillDB() {
        save(new Product(1L, Instant.parse("2020-02-18T13:08:47.286655400Z"), new double[]{1.00, 2.00, 3.00, 4.00}, 1000, "someKindURL"));
        save(new Product(2L, Instant.parse("2020-01-18T13:08:47.286655400Z"), new double[]{1.00, 2.00, 3.00, 4.00}, 1500, "someKindURL"));

    }
}
