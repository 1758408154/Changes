package com.changes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName WebsocketApplication
 * @Description TODO
 * @Author LiuJunJie
 * @Date 2019/4/4 15:34
 * @Version 1.0
 * @Company WH_tepia
 **/
@SpringBootApplication
@EnableScheduling
public class WebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class);
    }
}
