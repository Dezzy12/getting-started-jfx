package com.dezzy;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {
    static Stage stage;
    static boolean btnYesClicked;

    public static boolean show(String message, String title, String textYes, String textNo){
        btnYesClicked = false;

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button btnYes = new Button();
        btnYes.setText(textYes);
        btnYes.setOnAction(e -> {
            stage.close();
            btnYesClicked = true;
        });

        Button btnNo = new Button();
        btnNo.setText(textNo);
        btnNo.setOnAction(e -> {
            stage.close();
            btnYesClicked = false;
        });

        HBox paneBtn = new HBox(20);
        paneBtn.getChildren().addAll(btnYes, btnNo);

        VBox pane = new VBox(20);
        pane.getChildren().addAll(label, paneBtn);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
        return btnYesClicked;
    }
}
