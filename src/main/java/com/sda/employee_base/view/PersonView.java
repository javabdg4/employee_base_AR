package com.sda.employee_base.view;

import com.sda.employee_base.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public PersonView() {
        personList.add(new Person("John", "Kowalsky", "", "", "", ""));
        personList.add(new Person("Bob", "", "", "", "", ""));
        personList.add(new Person("Mark", "", "", "", "", ""));
        personList.add(new Person("Patrick", "", "", "", "", ""));
        personList.add(new Person("Paul", "", "", "", "", ""));
        personList.add(new Person("Sam", "", "", "", "", ""));
        personList.add(new Person("Carol", "", "", "", "", ""));
        personList.add(new Person("Susan", "", "", "", "", ""));
        personList.add(new Person("Mariah", "", "", "", "", ""));
        personList.add(new Person("Betty", "", "", "", "", ""));
    }
}
