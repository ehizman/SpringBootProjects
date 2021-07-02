package africa.ehizman.diaryproject.repositories;

import africa.ehizman.diaryproject.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DiaryRepository extends MongoRepository<Diary, String> {
    Optional<Diary> findDiaryByTitle(String title);
    void deleteByTitle(String title);
}
