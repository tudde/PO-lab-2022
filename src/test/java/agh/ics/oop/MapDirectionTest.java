package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class MapDirectionTest {
    @Test
    void NnextE(){
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
    }
    @Test
    void EnextS(){
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
    }
    @Test
    void SnextW(){
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
    }
    @Test
    void WnextN(){
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
    }
    @Test
    void NprevW(){
        assertEquals(MapDirection.NORTH.previous(),MapDirection.WEST);
    }
    @Test
    void EprevN(){
        assertEquals(MapDirection.EAST.previous(),MapDirection.NORTH);
    }
    @Test
    void SprevE(){
        assertEquals(MapDirection.SOUTH.previous(),MapDirection.EAST);
    }
    @Test
    void WprevS(){
        assertEquals(MapDirection.WEST.previous(),MapDirection.SOUTH);
    }

}