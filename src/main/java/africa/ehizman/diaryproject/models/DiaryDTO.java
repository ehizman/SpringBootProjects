package africa.ehizman.diaryproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@NoArgsConstructor
public class DiaryDTO {
    @Id
    private String Id;
    private String title;
    @DBRef
    private List<Entry> entries;
}
