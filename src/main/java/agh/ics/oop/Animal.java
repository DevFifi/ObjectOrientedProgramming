package agh.ics.oop;

import static java.lang.System.out;

public class Animal implements IMapElement {

    private AbstractWorldMap map;
    private MapDirection orientation = MapDirection.North;
    private Vector2d position;

    public Animal(AbstractWorldMap map)
    {
        this(map, new Vector2d(2,2));
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition)
    {
        this.position = initialPosition;

        if(map.place(this))
            this.map = map;
    }

    public String toString() {
        return switch (this.orientation) {
            case North -> "^";
            case East -> ">";
            case South -> "v";
            case West -> "<";
        };
        // return String.format("Animal is at %s looking %s", this.position.toString(), this.orientation.toString());
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    // MY ADDITIONAL METHODS
    public boolean isOnTheMap() {
        return this.map != null;
    }

    public Vector2d getPosition() {
        return this.position;
    }
    // END OF MY ADDITIONAL METHODS

    public void move(MoveDirection direction) {
        Vector2d moveVector = new Vector2d(0,0);
        switch (direction) {
            case Forward:
                moveVector = this.orientation.toUnitVector();
                break;
            case Backward:
                moveVector = this.orientation.toUnitVector().opposite();
                break;
            case Right:
                this.orientation = this.orientation.next();
                break;
            case Left:
                this.orientation = this.orientation.previous();
                break;
        }

        if(moveVector.equals(new Vector2d(0,0)))
            return;

        Vector2d newPosition = this.position.add(moveVector);

        if(!this.isOnTheMap() || this.map.canMoveTo(newPosition)) {
            if(this.map instanceof GrassField) {
                Object objectOnNewPosition = this.map.objectAt(newPosition);
                if (objectOnNewPosition != null && objectOnNewPosition instanceof Grass)
                    ((GrassField)this.map).RespawnGrass((Grass)objectOnNewPosition);
            }
            this.position = newPosition;
        }
    }
}
