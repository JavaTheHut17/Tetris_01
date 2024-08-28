package ui;

import gameModel.Engine.NavigationEngine;
import ui.Screens.SplashScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {



    public MainFrame() {

        //Navigation
        new NavigationEngine();
        add(NavigationEngine.cardPanel);
        NavigationEngine.init();

        //Title
        setTitle("Tetris");
        //Size
        setSize(new Dimension(600, 900));
        //Conditions
        setVisible(true);
        centerWindow();



        //Close Button
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

   // Center Window
    private void centerWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }


}
