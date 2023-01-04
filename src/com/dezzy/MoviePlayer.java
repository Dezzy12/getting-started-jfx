package com.dezzy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.io.File;
import java.net.MalformedURLException;

public class MoviePlayer extends Application {
    private Media media;

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FileChooser fileChooser = new FileChooser();

            /*
            fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(
                    "Videos", "*.mp4"
            ));
             */

            Label label = new Label("no files selected");
            Button button = new Button("Open file");

            HBox openFileHBox = new HBox(5, label, button);

            button.setOnAction(actionEvent -> {
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try {
                        Scene scene = new Scene(constructPreviewPane(
                                primaryStage,
                                openFileHBox,
                                file.toURI().toURL().toString())
                        );
                        String fileName = file.getName();
                        primaryStage.setTitle(fileName + " - Dreezy media Player");
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            BorderPane previewBorderPane = constructPreviewPane(primaryStage,  openFileHBox, "");

            Scene scene = new Scene(previewBorderPane);
            primaryStage.setMinWidth(640);
            primaryStage.setMinHeight(480);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Dreezy media Player");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private BorderPane constructPreviewPane(Stage stage, HBox openFileHBox, String mediaFilePath) {
        BorderPane previewBorderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        try {
            this.media = new Media(mediaFilePath);

            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);


            MediaView mediaView = new MediaView(mediaPlayer);

            mediaView.setFitHeight(stage.getHeight() * 8);
            mediaView.setPreserveRatio(true);
            mediaView.setFitWidth(stage.getWidth() * 8);

            mediaView.setSmooth(true);
            mediaView.setCache(true);
            stackPane.getChildren().add(mediaView);

            MediaBar mediaBar =  new MediaBar(mediaPlayer);
            previewBorderPane.setBottom(mediaBar);

            stage.heightProperty().addListener((observableValue, number, t1) -> {
                mediaView.setFitHeight(observableValue.getValue().doubleValue());
            });
            stage.widthProperty().addListener((observableValue, number, t1) -> {
                mediaView.setFitWidth(observableValue.getValue().doubleValue());
            });
        } catch (IllegalArgumentException e) {
            stackPane.getChildren().add(new Label("No Media Selected!"));
        }

        previewBorderPane.setCenter(stackPane);
        previewBorderPane.setTop(openFileHBox);

        return previewBorderPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
