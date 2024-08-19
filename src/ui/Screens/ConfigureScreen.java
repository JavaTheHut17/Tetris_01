package ui.Screens;

import gameModel.Engine.NavigationEngine;

import javax.swing.*;
import java.awt.*;

public class ConfigureScreen extends   JPanel {

    public ConfigureScreen(){

        //Config
        setVisible(true);
        setLayout(new GridBagLayout());

        //Layout Config
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.BLUE);

        //Title
        JLabel configTitle = new JLabel("Configuration: ");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
//        gbc.anchor = GridBagConstraints.NORTH;
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
        JSlider fieldWidthSlider = new JSlider(JSlider.HORIZONTAL, 5, 15, 7);
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
         JLabel fieldWidthValue = new JLabel("7");
        fieldWidthSlider.addChangeListener(e -> {
            int FWSValue = fieldWidthSlider.getValue();
            fieldWidthValue.setText(""+FWSValue);
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
        JSlider fieldHeightSlider = new JSlider(JSlider.HORIZONTAL, 15, 30, 20);
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
        JLabel fieldHeightValue = new JLabel("20");
        fieldHeightSlider.addChangeListener(e -> {
            int FHSValue = fieldHeightSlider.getValue();
            fieldHeightValue.setText(""+ FHSValue);
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
        JSlider gameLevelSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
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
        JLabel gameLevelValue = new JLabel("5");
        gameLevelSlider.addChangeListener(e -> {
            int GLValue = gameLevelSlider.getValue();
            gameLevelValue.setText(""+GLValue);
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
        MusicCheckBox.setSelected(true);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(MusicCheckBox, gbc);

        //Music Check Box Value Text
        JLabel MusicToggleValue = new JLabel("On");
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        MusicCheckBox.addChangeListener(e ->{
            Boolean MusicCheckBoxValue = MusicCheckBox.isSelected();
            if(MusicCheckBoxValue){
                MusicToggleValue.setText("On");
            }
            else{
                MusicToggleValue.setText("Off");
            }
        });
        add(MusicToggleValue, gbc);


        //Sound Effects Toggle Label
        JLabel SoundEffectsToggleLabel = new JLabel("Sound Effects (On/Off): ");
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(SoundEffectsToggleLabel, gbc);

        //Sound Effects Check Box
        JCheckBox SoundEffectsCheckBox = new JCheckBox();
        SoundEffectsCheckBox.setSelected(true);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(SoundEffectsCheckBox, gbc);

        //Sound Effects Check Box Value Text
        JLabel SoundEffectsToggleValue = new JLabel("On");
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        SoundEffectsCheckBox.addChangeListener(e ->{
            Boolean SoundEffectsCheckBoxValue = SoundEffectsCheckBox.isSelected();
            if(SoundEffectsCheckBoxValue){
                SoundEffectsToggleValue.setText("On");
            }
            else{
                SoundEffectsToggleValue.setText("Off");
            }
        });
        add(SoundEffectsToggleValue, gbc);


        //Back Button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
//        gbc.anchor = GridBagConstraints.CENTER;
        JButton backButton = new JButton("Back");
        add(backButton, gbc);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });



    }
}
