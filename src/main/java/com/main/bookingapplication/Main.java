package com.main.bookingapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.datastructures.DataStructureSingleton;
import logic.fillers.JsonFiller;
import logic.models.enums.TypesOfSquares;
import logic.models.places.SportsComplex;
import logic.models.places.SquaresFactory;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("rootWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(@NotNull String @NotNull []  args) { //не трожь аннотации
        launch();

    }
}