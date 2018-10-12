package com.sda.employee_base;

import com.sda.employee_base.view.PersonView;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    private Stage stage;
    private PersonView personView;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        personView = new PersonView(this.stage);
        personView.readFile();
        personView.loadView();
    }
}
