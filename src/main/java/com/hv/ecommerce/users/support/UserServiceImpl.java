package com.hv.ecommerce.users.support;

import com.hv.ecommerce.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

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
        String hashedPassword = "";
        return checkPass(plainPassword, hashedPassword);
    }
}
