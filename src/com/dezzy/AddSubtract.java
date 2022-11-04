package com.dezzy;

import javafx.application.Application;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddSubtract extends Application
    implements EventHandler <ActionEvent>
{
    public static void main(String[] args){
        launch(args);
    }

    Button btnAdd;
    Button btnSubtract;
    Label label;
    int ICounter = 0;

    @Override
    public void start(Stage stage){
        // Create the Add button
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(this);

        // Create the Subtract button
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(this);

        // Create the Label
        label = new Label();
        label.setText(Integer.toString(ICounter));

        // Add the buttons and label to the HBox pane
        HBox pane = new HBox(10);
        pane.getChildren().addAll(label,btnAdd,btnSubtract);

        // Adding the layout pane to a scene
        Scene scene = new Scene(pane, 200, 75);

        //Finalize and show stage
        stage.setScene(scene);
        stage.setTitle("Add/Sub");
        stage.show();
    }
    @Override public void handle(ActionEvent e){
        if(e.getSource() == btnAdd){
            ICounter++;
        }else{
            if (e.getSource() == btnSubtract){
                ICounter--;
            }
        }
        label.setText(Integer.toString(ICounter));
    }

}
