package ui.Screens;

import gameModel.Engine.NavigationEngine;

import javax.swing.*;
import java.awt.*;

public class HighScoreScreen extends JPanel {


    public HighScoreScreen() {

        //Config
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        setSize(600,900);

        //Layout Config
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Title
        JLabel highScoreTitle = new JLabel("High Score");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        highScoreTitle.setFont(new Font("Arial", Font.BOLD, 24));
        add(highScoreTitle, gbc);

        //Name Heading
        JLabel nameHeading = new JLabel("Name: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        nameHeading.setFont(new Font("Arial", Font.BOLD, 18));
        add(nameHeading, gbc);

        //Name1
        JLabel name1 = new JLabel("Tom: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(name1, gbc);

        //Name2
        JLabel name2 = new JLabel("Jerry: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(name2, gbc);

        //Name3
        JLabel name3 = new JLabel("Luke: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(name3, gbc);


        //Score Heading
        JLabel scoreHeading = new JLabel("Score: ");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        scoreHeading.setFont(new Font("Arial", Font.BOLD, 18));
        add(scoreHeading, gbc);


        //Score1
        JLabel score1 = new JLabel("8888");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(score1, gbc);

        //Score2
        JLabel score2 = new JLabel("7777");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(score2, gbc);

        //Score3
        JLabel score3 = new JLabel("6666");
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(score3, gbc);


        //Back Button
        gbc.gridx =0;
        gbc.gridy =5;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(200, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton backButton = new JButton("Back");
        add(backButton, gbc);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });






    }




}
