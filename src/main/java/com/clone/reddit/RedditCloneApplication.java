package com.clone.reddit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditCloneApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(RedditCloneApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("JKS");
//        InputStream resourceAsStream = getClass().getResourceAsStream("/security.jks");
//        keyStore.load(resourceAsStream, "password".toCharArray());
//        PrivateKey privateKey=(PrivateKey) keyStore.getKey("security", "password".toCharArray());
//        System.out.println(privateKey.toString());
    }
}
