package com.hv.ecommerce.cart;

import com.hv.ecommerce.products.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // Map with User
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Column(name = "customerId", length = 1024)
    private Long customerId;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Product> products = new ArrayList<>();

    @Column(name = "total", nullable = false)
    private Long total;

    @Column(name = "status", length = 1024)
    private String status;

    @Lob
    @Column(name = "deliverAddress")
    private byte[] deliverAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        return id != null && id.equals(((Order) o).getId());
    }

    @Override
    public int hashCode() {
        return 21;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(byte[] deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setProduct(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProduct(null);
    }
}
