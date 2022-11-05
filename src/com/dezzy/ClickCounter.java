package com.dezzy;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ClickCounter extends Application {
    public static void main(String[] args){
        launch(args);
    }

    Button btn;
    Label label;
    int iClickCount = 0;

    @Override
    public void start(Stage primaryStage){
        // Create button
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

        // Create label
        label = new Label();
        label.setText("You have not clicked the button.");

        // Add the label and the button to the layout pane
        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250,150);

        // Finalize and show stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");
        primaryStage.show();
    }
    public void buttonClick(){
        iClickCount++;
        if (iClickCount == 1){
            MessageBox.show("You have clicked once.", "Click!");
        }else{
            MessageBox.show("You have clicked " + iClickCount + " times." , "Click!");
        }
    }

}
