package africa.ehizman.diaryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiaryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryProjectApplication.class, args);
        System.out.println("Server started!");
    }

}
