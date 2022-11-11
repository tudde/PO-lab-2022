package agh.ics.oop;

public class World {
    public static void main(String[] args) {


        Animal a = new Animal();

        MoveDirection[] commands = OptionsParser.parse(args);
        for(MoveDirection dir : commands){
            a.move(dir);
        }

    }

}