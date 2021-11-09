package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.profile.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// work like DAO
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findUserById(Long id);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);

    User findUserByUsername(String username);

    List<User> findAll();

    long removeById(Long id);

    long removeByUsername(String username);

    long removeByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    @Query("SELECT c FROM User c WHERE c.username= :username OR c.email= :email")
    Optional<User> findUserFromLogInNormal(@Param("username") String username, @Param("email") String email);
}
