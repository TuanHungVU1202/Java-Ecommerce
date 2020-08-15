package com.hv.ecommerce.users.support;

import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findUserById(long id);

    User findUserByUsername(String username);

    User findUserByFirstName(String firstName);

    User findUserByLastName(String lastName);

    User updateUserByLastName(String lastName);

    void saveUser(User user);

    long deleteById(Long id);

    User removeByUsername(String username);

    User removeByEmail(String email);

    List<User> removeByFirstName(String firstName);

    List<User> removeByLastName(String lastName);

    String getHashsedPassword(String plainTextPassword);

//  boolean validatePassword(String plainPassword, String usernameOrEmail);

    User registerNewUser(AuthDTO authDTO) throws Exception;

    User logInNormal(AuthDTO authDTO) throws Exception;

    boolean isEmailExist(String email);

    boolean isUsernameExist(String username);
}
