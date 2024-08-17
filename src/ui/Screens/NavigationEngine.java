package ui.Screens;

import javax.swing.*;
import java.awt.*;

public class NavigationEngine extends JPanel {

    private static CardLayout cardLayout;
    public static JPanel cardPanel;

    public NavigationEngine() {

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new TitleScreen(), "TitleScreen");
        cardPanel.add(new GameScreen(), "GameScreen");
        cardPanel.add(new ConfigureScreen(), "ConfigureScreen");
        cardPanel.add(new HighScoreScreen(), "HighScoreScreen");
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

public static void init() {

        cardLayout.show(cardPanel, "TitleScreen");
        System.out.println("calling");
}


}
