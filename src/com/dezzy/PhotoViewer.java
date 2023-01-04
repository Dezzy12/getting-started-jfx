package com.dezzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class PhotoViewer extends Application {
    public static void main(String[] args){
        launch(args);
    }

    private final String PATH = "/home/dezzy/Pictures/Wallpapers";

    @Override public void start(Stage primaryStage){
        TilePane tile = new TilePane();
        tile.setHgap(20);
        tile.setVgap(20);
        tile.setPadding(new Insets(20));
        tile.setPrefColumns(4);

        File dir = new File(PATH);
        File[] files = dir.listFiles();
        for(File f : files){
            Image img = new Image(f.toURI().toString(),200,200,true,true);

            ImageView iview = new ImageView(img);
            iview.setFitWidth(200);
            iview.setFitHeight(200);
            iview.setPreserveRatio(true);

            Text txt = new Text(f.getName());
            txt.setFont(new Font("Times New Roman", 16));

            Region spacer = new Region();

            VBox box = new VBox(10, iview, spacer, txt);
            box.setVgrow(spacer, Priority.ALWAYS);
            box.setAlignment(Pos.CENTER);

            tile.getChildren().add(box);
        }

        ScrollPane scroll = new ScrollPane(tile);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setFitToWidth(true);


        Scene scene = new Scene(scroll);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Photo Viewer - "+ PATH);
        primaryStage.show();
    }
}
