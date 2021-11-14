package com.hv.ecommerce.profile.support;

import com.hv.ecommerce.authen.support.IUserService;
import com.hv.ecommerce.common.SearchCriteria;
import com.hv.ecommerce.common.SearchSpecification;
import com.hv.ecommerce.profile.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminUserController {
    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private IUserService userService;

    // Get all users
    @SuppressWarnings({"rawtypes", "unchecked"})
    @GetMapping("/users")
    public ResponseEntity<?> searchUsers(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size,
                                      @RequestParam (required = false) String search) {
        try {
            // Default sort Descending by Crate time
            //  Sort multiple conditions PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")));
            List<User> userList = new ArrayList<User>();
            if (null == search || search.isEmpty()){
                Pageable paging = PageRequest.of(page, size, Sort.by("createDate").descending());
                Page<User> userPage = userService.findAll(paging);
                userList = userPage.getContent();
            } else {
                SearchSpecification usernameSpec = new SearchSpecification(new SearchCriteria("username", ":", search));
                SearchSpecification emailSpec = new SearchSpecification(new SearchCriteria("email", ":", search));
                SearchSpecification firstNameSpec = new SearchSpecification(new SearchCriteria("firstName", ":", search));
                SearchSpecification lastNameSpec = new SearchSpecification(new SearchCriteria("lastName", ":", search));
                SearchSpecification phoneNoSpec = new SearchSpecification(new SearchCriteria("phoneNo", ":", search));
                SearchSpecification addressSpec = new SearchSpecification(new SearchCriteria("address", ":", search));
                Pageable paging = PageRequest.of(page, size, Sort.by("createDate").descending());
                Specification combinedSpecs = Specification.where(usernameSpec)
                        .or(emailSpec)
                        .or(firstNameSpec)
                        .or(lastNameSpec)
                        .or(phoneNoSpec)
                        .or(addressSpec);
                Page<User> userPage = userService.findAll(combinedSpecs, paging);
                userList = userPage.getContent();
            }

            return new ResponseEntity<>(userList, HttpStatus.FOUND);
        } catch (Exception e){
            logger.error("Get all users error: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
