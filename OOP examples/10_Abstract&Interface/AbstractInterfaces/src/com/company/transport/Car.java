package com.company.transport;

/**
 * Created by Администратор on 26.01.2016.
 */
public class Car extends GroundTransport{
    public static final int CITY_LIMIT = 60;

    private boolean inCity;

    public Car(int maxSpeed, boolean inCity) {
        super(maxSpeed);
        //this.maxSpeed = maxSpeed;
        setMaxSpeed(maxSpeed);
        this.inCity = inCity;
    }

    public Car() {
        super();
    }

    @Override
    public int speed() {
        return inCity ? CITY_LIMIT : getMaxSpeed();
    }
}
