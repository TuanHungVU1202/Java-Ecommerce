package com.hv.ecommerce.users.support;

import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    User findUserById(long id);

    User findUserByUsername(String username);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);

    long removeById(Long id);

    long removeByUsername(String username);

    long removeByEmail(String email);

    String getHashsedPassword(String plainTextPassword);

//  boolean validatePassword(String plainPassword, String usernameOrEmail);

    User registerNewUser(AuthDTO authDTO) throws Exception;

    User logInNormal(AuthDTO authDTO) throws Exception;

    boolean isEmailExist(String email);

    boolean isUsernameExist(String username);
}
