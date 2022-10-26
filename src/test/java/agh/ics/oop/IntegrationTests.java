package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    @Test
    public void integtation_test_1() {
        String[] args = new String[] {"f", "f", "l", "b", "r", "f" } ;

        Animal animal = new Animal();
        Stream.of(OptionsParser.parse(args)).forEach(moveDirection -> animal.move(moveDirection));

        assertTrue(animal.isAt(new Vector2d(3,4)));
    }

    @Test
    public void integtation_test_2() {
        String[] args = new String[] {"f", "l", "l", "b", "r", "b", "b" } ;

        Animal animal = new Animal();
        Stream.of(OptionsParser.parse(args)).forEach(moveDirection -> animal.move(moveDirection));

        assertTrue(animal.isAt(new Vector2d(4,4)));
    }

    @Test
    public void integtation_test_3() {
        String[] args = new String[] {"l", "forward", "right", "f", "x" , "f", "l", "backward", "l",  "b", "b", "left", "r", "l", "f" } ;

        Animal animal = new Animal();
        Stream.of(OptionsParser.parse(args)).forEach(moveDirection -> animal.move(moveDirection));

        assertTrue(animal.isAt(new Vector2d(3,4)));
    }
}
