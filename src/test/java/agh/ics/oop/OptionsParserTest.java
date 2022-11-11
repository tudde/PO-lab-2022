package agh.ics.oop;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void parseTest(){
        String[] input={"oo","f","b","backward","forward","r","AAAAAA","l","476","left"};
        MoveDirection[]  output;
        MoveDirection[]  toMatch={
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.LEFT
        };


        output=OptionsParser.parse(input);

        assertArrayEquals(output,toMatch);
    }

}