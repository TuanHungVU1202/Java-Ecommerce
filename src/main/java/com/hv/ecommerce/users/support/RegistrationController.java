package com.hv.ecommerce.users.support;

import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/user/registration", headers = "Accept=application/json")
    public ResponseEntity<User> register(@RequestBody AuthDTO authDTO) {
        try {
            userService.registerNewUser(authDTO);
            return new ResponseEntity<User>(HttpStatus.CREATED);
        } catch (Exception e) {
            //TODO: handle exception here
//            throw new AuthException("as");
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
