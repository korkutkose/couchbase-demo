package com.korkutkose.couchbasedemo;

import com.korkutkose.couchbasedemo.configuration.NativeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(NativeConfiguration.class)
public class CouchbaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouchbaseDemoApplication.class, args);
    }

}
