package ui.Screens;

import javax.swing.*;
import java.awt.*;

public class TitleScreen extends JPanel {

    public TitleScreen(){


//Edit
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,600));



        setLayout(new BorderLayout());
        setBackground(Color.GREEN);
        JLabel textLabel = new JLabel("Welcome To Tetris", JLabel.CENTER);
        add(textLabel, BorderLayout.NORTH);
        setVisible(true);
        System.out.println("Title Screen call test");




    }





}
