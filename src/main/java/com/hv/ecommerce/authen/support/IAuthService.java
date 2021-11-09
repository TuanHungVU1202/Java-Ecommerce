package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.authen.AuthDTO;
import com.hv.ecommerce.profile.User;

public interface IAuthService {
    User findUserByUsername(String username);

    String getHashsedPassword(String plainTextPassword);

    User registerNewUser(AuthDTO authDTO) throws Exception;

//    User logInNormal(AuthDTO authDTO) throws Exception;

    boolean isEmailExist(String email);

    boolean isUsernameExist(String username);

    void authenticate(String username, String password) throws Exception;
}
