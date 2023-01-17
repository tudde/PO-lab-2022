package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;


public class App extends Application{


    private GrassField map = new GrassField(10);
    private GridPane grid = new GridPane();
    private Scene scene = new Scene(grid);



    public void start(Stage primaryStage){

        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions,this);



        VBox container = new VBox();
        TextField textField = new TextField();
        Button button = new Button("Move");

        button.setOnAction((event) -> {
            String[] input = textField.getCharacters().toString().split(" ");
            MoveDirection[] newDirections = new OptionsParser().parse(input);
            engine.setMoves(newDirections);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

        container.getChildren().addAll(textField, button);
        container.getChildren().add(grid);

        scene = new Scene(container, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        render();
    }

    public void render(){
        grid.getChildren().clear();
        grid.getRowConstraints().clear();
        grid.getColumnConstraints().clear();
        grid.setGridLinesVisible(false);
        drawGrid();
    }

    private void drawGrid(){
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);

        Vector2d lowerLeft = map.getExtremes()[0];
        Vector2d upperRight= map.getExtremes()[1];


        int size = 40;
        Label yxLabel = new Label("y/x");
        grid.add(yxLabel, 0, 0, 1, 1);
        GridPane.setHalignment(yxLabel, HPos.CENTER);

        for(int i = upperRight.y; i>= lowerLeft.y-1; i--){
            grid.getRowConstraints().add(new RowConstraints(size));
        }
        for(int i = lowerLeft.x; i<=upperRight.x+1; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(size));
        }
        for(int i = upperRight.y; i>= lowerLeft.y; i--){
            Label yLabel = new Label(Integer.toString(i));
            grid.add(yLabel, 0, upperRight.y + 1 - i, 1, 1);
            GridPane.setHalignment(yLabel, HPos.CENTER);
        }
        for(int i = lowerLeft.x; i<=upperRight.x; i++){
            Label xLabel = new Label(Integer.toString(i));
            grid.add(xLabel, i + 1 - lowerLeft.x,0, 1, 1);
            GridPane.setHalignment(xLabel, HPos.CENTER);
        }

        for(int i = lowerLeft.x; i<=upperRight.x; i++){
            for(int j = upperRight.y; j>= lowerLeft.y; j--){
                if(map.isOccupied(new Vector2d(i, j))) {
                    VBox vbox = new GuiElementBox((IMapElement) map.objectAt(new Vector2d(i, j))).getVBox();
                    grid.add(vbox, 1 + i - lowerLeft.x, 1 + upperRight.y - j, 1, 1);
                    GridPane.setHalignment(vbox, HPos.CENTER);

                }
            }
        }
    }
}
