package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.profile.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<User> findAll(Pageable paging) {
        return userRepository.findAll(paging);
    }

    @Override
    public Page<User> findAll(Specification<User> spec, Pageable paging) {
        return userRepository.findAll(spec, paging);
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
