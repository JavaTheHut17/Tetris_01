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

    // Initialize the player with a new FileInputStream
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

    // Play the MP3 file
    public void play() {
        if (playerThread != null && playerThread.isAlive()) {
            return;  // Prevent restarting if already playing
        }

        playerThread = new Thread(this);
        playerThread.start();
    }

    // Main run method for the thread to play the music
    @Override
    public void run() {
        try {
            if (player == null) {
                init();  // Initialize player if not already done
            }
            player.play(pausedFrame, Integer.MAX_VALUE);  // Start from the paused frame
        } catch (JavaLayerException e) {
            System.out.println("Error during playback");
            throw new RuntimeException(e);
        }finally {
            cleanup();
        }
    }

    public void pause() {
        if (player != null) {
//            pausedFrame = player.getPosition();  // Save the current frame position
            player.close();  // Stop the player
            cleanup();
            isPaused = true;
            System.out.println("Paused at frame: " + pausedFrame);
        }
    }

    private void cleanup() {
        try {
            if (fileInputStream != null) {
                fileInputStream.close();  // Close input stream
            }
        } catch (IOException e) {
            System.out.println("Error cleaning up resources: " + e.getMessage());
            e.printStackTrace();
        }
    }
}






