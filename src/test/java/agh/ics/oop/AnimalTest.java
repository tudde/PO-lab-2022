package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void AnimalDirTest() {
        Animal a = new Animal(new RectangularMap(4,4),new Vector2d(2,2));

        a.move(MoveDirection.RIGHT);
        assertEquals(a.getDirection(), MapDirection.EAST);
        a.move(MoveDirection.RIGHT);
        assertEquals(a.getDirection(), MapDirection.SOUTH);
        a.move(MoveDirection.RIGHT);
        assertEquals(a.getDirection(), MapDirection.WEST);
        a.move(MoveDirection.LEFT);
        assertEquals(a.getDirection(), MapDirection.SOUTH);

    }

    @Test
    void AnimalMoveTest(){
        Animal a = new Animal(new RectangularMap(5,5),new Vector2d(2,2));
        a.move(MoveDirection.FORWARD);
        assertEquals(a.getPosition(),new Vector2d(2,3));
        a.move(MoveDirection.BACKWARD);
        assertEquals(a.getPosition(),new Vector2d(2,2));
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.RIGHT);
        a.move(MoveDirection.FORWARD);

        assertEquals(a.getPosition(),new Vector2d(3,3));
        assertEquals(a.getDirection(), MapDirection.EAST);

        a.move(MoveDirection.FORWARD);
        assertEquals(a.getPosition(),new Vector2d(4,3));
        a.move(MoveDirection.RIGHT);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.RIGHT);

        assertEquals(a.getPosition(),new Vector2d(4,1));
        assertEquals(a.getDirection(), MapDirection.SOUTH);

        a.move(MoveDirection.RIGHT);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);

        assertEquals(a.getPosition(),new Vector2d(1,1));
        assertEquals(a.getDirection(), MapDirection.WEST);

        a.move(MoveDirection.RIGHT);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.BACKWARD);
        a.move(MoveDirection.BACKWARD);

        assertEquals(a.getPosition(),new Vector2d(3,2));
        assertEquals(a.getDirection(), MapDirection.WEST);


    }

}