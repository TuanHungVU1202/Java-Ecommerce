package com.hv.practice.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TODO: map id to Customer ID in Order model
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 1024)
    private String username;

    @Column(name = "email", length = 1024)
    private String email;

    @Column(name = "phoneNo", length = 1024)
    private String phoneNo;

    @Column(name = "gender", length = 1024)
    private String gender;

    @Lob
    @Column(name = "billAddress")
    private byte[] billAddress;

    //TODO: put deliverAddress to Order model
    @Column(name = "purchaseId", length = 1024)
    private String purchaseId;

    //TODO: put deliverAddress to Order model
    @Lob
    @Column(name = "deliverAddress")
    private byte[] deliverAddress;

}
