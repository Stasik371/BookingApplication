package com.main.bookingapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.datastructures.DataStructureSingleton;
import logic.models.enums.TypesOfSquares;
import logic.models.places.SportsComplex;
import logic.models.places.SquaresFactory;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    int initialX;
    int initialY;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("rootWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 580, 580);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Booking Application");
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/Garfild_planet.jfif")));
        stage.getIcons().add(icon);
        scene.setOnMousePressed(m -> {
            if (m.getButton() == MouseButton.PRIMARY) {
                scene.setCursor(Cursor.MOVE);
                initialX = (int) (stage.getX() - m.getScreenX());
                initialY = (int) (stage.getY() - m.getScreenY());
            }
        });

        scene.setOnMouseDragged(m -> {
            if (m.getButton() == MouseButton.PRIMARY) {
                stage.setX(m.getScreenX() + initialX);
                stage.setY(m.getScreenY() + initialY);
            }
        });

        scene.setOnMouseReleased(m -> scene.setCursor(Cursor.DEFAULT));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(@NotNull String @NotNull []  args) {
        launch();
    }
}