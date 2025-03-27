module org.example.fuelcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.example.fuelcalculator to javafx.fxml;
    exports org.example.fuelcalculator;
}