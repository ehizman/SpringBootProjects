package africa.ehizman.diaryproject.web;
import africa.ehizman.diaryproject.models.Diary;
import africa.ehizman.diaryproject.models.User;
import africa.ehizman.diaryproject.models.UserDto;
import africa.ehizman.diaryproject.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import africa.ehizman.diaryproject.services.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class UserController {
    @Autowired private UserService userService; //injecting the userService class;

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
        userService.deleteUser(userId);
        return new ResponseEntity<>(String.format("user with id %s has been deleted!", userId), HttpStatus.OK);
    }

    @PostMapping("/users/add")
    public ResponseEntity<?> addNewUser(@RequestBody @NotNull UserDto userDto){
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        String password = userDto.getPassword();
        List<String> diaryTitles = userDto.getDiaryTitles();
        userService.saveNewUser(firstName,lastName,password,diaryTitles);
        return new ResponseEntity<>("new user saved!", HttpStatus.OK);
    }
}