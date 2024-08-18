package ui.Screens;

import gameModel.Engine.NavigationEngine;

import javax.swing.*;
import java.awt.*;

public class HighScoreScreen extends JPanel {


    public HighScoreScreen() {

        //Config
        setVisible(true);
        setBackground(Color.RED);
        setSize(600,900);

        //Layout Config
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        //Back Button
        gbc.gridx =0;
        gbc.gridy =0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(200, 10, 10, 10);
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton backButton = new JButton("Back");
        add(backButton, gbc);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });






    }




}
