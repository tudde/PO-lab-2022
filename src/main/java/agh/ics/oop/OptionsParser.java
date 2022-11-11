package agh.ics.oop;


import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] input) {
        MoveDirection[] parsed = new MoveDirection[input.length];
        int i=0;
        for (String str : input) {
            switch(str){
                case "b":
                    parsed[i]=MoveDirection.BACKWARD;
                    i++;
                    break;
                case "backward":
                    parsed[i]=MoveDirection.BACKWARD;
                    i++;
                    break;
                case "f":
                    parsed[i]=MoveDirection.FORWARD;
                    i++;
                    break;
                case "forward":
                    parsed[i]=MoveDirection.FORWARD;
                    i++;
                    break;
                case "r":
                    parsed[i]=MoveDirection.RIGHT;
                    i++;
                    break;
                case "right":
                    parsed[i]=MoveDirection.RIGHT;
                    i++;
                    break;
                case "l":
                    parsed[i]=MoveDirection.LEFT;
                    i++;
                    break;
                case "left":
                    parsed[i]=MoveDirection.LEFT;
                    i++;
                    break;
                default:
                    break;
            }




        }
        MoveDirection[] res = new MoveDirection[i];
        res= Arrays.copyOfRange(parsed,0,i);

        return res;
    }
}
