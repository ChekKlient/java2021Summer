package ua.kpi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Point point = new Point();
        point.setX(3);
        point.setY(5);
        int coordinateX = point.getX();
        int coordinateY = point.getY();

        point.setDoubleX(4.);
        point.setDoubleY(7.);
        double coordinateDoubleX = point.getDoubleX();
        double coordinateDoubleY = point.getDoubleY();
    }
}
