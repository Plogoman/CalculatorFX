package org.openjfx.calculatorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorMainWindow CalculatorWindow = new CalculatorMainWindow();
        CalculatorWindow.RunCalculatorWindow();
    }
}
