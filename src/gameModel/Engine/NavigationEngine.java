package gameModel.Engine;

import ui.Screens.ConfigureScreen;
import ui.Screens.GameScreen;
import ui.Screens.HighScoreScreen;
import ui.Screens.TitleScreen;

import javax.swing.*;
import java.awt.*;

public class NavigationEngine extends JPanel {

    private static CardLayout cardLayout;
    public static JPanel cardPanel;

    public NavigationEngine() {

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        //Screens
        cardPanel.add(new TitleScreen(), "TitleScreen");
//        cardPanel.add(new GameScreen(), "GameScreen");
        cardPanel.add(new ConfigureScreen(), "ConfigureScreen");
        cardPanel.add(new HighScoreScreen(), "HighScoreScreen");
    }


    //Play Button Nav Func
    public static void playButtonNavFunc(){
        cardPanel.add(new GameScreen(), "GameScreen");
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

    //Title Screen Initialization
public static void init() {

        cardLayout.show(cardPanel, "TitleScreen");
}


}
