package it.unibo.mostra;

import it.unibo.mostra.view.*;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Class that launches JavaFX application.
 */
public class LauncherApp extends Application{

    /**
     * Starts the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        new ViewImpl(primaryStage);
    }
}