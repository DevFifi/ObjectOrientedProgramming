package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTtest {
    @Test
    public void equals_identical_vectors() {
        assertTrue(new Vector2d(0,4).equals(new Vector2d(0,4)));
    }

    @Test
    public void equals_different_vectors() {
        assertFalse(new Vector2d(0,4).equals(new Vector2d(4,0)));
    }

    @Test
    public void equals_different_types() {
        assertFalse(new Vector2d(0,4).equals(5));
    }

    @Test
    public void toString_returns_correct_string_vector() {
        assertEquals("(0,4)", new Vector2d(0,4).toString());
    }

    @Test
    public void precedes_returns_true() {
        assertTrue(new Vector2d(1,2).precedes(new Vector2d(5,6)));
    }

    @Test
    public void precedes_returns_false() {
        assertFalse(new Vector2d(1,10).precedes(new Vector2d(5,6)));
    }

    @Test
    public void follows_returns_true() {
        assertTrue(new Vector2d(15,70).follows(new Vector2d(15,6)));
    }

    @Test
    public void follows_returns_false() {
        assertFalse(new Vector2d(1,2).follows(new Vector2d(5,6)));
    }

    @Test
    public void upperRight_returns_upperRight() {
        assertEquals(new Vector2d(-2,5),new Vector2d(-2, -1).upperRight(new Vector2d(-5,5)));
    }

    @Test
    public void lowerLeft_returns_lowerLeft() {
        assertEquals(new Vector2d(0,0), new Vector2d(0,10).lowerLeft(new Vector2d(17,0)));
    }

    @Test
    public void add_returns_sum() {
        assertEquals(new Vector2d(100,25), new Vector2d(69,0).add(new Vector2d(31,25)));
    }

    @Test
    public void subtract_returns_difference() {
        assertEquals(new Vector2d(-1,-2), new Vector2d(5,-1).subtract(new Vector2d(6,1)));
    }

    @Test
    public void opposite_returns_opposite() {
        assertEquals(new Vector2d(5,-3), new Vector2d(-5,3).opposite());
    }
}
