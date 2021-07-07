package africa.ehizman.diaryproject.services;

import africa.ehizman.diaryproject.exceptions.DiaryException;
import africa.ehizman.diaryproject.models.Diary;

public interface DiaryService {
    void addNewDiary(String title, String userId);
    Diary getDiary(String title) throws DiaryException;
    void deleteDiary(String title);
    void updateDiary(String title, String id);
}
