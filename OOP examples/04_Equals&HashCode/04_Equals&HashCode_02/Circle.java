package ua.kpi.tef;

/**
 * Created by User on 25.03.2016.
 */
public class Circle extends Point{
    private double radius;

    public Circle(double radius) {
        checkRadius(radius);
    }

    public Circle(double x, double y, double radius) {
        super(x, y);
        checkRadius(radius);
    }

    //@Override
    public void setAllParameters(double x, double y, double radius) {
        super.setAllParameters(x, y);
        setRadius(radius);
    }

    @Override
    public void moveCoordinate(double dX, double dY) {
        super.moveCoordinate(dX, dY);
    }

    public final void checkRadius(double radius) throws IllegalArgumentException {
        if( radius <= 0 ){
            throw new IllegalArgumentException("radius must be greater then 0");
        }
        this.radius = radius;
    }

    public void setRadius(double radius) {
        checkRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                super.toString()+
                "radius=" + radius +
                '}';
    }
}
