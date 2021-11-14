package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.profile.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IUserService {

    Page<User> findAll(Pageable paging);

    Page<User> findAll(Specification<User> spec, Pageable paging);

    User findUserById(long id);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);

    long removeById(Long id);

    long removeByUsername(String username);

    long removeByEmail(String email);
}
