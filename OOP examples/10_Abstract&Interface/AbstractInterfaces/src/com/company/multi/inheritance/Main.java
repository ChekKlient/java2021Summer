package com.company.multi.inheritance;



/**
 * Created by Администратор on 27.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        Transport transport = new ArmoredVehicle(90 , false);
        ((GroundTransport)transport).move();
        ((WaterTransport)transport).move();

        transport = new UBoat(true);
        transport.move();
    }
}
