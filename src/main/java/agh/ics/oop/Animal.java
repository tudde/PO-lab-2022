package agh.ics.oop;
import java.util.*;


public class Animal implements IMapElement{
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap worldMap;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.worldMap = map;
        this.direction = MapDirection.NORTH;
    }
    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public String toString(){
        String res=this.position.toString();
        switch (this.direction) {
            case NORTH -> res+=" N";
            case SOUTH -> res+=" S";
            case EAST -> res+=" E";
            case WEST -> res+=" W";
        }
        return res;
    }


    public boolean isAt(Vector2d pos){
        return position.equals(pos);
    }

    public void move(MoveDirection direction){
        Vector2d newPosition;
        if (direction == MoveDirection.LEFT){
            this.direction = this.direction.previous();
        }
        else if (direction == MoveDirection.RIGHT){
            this.direction = this.direction.next();
        }
        else{
            if (direction == MoveDirection.FORWARD) {
                newPosition = this.position.add(this.direction.toUnitVector());
            }
            else{
                newPosition = this.position.subtract(this.direction.toUnitVector());
            }
            if (worldMap.canMoveTo(newPosition)){
                positionChanged(newPosition);
                this.position= newPosition;
            }
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getDirection(){
        return this.direction;
    }

    public String toImg(){
        return switch(this.direction){
            case NORTH -> "src/main/resources/up.png";
            case SOUTH -> "src/main/resources/down.png";
            case WEST -> "src/main/resources/left.png";
            case EAST -> "src/main/resources/right.png";
        };
    }


    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d newPosition){
        Vector2d oldPosition = position;
        position = newPosition;
        for (IPositionChangeObserver o : observers){
            o.positionChanged(oldPosition, newPosition);
        }
    }
}
