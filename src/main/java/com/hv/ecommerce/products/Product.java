package com.hv.ecommerce.products;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "sku", length = 1024)
    private String sku;

    @Column(name = "priceTag", nullable = true)
    private Long priceTag;

    @Lob
    @Column(name = "productDetails", columnDefinition = "BLOB")
    private byte[] productDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        return id != null && id.equals(((Product) o).getId());
    }

    @Override
    public int hashCode() {
        return 12;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public byte[] getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(byte[] productDetails) {
        this.productDetails = productDetails;
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

    public Long getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(Long priceTag) {
        this.priceTag = priceTag;
    }
}
