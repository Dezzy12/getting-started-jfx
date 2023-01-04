package com.dezzy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.media.*;
import java.io.File;

public class VideoApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String PATH = "/home/dezzy/Videos/The Invitation (2022) (NetNaija.com).mp4";
        File file = new File(PATH);
        Media media = new Media(file.toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(500);
        mediaView.setFitWidth(700);

        StackPane stackPane = new StackPane(mediaView);

        Scene scene = new Scene(stackPane);
        stage.setScene(scene);
        stage.setTitle(PATH+"-VLC media Player");
        stage.show();
    }
}
