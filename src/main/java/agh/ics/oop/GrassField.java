package agh.ics.oop;

import java.util.*;
import java.lang.Math;

public class GrassField implements IWorldMap{

    private List<Grass> grassList = new ArrayList<Grass>();
    private List<Animal> animalList = new ArrayList<Animal>();
    private Vector2d minPos = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d maxPos = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);


    public GrassField(int n){
        Random rng = new Random();
        int i =0;
        while (i<n) {
            Vector2d newPosition = new Vector2d(rng.nextInt((int) Math.sqrt(n * 10)), rng.nextInt((int) Math.sqrt(n * 10)));
            if(!this.isOccupied(newPosition)){
                grassList.add(new Grass(newPosition));
                updateExtremes(newPosition);
                i++;
            }

        }

    }
    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);

    }

    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
            animalList.add(animal);
            updateExtremes(animal.getPosition());

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
        for( Grass g : grassList ){
            if (g.position.equals(position)){
                return g;
            }
        }
        return null;
    }
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(minPos,maxPos);

    }
    private void updateExtremes(Vector2d newPosition){
        minPos = new Vector2d(Math.min(minPos.x, newPosition.x),Math.min(minPos.y, newPosition.y));
        maxPos = new Vector2d(Math.max(maxPos.x, newPosition.x),Math.max(maxPos.y, newPosition.y));
    }

}
