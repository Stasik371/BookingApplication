package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class RootWindowController {

    private final ObservableList<String> testList = FXCollections.observableArrayList("1\n1\n1", "2", "3", "4");
    @FXML
    private ImageView btn_home, btn_profile, btn_orders, btn_exit, locationPhoto;
    @FXML
    private DatePicker datePicker;
    @FXML
    private AnchorPane menubar, homePane, profilePane, ordersPane, backgroundPane;
    @FXML
    private JFXListView<String> mainListView, ordersListView;

    public void initialize(){
        mainListView.setItems(testList);
        homePane.setVisible(false);
        profilePane.setVisible(false);
        ordersPane.setVisible(false);
        menubar.setVisible(true);
        /*listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = " + oldValue + " to newValue = " + newValue);
            }
        });*/
    }

    @FXML
    private void handleButtonAction(MouseEvent event){
        homePane.setVisible(event.getTarget().equals(btn_home) && !homePane.isVisible());
        profilePane.setVisible(event.getTarget().equals(btn_profile) && !profilePane.isVisible());
        ordersPane.setVisible(event.getTarget().equals(btn_orders) && !ordersPane.isVisible());
        if(event.getTarget().equals(btn_exit)){
            System.exit(0);
        }
    }
}