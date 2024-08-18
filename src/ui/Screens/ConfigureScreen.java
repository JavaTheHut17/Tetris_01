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


        //Field Width Slider
        JSlider fieldWidthSlider = new JSlider(JSlider.HORIZONTAL, 5, 15, 7);
        fieldWidthSlider.setMajorTickSpacing(1);
        fieldWidthSlider.setPaintTicks(true);
        fieldWidthSlider.setPaintLabels(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldWidthSlider, gbc);



        //Field Height Slider
        gbc.gridx = 1;
        gbc.gridy = 4;
//        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.weightx = .5;  // Allow the slider to expand horizontally
        gbc.weighty = 0.1;
        gbc.insets = new Insets(10, 10, 10, 10);
        JSlider fieldHeightSlider = new JSlider(JSlider.HORIZONTAL, 15, 30, 20);
        fieldHeightSlider.setMajorTickSpacing(2);
        fieldHeightSlider.setPaintTicks(true);
        fieldHeightSlider.setPaintLabels(true);
        add(fieldHeightSlider, gbc);


        //Game Level Slider
        gbc.gridx = 1;
        gbc.gridy = 6;
       // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridheight = 2;
//        gbc.weightx = 1.0;  // Allow the slider to expand horizontally
//        gbc.weighty = 0.1;
        gbc.insets = new Insets(10, 10, 10, 10);
        JSlider gameLevelSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        gameLevelSlider.setMajorTickSpacing(1);
        gameLevelSlider.setPaintTicks(true);
        gameLevelSlider.setPaintLabels(true);
        add(gameLevelSlider, gbc);

        //Back Button
        gbc.gridx = 0;
      //  gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton backButton = new JButton("Back");
        add(backButton, gbc);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });



    }
}
