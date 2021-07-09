package com.company.transport;

/**
 * Created by Администратор on 26.01.2016.
 */
public abstract class GroundTransport implements Transport {
    private int maxSpeed;

    public GroundTransport() {
        maxSpeed = 60;
    }

    public GroundTransport(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move() {
        System.out.println("we are moving by ground");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
