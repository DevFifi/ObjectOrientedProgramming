package agh.ics.oop;


import java.util.stream.*;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");

        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        out.println(position2);
        out.println(position1.add(position2));

        World.run(World.getDirections(args));

        out.println("Stop");
    }

    private static Stream<MoveDirection> getDirections(String[] moveLabels) {
        return Stream.of(moveLabels)
                .map(moveLabel -> switch (moveLabel) {
                    case "f" -> MoveDirection.Forward;
                    case "b" -> MoveDirection.Backward;
                    case "r" -> MoveDirection.Right;
                    case "l" -> MoveDirection.Left;
                    default -> null;
                })
                .filter(moveDirection -> moveDirection != null);
    }

    private static void printMoveLabels(String[] moveLabels) {
        String text = "";
        for (String moveLabel : moveLabels)
            text += moveLabel + ", ";
        if (moveLabels.length > 0)
            text = text.substring(0, text.length() - 2);
        out.println(text);
    }

    public static void run(Stream<MoveDirection> directions) {
        directions.forEach(moveDirection -> out.println("Zwierzak " + switch(moveDirection) {
            case Forward -> "idzie do przodu";
            case Backward -> "idzie do tyłu";
            case Right -> "skręca w prawo";
            case Left -> "skręca w lewo";
        }));
    }
}
