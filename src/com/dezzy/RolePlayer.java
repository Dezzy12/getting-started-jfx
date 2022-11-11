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
        Label labelCharacter = new Label("Character's Name: ");
        labelCharacter.setMinWidth(100);
        labelCharacter.setAlignment(Pos.BOTTOM_RIGHT);

        //Create the character text field
        txtCharacter = new TextField();
        txtCharacter.setMinWidth(200);
        txtCharacter.setMaxWidth(200);
        txtCharacter.setPromptText("Enter the name of the character here.");

        // Create the Actor label
        Label labelActor = new Label("Actors Name: ");
        labelActor.setMinWidth(100);
        labelActor.setAlignment(Pos.BOTTOM_RIGHT);

        // Create the actor text field
        txtActor = new TextField();
        txtActor.setMinWidth(200);
        txtActor.setMaxWidth(200);
        txtActor.setPromptText("Enter the name of the actor here.");

        // Create the OK button
        Button btnOK = new Button("OK");
        btnOK.setMinWidth(75);
        btnOK.setOnAction(e -> btnOK_Click());

        // Create the Character pane
        HBox paneCharacter = new HBox(20,labelCharacter,txtCharacter);
        paneCharacter.setPadding(new Insets(10));

        // Create the actor pane
        HBox paneActor = new HBox(20, labelActor,txtActor);
        paneActor.setPadding(new Insets(10));

        // Create the Button pane
        HBox paneButton = new HBox(20, btnOK);
        paneButton.setPadding(new Insets(10));
        paneButton.setAlignment(Pos.BOTTOM_RIGHT);

        //Add the character, actor, button panes to VBox
        VBox pane = new VBox(10,paneCharacter,paneActor, paneButton);

        //set the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Role Player");
        stage.show();

    }
    public void btnOK_Click(){
        String errorMessage = "";
        if(txtCharacter.getText().length() == 0){
            errorMessage += "\nCharacter is a required field.";

        }
        if (txtActor.getText().length() == 0){
            errorMessage += "\nActor is a required field.";
        }
        if (errorMessage.length() == 0){
            String message = "The role of "+ txtCharacter.getText()+ " will be played by "+ txtActor.getText()+".";
            MessageBox.show(message, "Cast");
        }else {
            MessageBox.show(errorMessage,"Missing Data");
        }
    }
}
