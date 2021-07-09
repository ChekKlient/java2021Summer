package com.company.entities;

/**
 * Created by Администратор on 25.01.2016.
 */
public abstract class Vehicle {
    private String model;
    private String number;
    private String vin;
    private DriverLicense.Category category;

    public Vehicle() {
    }

    public Vehicle(String model, String number, String vin, DriverLicense.Category category) {
        this.model = model;
        this.number = number;
        this.vin = vin;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public DriverLicense.Category getCategory() {
        return category;
    }

    public void setCategory(DriverLicense.Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", vin='" + vin + '\'' +
                ", category=" + category +
                '}';
    }
}
