package com.dezzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class TilePaneLayout extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override public void start(Stage primaryStage){
        TilePane tile = new TilePane();
        tile.setHgap(10);
        tile.setVgap(10);
        tile.setPadding(new Insets(10,10,10,10));
        tile.setPrefColumns(4);
        for(int i = 1; i < 13; i++){
            Rectangle r = new Rectangle(100,100);
            r.setFill(Color.LIGHTGRAY);
            Label label = new Label("A-" + i);
            StackPane s = new StackPane(r, label);
            tile.getChildren().add(s);

        }
        Scene scene = new Scene(tile);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tiles");
        primaryStage.show();
    }
}
