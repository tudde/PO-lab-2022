package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animalList = new ArrayList<>();
    private final MapVisualizer visualizer = new MapVisualizer(this);


    public abstract Vector2d[] getExtremes();

    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal){
        if(canMoveTo(animal.getPosition())){
            animalList.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position){
        for( Animal a : animalList ){
            if (a.isAt(position)){
                return a;
            }
        }
        return null;
    }

    public String toString(){
        Vector2d[] coords = getExtremes();
        return visualizer.draw(coords[0],coords[1]);
    }
}
