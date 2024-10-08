package org.openjfx.calculatorfx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CalculatorMainWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CalculatorWindowInterface.fxml"));

        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("CalculatorFX");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.png")));

        ((CalculatorController)loader.getController()).InitializeController(stage);

        stage.show();
    }

    public void RunCalculatorWindow() {
        launch();
    }
}
