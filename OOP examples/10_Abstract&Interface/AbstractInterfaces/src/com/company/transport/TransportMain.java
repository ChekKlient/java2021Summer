package com.company.transport;

/**
 * Created by Администратор on 26.01.2016.
 */
public class TransportMain {
    public static void main(String[] args) {
        Transport transport = new Car(150 , false);
        transport.move();
        System.out.println("speed = " + transport.speed());
        transport = new UBoat(true);
        transport.move();
        System.out.println("speed = " + transport.speed());
        ((UBoat)transport).setUnderWater(false);
        transport.move();
        System.out.println("speed = " + transport.speed());

    }
}
