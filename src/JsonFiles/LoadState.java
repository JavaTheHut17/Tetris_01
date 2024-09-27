package JsonFiles;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class LoadState {

    private int cols;
    private int rows;
    private int gameLvl;
    private boolean musicToggle;
    private boolean soundEffectsToggle;
    private boolean extendedModeToggle;
    private boolean aiPlayToggle;

    public int getCols(){
        return cols;
    }
    public int getRows(){
        return rows;
    }
    public int getgameLvl(){
        return gameLvl;
    }
    public boolean getMusicToggle(){
        return musicToggle;
    }
    public boolean getSoundEffectsToggle(){
        return soundEffectsToggle;
    }
    public boolean getextendedModeToggle(){
        return extendedModeToggle;
    }
    public boolean getaiPlayToggle(){
        return aiPlayToggle;
    }


    public static LoadState LoadFromFile(String filename) {

        Gson gson = new Gson();
        LoadState loadedData = null;

        try (FileReader readData = new FileReader(filename)) {
            loadedData = gson.fromJson(readData, LoadState.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedData;
    }


}
