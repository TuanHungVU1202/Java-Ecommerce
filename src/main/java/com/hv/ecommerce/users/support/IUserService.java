package com.hv.ecommerce.users.support;

import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findUserById(long id);

    public User findUserByUsername(String username);

    public User findUserByFirstName(String firstName);

    public User findUserByLastName(String lastName);

    public User updateUserByLastName(String lastName);

    public void saveUser(User user);

    long deleteById(Long id);

    User removeByUsername(String username);

    User removeByEmail(String email);

    List<User> removeByFirstName(String firstName);

    List<User> removeByLastName(String lastName);

    public String getHashsedPassword(String plainTextPassword);

    public boolean checkPwd(String plainPassword, String usernameOrEmail);

    public User registerNewUser(AuthDTO authDTO) throws AuthException;

    public boolean isEmailOrUsernameExist(String email, String username);
}
