package com.sda.employee_base.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty nameProperty = new SimpleStringProperty(this, "nameProperty");
    private StringProperty lastnameProperty = new SimpleStringProperty(this, "lastnameProperty");
    private StringProperty streetProperty = new SimpleStringProperty(this, "streetProperty");
    private StringProperty cityProperty = new SimpleStringProperty(this, "cityProperty");
    private StringProperty postalcodeProperty = new SimpleStringProperty(this, "postalcodeProperty");
    private StringProperty telephoneProperty = new SimpleStringProperty(this, "phoneProperty");


    public Person(StringProperty nameProperty, StringProperty lastnameProperty, StringProperty streetProperty, StringProperty cityProperty, StringProperty postalcodeProperty, StringProperty telephoneProperty) {
        this.nameProperty = nameProperty;
        this.lastnameProperty = lastnameProperty;
        this.streetProperty = streetProperty;
        this.cityProperty = cityProperty;
        this.postalcodeProperty = postalcodeProperty;
        this.telephoneProperty = telephoneProperty;
    }

    public Person() {
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(StringProperty nameProperty) {
        this.nameProperty = nameProperty;
    }

    public StringProperty getLastnameProperty() {
        return lastnameProperty;
    }

    public void setLastnameProperty(StringProperty lastnameProperty) {
        this.lastnameProperty = lastnameProperty;
    }

    public StringProperty getStreetProperty() {
        return streetProperty;
    }

    public void setStreetProperty(StringProperty streetProperty) {
        this.streetProperty = streetProperty;
    }

    public StringProperty getCityProperty() {
        return cityProperty;
    }

    public void setCityProperty(StringProperty cityProperty) {
        this.cityProperty = cityProperty;
    }

    public StringProperty getPostalcodeProperty() {
        return postalcodeProperty;
    }

    public void setPostalcodeProperty(StringProperty postalcodeProperty) {
        this.postalcodeProperty = postalcodeProperty;
    }

    public StringProperty getTelephoneProperty() {
        return telephoneProperty;
    }

    public void setTelephoneProperty(StringProperty telephoneProperty) {
        this.telephoneProperty = telephoneProperty;
    }
}
