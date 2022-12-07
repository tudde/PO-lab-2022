package agh.ics.oop;
import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    private final MapVisualizer visualizer = new MapVisualizer(this);



    public abstract Vector2d[] getExtremes();

    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal){
        if(canMoveTo(animal.getPosition())){
            animal.addObserver(this);
            animals.put(animal.getPosition(),animal);

            return true;
        }
        else
            throw new IllegalArgumentException("cannot place animal at position "+ animal.getPosition().toString());
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
    public Object objectAt(Vector2d position){
        return animals.get(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal a = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,a);

    }

    public String toString(){
        Vector2d[] coords = getExtremes();
        return visualizer.draw(coords[0],coords[1]);
    }
}
