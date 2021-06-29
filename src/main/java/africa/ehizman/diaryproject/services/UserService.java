package africa.ehizman.diaryproject.services;


import africa.ehizman.diaryproject.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    void saveNewUser(String firstName, String lastName, String password);
    User findUser(String userId);
    ResponseEntity<User>deleteUser(String userId);
}
