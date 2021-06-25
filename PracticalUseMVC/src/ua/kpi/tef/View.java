package ua.kpi.tef;

/**
 * Created by User on 17.03.2016.
 */
public class View {
    // Text's constants
    public static final String INPUT_DATA = "Input 2 values <Hello> <world!> ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String OUR_SENTENCE = "Result sentence value = ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndValue(String message, String value){
        System.out.println(message + value);
    }

}
