package com.company.multi.inheritance;

/**
 * Created by Администратор on 27.01.2016.
 */
public interface WaterTransport extends Transport {
    @Override
    default void move(){
        System.out.println("we are sailing");
    }
}
