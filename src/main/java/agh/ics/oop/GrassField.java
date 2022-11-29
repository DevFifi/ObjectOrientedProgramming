package agh.ics.oop;

import java.util.*;

import static java.lang.System.out;

public class GrassField extends AbstractWorldMap {
    private int range;

    private Map<Vector2d, Grass> grasses;

    @Override
    public MapBounds getMapBounds() {
        return new MapBounds(0,0, this.range-1, this.range-1);
    }

    public GrassField(int grassCount) {
        this.grasses = new HashMap<>();

        Random rand = new Random();
        this.range = ((int) Math.sqrt(grassCount*10))+1;
        for (int i=0; i<grassCount; i++) {
            Vector2d newPosition = new Vector2d(rand.nextInt(this.range),rand.nextInt(this.range));
            if(this.grasses.get(newPosition) != null) {
                i--;
                continue;
            }

            this.grasses.put(newPosition, new Grass(newPosition));
        }
    }

    public void RespawnGrass(Grass oldGrass) {
        this.grasses.remove(oldGrass);

        Vector2d newPosition;
        Random rand = new Random();
        do {
            newPosition = new Vector2d(rand.nextInt(this.range),rand.nextInt(this.range));
        } while (objectAt(newPosition) != null);
        this.grasses.put(newPosition, new Grass(newPosition));
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object objectAtPosition = this.animals.get(position);
        if(objectAtPosition == null)
            objectAtPosition = this.grasses.get(position);
        return objectAtPosition;
    }
}
