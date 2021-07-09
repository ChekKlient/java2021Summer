package ua.kpi.tef;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Point p1 = new Point(3,4);
        p1.setAllParameters(4,5);
        Point p2 = p1.clone();

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.hashCode() == p2.hashCode() );

        System.out.println("==============================");
        p1.getHistory().get(0).setX(100500);
        System.out.println(p1.getHistory());
        System.out.println(p2.getHistory());

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.hashCode() == p2.hashCode() );

    }
}
