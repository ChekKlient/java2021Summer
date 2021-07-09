package com.company;

import com.company.entities.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Human john = new Human("John" , new Date() , Human.Gender.MALE , Human.BloodGroup.FIRST);
        Driver johnDriver = new Driver(john ,new DriverLicense(new Date() ,
                                 DriverLicense.Category.C , new Date()));
        GasolineCar car = new GasolineCar("ZAZ", "AA5555AA", "100500" , DriverLicense.Category.C ,
                                1499 , 80 , GasolineCar.Transmission.AUTOMATIC);
        Route route = new Route(car , johnDriver , "Troeshina" , "Klovska");
        System.out.println(route);


    }
}
