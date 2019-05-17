package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.online.auction.entity.User;
import spring.online.auction.model.Message;
import spring.online.auction.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auction/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/all")
    public ResponseEntity<Message> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<Message> addAdmin(User user){
        return new ResponseEntity<>(userService.addAdmin(user), HttpStatus.OK);
    }

    @GetMapping("/admin/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        User u = userService.getUserById(userId);
        if(u!=null) return new ResponseEntity<>(u,HttpStatus.OK);
        return new ResponseEntity<>(new Message("User with id " + userId + " does not exist"),HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Message> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @PutMapping("/admin/block/{userId}")
    public ResponseEntity<Message> blockUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.blockUser(userId),HttpStatus.OK);
    }

    @PutMapping("/admin/unblock/{userId}")
    public ResponseEntity<Message> unblockUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.unblockUser(userId),HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

}
