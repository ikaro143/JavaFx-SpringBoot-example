package com.springjavafx.example.applauncher;

import com.springjavafx.example.ExampleApplication;
import com.springjavafx.example.applauncher.StageInitializer.StageReadyEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class AppLauncher extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        this.applicationContext = new SpringApplicationBuilder(ExampleApplication.class).run();
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {

        this.applicationContext.publishEvent(new StageReadyEvent(stage));
    }
}
