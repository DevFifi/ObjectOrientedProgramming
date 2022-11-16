package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class GrassField extends AbstractWorldMap {
    private int range;

    private List<Grass> grasses;

    @Override
    public MapBounds getMapBounds() {
        return new MapBounds(0,0, this.range-1, this.range-1);
    }

    public GrassField(int grassCount) {
        this.grasses = new ArrayList<>();

        Random rand = new Random();
        this.range = ((int) Math.sqrt(grassCount*10))+1;
        for (int i=0; i<grassCount; i++) {
            Vector2d newPosition = new Vector2d(rand.nextInt(this.range),rand.nextInt(this.range));
            if(this.grasses.stream().anyMatch(grass -> grass.getPosition().equals(newPosition))) {
                i--;
                continue;
            }

            this.grasses.add(new Grass(newPosition));
        }
    }

    public void RespawnGrass(Grass oldGrass) {
        this.grasses.remove(oldGrass);

        Vector2d newPosition;
        Random rand = new Random();
        do {
            newPosition = new Vector2d(rand.nextInt(this.range),rand.nextInt(this.range));
        } while (objectAt(newPosition) != null);
        this.grasses.add(new Grass(newPosition));
    }

    @Override
    public Object objectAt(Vector2d position) {
        List<IMapElement> objectsOnMap = new ArrayList<>();
        objectsOnMap.addAll(this.animals);
        objectsOnMap.addAll(this.grasses);
        return objectsOnMap.stream().filter(obj -> obj.getPosition().equals(position)).findAny().orElse(null);
    }
}
