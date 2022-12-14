package com.dezzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ScrolledTile extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override public void start(Stage primaryStage){
        TilePane tile1 = new TilePane();
        tile1.setHgap(10);
        tile1.setVgap(10);
        tile1.setPadding(new Insets(10,10,10,10));
        tile1.setPrefColumns(4);
        for(int i = 1; i < 13; i++){
            Rectangle r = new Rectangle(100,100);
            r.setFill(Color.LIGHTGRAY);
            Label label = new Label("A-" + i);
            StackPane s = new StackPane(r, label);
            tile1.getChildren().add(s);

        }
        ScrollPane spane = new ScrollPane(tile1);
        spane.setMinWidth(250);
        spane.setPrefWidth(250);
        spane.setMaxHeight(290);
        spane.setPrefHeight(400);
        spane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        StackPane stack = new StackPane(spane);
        stack.setMargin(spane, new Insets(40,40,40,40));

        Scene scene = new Scene(stack);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scrolled Tiles");
        primaryStage.show();
    }
}
