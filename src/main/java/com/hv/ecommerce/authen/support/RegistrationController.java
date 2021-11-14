package com.hv.ecommerce.authen.support;

import com.hv.ecommerce.common.Constant;
import com.hv.ecommerce.common.Utils;
import com.hv.ecommerce.exception.AuthException;
import com.hv.ecommerce.authen.AuthDTO;
import com.hv.ecommerce.profile.User;
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
    private IAuthService authService;

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public ResponseEntity<?> register(@Valid @RequestBody AuthDTO authDTO) throws Exception {
        String returnStr;
        try {
            User user = authService.registerNewUser(authDTO);
            user.setEncryptedPwd(null);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (AuthException authE) {
            returnStr = Utils.customMessageObj(Constant.RETURN_MESSAGE_KEY, authE.getMessage());
            return new ResponseEntity<>(returnStr, HttpStatus.GONE);
        } catch (Exception e) {
            logger.error("Register error: ", e);
            return ResponseEntity.status(HttpStatus.GONE)
                    .body(e.getMessage());
        }
    }
}
