package ui.Screens;

import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ConfigureScreen extends   JPanel {

    public ConfigureScreen(){

        JPanel configurePanel = new JPanel();
        setVisible(true);

        setBackground(Color.BLUE);

        //Back Button
        JButton backButton = new JButton("Back");
        add(backButton);
        backButton.addActionListener(e ->{
            NavigationEngine.bButtonFunc();
        });



    }
}
