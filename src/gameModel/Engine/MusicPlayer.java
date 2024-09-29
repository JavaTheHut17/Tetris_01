package gameModel.Engine;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MusicPlayer implements Runnable {

    private String fileName;
    private AdvancedPlayer player;
    private FileInputStream fileInputStream;
    private Thread playerThread;
    private boolean isPaused = false;
    private int pausedFrame = 0;

    public MusicPlayer(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        try {
            fileInputStream = new FileInputStream(fileName);
            player = new AdvancedPlayer(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            throw new RuntimeException(e);
        } catch (JavaLayerException e) {
            System.out.println("Error initializing player");
            throw new RuntimeException(e);
        }
    }

    // Play MP3
    public void play() {
        if (playerThread != null && playerThread.isAlive()) {
            return;
        }

        playerThread = new Thread(this);
        playerThread.start();
    }

    @Override
    public void run() {
        try {
            if (player == null) {
                init();
            }
            player.play(pausedFrame, Integer.MAX_VALUE); ]
        } catch (JavaLayerException e) {
            System.out.println("Error during playback");
            throw new RuntimeException(e);
        }
    }

    public void pause() {
        if (player != null) {
            player.close();  // Stop the player
            isPaused = true;
            System.out.println("Paused at frame: " + pausedFrame);
        }
    }

}






