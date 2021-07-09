package com.company;

/**
 * Created by Администратор on 26.01.2016.
 */
public class Addition implements Operation {

    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
