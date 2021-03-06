package africa.ehizman.diaryproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Diary {
    @Id
    private String id;
    @DBRef
    private List<Entry> entriesList;
    private String title;
}
