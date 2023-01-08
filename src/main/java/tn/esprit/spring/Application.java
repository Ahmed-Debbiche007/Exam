package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableSpringConfigured
@EnableScheduling
@EntityScan (basePackages = {"tn.esprit.spring.entities"})
@EnableAspectJAutoProxy
 public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
