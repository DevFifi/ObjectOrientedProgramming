package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public MapBounds getMapBounds() {
        return new MapBounds(0,0, this.width-1, this.height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        MapBounds bounds = this.getMapBounds();
        if(position.follows(bounds.lowerLeft) && position.precedes(bounds.upperRight))
            return super.canMoveTo(position);
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals.get(position);
    }
}
