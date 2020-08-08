package com.hv.ecommerce.users.support;

import com.hv.ecommerce.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findUserById(Long id);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);

    List<User> findUserByUsername(String username);

    List<User> findAll();

    void deleteById(Long id);

    User removeByUsername(String username);

    User removeByEmail(String email);

    List<User> removeByFirstName(String firstName);

    List<User> removeByLastName(String lastName);

    boolean existsByEmailOrUsername(String email, String username);
}
