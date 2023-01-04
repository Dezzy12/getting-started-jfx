package com.dezzy;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.control.*;
import javafx.util.Duration;

public class MediaBar extends HBox {
    //introducing different controls
    Slider timeSlider = new Slider();
    Slider volumeSlider = new Slider();
    Button playButton = new Button("||"); //pausing
    Label volume = new Label("Volume: ");
    MediaPlayer player;

    public void setupVolume() {
        volumeSlider.setPrefWidth(70);
        volumeSlider.setPrefWidth(30);
        volumeSlider.setValue(100);
        // Volume slider
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (volumeSlider.isPressed()){
                    player.setVolume(volumeSlider.getValue() / 100);
                }
            }
        });

    }

    public void setupTimeSlider() {

        timeSlider.valueProperty().addListener(observable -> {
            if (timeSlider.isPressed()){//sets video to the new time
                player.seek(Duration.seconds(timeSlider.getValue()));
            }
        });
    }

    public void setupPlayButton() {
        //Function to play the media player
        playButton.setPrefWidth(30);

        playButton.setOnAction(actionEvent -> {
            Status status = player.getStatus();
            if (status == Status.PLAYING){
                //While playing
                if (player.getCurrentTime().greaterThanOrEqualTo(
                        player.getTotalDuration()
                )){
                    // If the player is at the end of the video
                    player.seek(player.getStartTime());
                    player.play();//restarts the video
                }else{
                    // Pausing the video
                    player.pause();
                    playButton.setText(">");
                }


            }
            // If video is paused or stopped
            if(status == Status.HALTED || status == Status.STOPPED || status == Status.PAUSED){
                player.play();
                playButton.setText("||");
            }
        });
    }

    public void setupMediaBar() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(5,10,5,10));

        HBox.setHgrow(timeSlider, Priority.ALWAYS);


        //Adding components
        this.getChildren().add(playButton);
        this.getChildren().add(timeSlider);
        this.getChildren().add(volume);
        this.getChildren().add(volumeSlider);
    }
    
    public MediaBar(MediaPlayer mediaPlayer){ //Default constructor
        player = mediaPlayer;

        this.setupMediaBar();
        this.setupVolume();
        this.setupTimeSlider();
        this.setupPlayButton();

        //time Slider functionality
        player.currentTimeProperty().addListener(this::updateValues);

        player.setOnReady(this::onMediaLoaded);

    }

    public void onMediaLoaded() {
        timeSlider.maxProperty().bind(Bindings.createDoubleBinding(
                () -> player.getTotalDuration().toSeconds(),
                player.totalDurationProperty())
        );
    }
    protected void updateValues(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1){
        Platform.runLater(() -> {
            timeSlider.setValue(observableValue.getValue().toSeconds());
        });
    }
}
