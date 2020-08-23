package com.hv.ecommerce.products;

import javax.persistence.*;

@Entity
@Table(name = "productDetails")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Map directly with Id of Product Entity
    @OneToOne
    @MapsId
    private Product product;

    @Column(name = "sku", length = 1024, unique = true, nullable = false)
    private String sku;

    @Column(name = "productName", length = 1024)
    private String productName;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "dimension", length = 1024)
    private String dimension;

    @Column(name = "photoPath", length = 1024)
    private String photoPath;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
