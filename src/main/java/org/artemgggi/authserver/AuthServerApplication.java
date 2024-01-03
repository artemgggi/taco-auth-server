package org.artemgggi.authserver;

import org.artemgggi.authserver.model.Users;
import org.artemgggi.authserver.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(
            UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            repo.save(
                    new Users("habuma", encoder.encode("password"), "ROLE_ADMIN"));
            repo.save(
                    new Users("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }
}
