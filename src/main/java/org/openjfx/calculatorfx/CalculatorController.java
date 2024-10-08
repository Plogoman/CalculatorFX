package org.openjfx.calculatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorController {
    @FXML private Pane TitlePane;
    @FXML private ImageView CloseButton, MinimizeButton;
    @FXML private Label DisplayResult;

    private double x, y;
    private double Number1 = 0;
    private String Operator = "+";

    public void InitializeController(Stage stage) {
        TitlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        TitlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        CloseButton.setOnMouseClicked(mouseEvent -> stage.close());
        MinimizeButton.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    void OnNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("Button", ""));
        DisplayResult.setText(Double.parseDouble(DisplayResult.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(DisplayResult.getText())*10+value));
    }

    @FXML
    void OnSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("Button", "");
        if (symbol.equals("Equal")) {
            double Number2 = Double.parseDouble(DisplayResult.getText());
            switch (Operator) {
                case "+" -> DisplayResult.setText((Number1+Number2) + "");
                case "-" -> DisplayResult.setText((Number1-Number2) + "");
                case "*" -> DisplayResult.setText((Number1*Number2) + "");
                case "/" -> DisplayResult.setText((Number1/Number2) + "");
            }
            Operator = ".";
        } else if (symbol.equals("Clear")) {
            DisplayResult.setText(String.valueOf(0.0));
            Operator = ".";
        } else {
            switch (symbol) {
                case "Plus" -> Operator = "+";
                case "Minus" -> Operator = "-";
                case "Multiply" -> Operator = "*";
                case "Divide" -> Operator = "/";
            }
            Number1 = Double.parseDouble(DisplayResult.getText());
            DisplayResult.setText(String.valueOf(0.0));
        }
    }
}