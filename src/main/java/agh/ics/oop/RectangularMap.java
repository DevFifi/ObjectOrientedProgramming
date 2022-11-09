package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;

    private List<Animal> animals;

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;

        this.animals = new ArrayList<>();
    }

    public Vector2d getLowerLeft() {
        return new Vector2d(0,0);
    }
    public Vector2d getUpperRight() {
        return new Vector2d(this.width-1, this.height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.follows(this.getLowerLeft()) && position.precedes(this.getUpperRight()))
            return !this.isOccupied(position);
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.stream().anyMatch(animal -> animal.isAt(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals.stream().filter(animal -> animal.isAt(position)).findAny().orElse(null);
    }

    public String toString() {
        return new MapVisualizer(this).draw(this.getLowerLeft(), this.getUpperRight());
    }
}
