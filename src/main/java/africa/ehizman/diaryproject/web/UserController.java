package africa.ehizman.diaryproject.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import africa.ehizman.diaryproject.services.UserService;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/users/add/{firstName}/{lastName}/{password}")
    public ResponseEntity<?> addNewUser(@PathVariable("firstName")String firstName,
                                        @PathVariable("lastName")String lastName,
                                        @PathVariable("password") String password) {
        userService.saveNewUser(firstName, lastName, password);
        return new ResponseEntity<>("new user added",HttpStatus.OK);
    }

    @GetMapping("/users/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String userId){
        return new ResponseEntity<>(userService.findUser(userId),HttpStatus.OK);
    }

    @DeleteMapping("users/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
}
