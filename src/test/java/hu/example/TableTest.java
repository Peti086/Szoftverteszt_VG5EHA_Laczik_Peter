package hu.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TableTest {


    @Test
    void testArea() {
        Table t = new Table(100, 200, 75);
        assertEquals(20000, t.area());
    }

    @Test
    void testGetCapacity() {
        Table t = new Table(120, 180, 75); // Kerület = 600
        assertEquals(10, t.getCapacity());
    }

    @Test
    void testSetHeightAdjustableValid() {
        Table t = new Table(100, 200, 75, 75); // állítható
        t.setHeight(100);
        assertEquals(100, t.getCurrentHeight());
    }

    @Test
    void testSetHeightNotAdjustableThrows() {
        Table t = new Table(100, 200, 75); // nem állítható
        assertThrows(IllegalStateException.class, () -> t.setHeight(100));
    }

    @Test
    void testSetHeightInvalidBoundsThrows() {
        Table t = new Table(100, 200, 75, 75);
        assertThrows(IllegalArgumentException.class, () -> t.setHeight(-1));
        assertThrows(IllegalArgumentException.class, () -> t.setHeight(201));
    }


    @Test
    void testRepaint() {
        Table t = new Table(100, 100, 75, 75, true, "piros", 4);
        t.repaint("kék");
        assertEquals("kék", t.getColor());
    }

    @Test
    void testIsStable() {
        Table stable = new Table(100, 100, 75, 75, true, "piros", 3);
        assertTrue(stable.isStable());

        Table unstable = new Table(100, 100, 75, 75, true, "piros", 2);
        assertFalse(unstable.isStable());
    }

    @Test
    void testIsFoldable() {
        Table foldable = new Table(100, 100, 75, 75, true, "piros", 4);
        assertTrue(foldable.isFoldable());

        Table notAdjustable = new Table(100, 100, 75, 75, false, "piros", 4);
        assertFalse(notAdjustable.isFoldable());

        Table notEnoughLegs = new Table(100, 100, 75, 75, true, "piros", 3);
        assertFalse(notEnoughLegs.isFoldable());
    }

    @Test
    void testGetPerimeter() {
        Table t = new Table(100, 150, 75);
        assertEquals(500, t.getPerimeter());
    }
}
