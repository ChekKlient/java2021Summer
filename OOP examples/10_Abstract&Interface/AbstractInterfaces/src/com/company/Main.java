package com.company;

public class Main {
/*    private static void printOperation( Operation op , int a, int b ){
        System.out.println(op.calculate(a,b));
    }*/

    public static void main(String[] args) {
	// write your code here
        int a = 3;
        int b = 5;
        Operation operation = new Addition();
        Operation.printOperation(operation , a, b);
        operation = new Multiplication();
        Operation.printOperation(operation ,a,b);
        operation = new Division();
        Operation.printOperation(operation, a,b);




    }
}
