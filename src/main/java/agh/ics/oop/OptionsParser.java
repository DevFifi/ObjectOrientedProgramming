package agh.ics.oop;

import java.util.stream.*;
import java.util.stream.Stream;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        return Stream.of(args)
                .map(moveLabel -> switch (moveLabel) {
                    case "forward", "f" -> MoveDirection.Forward;
                    case "backward", "b" -> MoveDirection.Backward;
                    case "right", "r" -> MoveDirection.Right;
                    case "left", "l" -> MoveDirection.Left;
                    default -> null;
                })
                .filter(moveDirection -> moveDirection != null)
                .toArray(MoveDirection[]::new);
    }
}
