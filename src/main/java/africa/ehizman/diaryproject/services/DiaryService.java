package africa.ehizman.diaryproject.services;

import africa.ehizman.diaryproject.models.Diary;

public interface DiaryService {
    void addNewDiary(String title, String userId);
    Diary getDiary(String title);
    void deleteDiary(String title);
}
