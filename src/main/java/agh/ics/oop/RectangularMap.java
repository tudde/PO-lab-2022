package agh.ics.oop;
public class RectangularMap extends AbstractWorldMap{
    private final int width, height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Vector2d position){
        return  position.precedes(new Vector2d(width-1, height-1))
                && position.follows(new Vector2d(0,0))
                && super.canMoveTo(position);

    }
    public Vector2d getLowerLeft(){
        return new Vector2d(0,0);
    }
    public Vector2d getUpperRight(){
        return new Vector2d(width-1,height-1);
    }


}
