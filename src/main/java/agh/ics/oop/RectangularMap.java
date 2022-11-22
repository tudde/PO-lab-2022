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

    public Vector2d[] getExtremes(){
        Vector2d[] coords = {new Vector2d(0,0),new Vector2d(width-1,height-1)};
        return coords;
    }


}
