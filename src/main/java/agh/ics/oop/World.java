package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(enumize(args));
        System.out.println("system zakończył działanie");
    }
    public static Direction[] enumize(String[] args){
        Direction[] res = new Direction[args.length];
        int i=0;
        for(String x : args){
            switch(x){
                case "f":
                    res[i]=Direction.FORWARD;
                    break;
                case "b":
                    res[i]=Direction.BACKWARD;
                    break;
                case "r":
                    res[i]=Direction.RIGHT;
                    break;
                case "l":
                    res[i]=Direction.LEFT;
                    break;
                default:
                    res[i]=Direction.INVALID;
                    break;
            }
            i++;
        }
        return res;
    }
    public static void run(Direction[] args){
        System.out.println("Start");
        for(Direction x : args){
            switch(x){
                case FORWARD:
                        System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                        System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    break;
            }

        }
        System.out.println("Stop");

    }



}