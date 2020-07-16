package cn.edu.gues.mjzblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author TAHUN
 */
@EnableScheduling
@SpringBootApplication
public class MjzblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MjzblogApplication.class, args);
    }

}
