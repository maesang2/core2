package com.example.core2.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    public void init() {
        this.uuid = UUID.randomUUID().toString();
        this.requestURL = requestURL;
    }

    public void destroy() {
        System.out.println("[" + uuid + "] request finished");
    }
}
