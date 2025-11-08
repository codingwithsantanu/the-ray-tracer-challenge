package main.tuples;

import main.utils.Utils;

public class Vector extends Tuple {
    public final static Vector ZERO = new Vector(0.0, 0.0, 0.0);

    public Vector(double x, double y, double z) {
        super(x, y, z, 0.0);
    }

    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public double magnitude() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector normalize() {
        double mag = magnitude();
        if (Utils.equals(mag, 0.0)) {
            throw new ArithmeticException("Can't normalize a zero vector.");
        }
        return new Vector(
            x / mag,
            y / mag,
            z / mag
        );
    }

    public double dot(Vector vector) {
        return (
            x * vector.x +
            y * vector.y +
            z * vector.z
        );
    }

    public Vector cross(Vector vector) {
        return new Vector(
            y * vector.z - z * vector.y,
            z * vector.x - x * vector.z,
            x * vector.y - y * vector.x
        );
    }
}