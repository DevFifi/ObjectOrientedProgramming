package agh.ics.oop;


import java.util.*;
import java.util.stream.*;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        World.run(World.getDirections(args));
        out.println("Stop");
    }

    private static Stream<Direction> getDirections(String[] moveLabels) {
        return Stream.of(moveLabels)
                .map(moveLabel -> switch (moveLabel) {
                    case "f" -> Direction.Forward;
                    case "b" -> Direction.Backward;
                    case "r" -> Direction.Right;
                    case "l" -> Direction.Left;
                    default -> null;
                })
                .filter(direction -> direction != null);
    }

    private static void printMoveLabels(String[] moveLabels) {
        String text = "";
        for (String moveLabel : moveLabels)
            text += moveLabel + ", ";
        if (moveLabels.length > 0)
            text = text.substring(0, text.length() - 2);
        out.println(text);
    }

    public static void run(Stream<Direction> directions) {
        directions.forEach(direction -> out.println("Zwierzak " + switch(direction) {
            case Forward -> "idzie do przodu";
            case Backward -> "idzie do tyłu";
            case Right -> "skręca w prawo";
            case Left -> "skręca w lewo";
        }));
    }
}
