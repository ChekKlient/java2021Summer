package Calculation;

public class Arithmetics {
    public double add(double firstValue, double secondVaule){
        return firstValue + secondVaule ;
    }
    public double mult(double firstValue, double secondVaule){
        return firstValue * secondVaule ;
    }
    public double deduct(double firstValue, double secondVaule){
        return firstValue - secondVaule ;
    }
    public double div(double firstValue, double secondVaule){
        if (secondVaule == 0) throw new ArithmeticException();
        return firstValue / secondVaule ;
    }
}
