package com.dezzy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddSubtract2 extends Application {
    // Uses Lambda expression to handle the button clicks.

    public static void main(String[] args){
        launch(args);
    }

    Button btnAdd;
    Button btnSubtract;
    Label label;
    int iCounter = 0;

    @Override
    public void start(Stage stage){
        // Create the Add button
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e -> {
            iCounter++;
            label.setText(Integer.toString(iCounter));
        });

        // Create Subtract button
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> {
            iCounter--;
            label.setText(Integer.toString(iCounter));
        });

        // Create the label
        label = new Label();
        label.setText(Integer.toString(iCounter));

        //Add buttons
        HBox pane = new HBox(10);
        pane.getChildren().addAll(label, btnAdd, btnSubtract);

        //Add layout pane to a scene
        Scene scene = new Scene(pane, 200, 75);

        //Finalize and show
        stage.setScene(scene);
        stage.setTitle("Add/Sub");
        stage.show();
    }
}
