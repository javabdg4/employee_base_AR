package com.sda.employee_base.controller;

import com.sda.employee_base.model.Person;
import com.sda.employee_base.view.PersonView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class PersonController {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label telephoneLabel;

    private PersonView personView;

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }


    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cell -> cell.getValue().getNameProperty());
        lastNameColumn.setCellValueFactory(cell -> cell.getValue().getLastnameProperty());
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldField, newField) -> viewPersonInfoOnLabel(newField));
    }

    public void viewPersonInfoOnLabel(Person person) {
        if (person != null) {
            nameLabel.textProperty().bind(person.getNameProperty());
            lastnameLabel.textProperty().bind(person.getLastnameProperty());
            streetLabel.textProperty().bind(person.getStreetProperty());
            cityLabel.textProperty().bind(person.getCityProperty());
            postalCodeLabel.textProperty().bind(person.getPostalcodeProperty());
            telephoneLabel.textProperty().bind(person.getTelephoneProperty());
        }
    }

    public void handleNewButton(ActionEvent actionEvent) {
        personView.loadNewPerson();
    }

    public void handleEditButton(ActionEvent actionEvent) {
        Person selectPerson = personTableView.getSelectionModel().getSelectedItem();

        int index = personTableView.getSelectionModel().getFocusedIndex();
        personView.loadEditPerson(selectPerson, index);
    }

    public void handleSaveButton(ActionEvent actionEvent) {
        personView.writeToFile();
    }

    public void handleDeleteButton(ActionEvent actionEvent) {

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Do you want delete this person?",
                ButtonType.YES,
                ButtonType.NO
        );
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/error.png"));
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            //System.out.println("Deleting...");
        }
        Person personToDelete = personTableView.getSelectionModel().getSelectedItem();
        personView.getPersonList().remove(personToDelete);
    }

}
