package com.sda.employee_base.controller;

import com.sda.employee_base.model.Person;
import com.sda.employee_base.view.PersonView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonNewController {

    private PersonView personView;

    public boolean isPersonSaved;

    private int index;

    public void setPersonSaved(boolean personSaved) {
        isPersonSaved = personSaved;
    }

    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField postalCode;

    @FXML
    private TextField telephone;

    @FXML
    private Button closeButton;

    @FXML
    private Button saveButton;

    public void handleSaveButton(ActionEvent actionEvent) {
        if (isPersonSaved) {
            Person person = new Person(name.getText(), lastname.getText(),
                    street.getText(), city.getText(), postalCode.getText(), telephone.getText());

            personView.getPersonList().add(person);
            System.out.println("Save person");
        } else {
            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Seve changed?",
                    ButtonType.YES,
                    ButtonType.NO
            );
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                System.out.println("saving changes...");
            }
            Person person = new Person(name.getText(), lastname.getText(), street.getText(),
                    city.getText(), postalCode.getText(), telephone.getText());
            personView.getPersonList().set(this.index, person);
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
        name.setText(person.getName());
        lastname.setText(person.getLastname());
        street.setText(person.getStreet());
        city.setText(person.getCity());
        postalCode.setText(person.getPostalCode());
        telephone.setText(person.getTelephone());
    }

    public void setSelectIndex(int index) {
        this.index = index;
    }
}
