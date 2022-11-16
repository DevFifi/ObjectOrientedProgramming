package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

import static java.lang.System.out;

public abstract class AbstractWorldMap {
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

    protected List<Animal> animals = new ArrayList<>();

    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position);
    }

    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return this.animals.stream().anyMatch(animal -> animal.isAt(position));
    }

    public abstract Object objectAt(Vector2d position);

    @Override
    public String toString() {
        MapBounds bounds = this.getMapBounds();
        return new MapVisualizer(this).draw(bounds.lowerLeft, bounds.upperRight);
    }
}