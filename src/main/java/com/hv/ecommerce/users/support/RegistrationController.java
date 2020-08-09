package com.hv.ecommerce.users.support;

import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.users.AuthDTO;
import com.hv.ecommerce.users.User;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/user/registration", headers = "Accept=application/json")
    public ResponseEntity<?> register(@Valid @RequestBody AuthDTO authDTO) throws Exception {
        try {
            userService.registerNewUser(authDTO);
            return new ResponseEntity<User>(HttpStatus.CREATED);
        } catch (AuthException authE) {
            throw new AuthException(HttpStatus.GONE, authE.getMessage());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.GONE)
                    .body(e.getMessage());
        }
    }
}
