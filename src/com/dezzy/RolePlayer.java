package com.dezzy;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class RolePlayer extends Application {
    public static void main(String[] args){
        launch(args);
    }

    TextField txtCharacter;
    TextField txtActor;

    @Override public void start (Stage stage){
        // Create the character
        Label labelCharacter = new Label("Character's Name:");
        labelCharacter.setMinWidth(100);
        labelCharacter.setAlignment(Pos.BOTTOM_RIGHT);

        //Create the character text field
        txtCharacter = new TextField();
        txtCharacter.setMinWidth(200);
        txtCharacter.setMaxWidth(200);
        txtCharacter.setPromptText("Enter the name of the character here.");

        // Create the Actor label
        Label labelActor = new Label("Actors Name:");
        labelActor.setMinWidth(100);
        labelActor.setAlignment(Pos.BOTTOM_RIGHT);

        // Create the actor text field
        txtActor = new TextField();
        txtActor.setMinWidth(200);
        txtActor.setMaxWidth(200);
        txtActor.setPromptText("Enter the name of the actor here.");

        //Create the role labels
        Label labelRole1 = new Label("The role of ");
        Label labelRole2 = new Label();
        Label labelRole3 = new Label(" will be played by ");
        Label labelRole4 = new Label();

        // Create the Character pane
        HBox paneCharacter = new HBox(20, labelCharacter, txtCharacter);
        paneCharacter.setPadding(new Insets(10));

        // Create the Actor pane
        HBox paneActor = new HBox(20, labelActor, txtActor);
        paneActor.setPadding(new Insets(10));

        // Create the Role pane
        HBox paneRole = new HBox(labelRole1,labelRole2,labelRole3,labelRole4);
        paneRole.setPadding(new Insets(10));

        // Add the Character and Actor panes to a VBox
        VBox pane = new VBox(10, paneCharacter,paneActor,paneRole);

        // Create the bindings
        labelRole2.textProperty().bind(txtCharacter.textProperty());
        labelRole4.textProperty().bind(txtActor.textProperty());


        //set the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Role Player");
        stage.show();

    }

}
