package agh.ics.oop;


import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] input) {
        MoveDirection[] parsed = new MoveDirection[input.length];
        int i=0;
        for (String str : input) {
            switch(str){
                case "b","backward":
                    parsed[i]=MoveDirection.BACKWARD;
                    i++;
                    break;

                case "f","forward":
                    parsed[i]=MoveDirection.FORWARD;
                    i++;
                    break;
                case "r","right":
                    parsed[i]=MoveDirection.RIGHT;
                    i++;
                    break;

                case "l","left":
                    parsed[i]=MoveDirection.LEFT;
                    i++;
                    break;

                default:
                    throw new IllegalArgumentException(str + " is not legal move specification");
            }

        }

        return Arrays.copyOfRange(parsed,0,i);

    }
}
