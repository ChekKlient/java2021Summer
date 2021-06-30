package org.itstep;

public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_RANGE_DATA = "Wrong input! Repeat please! ";
     public static final String WRONG_INPUT_DATA =
                                        "Wrong input! Repeat please! ";
    public static final String OUR_INT = "INT value = ";
     public static final String INPUT_MORE_THEN_CODE = "Value more then code";
    public static final String INPUT_LESS_THEN_CODE = "Value less then code";
    public static final String INPUT_EQUAL_CODE = "Value equal to code";
    public static final String NUMBER_ATTEMPTS = "You use next attempts:";
    public static final String ATTEMPT = "Your attempt number ";
    public static final String IS = " is ";

    public void printMessage(String message){
        System.out.println(message);
    }

}
