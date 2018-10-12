package com.sda.employee_base.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.employee_base.App;
import com.sda.employee_base.controller.PersonController;
import com.sda.employee_base.controller.PersonNewController;
import com.sda.employee_base.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class PersonView {

    private VBox vBox;
    private Stage stage;
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public PersonView(Stage stage) {
        this.stage = stage;

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
        newPersonStage.getIcons().add(new Image(App.class.getResourceAsStream("/icon.png")));
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
            stage.getIcons().add(new Image(App.class.getResourceAsStream("/icon2.png")));
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
        newPersonStage.getIcons().add(new Image(App.class.getResourceAsStream("/icon.png")));
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.show();
        PersonNewController personNewController = loader.getController();
        personNewController.setPersonView(this); //this odnosi się do klasy
        personNewController.setPersonSaved(false);
        personNewController.setSelectIndex(index);
        personNewController.setPerson(person);
    }

    public void writeToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File filename = new File("Person base.json");

        try {
            objectMapper.writeValue(filename, personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File filename = new File("Person base.json");
        if (filename != null) {
            try {
                personList = (ObservableList<Person>) objectMapper.readValue(filename, Person.class);

                for (Person p : personList) {
                    personList.add(new Person(
                            p.getNameProperty(),
                            p.getLastnameProperty(),
                            p.getStreetProperty(),
                            p.getCityProperty(),
                            p.getPostalcodeProperty(),
                            p.getTelephoneProperty()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           // ???
        }
    }
}