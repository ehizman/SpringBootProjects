package africa.ehizman.diaryproject.services;
import africa.ehizman.diaryproject.models.Diary;
import africa.ehizman.diaryproject.models.User;
import africa.ehizman.diaryproject.repositories.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService{
    @Autowired private UserService userService;
    @Autowired private DiaryRepository diaryRepository;

    @Override
    public void addNewDiary(String title, String userId) {
        Diary newDiary = new Diary();
        newDiary.setTitle(title);
        User user = userService.findUser(userId);
        if (user != null){
            diaryRepository.save(newDiary);
            user.getDiaries().add(newDiary);
            userService.updateUser(user);
            new ResponseEntity<>("diary added to user Diary List", HttpStatus.CREATED);
            return;
        }
        new ResponseEntity<>("user does not exist", HttpStatus.EXPECTATION_FAILED);
    }

    @Override
    public Diary getDiary(String title) {
        if (diaryRepository.findDiaryByTitle(title).isPresent()){
            return diaryRepository.findDiaryByTitle(title).get();
        }
        return null;
    }

    @Override
    public void deleteDiary(String title) {
        if (diaryRepository.findDiaryByTitle(title).isPresent()){
            diaryRepository.deleteByTitle(title);
            new ResponseEntity<>("diary has been deleted", HttpStatus.OK);
            return;
        }
        new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
