package com.company.entities;

/**
 * Created by Администратор on 25.01.2016.
 */
public class Route {
    private Vehicle vehicle;
    private Driver driver;
    private String from;
    private String where;

    public Route(Vehicle vehicle, Driver driver, String from, String where) {
        if( driver.getDriverLicense().getCategories().
                contains(vehicle.getCategory()) ) {
            this.vehicle = vehicle;
            this.driver = driver;
            this.from = from;
            this.where = where;
        }else{
            throw new IllegalArgumentException("Driver and " +
                    "vehicle are not compatible");
        }
    }

    @Override
    public String toString() {
        return "Route{" +
                "vehicle=" + vehicle +
                ", driver=" + driver +
                ", from='" + from + '\'' +
                ", where='" + where + '\'' +
                '}';
    }
}
