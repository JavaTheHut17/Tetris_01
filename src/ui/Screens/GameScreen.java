package ui.Screens;

import gameModel.Engine.NavigationEngine;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen() {

        //Config
        setVisible(true);
        setSize(600,900);
        setBackground(Color.LIGHT_GRAY);

        //Layout Config
        setLayout(new FlowLayout());


        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });




    }



}
