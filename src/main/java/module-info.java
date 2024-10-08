module org.openjfx.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.calculatorfx to javafx.fxml;
    exports org.openjfx.calculatorfx;
}