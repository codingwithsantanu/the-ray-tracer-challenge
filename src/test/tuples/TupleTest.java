package test.tuples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.tuples.Tuple;
import main.tuples.Vector;
import main.tuples.Point;

public class TupleTest {
    @Test
    public void testCreation() {
        Tuple tuple = new Tuple(4.3, -4.2, 3.1, 1.0);

        assertEquals(4.3, tuple.x);
        assertEquals(-4.2, tuple.y);
        assertEquals(3.1, tuple.z);
        assertEquals(1.0, tuple.w);
    }

    @Test
    public void testEquality() {
        Tuple a = new Tuple(1.0, 2.0, 3.0, 4.0);
        Tuple b = new Tuple(1.0, 2.0, 3.0, 4.0);
        Tuple c = new Tuple(5.0, 6.0, 7.0, 8.0);

        assertEquals(a, b);
        assertNotEquals(a, c);
    }

    @Test
    public void testConversion() {
        Tuple tuple = new Tuple(1.0, 2.0, 3.0, 4.0);
        Vector vector = new Vector(1.0, 2.0, 3.0);
        Point point = new Point(1.0, 2.0, 3.0);

        assertEquals(vector, tuple.toVector());
        assertEquals(point, tuple.toPoint());
    }

    @Test
    public void testTypeHelpers() {
        Tuple vector = new Tuple(1.0, 2.0, 3.0, 0.0);
        assertTrue(vector.isVector());
        assertFalse(vector.isPoint());

        Tuple point = new Tuple(1.0, 2.0, 3.0, 1.0);
        assertTrue(point.isPoint());
        assertFalse(point.isVector());
    }

    @Test
    public void testAddition() {
        Tuple a = new Tuple(3.0, -2.0, 5.0, 1.0);
        Tuple b = new Tuple(-2.0, 3.0, 1.0, 0.0);

        Tuple expected = new Tuple(1.0, 1.0, 6.0, 1.0);
        assertEquals(expected, a.add(b));
    }

    @Test
    public void testSubtractionOfTwoPoints() {
        Tuple a = new Tuple(3.0, 2.0, 1.0, 1.0);
        Tuple b = new Tuple(5.0, 6.0, 7.0, 1.0);

        Tuple expected = new Tuple(-2.0, -4.0, -6.0, 0.0);
        assertEquals(expected, a.subtract(b));
    }

    @Test
    public void testSubtractionOfTwoVectors() {
        Tuple a = new Tuple(3.0, 2.0, 1.0, 0.0);
        Tuple b = new Tuple(5.0, 6.0, 7.0, 0.0);

        Tuple expected = new Tuple(-2.0, -4.0, -6.0, 0.0);
        assertEquals(expected, a.subtract(b));
    }

    @Test
    public void testSubtractionOfPointAndVector() {
        Tuple a = new Tuple(3.0, 2.0, 1.0, 1.0);
        Tuple b = new Tuple(5.0, 6.0, 7.0, 0.0);

        Tuple expected = new Tuple(-2.0, -4.0, -6.0, 1.0);
        assertEquals(expected, a.subtract(b));
    }

    @Test
    public void testNegation() {
        Tuple a = new Tuple(1.0, -2.0, 3.0, -4.0);
        Tuple expected = new Tuple(-1.0, 2.0, -3.0, 4.0);
        assertEquals(expected, a.negate());
        assertEquals(expected, Vector.ZERO.subtract(a));
    }

    @Test
    public void testMultiplication() {
        Tuple a = new Tuple(1.0, -2.0, 3.0, -4.0);
        Tuple b = new Tuple(3.5, -7.0, 10.5, -14);
        assertEquals(a.multiply(3.5), b);

        Tuple x = new Tuple(1.0, -2.0, 3.0, -4.0);
        Tuple y = new Tuple(0.5, -1.0, 1.5, -2.0);
        assertEquals(x.multiply(0.5), y);
    }

    @Test
    public void testDivision() {
        Tuple a = new Tuple(1.0, -2.0, 3.0, -4.0);
        Tuple expected = new Tuple(0.5, -1.0, 1.5, -2.0);
        assertEquals(expected, a.divide(2.0));
    }
}