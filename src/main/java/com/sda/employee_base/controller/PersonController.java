package com.sda.employee_base.controller;

import com.sda.employee_base.model.Person;
import com.sda.employee_base.view.PersonView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    public void initialize(){
        System.out.println("TEST");
        nameColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameColumn.setCellValueFactory(cell -> cell.getValue().lastnameProperty());
    }
}
