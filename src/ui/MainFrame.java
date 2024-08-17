package ui;


import ui.Screens.ConfigureScreen;
import ui.Screens.GameScreen;
import ui.Screens.HighScoreScreen;
import ui.Screens.TitleScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    public MainFrame() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        TitleScreen titleScreen = new TitleScreen();
        cardPanel.add(titleScreen, "TitleScreen");
        cardPanel.add(new GameScreen(), "GameScreen");
        cardPanel.add(new ConfigureScreen(), "ConfigureScreen");
        cardPanel.add(new HighScoreScreen(), "HighScoreScreen");

        //Title
        setTitle("Tetris");
        //Size
        setSize(new Dimension(600, 900));
        //Conditions
        setVisible(true);
        centerWindow();
//        TitleScreen titleScreen = new TitleScreen();
//        add(titleScreen);
        add(cardPanel);
        cardLayout.show(cardPanel, "TitleScreen");
//        cardLayout.show(cardPanel, "GameScreen");


        //Close Button
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
//Play Button Nav Func
public static void playButtonNavFunc(){
        cardLayout.show(cardPanel, "GameScreen");
}
//Config Button Nav Func
public static void ConfigNavFunc() {
        cardLayout.show(cardPanel, "ConfigureScreen");
}
//High Score Nav Func
    public static void hScoreNavFunc() {
        cardLayout.show(cardPanel, "HighScoreScreen");
    }
//Back Button Nav Func
    public static void bButtonFunc(){
        cardLayout.show(cardPanel, "TitleScreen");
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
