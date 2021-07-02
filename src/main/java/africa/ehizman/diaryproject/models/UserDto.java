package africa.ehizman.diaryproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String password;
    private List<String> diaryTitles;
}
