package com.sda.employee_base;

import com.sda.employee_base.controller.PersonController;
import com.sda.employee_base.view.PersonView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private VBox vBox;
    private Stage stage;
    private PersonView personView;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        loadView();
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
            PersonView personView = new PersonView();
            personController.setPersonView(personView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
