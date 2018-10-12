package com.sda.employee_base.controller;

import com.sda.employee_base.model.Person;
import com.sda.employee_base.view.PersonView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PersonNewController {

    private PersonView personView;

    public boolean isPersonSaved;

    private int index;

    public void setPersonSaved(boolean personSaved) {
        isPersonSaved = personSaved;
    }

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldLastname;

    @FXML
    private TextField textFieldStreet;

    @FXML
    private TextField textFieldCity;

    @FXML
    private TextField textFieldPostalCode;

    @FXML
    private TextField textFieldTelephone;

    @FXML
    private Button closeButton;

    @FXML
    private Button saveButton;

    public void handleSaveButton(ActionEvent actionEvent) {
        if (isPersonSaved) {
            Person person = new Person(
                    textFieldName.textProperty(),
                    textFieldLastname.textProperty(),
                    textFieldStreet.textProperty(),
                    textFieldCity.textProperty(),
                    textFieldPostalCode.textProperty(),
                    textFieldTelephone.textProperty());
            personView.getPersonList().add(person);
            //System.out.println("Save person");
        } else {
            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Save changes?",
                    ButtonType.YES,
                    ButtonType.NO
            );
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/error.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                //System.out.println("saving changes...");

                Person person = new Person(textFieldName.textProperty(),
                        textFieldLastname.textProperty(),
                        textFieldStreet.textProperty(),
                        textFieldCity.textProperty(),
                        textFieldPostalCode.textProperty(),
                        textFieldTelephone.textProperty());
                personView.getPersonList().set(this.index, person);
            }
        }
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    public void handleCancelButton(ActionEvent actionEvent) {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    public void setPerson(Person person) {
        textFieldName.textProperty().bindBidirectional(person.getNameProperty());
        textFieldLastname.textProperty().bindBidirectional(person.getLastnameProperty());
        textFieldStreet.textProperty().bindBidirectional(person.getStreetProperty());
        textFieldCity.textProperty().bindBidirectional(person.getCityProperty());
        textFieldPostalCode.textProperty().bindBidirectional(person.getPostalcodeProperty());
        textFieldTelephone.textProperty().bindBidirectional(person.getTelephoneProperty());
    }

    public void setSelectIndex(int index) {
        this.index = index;
    }
}
