package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.profile.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findUserById(long id);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);

    long removeById(Long id);

    long removeByUsername(String username);

    long removeByEmail(String email);
}
