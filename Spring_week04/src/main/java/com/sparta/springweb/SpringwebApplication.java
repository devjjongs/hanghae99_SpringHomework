package com.sparta.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class SpringwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringwebApplication.class, args);
    }

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

//    @Bean
//    public CommandLineRunner demo(ContentsRepository repository) {
//        return (args) -> {
//            repository.save(new Contents("항해99", "선원1", "어푸어푸"));
//        };
//    }
}
