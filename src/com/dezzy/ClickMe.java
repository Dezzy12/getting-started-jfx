package com.dezzy;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClickMe extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Button btn;
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

        StackPane pane = new StackPane();
        pane.getChildren().add(btn);
        stage.setTitle("The Click Me App");
        stage.setScene(new Scene(pane, 300, 250));
        stage.show();

    }
    public void buttonClick(){
        System.out.println("Been clicked");
    }
    public static void main(String[] args){
        launch(args);
    }

}
