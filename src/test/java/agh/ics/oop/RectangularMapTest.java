package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    //expected behavior
    @Test
    void mapTest1(){
        RectangularMap map = new RectangularMap(4,4);

        Vector2d position =new Vector2d(3,3);
        Animal a = new Animal(map, position);

        assertFalse(map.isOccupied(position));
        assertTrue(map.canMoveTo(position));

        assertTrue(map.place(a));

        assertTrue(map.isOccupied(position));
        assertFalse(map.canMoveTo(position));

        assertEquals(a, map.objectAt(position));
    }

    //out of bounds input
    @Test
    void mapTest2(){
        RectangularMap map = new RectangularMap(4,4);
        Vector2d position = new Vector2d(21,37);
        Animal a = new Animal(map,position);

        assertFalse(map.canMoveTo(position));
        assertFalse(map.place(a));

    }
    //tries to place one animal on top of another
    @Test
    void mapTest3(){
        RectangularMap map = new RectangularMap(4,4);
        Vector2d position = new Vector2d(2,2);
        Animal a1 = new Animal(map,position);
        Animal a2 = new Animal(map,position);

        assertTrue(map.place(a1));
        assertFalse(map.place(a2));

        assertEquals(a1,map.objectAt(position));
    }

}