package agh.ics.oop;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.System.out;

public abstract class AbstractWorldMap implements IPositionChangeObserver {
    protected class MapBounds {
        public Vector2d lowerLeft = new Vector2d(0,0);
        public Vector2d upperRight = new Vector2d(9,9);

        public MapBounds(Vector2d lowerLeft, Vector2d upperRight) {
            this.lowerLeft = lowerLeft;
            this.upperRight = upperRight;
        }
        public MapBounds(int left, int bottom, int right, int up) {
            this(new Vector2d(left,bottom), new Vector2d(right, up));
        }
    }
    public abstract MapBounds getMapBounds();

    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position);
    }

    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(this.canMoveTo(animalPosition)) {
            this.animals.put(animalPosition, animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    public abstract Object objectAt(Vector2d position);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.remove(oldPosition);
        if(animal != null)
            this.animals.put(newPosition, animal);
    }

    @Override
    public String toString() {
        MapBounds bounds = this.getMapBounds();
        return new MapVisualizer(this).draw(bounds.lowerLeft, bounds.upperRight);
    }
}