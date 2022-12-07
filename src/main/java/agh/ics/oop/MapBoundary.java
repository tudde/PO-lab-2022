package agh.ics.oop;
import java.util.*;


public class MapBoundary implements IPositionChangeObserver{
    private TreeSet<Vector2d> xOrder= new TreeSet<>((a, b) -> {
        if(a.x == b.x){
            return a.y-b.y;
        }
        return a.x - b.x;
    });
    private TreeSet<Vector2d> yOrder = new TreeSet<>((a, b) -> {
        if(a.y == b.y){
            return a.x - b.x;
        }
        return a.y-b.y;
    });

    public void add(Vector2d v){
        xOrder.add(v);
        yOrder.add(v);
    }

    public void remove(Vector2d v){
        xOrder.remove(v);
        yOrder.remove(v);

    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if (!xOrder.isEmpty()){
            remove(newPosition);
        }
        add(newPosition);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(xOrder.first().x, yOrder.first().y);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(xOrder.last().x, yOrder.last().y);

    }


}
