package org.example.fuelcalculator;

import javafx.fxml.FXML;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private Label lblResult;
    @FXML
    private TextField txtDistance;
    @FXML
    private TextField txtFuel;
    @FXML
    private Label lblDistance;
    @FXML
    private Label lblFuel;
    @FXML
    private Button btnCalculate;

    private Locale currentLocale = new Locale("en");

    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        this.currentLocale = locale;
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        lblDistance.setText(bundle.getString("distance.label"));
        lblFuel.setText(bundle.getString("fuel.label"));
        btnCalculate.setText(bundle.getString("calculate.button"));
        lblResult.setText(bundle.getString("result.label.default"));
    }
    @FXML
    public void onCalculateClick(ActionEvent actionEvent) {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double fuel = Double.parseDouble(txtFuel.getText());

            if (distance <= 0 || fuel <= 0) {
                lblResult.setText(getMessage("invalid.input"));
                return;
            }

            double consumption = (fuel / distance) * 100;
            String resultMessage = MessageFormat.format(getMessage("result.label"), String.format("%.2f", consumption));
            lblResult.setText(resultMessage);

        } catch (NumberFormatException e) {
            lblResult.setText(getMessage("invalid.input"));
        }
    }
    @FXML
    protected void onENClick(ActionEvent actionEvent) {
        setLanguage(new Locale("en", "US"));
    }
    @FXML
    protected void onFRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fr", "FR"));
    }
    @FXML
    protected void onIRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fa", "IR"));
    }
    @FXML
    protected void onJPClick(ActionEvent actionEvent) {
        setLanguage(new Locale("ja", "JP"));
    }

    private String getMessage(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", currentLocale);
        return bundle.getString(key);
    }
}
