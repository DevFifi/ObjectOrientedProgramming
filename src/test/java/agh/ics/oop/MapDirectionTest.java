package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    public void next_returns_east() {
        assertEquals(MapDirection.East, MapDirection.North.next());
    }

    @Test
    public void next_returns_south() {
        assertEquals(MapDirection.South, MapDirection.East.next());
    }

    @Test
    public void next_returns_west() {
        assertEquals(MapDirection.West, MapDirection.South.next());
    }

    @Test
    public void next_returns_north() {
        assertEquals(MapDirection.North, MapDirection.West.next());
    }

    @Test
    public void previous_returns_west() {
        assertEquals(MapDirection.West, MapDirection.North.previous());
    }

    @Test
    public void previous_returns_north() {
        assertEquals(MapDirection.North, MapDirection.East.previous());
    }

    @Test
    public void previous_returns_east() {
        assertEquals(MapDirection.East, MapDirection.South.previous());
    }

    @Test
    public void previous_returns_south() {
        assertEquals(MapDirection.South, MapDirection.West.previous());
    }
}
