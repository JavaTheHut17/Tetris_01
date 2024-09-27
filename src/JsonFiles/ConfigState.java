package JsonFiles;

import ui.Screens.ConfigureScreen;

public class ConfigState {

private int cols;
private int rows;
private int gameLvl;
private boolean musicToggle;
private boolean soundEffectsToggle;
private boolean extendedModeToggle;
private boolean aiPlayToggle;



public ConfigState() {

    ConfigureScreen CFS = new ConfigureScreen();
   int cols = CFS.getCols();
   int rows = CFS.getRows();
   int gameLvl = CFS.getgameLvl();
   boolean musicToggle = CFS.getMusicToggle();
   boolean soundEffectsToggle = CFS.getSoundEffectsToggle();
   boolean extendedModeToggle = CFS.getextendedModeToggle();
   boolean aiPlayToggle = CFS.getaiPlayToggle();


   this.cols = cols;
   this.rows = rows;
   this.gameLvl = gameLvl;
   this.musicToggle = musicToggle;
   this.soundEffectsToggle = soundEffectsToggle;
   this.extendedModeToggle = extendedModeToggle;
   this.aiPlayToggle = aiPlayToggle;






}
    public void setCols(int cols){
        this.cols = cols;
    }

    public void setRows(int rows){
        this.rows = rows;
    }
    public void setgameLvl(int gameLvl){
        this.gameLvl = gameLvl;
    }
    public void setMusicToggle(boolean musicToggle){
        this.musicToggle = musicToggle;
    }

    public void setSoundEffectsToggle(boolean soundEffectsToggle){
        this.soundEffectsToggle = soundEffectsToggle;
    }
    public void setextendedModeToggle(boolean extendedModeToggle){
        this.extendedModeToggle = extendedModeToggle;
    }
    public void setaiPlayToggle(boolean aiPlayToggle){
        this.aiPlayToggle = aiPlayToggle;
    }

}
