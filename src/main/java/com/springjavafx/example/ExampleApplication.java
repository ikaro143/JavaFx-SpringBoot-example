package com.springjavafx.example;

import com.springjavafx.example.applauncher.AppLauncher;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        Application.launch(AppLauncher.class, args);
    }

}
