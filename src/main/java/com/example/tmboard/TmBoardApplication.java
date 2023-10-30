package com.example.tmboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TmBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmBoardApplication.class, args);
    }

}
