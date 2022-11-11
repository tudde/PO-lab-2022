package agh.ics.oop;

import java.util.Map;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);

    }

    public String toString(){
        return this.direction.toString()+" "+this.position.toString();
    }
    public boolean isAt(Vector2d pos){
        return position.equals(pos);
    }
    public void move(MoveDirection direction){
        int newx;
        int newy;
        Vector2d moveVector;
        switch(direction){

            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:

                moveVector = this.direction.toUnitVector();
                newx = this.position.x+moveVector.x;
                newy = this.position.y+ moveVector.y;
                if (newx>=0 && newx<=4 && newy>=0 && newy<=4){
                    this.position= new Vector2d(newx, newy);
                }
                break;
            case BACKWARD:

                moveVector = this.direction.toUnitVector().opposite();
                newx = this.position.x+moveVector.x;
                newy = this.position.y+ moveVector.y;
                if (newx>=0 && newx<=4 && newy>=0 && newy<=4){
                    this.position= new Vector2d(newx, newy);
                }
                break;
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getDirection(){
        return this.direction;
    }





}
