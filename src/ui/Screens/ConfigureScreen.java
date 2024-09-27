package ui.Screens;

import JsonFiles.ConfigState;
import JsonFiles.LoadState;
import JsonFiles.SaveState;
import gameModel.Engine.MusicPlayer;
import gameModel.Engine.NavigationEngine;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class ConfigureScreen extends   JPanel {


    public int cols;
    public int rows;
    public int gameLvl;
    public boolean musicToggle;
    public boolean soundEffectsToggle;
    public boolean aiPlayToggle;
    public boolean extendedModeToggle;


    public ConfigureScreen() {

////        LoadState loadState = new LoadState();
        MusicPlayer mp = new MusicPlayer("src/Assets/Sound/backgroundMusic.mp3");
//        Thread thread = new Thread(mp);
//            mp.play();
        LoadState ls = LoadState.LoadFromFile("config.json");

        this.cols = ls.getCols();
        this.rows = ls.getRows();
        this.gameLvl = ls.getgameLvl();
        this.musicToggle = ls.getMusicToggle();
        this.soundEffectsToggle = ls.getSoundEffectsToggle();
        this.extendedModeToggle = ls.getextendedModeToggle();
        this.aiPlayToggle = ls.getaiPlayToggle();

        if(musicToggle){
            mp.play();
        }


        //Config
        setVisible(true);
        setLayout(new GridBagLayout());

        //Layout Config
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.LIGHT_GRAY);

        //Title
        JLabel configTitle = new JLabel("Configuration: ");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        configTitle.setFont(new Font("Arial", Font.BOLD, 24));
        add(configTitle, gbc);


        //Field Width Text
        JLabel fieldWidthLabel = new JLabel("Field Width: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldWidthLabel, gbc);

        //Field Width Slider
        JSlider fieldWidthSlider = new JSlider(JSlider.HORIZONTAL, 5, 15, cols);
        fieldWidthSlider.setMajorTickSpacing(1);
        fieldWidthSlider.setPaintTicks(true);
        fieldWidthSlider.setPaintLabels(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldWidthSlider, gbc);
        //Value Extract FWS
        AtomicInteger FWSValue = new AtomicInteger(fieldWidthSlider.getValue());
        cols = FWSValue.get();
        String colsStr = Integer.toString(cols);
        JLabel fieldWidthValue = new JLabel(colsStr);
        fieldWidthSlider.addChangeListener(e -> {
            FWSValue.set(fieldWidthSlider.getValue());
            cols = FWSValue.get();
            setCols(cols);
            fieldWidthValue.setText("" + FWSValue);
        });
        //Field Width Slider Value Text
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldWidthValue, gbc);


        //Field Height Text
        JLabel fieldHeightLabel = new JLabel("Field Height: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldHeightLabel, gbc);

        //Field Height Slider
        JSlider fieldHeightSlider = new JSlider(JSlider.HORIZONTAL, 15, 30, rows);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = .5;  // Allow the slider to expand horizontally
        gbc.weighty = 0.1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldHeightSlider, gbc);
        //Value Extract FHS
        AtomicInteger FHSValue = new AtomicInteger(fieldHeightSlider.getValue());
        rows = FHSValue.get();
        String rowsStr = Integer.toString(rows);
        JLabel fieldHeightValue = new JLabel(rowsStr);
        fieldHeightSlider.addChangeListener(e -> {
            FHSValue.set(fieldHeightSlider.getValue());
            rows = FHSValue.get();
            setRows(rows);
            fieldHeightValue.setText("" + FHSValue);
        });

        //Field Height Slider Value Text
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldHeightValue, gbc);
        fieldHeightSlider.setMajorTickSpacing(1);
        fieldHeightSlider.setPaintTicks(true);
        fieldHeightSlider.setPaintLabels(true);


        //Game Level Text
        JLabel gameLevelLabel = new JLabel("Game Level: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(gameLevelLabel, gbc);

        //Game Level Slider
        JSlider gameLevelSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, gameLvl);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;  // Allow the slider to expand horizontally
        gbc.weighty = 0.1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(gameLevelSlider, gbc);
        //Value Extract GLV
        AtomicInteger GLVValue = new AtomicInteger(gameLevelSlider.getValue());
        gameLvl = GLVValue.get();
        String gameLvlStr = Integer.toString(gameLvl);
        JLabel gameLevelValue = new JLabel(gameLvlStr);
        gameLevelSlider.addChangeListener(e -> {
            int GLValue = gameLevelSlider.getValue();
            setgameLvl(GLValue);
            gameLevelValue.setText("" + GLValue);
        });
        //Game Level Value Text
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(gameLevelValue, gbc);
        gameLevelSlider.setMajorTickSpacing(1);
        gameLevelSlider.setPaintTicks(true);
        gameLevelSlider.setPaintLabels(true);


        //Music Toggle Label
        JLabel MusicToggleLabel = new JLabel("Music (On/Off): ");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(MusicToggleLabel, gbc);

        //Music Check Box
        JCheckBox MusicCheckBox = new JCheckBox();
        MusicCheckBox.setSelected(musicToggle);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(MusicCheckBox, gbc);

        //Music Check Box Value Text
        String on_off;
        if (musicToggle) {
            on_off = "On";
        } else {
            on_off = "Off";
        }
        JLabel MusicToggleValue = new JLabel(on_off);
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        MusicCheckBox.addChangeListener(e -> {
            Boolean MusicCheckBoxValue = MusicCheckBox.isSelected();
            if (MusicCheckBoxValue) {
                MusicToggleValue.setText("On");
                setMusicToggle(true);


            } if(!MusicCheckBoxValue) {
                MusicToggleValue.setText("Off");
                setMusicToggle(false);



            }
        });
        add(MusicToggleValue, gbc);


        //Assets.Sound Effects Toggle Label
        JLabel SoundEffectsToggleLabel = new JLabel("Assets.Sound Effects (On/Off): ");
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(SoundEffectsToggleLabel, gbc);

        //Assets.Sound Effects Check Box
        JCheckBox SoundEffectsCheckBox = new JCheckBox();
        SoundEffectsCheckBox.setSelected(soundEffectsToggle);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(SoundEffectsCheckBox, gbc);
        String Son_off;
        if (soundEffectsToggle) {
            Son_off = "On";
        } else {
            Son_off = "Off";
        }
        //Assets.Sound Effects Check Box Value Text
        JLabel SoundEffectsToggleValue = new JLabel(Son_off);
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        SoundEffectsCheckBox.addChangeListener(e -> {
            Boolean SoundEffectsCheckBoxValue = SoundEffectsCheckBox.isSelected();
            if (SoundEffectsCheckBoxValue) {
                SoundEffectsToggleValue.setText("On");
                setsoundEffectsToggle(true);
            } else {
                SoundEffectsToggleValue.setText("Off");
                setsoundEffectsToggle(false);
            }
        });
        add(SoundEffectsToggleValue, gbc);


        //AI Play Toggle Label
        JLabel AIPlayToggleLabel = new JLabel("AI Play (On/Off): ");
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(AIPlayToggleLabel, gbc);
        String Aon_off;
        if (aiPlayToggle) {
            Aon_off = "On";
        } else {
            Aon_off = "Off";
        }
        //AI Play Check Box
        JCheckBox AIPlayCheckBox = new JCheckBox();
        AIPlayCheckBox.setSelected(aiPlayToggle);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(AIPlayCheckBox, gbc);

        //AI Play Check Box Value Text
        JLabel AIPlayToggleValue = new JLabel(Aon_off);
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        AIPlayCheckBox.addChangeListener(e -> {
            Boolean AIPlayCheckBoxValue = AIPlayCheckBox.isSelected();
            if (AIPlayCheckBoxValue) {
                AIPlayToggleValue.setText("On");
                setaiPlayToggle(true);
            } else {
                AIPlayToggleValue.setText("Off");
                setaiPlayToggle(false);
            }
        });
        add(AIPlayToggleValue, gbc);

        String Eon_off;
        if (extendedModeToggle) {
            Eon_off = "On";
        } else {
            Eon_off = "Off";
        }
        //Extended Mode Toggle Label
        JLabel ExtendedModeToggleLabel = new JLabel("Extended Mode (On/Off): ");
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(ExtendedModeToggleLabel, gbc);

        //Extended ModeCheck Box
        JCheckBox ExtendedModeCheckBox = new JCheckBox();
        ExtendedModeCheckBox.setSelected(extendedModeToggle);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(ExtendedModeCheckBox, gbc);

        //AI Play Check Box Value Text
        JLabel ExtendedModeToggleValue = new JLabel(Eon_off);
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        ExtendedModeCheckBox.addChangeListener(e -> {
            Boolean ExtendedModeCheckBoxValue = ExtendedModeCheckBox.isSelected();
            if (ExtendedModeCheckBoxValue) {
                ExtendedModeToggleValue.setText("On");
                setextendedModeToggle(true);

            } else {
                ExtendedModeToggleValue.setText("Off");
                setextendedModeToggle(false);

            }
        });
        add(ExtendedModeToggleValue, gbc);

        //Save Button
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
//        gbc.anchor = GridBagConstraints.CENTER;
        JButton saveButton = new JButton("Save Configuration");
        add(saveButton, gbc);
        saveButton.addActionListener(e -> {
            ConfigState configState = new ConfigState();
            configState.setCols(cols);
            configState.setRows(rows);
            configState.setSoundEffectsToggle(soundEffectsToggle);
            configState.setMusicToggle(musicToggle);
            configState.setgameLvl(gameLvl);
            configState.setaiPlayToggle(aiPlayToggle);
            configState.setextendedModeToggle(extendedModeToggle);
            SaveState SS = new SaveState();
            SS.saveState(configState);
            if(musicToggle){
                mp.play();
            }if(!musicToggle){
                mp.pause();
            }
        });


        //Back Button
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
//        gbc.anchor = GridBagConstraints.CENTER;
        JButton backButton = new JButton("Back");
        add(backButton, gbc);
        backButton.addActionListener(e -> {
            NavigationEngine.bButtonFunc();
        });


    }
public int getCols(){
        return cols;
}
public void setCols(int cols){
        this.cols = cols;
}
public int getRows(){
        return rows;
}
public void setRows(int rows){
        this.rows = rows;
}
public int getgameLvl(){
        return gameLvl;
}
public void setgameLvl(int gameLvl){
        this.gameLvl = gameLvl;
}

public void setMusicToggle(boolean musicToggle) {
        this.musicToggle = musicToggle;
    }
    public boolean getMusicToggle() {
        return musicToggle;
    }

public boolean getSoundEffectsToggle(){
        return soundEffectsToggle;
}
public void setsoundEffectsToggle(boolean soundEffectsToggle) {
        this.soundEffectsToggle = soundEffectsToggle;
}
public boolean getextendedModeToggle() {
        return extendedModeToggle;
}
public void setextendedModeToggle(boolean extendedModeToggle) {
        this.extendedModeToggle = extendedModeToggle;
}
public boolean getaiPlayToggle(){
        return aiPlayToggle;
}
public void setaiPlayToggle(boolean aiPlayToggle) {
        this.aiPlayToggle = aiPlayToggle;
}

}

