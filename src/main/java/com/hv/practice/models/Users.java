package com.hv.practice.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 1024)
    private String username;

    @Column(name = "email", length = 1024)
    private String email;

    @Column(name = "phoneNo", length = 1024)
    private String phoneNo;

}
