package com.dezzy;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PhotoGallery extends Application {
    public static void main(String[] args){
        launch(args);
    }

    Stage stage;
    private final String PATH = "/home/dezzy/Pictures/Wallpapers";

    @Override public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        ScrollPane root = new ScrollPane();
        TilePane tile = new TilePane();
        root.setStyle("-fx-background-color: DAE6F3;");
        root.setPadding(new Insets(15,15,15,15));
        tile.setHgap(15);

        File dir = new File(PATH);
        File[] files = dir.listFiles();

        for(File file : files){
            ImageView imageView;
            imageView = createImageView(file);
            tile.getChildren().addAll(imageView);
        }

        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setFitToWidth(true);
        root.setContent(tile);

        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());

        Scene scene = new Scene(root);
        primaryStage.setTitle("Photo Viewer - "+ PATH);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView createImageView(File imageFile){
        ImageView imageView = null;
        try{
            Image image = new Image(new FileInputStream(imageFile),200, 0, true, true);

            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2){
                        try{
                            BorderPane borderPane = new BorderPane();
                            ImageView imageView = new ImageView();
                            Image image = new Image(new FileInputStream(imageFile));
                            imageView.setImage(image);
                            imageView.setFitHeight(stage.getHeight() - 20);
                            imageView.setPreserveRatio(true);
                            imageView.setSmooth(true);
                            imageView.setCache(true);
                            borderPane.setCenter(imageView);
                            Stage currPic = new Stage();
                            currPic.setWidth(stage.getWidth());
                            currPic.setHeight(stage.getHeight());
                            currPic.setTitle(imageFile.getName());
                            Scene scene = new Scene(borderPane, Color.BLACK);
                            currPic.setScene(scene);
                            currPic.show();
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
            });
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return imageView;
    }
}
