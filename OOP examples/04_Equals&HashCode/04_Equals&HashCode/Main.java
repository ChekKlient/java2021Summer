package ua.kpi.tef;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Circle circle1 = new Circle(3., 4., 3.5);
        Circle circle2 = new Circle(3., 4., 3.5);

        System.out.println(circle1 == circle2);
        System.out.println(circle1.equals(circle2));
        System.out.println(circle1.hashCode() == circle2.hashCode() );
        System.out.println(circle1.hashCode());
        System.out.println(circle2.hashCode());
    }
}
