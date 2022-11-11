package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    Vector2d a;
    Vector2d b;
    Vector2d c;
    Vector2d d;
    Vector2d e;

    public Vector2dTest(){
        this.a = new Vector2d(1,0);
        this.b = new Vector2d(1,0);
        this.c = new Vector2d(0,1);
        this.d = new Vector2d(2,3);
        this.e = new Vector2d(0,0);
    }
    @Test
    void equalsTest(){
        assertEquals(a,b);
    }
    @Test
    void toStringTest(){
        assertEquals(a.toString(),"(1,0)");
    }

    @Test
    void precedesTest(){
        assertTrue(a.precedes(b));
        assertFalse(a.precedes(c));
        assertTrue(a.precedes(d));
        assertFalse(a.precedes(e));
    }

    @Test
    void followsTest(){
        assertTrue(a.follows(b));
        assertFalse(a.follows(c));
        assertFalse(a.follows(d));
        assertTrue(a.follows(e));
    }

    @Test
    void upperRightTest(){
        assertEquals(a.upperRight(c), new Vector2d(1,1));
        assertEquals(a.upperRight(d), new Vector2d(2,3));
        assertEquals(a.upperRight(e), new Vector2d(1,0));

    }

    @Test
    void lowerLeftTest(){
        assertEquals(a.lowerLeft(c), new Vector2d(0,0));
        assertEquals(a.lowerLeft(d), new Vector2d(1,0));
        assertEquals(a.lowerLeft(e), new Vector2d(0,0));

    }

    @Test
    void addTest(){
        assertEquals(a.add(b), new Vector2d(2,0));
        assertEquals(a.add(c), new Vector2d(1,1));
        assertEquals(a.add(d), new Vector2d(3,3));
    }

    @Test
    void subtractTest(){
        assertEquals(a.subtract(b), new Vector2d(0,0));
        assertEquals(a.subtract(c), new Vector2d(1,-1));
        assertEquals(a.subtract(d), new Vector2d(-1,-3));
    }

    @Test
    void oppositeTest(){
        assertEquals(a.opposite(), new Vector2d(-1,0));
        assertEquals(c.opposite(), new Vector2d(0,-1));
        assertEquals(d.opposite(), new Vector2d(-2,-3));
    }



}