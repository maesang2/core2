package com.example.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest{

    @Test
    void lifeCycleTest() {
        NetworkClient networkClient = new NetworkClient();
        networkClient.setUrl("http://hello-spring.dev");
        networkClient.connect();
        networkClient.call("hello");
        networkClient.close();
    }

    @Configuration
    static class LifeCycleConfig {

         @Bean(initMethod = "init", destroyMethod = "close")
         public NetworkClient networkClient() {
             NetworkClient networkClient = new NetworkClient();
             networkClient.setUrl("http://hello-spring.dev");
             return networkClient;
         }
    }
}
