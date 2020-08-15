package com.hv.ecommerce.users.support;

import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        Optional<User> user = userRepository.findUserById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserByFirstName(String firstName) {
        return null;
    }

    @Override
    public User findUserByLastName(String lastName) {
        return null;
    }

    @Override
    public User updateUserByLastName(String lastName) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public long deleteById(Long id) {
        return 0;
    }

    @Override
    public User removeByUsername(String username) {
        return null;
    }

    @Override
    public User removeByEmail(String email) {
        return null;
    }

    @Override
    public List<User> removeByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> removeByLastName(String lastName) {
        return null;
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    @Override
    public String getHashsedPassword(String plainTextPassword) {

        return hashPassword(plainTextPassword);
    }

    /*
    private boolean checkPassword(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
            return false;
    }

    @Override
    public boolean validatePassword(String plainPassword, String usernameOrEmail) {
//        Optional<User> user = userRepository.findUserById().get();

        String hashedPassword = "";
        return checkPassword(plainPassword, hashedPassword);
    }
    */

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

        userRepository.save(newUser);
        return newUser;
    }

    @Override
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
    }
}
