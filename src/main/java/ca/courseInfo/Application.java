/**
 * Application class is just a main class which is Spring Boot Application..
 * @author Akansha Vaish
 */

package ca.courseInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main (String[] args) {
        SpringApplication.run (Application.class, args);
    }
}
