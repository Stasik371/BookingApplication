module com.main.bookingapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires json.simple;
    requires lombok;
    requires org.jetbrains.annotations;
    requires com.google.gson;
    requires com.jfoenix;
    requires MaterialFX;
    opens logic.models.places to com.google.gson;
    opens logic.models.enums to com.google.gson;
    opens com.main.bookingapplication to javafx.fxml;
    exports com.main.bookingapplication;
    exports controllers;
    opens controllers to javafx.fxml;
}