package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GuiElementBox {
    private VBox vbox = new VBox(4);

    public GuiElementBox (IMapElement el){
        try {
            Image image = new Image(new FileInputStream(el.toImg()));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);

            vbox.getChildren().add(imageView);

            if(el.toString()!="*"){
                Label label = new Label(el.toString());
                vbox.getChildren().add(label);
            }

            vbox.setAlignment(Pos.CENTER);
        }
        catch(FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }

    public VBox getVBox(){
        return vbox;
    }
}
