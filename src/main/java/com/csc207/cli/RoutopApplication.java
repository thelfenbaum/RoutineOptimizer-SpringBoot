package com.csc207.cli;

import com.csc207.domain.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * This class is the routine optimizer application and is the CLI.
 */

@SpringBootApplication
@EnableJpaRepositories("com.csc207.api")
@EntityScan({"com.csc207.domain"})
@ComponentScan({"com.csc207.api", "com.csc207.cli", "com.csc207.domain"})
public class RoutopApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoutopApplication.class, args);
    }
}
