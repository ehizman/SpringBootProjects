package africa.ehizman.diaryproject.services;

import africa.ehizman.diaryproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import africa.ehizman.diaryproject.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired private UserRepository userRepository;


    @Override
    public void saveNewUser(String firstName, String lastName, String password) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPassword(password);
        userRepository.save(newUser);
    }

    @Override
    public User findUser(String userId) {
        if (userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        }
        return null;
    }

    @Override
    public ResponseEntity<User> deleteUser(String userId) {
        if (findUser(userId) != null){
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
