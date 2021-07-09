package ua.lamp.entity;

public class Switcher {
    private ElectricityConsumer consumer;

    public void switchOn() {
        System.out.println("Switch ON!");
        if (consumer != null){
            consumer.electricityOn();
        }
    }

    public void switchOff() {
        System.out.println("Switch OFF!");
        if (consumer != null){
            consumer.electricityOff();
        }
    }

    public ElectricityConsumer getConsumer() {
        return consumer;
    }

    public void setConsumer(ElectricityConsumer consumer) {
        this.consumer = consumer;
    }
}
