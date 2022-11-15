package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    //expected behavior
    @Test
    void mapTest1(){
        GrassField map = new GrassField(10);

        Vector2d position =new Vector2d(3,3);
        Animal a = new Animal(map, position);

        assertFalse(map.isOccupied(position));
        assertTrue(map.canMoveTo(position));

        assertTrue(map.place(a));

        assertTrue(map.isOccupied(position));
        assertFalse(map.canMoveTo(position));

        assertEquals(a, map.objectAt(position));
    }

    //tries to place one animal on top of another
    @Test
    void mapTest2(){
        GrassField map = new GrassField(10);
        Vector2d position = new Vector2d(2,2);
        Animal a1 = new Animal(map,position);
        Animal a2 = new Animal(map,position);

        assertTrue(map.place(a1));
        assertFalse(map.place(a2));

        assertEquals(a1,map.objectAt(position));
    }
    //places animal Very Far^tm
    @Test
    void mapTest3(){
        GrassField map = new GrassField(10);
        Vector2d position =new Vector2d(6291,-43270);
        Animal a = new Animal(map, position);

        assertTrue(map.place(a));

    }

}