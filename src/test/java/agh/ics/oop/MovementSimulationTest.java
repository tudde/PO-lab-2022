package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementSimulationTest {

    @Test
    public void movementTest(){
        IWorldMap map = new RectangularMap(10, 5);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(2,0)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(3,4)));
        assertFalse(engine.getAnimal(0).isAt(new Vector2d(3,0)));
        assertFalse(engine.getAnimal(1).isAt(new Vector2d(2,4)));
    }
    @Test
    public void movementTest2(){
        IWorldMap map = new GrassField(10);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(2,3)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(3,3)));
    }


}