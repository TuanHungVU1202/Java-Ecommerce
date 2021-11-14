package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.authen.AuthDTO;
import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.profile.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;

@Service
public class AuthServiceImpl implements UserDetailsService, IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findUserByUsername(username);
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    @Override
    public String getHashsedPassword(String plainTextPassword) {

        return hashPassword(plainTextPassword);
    }

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean isUsernameExist(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    @Override
    public User registerNewUser(AuthDTO authDTO)
            throws AuthException {

        if (isEmailExist(authDTO.getEmail())) {
            throw new AuthException(
                    "There is an account with that email address: "
                            + authDTO.getEmail());
        }

        if (isUsernameExist(authDTO.getUsername())) {
            throw new AuthException(
                    "There is an account with that username: "
                            + authDTO.getUsername());
        }

        User newUser = new User();
        newUser.setUsername(authDTO.getUsername());
        newUser.setEmail(authDTO.getEmail());
        newUser.setEncryptedPwd(getHashsedPassword(authDTO.getPlainPassword()));

        // saving new user
        userRepository.save(newUser);
        return newUser;
    }

/*    @Override
    public User logInNormal(AuthDTO authDTO) throws AuthException {
        Optional<User> foundUser;
        String usernameOrEmail = authDTO.getUsername();

        foundUser = userRepository.findUserFromLogInNormal(usernameOrEmail, usernameOrEmail);
        if (foundUser.isPresent()) {
            String encryptedPwd = foundUser.get().getEncryptedPwd();
            if (BCrypt.checkpw(authDTO.getPlainPassword(), encryptedPwd)) {
                return foundUser.get();
            } else {
                throw new AuthException("The entered Password is incorrect");
            }
        } else {
            throw new AuthException("No account associate with entered Username/Email");
        }
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getEncryptedPwd(),
                new ArrayList<>());
    }

    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
