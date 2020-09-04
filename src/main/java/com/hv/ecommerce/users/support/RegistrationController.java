package com.hv.ecommerce.users.support;

import com.hv.ecommerce.common.Constant;
import com.hv.ecommerce.common.Utils;
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

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public ResponseEntity<?> register(@Valid @RequestBody AuthDTO authDTO) throws Exception {
        String returnStr;
        try {
            User user = userService.registerNewUser(authDTO);
            user.setEncryptedPwd(null);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (AuthException authE) {
            returnStr = Utils.customMessageObj(Constant.RETURN_MESSAGE_KEY, authE.getMessage());
            return new ResponseEntity<>(returnStr, HttpStatus.GONE);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.GONE)
                    .body(e.getMessage());
        }
    }
}
