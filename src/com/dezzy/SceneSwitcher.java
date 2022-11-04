package com.dezzy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class SceneSwitcher extends Application {
    public static void main(String[] args){
        launch(args);
    }
    // fields for scene 1
    int iClickCount = 0;
    Label labelClicks;
    Button btnClickMe;
    Button btnSwitchToScene2;
    Scene scene1;

    // fields for scene 2
    int iCounter = 0;
    Label labelCounter;
    Button btnAdd;
    Button btnSubtract;
    Button btnSwitchToScene1;
    Scene scene2;

    // field for the stage
    Stage stage;
    @Override
    public void start (Stage primaryStage){
        stage = primaryStage;

        //Click-Counter scene
        labelClicks = new Label();
        labelClicks.setText("You have not clicked the button.");

        btnClickMe = new Button();
        btnClickMe.setText("Click me please!");
        btnClickMe.setOnAction(e -> btnClickMe_Click());

        btnSwitchToScene2 = new Button();
        btnSwitchToScene2.setText("Switch!");
        btnSwitchToScene2.setOnAction(e -> btnSwitchToScene2_Click());

        VBox pane1  = new VBox(10);
        pane1.getChildren().addAll(labelClicks,btnClickMe,btnSwitchToScene2);

        scene1 = new Scene(pane1, 250,150);

        // the add/subtract scene
        labelCounter = new Label();
        labelCounter.setText(Integer.toString(iCounter));

        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e -> btnAdd_Click());

        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> btnSubtract_Click());

        btnSwitchToScene1 = new Button();
        btnSwitchToScene1.setText("Switch!");
        btnSwitchToScene1.setOnAction(e -> btnSwitchToScene1_Clicks());

        HBox pane2 = new HBox(10);
        pane2.getChildren().addAll(labelCounter,btnAdd,btnSubtract,btnSwitchToScene1);

        scene2 = new Scene(pane2, 300, 75);

        // Set the stage with scene 1 and show the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switcher");
        primaryStage.show();
    }

    // Event handlers for scene 1
    public void btnClickMe_Click(){
        iClickCount++;
        if (iClickCount == 1){
            labelClicks.setText("You have clicked once.");
        }else{
            labelClicks.setText("You have clicked " + iClickCount + " times");
        }
    }
    private void btnSwitchToScene2_Click(){
        stage.setScene(scene2);
    }

    // Event handlers for scene 2
    private void btnAdd_Click(){
        iCounter++;
        labelCounter.setText(Integer.toString(iCounter));
    }
    private void btnSubtract_Click(){
        iCounter--;
        labelCounter.setText(Integer.toString(iCounter));
    }
    private void btnSwitchToScene1_Clicks(){
        stage.setScene(scene1);
    }
}
