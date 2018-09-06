package com.sda.employee_base.view;

import com.sda.employee_base.App;
import com.sda.employee_base.controller.PersonController;
import com.sda.employee_base.controller.PersonNewController;
import com.sda.employee_base.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonView {

    private VBox vBox;
    private Stage stage;
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public PersonView(Stage stage) {
        this.stage = stage;
        personList.add(new Person("John", "Kowalsky", "", "Liverpool", "", ""));
        personList.add(new Person("Bob", "Marley", "", "Liverpool", "", ""));
        personList.add(new Person("Mark", "Dawson", "", "London", "", ""));
        personList.add(new Person("Patrick", "Dewey", "", "Manchester", "", ""));
        personList.add(new Person("Paul", "Hevert", "", "London", "", ""));
        personList.add(new Person("Sam", "Caus", "", "London", "", ""));
        personList.add(new Person("Carol", "Thompson", "", "Manchester", "", ""));
        personList.add(new Person("Susan", "Wright", "", "London", "", ""));
        personList.add(new Person("Mariah", "Armstrong", "", "London", "", ""));
        personList.add(new Person("Betty", "Bright", "", "London", "", ""));

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void loadNewPerson() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/EditLabelView.fxml"));
        VBox newPersonView = null;
        try {
            newPersonView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.show();

        PersonNewController personNewController = loader.getController();
        personNewController.setPersonView(this); //this odnosi się do klasy
        personNewController.setPersonSaved(true);
    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/RootView.fxml"));
        try {
            vBox = (VBox) loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.show();
            PersonController personController = loader.getController();
            personController.setPersonView(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadEditPerson(Person person, int index) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/EditLabelView.fxml"));
        VBox newPersonView = null;
        try {
            newPersonView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.show();
        PersonNewController personNewController = loader.getController();
        personNewController.setPersonView(this); //this odnosi się do klasy
        personNewController.setPersonSaved(false);
        personNewController.setSelectIndex(index);
        personNewController.setPerson(person);

    }
}