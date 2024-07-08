package org.example.sbootthymleafcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SbootThymleafCrudApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SbootThymleafCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeRoles() {
        return args -> {
            // Check if roles exist
            System.out.println("XYZ"+ passwordEncoder.encode("xyz"));
        };
    }


}
