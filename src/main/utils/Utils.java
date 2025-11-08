package main.utils;

public abstract class Utils {
    private static final double EPSILON = 1e-5;

    private Utils() {
    }

    public static boolean equals(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }
}