package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.entities.User;
import expense.tracker.trackerBackend.service.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUser userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

   // @PostMapping("/login")
   // public ResponseEntity<Boolean> loginUser(@RequestBody User user) {
       // boolean success = userService.login(user.getEmail(), user.getPassword());
       // return ResponseEntity.ok(success);
    //}
}
