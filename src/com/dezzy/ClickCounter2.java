package com.dezzy;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClickCounter2 extends Application {
    public static void main(String[] args){
        launch(args);
    }

    Stage stage;
    int iClickCount;

    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;

        // ClickMe button
        Button btnClickMe = new Button();
        btnClickMe.setText("Click me please!");
        btnClickMe.setOnAction(e -> btnClickMe_Click());

        // Creating the close button
        Button btnClose = new Button();
        btnClose.setText("Close");
        btnClose.setOnAction(e -> btnClose_Click());

        //Adding buttons to layout
        VBox pane = new VBox(10);
        pane.getChildren().addAll(btnClickMe, btnClose);
        pane.setAlignment(Pos.CENTER);

        // Adding layout pane to a scene
        Scene scene = new Scene(pane, 250, 150);

        // Finalizing
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            btnClose_Click();
        });
        primaryStage.show();
    }

    public void btnClickMe_Click(){
        iClickCount++;
        if (iClickCount == 1){
            MessageBox.show("You have clicked once.", "Click!");
        }else{
            MessageBox.show("You have clicked "+ iClickCount + " times.", "Click!");
        }
    }
    public void btnClose_Click(){
        boolean confirm = false;
        confirm = ConfirmationBox.show("Are you sure you want to quit?",
                "Confirmation", "Yes", "No");

        if (confirm){
            //place any code needed to save files or
            // close resources here.

            stage.close();
        }
    }
}
