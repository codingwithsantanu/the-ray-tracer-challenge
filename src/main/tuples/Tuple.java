package main.tuples;

import main.tuples.Vector;
import main.tuples.Point;
import main.utils.Utils;

public class Tuple {
    public double x;
    public double y;
    public double z;
    public double w;
    // NOTE: Here, w indicates whether an instance is a Vector or a Point.
    // 0.0 means it is a Vector, and 1.0 means it is a Point.

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Tuple{" + "x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + '}';
    }

    public boolean equals(Object object) {
        if (!(object instanceof Tuple tuple)) {
            return false;
        }
        return Utils.equals(x, tuple.x) &&
               Utils.equals(y, tuple.y) &&
               Utils.equals(z, tuple.z) &&
               Utils.equals(w, tuple.w);
    }

    public Vector toVector() {
        return new Vector(x, y, z);
    }

    public Point toPoint() {
        return new Point(x, y, z);
    }

    public boolean isVector() {
        return w == 0.0;
    }

    public boolean isPoint() {
        return w == 1.0;
    }

    public Tuple add(Tuple tuple) {
        return new Tuple(
            x + tuple.x,
            y + tuple.y,
            z + tuple.z,
            w + tuple.w
        );
    }

    public Tuple subtract(Tuple tuple) {
        return new Tuple(
            x - tuple.x,
            y - tuple.y,
            z - tuple.z,
            w - tuple.w
        );
    }

    public Tuple negate() {
        return new Tuple(-x, -y, -z, -w);
    }

    public Tuple multiply(double scalar) {
        return new Tuple(
            x * scalar,
            y * scalar,
            z * scalar,
            w * scalar
        );
    }

    public Tuple divide(double scalar) {
        return new Tuple(
            x / scalar,
            y / scalar,
            z / scalar,
            w / scalar
        );
    }
}