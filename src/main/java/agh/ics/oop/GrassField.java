package agh.ics.oop;

import java.util.*;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{

    private Map<Vector2d, Grass> grasses = new HashMap<>();
    private Vector2d minPos = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d maxPos = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);


    public GrassField(int n){
        Random rng = new Random();
        int i =0;
        while (i<n) {
            Vector2d newPosition = new Vector2d(rng.nextInt((int) Math.sqrt(n * 10)), rng.nextInt((int) Math.sqrt(n * 10)));
            if(!this.isOccupied(newPosition)){
                grasses.put(newPosition,new Grass(newPosition));
                i++;
            }
        }
    }



    public Object objectAt(Vector2d position){
        if(super.objectAt(position)!=null) return super.objectAt(position);
        return grasses.get(position);
    }

    private void updateExtremes(Vector2d newPosition){
        minPos = minPos.lowerLeft(newPosition);
        maxPos = maxPos.upperRight(newPosition);
    }

    public Vector2d[] getExtremes(){
        for (Animal a : animals.values()) {
            minPos = minPos.lowerLeft(a.getPosition());
            maxPos = maxPos.upperRight(a.getPosition());
        }

        for (Grass g: grasses.values()) {
            minPos = minPos.lowerLeft(g.getPosition());
            maxPos = maxPos.upperRight(g.getPosition());
        }
        Vector2d[] coords = {minPos,maxPos};
        return coords;
    }




}
