package ua.kpi.tef;

/**
 * Created by User on 05.04.2016.
 */
public abstract class Operation {
    public abstract int calculate(int valueA, int valueB);

    public static void printOperation( Operation op , int a, int b ){
        System.out.println(op.calculate(a,b));
    }
}
