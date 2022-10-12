package agh.ics.oop;

public enum MapDirection {
    North,
    South,
    West,
    East;

    public String toString() {
        return switch (this) {
            case North -> "Północ";
            case South -> "Południe";
            case West -> "Zachód";
            case East -> "Wschód";
        };
    }

    public MapDirection next() {
        return switch (this) {
            case North -> East;
            case South -> West;
            case West -> North;
            case East -> South;
        };
    }

    public MapDirection previous() {
        return switch (this) {
            case North -> West;
            case South -> East;
            case West -> South;
            case East -> North;
        };
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case North -> new Vector2d(0,1);
            case South -> new Vector2d(0,-1);
            case West -> new Vector2d(-1,0);
            case East -> new Vector2d(1,0);
        };
    }
}
