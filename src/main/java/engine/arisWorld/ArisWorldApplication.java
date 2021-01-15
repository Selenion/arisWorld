package engine.arisWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ArisWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArisWorldApplication.class, args);
    }

}
