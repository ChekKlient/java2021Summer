package ua.kpi.tef;

import java.util.ArrayList;

/**
 * Created by User on 30.03.2016.
 */
public class Point implements Cloneable {
    private double x;
    private double y;
    private ArrayList<Point> history = new ArrayList<>();

    public Point() {
        // x = y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setAllParameters (double x, double y){
        history.add(new Point(getX() , getY()) );
        this.x = x;
        this.y = y;
    }

    public void moveCoordinate (double dX, double dY){
        history.add(new Point(getX() , getY()) );
        this.x += dX;
        this.y += dY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ArrayList<Point> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Point> history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        if (Double.compare(point.y, y) != 0) return false;
        return history != null ? history.equals(point.history) : point.history == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (history != null ? history.hashCode() : 0);
        return result;
    }

    @Override
    public Point clone() {
        try{
            //return super.clone();
            Point temp = (Point)super.clone();
            //reference type MUST HAVE be cloned
            temp.history = (ArrayList<Point>)this.history.clone();
            return temp;
        }catch ( CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
