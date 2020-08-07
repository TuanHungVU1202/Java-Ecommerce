package com.hv.ecommerce.users.support;

import com.hv.ecommerce.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public ResponseEntity<User> register(@RequestBody String payload) {
        if (null != payload) {

            return new ResponseEntity<User>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
