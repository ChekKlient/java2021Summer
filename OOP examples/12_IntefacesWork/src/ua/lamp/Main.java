package ua.lamp;

import ua.lamp.entity.Lamp;
import ua.lamp.entity.Switcher;

public class Main {
    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();

        //event subscribe
        sw.setConsumer(lamp);

        sw.switchOn();
        sw.switchOff();

    }
}
