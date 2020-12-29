package com.hv.ecommerce.controllers;
import com.hv.ecommerce.users.support.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healthcheck {
    @Autowired
    private IUserService userService;

    @GetMapping("/healthcheck")
    public String getHealthCheck() {
        return "ok";
    }

    @GetMapping("/test")
    public void test() {
        try {
//            userService.removeByUsername("c");
//            userService.removeByEmail("3@abc.com");
//            userService.removeById(4L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
