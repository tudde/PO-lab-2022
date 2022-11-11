package agh.ics.oop;
import java.util.*;

public class RectangularMap implements IWorldMap{
    private final int width, height;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Vector2d position){
        return  position.precedes(new Vector2d(width-1, height-1))
                && position.follows(new Vector2d(0,0))
                && !(this.isOccupied(position));

    }

    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position){
        for( Animal a : animals ){
            if (a.isAt(position)){
                return a;
            }
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }
}
