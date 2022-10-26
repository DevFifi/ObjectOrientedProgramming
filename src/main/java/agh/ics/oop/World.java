package agh.ics.oop;


import javax.swing.text.html.Option;
import java.util.stream.*;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");

        Animal animal = new Animal();
        out.println(animal.toString());
        run(Stream.of(OptionsParser.parse(args)));
        Stream.of(OptionsParser.parse(args)).forEach(moveDirection -> animal.move(moveDirection));
        out.println(animal.toString());

        out.println("Stop");
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
        directions.forEach(moveDirection -> out.println("Animal " + switch(moveDirection) {
            case Forward -> "goes forward";
            case Backward -> "goes backwards";
            case Right -> "turns right";
            case Left -> "turns left";
        }));
    }
}
