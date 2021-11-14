package com.hv.ecommerce.profile.support;

import com.hv.ecommerce.authen.support.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("userProfileController")
public class ProfileController {
    // TODO: get user info, put update info
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private IUserService userService;

    // Get profile of 1 user
    @GetMapping("/users")
    public ResponseEntity<?> getUserProfile(@RequestParam String id) {
        try {
            return null;
        } catch (Exception e){
            logger.error("Get user profile error: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
