package agh.ics.oop;

import java.util.ArrayList;

import agh.ics.oop.gui.App;
import java.util.List;
import javafx.application.Platform;

public class SimulationEngine implements IEngine,Runnable {
    MoveDirection[] moves;
    IWorldMap worldMap;
    Vector2d[] positions;
    App app;
    int animalsCount = 0;
    private List<Animal> animals = new ArrayList<Animal>();
    public SimulationEngine(MoveDirection[] moves,IWorldMap map, Vector2d[] positions, App app){
        this.app=app;
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

    public void setMoves(MoveDirection[] moves){
        this.moves=moves;
    }


    public void run(){
        int delay=300;
        try {
            Platform.runLater(() -> {
                this.app.render();
            });
            Thread.sleep(delay);

            for (int i=0; i<moves.length; i++){
                animals.get(i%animalsCount).move(moves[i]);
                Platform.runLater(() -> {
                    this.app.render();
                });
                Thread.sleep(delay);

            }

                Thread.sleep(delay);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
