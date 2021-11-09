package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.profile.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<User> findUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    @Override
    public List<User> findUserByLastName(String lastName) {

        return userRepository.findUserByLastName(lastName);
    }

    @Transactional
    @Override
    public long removeById(Long id) {
        return userRepository.removeById(id);
    }

    @Transactional
    @Override
    public long removeByUsername(String username) {

        return userRepository.removeByUsername(username);
    }

    @Transactional
    @Override
    public long removeByEmail(String email) {

        return userRepository.removeByEmail(email);
    }
}
