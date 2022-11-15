package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animalList = new ArrayList<>();

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();

    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
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
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(getLowerLeft(),getUpperRight());
    }
}
