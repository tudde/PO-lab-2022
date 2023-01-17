package agh.ics.oop;

public class Grass implements IMapElement{
    public Vector2d position;
    public Grass(Vector2d position){
        this.position=position;
    }

    public String toImg() {
        return "src/main/resources/grass.png";
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return "*";
    }
}
