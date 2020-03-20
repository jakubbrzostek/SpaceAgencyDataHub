package j.brzostek.spaceagency.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long productId;
    private Instant acquisitionDate;
    private double[] productFootprint;
    private int price;
    private String productURL;

    public Product() {
    }

    public Product(Long productId, Instant acquisitionDate, double[] productFootprint, int price, String productURL) {
        this.productId = productId;
        this.acquisitionDate = acquisitionDate;
        this.productFootprint = productFootprint;
        this.price = price;
        this.productURL = productURL;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) { this.productId = productId; }

    public Instant getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Instant acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public double[] getProductFootprint() {
        return productFootprint;
    }

    public void setProductFootprint(double[] productFootprint) {
        this.productFootprint = productFootprint;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }
}
