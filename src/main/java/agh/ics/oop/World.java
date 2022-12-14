package agh.ics.oop;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");

        if(args == null || args.length == 0)
            args = "f b r r f f SUSPICIOUS_MOVE f l f r r f f f l r f f f f f".split(" ");

        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        out.println(map.toString());
        engine.run();
        out.println(map.toString());

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