package ua.lamp.entity;

public class Lamp implements ElectricityConsumer{

    private void lightOn() {
        System.out.println("Lamp ON!");
    }
    private void lightOff() {
        System.out.println("Lamp OFF!");
    }

    @Override
    public void electricityOn() {
        lightOn();
    }

    @Override
    public void electricityOff() {
        lightOff();
    }


}
