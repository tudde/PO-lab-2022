package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    MoveDirection[] moves;
    IWorldMap worldMap;
    Vector2d[] positions;
    int animalsCount = 0;
    private List<Animal> animals = new ArrayList<Animal>();
    public SimulationEngine(MoveDirection[] moves,IWorldMap map, Vector2d[] positions){
        this.moves=moves;
        this.worldMap=map;
        this.positions=positions;

        for(Vector2d p: positions){
            Animal a=new Animal(map,p);
            animals.add(a);
            map.place(a);
            animalsCount++;
        }
    }

    public Animal getAnimal(int i){
        return animals.get(i);
    }

    @Override
    public void run(){
        for (int i=0; i<moves.length; i++){
            animals.get(i%animalsCount).move(moves[i]);
        }
    }
}
