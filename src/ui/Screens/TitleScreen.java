package ui.Screens;

import gameModel.Engine.NavigationEngine;

import javax.sound.midi.Sequencer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.Timer;

public class TitleScreen extends JPanel {

    public TitleScreen() {



        //Config
        setVisible(true);

        //Layout
        setLayout(new GridLayout(7, 1));

        //Background Colour
        setBackground(Color.LIGHT_GRAY);

        //Title
        JLabel textLabel = new JLabel("Welcome To Tetris", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(textLabel);

        //Play Button
            JButton playButton = new JButton("Play");
            add(playButton);
            playButton.addActionListener(e ->{

            NavigationEngine.playButtonNavFunc();
            });


        //Configuration Button
        JButton configButton = new JButton("Config");
        add(configButton);
        configButton.addActionListener(e ->{
            NavigationEngine.ConfigNavFunc();
        });

        //High Score Button
        JButton highScoreButton = new JButton("High Score");
        add(highScoreButton);
        highScoreButton.addActionListener(e -> {
            NavigationEngine.hScoreNavFunc();
        });


        //Exit Button
        JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });





    }





}
