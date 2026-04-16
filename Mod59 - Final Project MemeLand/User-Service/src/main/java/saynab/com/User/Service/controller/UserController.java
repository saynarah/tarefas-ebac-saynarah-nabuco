package saynab.com.User.Service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import saynab.com.User.Service.controller.DTOs.CreateUserDTO;
import saynab.com.User.Service.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saynab.com.User.Service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO userDTO) {

        var user = userService.createUser(userDTO);

        LOGGER.info("Create new user by email: " + user.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @GetMapping
    public ResponseEntity<Long> getUserByEmail(@RequestParam("email") String email) {

        var userId = userService.getUserByEmail(email)
                .orElse(null);

        LOGGER.info("Get UserId by user email: " + email + " - userId is :" + userId);

        if (userId == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userId);
        } else {
            return ResponseEntity.ok(userId);
        }

    }

}

