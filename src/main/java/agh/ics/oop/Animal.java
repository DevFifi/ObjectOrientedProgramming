package agh.ics.oop;

import static java.lang.System.out;

public class Animal {
    private MapDirection orientation = MapDirection.North;
    private Vector2d position = new Vector2d(2,2);

    public String toString() {
        return String.format("Animal is at %s looking %s", this.position.toString(), this.orientation.toString());
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

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
        if(newPosition.follows(new Vector2d(0,0)) && newPosition.precedes(new Vector2d(4,4))) {
            this.position = newPosition;
        }
    }
}
