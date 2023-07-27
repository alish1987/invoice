package com.mirhashemi.invoice;

import com.mirhashemi.invoice.auth.AuthenticationService;
import com.mirhashemi.invoice.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.mirhashemi.invoice.user.Role.*;

@SpringBootApplication
public class InvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var user = RegisterRequest.builder()
                    .firstname("User")
                    .lastname("User")
                    .email("user@mail.com")
                    .password("pass")
                    .role(USER)
                    .build();
            System.out.println("User token: " + service.register(user).getAccessToken());

        };
    }
}
