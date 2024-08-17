package ui.Screens;

import ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JPanel {

//        MainFrame mainFrame = new MainFrame();

    public TitleScreen() {

        //Config
//        JPanel panel = new JPanel();
        setVisible(true);

        //Layout
        setLayout(new GridLayout(7, 1));

        //Background Colour
        setBackground(Color.GRAY);

        //Title
        JLabel textLabel = new JLabel("Welcome To Tetris", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(textLabel);

        //Play Button
            JButton playButton = new JButton("Play");
            add(playButton);
            playButton.addActionListener(e ->{
            MainFrame.playButtonNavFunc();
            });


        //Configuration Button
        JButton configButton = new JButton("Config");
        add(configButton);
        configButton.addActionListener(e ->{
            MainFrame.ConfigNavFunc();
        });

        //High Score Button
        JButton highScoreButton = new JButton("High Score");
        add(highScoreButton);
        highScoreButton.addActionListener(e -> {
            MainFrame.hScoreNavFunc();
        });


        //Exit Button
        JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });





    }





}
