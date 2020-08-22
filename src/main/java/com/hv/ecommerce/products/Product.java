package com.hv.ecommerce.products;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", nullable = false)
    private Long productId;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductDetails productDetails;

    // This is for Order model
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(name = "priceTag")
    private Long priceTag;

    @Column(name = "availability", length = 1024)
    private String availability;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        return productId != null && productId.equals(((Product) obj).getProductId());
    }

    @Override
    public int hashCode() {
        return 12;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(Long priceTag) {
        this.priceTag = priceTag;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
