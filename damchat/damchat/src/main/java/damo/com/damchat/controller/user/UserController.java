package damo.com.damchat.controller.user;
import damo.com.damchat.dto.request.RegisterUserDTO;
import damo.com.damchat.dto.response.ResponseDetails;
import damo.com.damchat.exception.AppException;
import damo.com.damchat.model.user.User;
import damo.com.damchat.service.user.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/endpoint/user")
@Slf4j
public class UserController {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody RegisterUserDTO registerUserDTO) {
        userServiceImplementation.createUser(registerUserDTO);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Created successfully.", HttpStatus.OK.toString());
        return ResponseEntity.ok(responseDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) throws AppException {
        userServiceImplementation.deleteUser(id);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Deleted account successfully.", HttpStatus.OK.toString());
        return ResponseEntity.ok(responseDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) throws AppException {
        userServiceImplementation.findUser(id);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Found", HttpStatus.OK.toString());
        return ResponseEntity.ok(responseDetails);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) throws AppException {
        User updated = userServiceImplementation.updateUser(id, updatedUser);
        return ResponseEntity.ok(updated);
    }
}


