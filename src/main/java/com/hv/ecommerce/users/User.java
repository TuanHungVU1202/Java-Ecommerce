package com.hv.ecommerce.users;

import com.hv.ecommerce.cart.Order;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 1024, unique = true, nullable = false)
    private String username;

    @Column(name = "firstName", length = 1024)
    private String firstName;

    @Column(name = "lastName", length = 1024)
    private String lastName;

    @Column(name = "email", length = 1024, unique = true, nullable = false)
    private String email;

    @Column(name = "encryptedPwd", length = 1024)
    private String encryptedPwd;

    @Column(name = "phoneNo", length = 1024)
    private String phoneNo;

    @Column(name = "gender", length = 1024)
    private String gender;

    @Column(name = "nationalId", length = 1024, unique = true)
    private String nationalId;

    @Column(name = "passportNo", length = 1024, unique = true)
    private String passportNo;

    @Column(name = "registerDate", length = 1024)
    private String registerDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
//    @OrderBy("id desc")
    private List<LogHistory> lstLogs = new ArrayList<>();

    @Column(name = "address", length = 1024)
    private String address;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setOrder(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setOrder(null);
    }

    public List<LogHistory> getLstLogs() {
        return lstLogs;
    }

    public void setLstLogs(List<LogHistory> lstLogs) {
        this.lstLogs = lstLogs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEncryptedPwd() {
        return encryptedPwd;
    }

    public void setEncryptedPwd(String encryptedPwd) {
        this.encryptedPwd = encryptedPwd;
    }
}
