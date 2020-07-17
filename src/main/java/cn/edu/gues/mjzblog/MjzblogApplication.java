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
        // 解决elasticsearch启动版本冲突
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(MjzblogApplication.class, args);
    }

}
