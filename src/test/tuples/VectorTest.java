package test.tuples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.tuples.Vector;

public class VectorTest {
    @Test
    public void testCreation() {
        Vector vector = new Vector(4.3, -4.2, 3.1);

        assertEquals(4.3, vector.x);
        assertEquals(-4.2, vector.y);
        assertEquals(3.1, vector.z);
        assertEquals(0.0, vector.w);
    }

    @Test
    public void testMagnitude() {
        Vector a = new Vector(1.0, 0.0, 0.0);
        Vector b = new Vector(0.0, 1.0, 0.0);
        Vector c = new Vector(0.0, 0.0, 1.0);
        Vector d = new Vector(1.0, 2.0, 3.0);
        Vector e = new Vector(-1.0, -2.0, -3.0);

        assertEquals(1.0, a.magnitude());
        assertEquals(1.0, b.magnitude());
        assertEquals(1.0, c.magnitude());
        assertEquals(Math.sqrt(14.0), d.magnitude());
        assertEquals(Math.sqrt(14.0), e.magnitude());
    }

    @Test
    public void testDivision() {
        Vector a = new Vector(4.0, 0.0, 0.0);
        Vector b = new Vector(1.0, 0.0, 0.0);

        Vector x = new Vector(1.0, 2.0, 3.0);
        Vector y = new Vector(
            1.0 / Math.sqrt(14),
            2.0 / Math.sqrt(14),
            3.0 / Math.sqrt(14)
        );

        assertThrows(ArithmeticException.class, Vector.ZERO::normalize);
        assertEquals(b, a.normalize());
        assertEquals(y, x.normalize());
    }

    @Test
    public void testDotProduct() {
        Vector a = new Vector(1.0, 2.0, 3.0);
        Vector b = new Vector(2.0, 3.0, 4.0);
        assertEquals(20.0, a.dot(b));
    }

    @Test
    public void testCrossProduct() {
        Vector a = new Vector(1.0, 2.0, 3.0);
        Vector b = new Vector(2.0, 3.0, 4.0);

        Vector x = new Vector(-1.0, 2.0, -1.0);
        Vector y = x.negate().toVector();
        assertEquals(x, a.cross(b));
        assertEquals(y, b.cross(a));
    }
}