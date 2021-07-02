package africa.ehizman.diaryproject.services;


import africa.ehizman.diaryproject.models.Diary;
import africa.ehizman.diaryproject.models.User;

import java.util.List;

public interface UserService {
    void saveNewUser(String firstName, String lastName, String password);
    User findUser(String userId);
    void deleteUser(String userId);

    void updateUser(User user);
    void saveNewUser(String firstName, String lastName, String password, List<String> diaryTitles);
}
