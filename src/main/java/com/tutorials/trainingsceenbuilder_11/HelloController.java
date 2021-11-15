package com.tutorials.trainingsceenbuilder_11;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private MediaView myMediaView;

    @FXML
    private Button returnButton,playButton,pauseButton,
            increaseButton,muteButton,resetButton,volUpButton,volDownButton;

    @FXML
    private Slider volumeSlider;

    private File mediaFile;
    private Media media;
    private MediaPlayer mediaPlayer;

    private double volume = 1.0,slider;
    private Duration duration;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaFile = new File("src/main/resources/sadasdas.mp4");
        media = new Media(mediaFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        myMediaView.setMediaPlayer(mediaPlayer);

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                slider = volumeSlider.getValue();
                mediaPlayer.setVolume(slider);
            }
        });
    }

    public void returnMedia(){
        duration = mediaPlayer.getCurrentTime().subtract(Duration.seconds(2));
        mediaPlayer.seek(duration);
    }

    public void increaseMedia(){
        duration = mediaPlayer.getCurrentTime().add(Duration.seconds(2));
        mediaPlayer.seek(duration);
    }

    public void playMedia(){
        mediaPlayer.play();
    }

    public void pauseMedia(){
        mediaPlayer.pause();
    }

    public void muteMedia(){
        if(!mediaPlayer.isMute()) {
            mediaPlayer.setMute(true);
        }else{
            mediaPlayer.setMute(false);
        }
    }

    public void resetMedia(){
        duration = Duration.seconds(0.0);
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY)
            mediaPlayer.seek(duration);
    }

    public void volumeUp(){
        if(mediaPlayer.getVolume() != 1.0){
            volume += 0.2;
            mediaPlayer.setVolume(volume);
            System.out.println(mediaPlayer.getVolume());

        }
    }

    public void volumeDown(){
        if(mediaPlayer.getVolume() != 0.0){
            volume -= 0.2;
            mediaPlayer.setVolume(volume);
            System.out.println(mediaPlayer.getVolume());
        }
    }
}