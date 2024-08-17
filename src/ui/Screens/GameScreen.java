package ui.Screens;

import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen() {

        System.out.println("GameScreen Initiated");
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(600,900);
        setBackground(Color.GREEN);

        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });

    }



}
