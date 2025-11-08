package test.tuples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.tuples.Point;

public class PointTest {
    @Test
    public void testCreation() {
        Point point = new Point(4.3, -4.2, 3.1);

        assertEquals(4.3, point.x);
        assertEquals(-4.2, point.y);
        assertEquals(3.1, point.z);
        assertEquals(1.0, point.w);
    }
}