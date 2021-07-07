package africa.ehizman.diaryproject.web;
import africa.ehizman.diaryproject.exceptions.DiaryException;
import africa.ehizman.diaryproject.models.Diary;
import africa.ehizman.diaryproject.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PostMapping("/diaries/add/{title}/{userId}")
    public ResponseEntity<?> addNewDiary(@PathVariable("title")String title, @PathVariable("userId") String userId){
        diaryService.addNewDiary(title, userId);
        return null;
    }

    @GetMapping("/diaries/get/{title}")
    public ResponseEntity<?> getDiary(@PathVariable("title") String title) throws DiaryException {
        Diary response = diaryService.getDiary(title);
        if (response != null){
            return new ResponseEntity<>(diaryService.getDiary(title), HttpStatus.OK);
        }
        return new ResponseEntity<>("diary not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/diaries/delete/{title}")
    public ResponseEntity<?> deleteDiary(@PathVariable("title") String title) throws DiaryException {
        Diary diary = diaryService.getDiary(title);
        if (diary != null){
            diaryService.deleteDiary(title);
            return new ResponseEntity<>("diary deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("diary not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/diaries/update/{id}/{title}")
    public ResponseEntity<?> updateDiary(@PathVariable("title") String title, @PathVariable("id") String id){
        diaryService.updateDiary(title, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
