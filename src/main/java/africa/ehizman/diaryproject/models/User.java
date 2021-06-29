package africa.ehizman.diaryproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String password;
}
