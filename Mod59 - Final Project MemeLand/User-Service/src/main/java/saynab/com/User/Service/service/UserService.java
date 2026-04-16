package saynab.com.User.Service.service;

import saynab.com.User.Service.controller.DTOs.CreateUserDTO;
import saynab.com.User.Service.domain.User;
import org.springframework.stereotype.Component;
import saynab.com.User.Service.exceptions.UserAlreadyExistsException;
import saynab.com.User.Service.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;


@Component
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDTO userDTO){

        Optional<Long> userId  = userRepository.findByEmail(userDTO.email()).map(User::getId);

        if(userId.isPresent()){
            throw new UserAlreadyExistsException("User already exists by email: "+ userDTO.email());
        }

        User newUser = new
                User(null,
                userDTO.name(),
                userDTO.email(),
                Date.valueOf(LocalDate.now()));

        return userRepository.save(newUser);
    }

    public Optional<Long> getUserByEmail(String email){

        return userRepository.findByEmail(email).map(User::getId);
    }





}
