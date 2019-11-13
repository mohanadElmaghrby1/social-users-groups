package com.idealwaves.controller.v1;

import com.idealwaves.domain.User;
import com.idealwaves.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * create by mohannad on 11/11/2019
 */
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/v1/users";

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity(userService.save(user) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        User user = userService.findById(id).
                orElseThrow(()-> new EntityNotFoundException("cant find user with id: " + id));
        return new ResponseEntity(user , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable long id){
//        userService.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("cant find user to delete with id: " + id));
        userService.deleteById(id);
//        return new ResponseEntity("deleted" , HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity(userService.findAll() , HttpStatus.OK);
    }


}
