package ua.kpi;

/**
 * Created by User1 on 26.02.2016.
 */
public class Point {
    private /*int*/ double x;
    private /*int*/ double y;

    public double getDoubleX() {
        return x;
    }

    public void setDoubleX(double x) {
        this.x = x;
    }

    public double getDoubleY() {
        return y;
    }

    public void setDoubleY(double y) {
        this.y = y;
    }

    public int getX() {
        return (int)x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return (int)y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
