package com.hv.ecommerce.users.support;

import com.hv.ecommerce.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    Users findUserBySku(String sku);

    Optional<Users> findUserById(Long id);

    List<Users> findAll();
}
