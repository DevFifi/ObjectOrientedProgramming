package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    @Test
    public void rect_map_test() {
        String args = "f b r l SUSPICIOUS_MOVE f f r r f f f f f f f f";

        MoveDirection[] directions = new OptionsParser().parse(args.split(" "));
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(-1, 5), new Vector2d(2, 2), new Vector2d(3, 4)};

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2,0)) && map.isOccupied(new Vector2d(3,4)));
    }

    @Test
    public void grass_field_test() {
        String args = "f b r l SUSPICIOUS_MOVE f f r r f f f f f f";

        MoveDirection[] directions = new OptionsParser().parse(args.split(" "));
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(-1, 5), new Vector2d(2, 2), new Vector2d(3, 4)};

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(-1,8)) && map.isOccupied(new Vector2d(4,2)) && map.isOccupied(new Vector2d(6,4)));
    }
}
