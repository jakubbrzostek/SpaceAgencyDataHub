package j.brzostek.spaceagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com")
public class SpaceAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceAgencyApplication.class, args);
    }

}
