package com.sparta.springcrudexamples;

import com.sparta.springcrudexamples.entities.UserEntity;
import com.sparta.springcrudexamples.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringCrudExamplesApplication {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudExamplesApplication.class, args);
    }

    /* Generates users - run once
    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            userRepository.save(new UserEntity("James", encoder.encode("Smith"), "ADMIN", 1));
            userRepository.save(new UserEntity("Kieran", encoder.encode("Kieran"), "USER", 1));
        };
    }
     */

}