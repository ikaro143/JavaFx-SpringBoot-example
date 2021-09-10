package com.springjavafx.example.applauncher;

import com.springjavafx.example.applauncher.StageInitializer.StageReadyEvent;
import com.springjavafx.example.components.MainUI;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger( StageInitializer.class );

    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        // Start the user interface
        try {
            Stage stage = event.getStage();
            stage.setTitle("This is an example of JavaFX & SpringBoot");

                Scene scene = new Scene(new MainUI(),
                        Color.web("#666970"));
                stage.setScene(scene);
                stage.show();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    static class StageReadyEvent extends ApplicationEvent {


        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return (Stage) this.getSource();
        }
    }
}
