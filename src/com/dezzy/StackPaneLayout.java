package com.dezzy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class StackPaneLayout extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override public void start(Stage primaryStage){
        Rectangle r1 = new Rectangle(250,250);
        r1.setFill(Color.DARKGRAY);
        Rectangle r2 = new Rectangle(125, 125);
        r2.setFill(Color.LIGHTGRAY);
        StackPane stack = new StackPane(r1, r2);
//        stack.getChildren().addAll(r2, r1);
        Scene scene = new Scene(stack);
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(450);
        primaryStage.setTitle("Rectangles");
        primaryStage.show();

    }
}
