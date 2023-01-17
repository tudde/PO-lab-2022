package agh.ics.oop;

import java.util.*;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{

    private Map<Vector2d, Grass> grasses = new HashMap<>();
    private Vector2d minPos = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d maxPos = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
    private MapBoundary mapBoundary = new MapBoundary();


    public GrassField(int n){
        spawnGrass(n);
    }

    private void spawnGrass(int n){
        Random rng = new Random();
        int i =0;
        while (i<n) {
            Vector2d newPosition = new Vector2d(rng.nextInt((int) Math.sqrt(n * 10)), rng.nextInt((int) Math.sqrt(n * 10)));
            if(!this.isOccupied(newPosition)){
                Grass g = new Grass(newPosition);
                grasses.put(newPosition,g);
                mapBoundary.add(newPosition);
                i++;
            }
        }

    }


    public boolean place(Animal animal) {
        mapBoundary.add(animal.getPosition());
        animal.addObserver(mapBoundary);
        return super.place(animal);

    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(grasses.containsKey(newPosition)){
            grasses.remove(newPosition);
            spawnGrass(1);
            //System.out.println("touched grass");
        }
        super.positionChanged(oldPosition, newPosition);
    }

    public Object objectAt(Vector2d position){
        if(super.objectAt(position)!=null) return super.objectAt(position);
        return grasses.get(position);
    }



    public Vector2d[] getExtremes(){
//        for (Animal a : animals.values()) {
//            minPos = minPos.lowerLeft(a.getPosition());
//            maxPos = maxPos.upperRight(a.getPosition());
//        }
//        for (Grass g: grasses.values()) {
//            minPos = minPos.lowerLeft(g.getPosition());
//            maxPos = maxPos.upperRight(g.getPosition());
//        }
// Vector2d[] coords = {minPos,maxPos};
        Vector2d[] coords = {mapBoundary.getLowerLeft(),mapBoundary.getUpperRight()}
;        return coords;
    }




}
