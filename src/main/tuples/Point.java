package main.tuples;

public class Point extends Tuple {
    public Point(double x, double y, double z) {
        super(x, y, z, 1.0);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}