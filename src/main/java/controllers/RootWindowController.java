package controllers;

import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.datastructures.DataStructureSingleton;
import logic.models.places.SquaresFactory;

import java.util.Objects;

class User{
    private String first_name, last_name, email, phone;
    private static User user;

    private User(){}
    public static User getUser(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){this.email = email;}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

public class RootWindowController {
    private final ObservableList<String> bookingList = FXCollections.observableArrayList();
    private final ObservableList<String> ordersList = FXCollections.observableArrayList();
    private final Character[] banList1 = {
            ' ', '!', '\'', '"', '#', '№', '$', ';', '%', '^', ':', '&', '?', '*',
            '(', ')', '_', '+', '=', ',', '<', '>', '/', '\\', '`', '~', '|'
    };
    private final Character[] banList2 = {'@', '.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    @FXML
    private ImageView btn_home, btn_profile, btn_orders, btn_exit, locationPhoto, profileImage;
    @FXML
    private DatePicker datePicker;
    @FXML
    private AnchorPane menubar, homePane, profilePane, ordersPane, backgroundPane;
    @FXML
    private JFXListView<String> mainListView, ordersListView;
    @FXML
    private JFXCheckBox box_male, box_female, box_sport, box_rb, box_concert, box_loft;
    @FXML
    private TextField nameField_1, nameField_2, emailField, phoneField;
    @FXML
    private Label error1, error2, error3, error4, doneLabel, doneLabel2, descriptionText;

    public void initialize(){
        SquaresFactory.initSquares();
        mainListView.setItems(bookingList);
        ordersListView.setItems(ordersList);
        homePane.setVisible(false);
        profilePane.setVisible(false);
        ordersPane.setVisible(false);
        menubar.setVisible(true);
        mainListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("ListView selection changed from oldValue = " + oldValue + " to newValue = " + newValue));
        ordersListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Orders selection changed from oldValue = " + oldValue + " to newValue = " + newValue);
            setDescriptionText();
        });
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

    @FXML
    private void genderCheckMale(){
        box_male.setSelected(true);
        box_female.setSelected(false);
        profileImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/businessman.png"))));
    }

    @FXML
    private void genderCheckFemale(){
        box_female.setSelected(true);
        box_male.setSelected(false);
        profileImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/woman.png"))));
    }

    @FXML
    private void listFormationSport(){
        doneLabel2.setVisible(false);
        if(box_sport.isSelected()){
            for(int i = 0; i < DataStructureSingleton.getSportsComplexes().size(); i++){
                bookingList.add(DataStructureSingleton.getSportsComplexes().get(i).getName() + "\n" +
                        DataStructureSingleton.getSportsComplexes().get(i).getLocation() + "\n" +
                        DataStructureSingleton.getSportsComplexes().get(i).getPricePerHour());
            }
        } else{
            for(int i = 0; i < DataStructureSingleton.getSportsComplexes().size(); i++){
                for(int j = 0; j < bookingList.size(); j++) {
                    if (bookingList.get(j).contains(DataStructureSingleton.getSportsComplexes().get(i).getName())){
                        bookingList.remove(bookingList.get(j));
                    }
                }
            }
        }
        if(datePicker.getValue() != null) dateChanged();
    }

    @FXML
    private void listFormationConcert(){
        doneLabel2.setVisible(false);
        if(box_concert.isSelected()){
            for(int i = 0; i < DataStructureSingleton.getConcertHalls().size(); i++){
                bookingList.add(DataStructureSingleton.getConcertHalls().get(i).getName() + "\n" +
                        DataStructureSingleton.getConcertHalls().get(i).getLocation() + "\n" +
                        DataStructureSingleton.getConcertHalls().get(i).getPricePerHour());
            }
        } else{
            for(int i = 0; i < DataStructureSingleton.getConcertHalls().size(); i++){
                for(int j = 0; j < bookingList.size(); j++){
                    if(bookingList.get(j).contains(DataStructureSingleton.getConcertHalls().get(i).getName())){
                        bookingList.remove(bookingList.get(j));
                    }
                }
            }
        }
        if(datePicker.getValue() != null) dateChanged();
    }

    @FXML
    private void listFormationRB(){
        doneLabel2.setVisible(false);
        if(box_rb.isSelected()){
            for(int i = 0; i < DataStructureSingleton.getRehearsalBases().size(); i++){
                bookingList.add(DataStructureSingleton.getRehearsalBases().get(i).getName() + "\n" +
                        DataStructureSingleton.getRehearsalBases().get(i).getLocation() + "\n" +
                        DataStructureSingleton.getRehearsalBases().get(i).getPricePerHour());
            }
        } else{
            for(int i = 0; i < DataStructureSingleton.getRehearsalBases().size(); i++){
                for(int j = 0; j < bookingList.size(); j++){
                    if(bookingList.get(j).contains(DataStructureSingleton.getRehearsalBases().get(i).getName())){
                        bookingList.remove(bookingList.get(j));
                    }
                }
            }
        }
        if(datePicker.getValue() != null) dateChanged();
    }

    @FXML
    private void listFormationLoft(){
        doneLabel2.setVisible(false);
        if(box_loft.isSelected()){
            for(int i = 0; i < DataStructureSingleton.getLofts().size(); i++){
                bookingList.add(DataStructureSingleton.getLofts().get(i).getName() + "\n" +
                        DataStructureSingleton.getLofts().get(i).getLocation() + "\n" +
                        DataStructureSingleton.getLofts().get(i).getPricePerHour());
            }
        } else{
            for(int i = 0; i < DataStructureSingleton.getLofts().size(); i++){
                for(int j = 0; j < bookingList.size(); j++){
                    if(bookingList.get(j).contains(DataStructureSingleton.getLofts().get(i).getName())){
                        bookingList.remove(bookingList.get(j));
                    }
                }
            }
        }
        if(datePicker.getValue() != null) dateChanged();
    }

    private boolean profileDataCheck(){
        doneLabel.setVisible(false);
        String tmpName = nameField_1.getText();
        String tmpLastName = nameField_2.getText();
        String tmpEmail = emailField.getText();
        String tmpPhone = phoneField.getText();
        if(tmpName.equals("")){
            error1.setVisible(true);
            return false;
        }
        if(tmpLastName.equals("")){
            error2.setVisible(true);
            return false;
        }
        if(tmpEmail.indexOf('@') <= 0 || tmpEmail.indexOf('.') <= 3 || tmpEmail.indexOf('@') > tmpEmail.indexOf('.')){
            error3.setVisible(true);
            return false;
        }
        if(!tmpPhone.equals("") && (tmpPhone.indexOf('@') > -1 || tmpPhone.indexOf('.') > -1)){
            error4.setVisible(true);
            return false;
        }
        if(!tmpPhone.equals("") && (tmpPhone.indexOf("+79") != 0 || tmpPhone.length() != 12)){
            error4.setVisible(true);
            return false;
        }
        for (Character character : banList1) {
            if (tmpName.indexOf(character) > -1){
                error1.setVisible(true);
                return false;
            }
            if(tmpLastName.indexOf(character) > -1){
                error2.setVisible(true);
                return false;
            }
            if(tmpEmail.indexOf(character) > -1){
                error3.setVisible(true);
                return false;
            }
            if(!tmpPhone.equals("") && tmpPhone.indexOf(character, 1) > -1){
                error4.setVisible(true);
                return false;
            }
        }
        for(Character character : banList2){
            if(tmpName.indexOf(character) > -1){
                error1.setVisible(true);
                return false;
            }
            if(tmpLastName.indexOf(character) > -1){
                error2.setVisible(true);
                return false;
            }
        }
        doneLabel.setVisible(true);
        return true;
    }

    @FXML
    private void onSaveButton(){
        if(profileDataCheck()){
            User profile = User.getUser();
            profile.setFirstName(nameField_1.getText());
            profile.setLastName(nameField_2.getText());
            profile.setEmail(emailField.getText());
            profile.setPhone(phoneField.getText());
        }
    }

    @FXML
    private void handleTextFieldAction(){
        error1.setVisible(false);
        error2.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
        doneLabel.setVisible(false);
    }

    @FXML
    private void onOkButton() {
        if (User.getUser().getEmail() == null) {
            final Stage warning = new Stage();
            warning.setTitle("Warning");
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/warning.png")));
            warning.getIcons().add(image);
            warning.initModality(Modality.APPLICATION_MODAL);
            AnchorPane root = new AnchorPane();
            root.prefWidth(380);
            root.prefHeight(200);
            Label call = new Label("Enter user data in the \"profile\" tab");
            call.setFont(Font.font("Consolas", 18));
            call.setLayoutX(7.0);
            call.setLayoutY(87.0);
            call.prefWidth(26.0);
            call.prefHeight(366.0);
            root.getChildren().add(call);
            Scene scene = new Scene(root, 380, 200);
            warning.setResizable(false);
            warning.setScene(scene);
            warning.show();
        } else if (datePicker.getValue() == null) {
            final Stage warning = new Stage();
            warning.setTitle("Warning");
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/warning.png")));
            warning.getIcons().add(image);
            warning.initModality(Modality.APPLICATION_MODAL);
            AnchorPane root = new AnchorPane();
            root.prefWidth(380);
            root.prefHeight(200);
            Label call = new Label("Select booking date");
            call.setFont(Font.font("Consolas", 18));
            call.setLayoutX(95.0);
            call.setLayoutY(87.0);
            call.prefWidth(26.0);
            call.prefHeight(366.0);
            root.getChildren().add(call);
            Scene scene = new Scene(root, 380, 200);
            warning.setResizable(false);
            warning.setScene(scene);
            warning.show();
        } else if (mainListView.getSelectionModel().getSelectedItem() == null) {
            final Stage warning = new Stage();
            warning.setTitle("Warning");
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/warning.png")));
            warning.getIcons().add(image);
            warning.initModality(Modality.APPLICATION_MODAL);
            AnchorPane root = new AnchorPane();
            root.prefWidth(380);
            root.prefHeight(200);
            Label call = new Label("Select an object to book from the list");
            call.setFont(Font.font("Consolas", 18));
            call.setLayoutX(2.0);
            call.setLayoutY(87.0);
            call.prefWidth(26.0);
            call.prefHeight(366.0);
            root.getChildren().add(call);
            Scene scene = new Scene(root, 380, 200);
            warning.setResizable(false);
            warning.setScene(scene);
            warning.show();
        } else if (checkOrders()) {
            final Stage warning = new Stage();
            warning.setTitle("Warning");
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/main/bookingapplication/images/warning.png")));
            warning.getIcons().add(image);
            warning.initModality(Modality.APPLICATION_MODAL);
            AnchorPane root = new AnchorPane();
            root.prefWidth(380);
            root.prefHeight(200);
            Label call = new Label("You have already booked this property!");
            call.setFont(Font.font("Consolas", 18));
            call.setLayoutX(4.0);
            call.setLayoutY(87.0);
            call.prefWidth(26.0);
            call.prefHeight(366.0);
            root.getChildren().add(call);
            Scene scene = new Scene(root, 380, 200);
            warning.setResizable(false);
            warning.setScene(scene);
            warning.show();
        } else {
            ordersList.add(datePicker.getValue().getDayOfMonth() + "." + datePicker.getValue().getMonthValue() + "."
                    + datePicker.getValue().getYear() + "\n" + mainListView.getSelectionModel().getSelectedItem());
            doneLabel2.setVisible(true);
        }
    }

    @FXML
    private void dateChanged() {
        doneLabel2.setVisible(false);
        bookingList.retainAll();
        if (box_sport.isSelected()){
            for (int i = 0; i < DataStructureSingleton.getSportsComplexes().size(); i++) {
                if (DataStructureSingleton.getSportsComplexes().get(i).getFreeDays().contains(datePicker.getValue().getDayOfWeek())) {
                    bookingList.add(DataStructureSingleton.getSportsComplexes().get(i).getName() + "\n" +
                            DataStructureSingleton.getSportsComplexes().get(i).getLocation() + "\n" +
                            DataStructureSingleton.getSportsComplexes().get(i).getPricePerHour());
                }
            }
        }
        if(box_concert.isSelected()){
            for (int i = 0; i < DataStructureSingleton.getConcertHalls().size(); i++) {
                if (DataStructureSingleton.getConcertHalls().get(i).getFreeDays().contains(datePicker.getValue().getDayOfWeek())) {
                    bookingList.add(DataStructureSingleton.getConcertHalls().get(i).getName() + "\n" +
                            DataStructureSingleton.getConcertHalls().get(i).getLocation() + "\n" +
                            DataStructureSingleton.getConcertHalls().get(i).getPricePerHour());
                }
            }
        }
        if(box_rb.isSelected()){
            for (int i = 0; i < DataStructureSingleton.getRehearsalBases().size(); i++) {
                if (DataStructureSingleton.getRehearsalBases().get(i).getFreeDays().contains(datePicker.getValue().getDayOfWeek())) {
                    bookingList.add(DataStructureSingleton.getRehearsalBases().get(i).getName() + "\n" +
                            DataStructureSingleton.getRehearsalBases().get(i).getLocation() + "\n" +
                            DataStructureSingleton.getRehearsalBases().get(i).getPricePerHour());
                }
            }
        }
        if(box_loft.isSelected()){
            for (int i = 0; i < DataStructureSingleton.getLofts().size(); i++) {
                if (DataStructureSingleton.getLofts().get(i).getFreeDays().contains(datePicker.getValue().getDayOfWeek())) {
                    bookingList.add(DataStructureSingleton.getLofts().get(i).getName() + "\n" +
                            DataStructureSingleton.getLofts().get(i).getLocation() + "\n" +
                            DataStructureSingleton.getLofts().get(i).getPricePerHour());
                }
            }
        }
    }

    private boolean checkOrders(){
        for (String s : ordersList) {
            if (s.contains(datePicker.getValue().getDayOfMonth() + "." + datePicker.getValue().getMonthValue() + "."
                    + datePicker.getValue().getYear() + "\n" + mainListView.getSelectionModel().getSelectedItem())) {
                return true;
            }
        }
        return false;
    }

    private void setDescriptionText(){ // сделать норм
        descriptionText.setText(ordersListView.getSelectionModel().getSelectedItem());
    }
}