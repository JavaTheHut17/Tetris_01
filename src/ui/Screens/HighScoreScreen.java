package ui.Screens;

import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class HighScoreScreen extends JPanel {


    public HighScoreScreen() {

        JFrame HighScoreFrame = new JFrame("High Score");
        setVisible(true);
        setBackground(Color.RED);

        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });
    }



}
