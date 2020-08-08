package com.hv.ecommerce.users.support;

import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

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

    private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
            return false;
    }

    @Override
    public boolean checkPwd(String plainPassword, String usernameOrEmail) {
//        Optional<User> user = userRepository.findUserById().get();

        //TODO: query hashedPassword from DB to match with plainPassword
        String hashedPassword = "";
        return checkPass(plainPassword, hashedPassword);
    }

    @Transactional
    @Override
    public User registerNewUser(AuthDTO authDTO)
            throws AuthException {

        if (isEmailOrUsernameExist(authDTO.getEmail(), authDTO.getUsername())) {
            throw new AuthException(
                    "There is an account with that email address: "
                            + authDTO.getEmail());
        }

        User newUser = new User();
        newUser.setUsername(authDTO.getUsername());
        newUser.setEmail(authDTO.getEmail());
        newUser.setEncryptedPwd(hashPassword(authDTO.getPlainPassword()));

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public boolean isEmailOrUsernameExist(String email, String username) {
        return userRepository.existsByEmailOrUsername(email, username);
    }
}
